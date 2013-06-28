package com.isoftstone.agiledev.web.virgo.filter;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

public class ResourcePositioning implements org.osgi.framework.BundleActivator {

        private static Dictionary<String, String> pathMapping = null;
        private static Bundle bundle = null;

        private static String getLookupPath(String servletPath) {
                if(pathMapping==null || pathMapping.isEmpty())
                        return null;
                return pathMapping.get(servletPath);
        }

        private static URL getResource(String lookupPath) {
                Enumeration<URL> resources = bundle.findEntries("/", lookupPath, false);
                if(resources == null)
                        return null;
                if(!resources.hasMoreElements())
                        return null;
                
                return resources.nextElement();
        }

        public static boolean tryLookup(String servletPath,String contextPath,OutputStream output) {
                String lookupPath = getLookupPath(servletPath.substring(contextPath.length()));

                if (lookupPath == null)
                        return false;
                try {

                        URL resource = getResource(lookupPath);
                        if (resource == null)
                                return false;
                        InputStream input = new BufferedInputStream(resource.openStream());
                        byte[] buffer = new byte[4096];
                        int len;
                        while ((len = input.read(buffer)) > 0) {
                                output.write(buffer, 0, len);
                        }
                        output.flush();

                        return true;
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return false;
        }

        public String getConfig() {
                return null;
        }

        @Override
        public void start(BundleContext context) throws Exception {
                Bundle[] bundles = context.getBundles();
                for (Bundle b : bundles) {
                        if (b.getSymbolicName().equals("com.isoftstone.ittbank.portal")) {
                                bundle = b;
                                registePath(b);
                                break;
                        }
                }
        }

        private static void registePath(Bundle b) {
                if (b != null) {
                        pathMapping = new Hashtable<String, String>();
                        Dictionary<String, String> temp = b.getHeaders();
                        Enumeration<String> keys = temp.keys();
                        while (keys.hasMoreElements()) {
                                String key = keys.nextElement();
                                if (key.equals("Path-Mapping")) {
                                        String[] value = temp.get(key).split(";");
                                        for (String s : value) {
                                                pathMapping.put(s.split("=")[0], s.split("=")[1]);
                                        }

                                }
                        }
                }
        }

        @Override
        public void stop(BundleContext context) throws Exception {
        }
}