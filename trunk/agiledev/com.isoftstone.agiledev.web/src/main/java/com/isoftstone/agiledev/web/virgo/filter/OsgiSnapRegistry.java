package com.isoftstone.agiledev.web.virgo.filter;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.virgo.snaps.core.SnapRegistry;
import org.eclipse.virgo.snaps.core.internal.Snap;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OsgiSnapRegistry implements SnapRegistry{

    private static final String PROPERTY_SNAP_CONTEXT_PATH = "snap.context.path";

    private static final String FILTER_PATTERN = "(& (objectClass=" + Snap.class.getName() + ")(snap.host.id=%d))";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final BundleContext bundleContext;

    private final ServiceTracker<Snap, Object> tracker;

    private final Map<String, Snap> snaps = new ConcurrentHashMap<String, Snap>();

    public OsgiSnapRegistry(BundleContext bundleContext) throws InvalidSyntaxException {
        this.bundleContext = bundleContext;
        this.tracker = new ServiceTracker<Snap, Object>(bundleContext, createFilter(bundleContext), new OsgiSnapRegistryCustomizer());
    }

    private Filter createFilter(BundleContext bundleContext) throws InvalidSyntaxException {
        String filterString = String.format(FILTER_PATTERN, bundleContext.getBundle().getBundleId());
        return FrameworkUtil.createFilter(filterString);
    }

    public void init() {
        this.tracker.open();
        logger.info("Snap registry created");
    }

    public void destroy() {
        logger.info("Snap registry destroyed");
        this.tracker.close();
    }

    public Snap findSnapByContextPath(String contextPath) {
        Snap snap = this.snaps.get(contextPath);
        if (snap != null) {
            logger.info("Snap '{}' found for context path '{}'", snap, contextPath);
        } else {
            logger.warn("No snap found for context path '{}'", contextPath);
        }
        return snap;
    }

    private final class OsgiSnapRegistryCustomizer implements ServiceTrackerCustomizer<Snap, Object> {

        public Object addingService(ServiceReference<Snap> reference) {
            String contextPath = getSnapContextPath(reference);
            if (contextPath != null) {
                logger.info("Adding snap service '{}' to service registry for context path '{}'", reference.toString(), contextPath);
                Snap snap = bundleContext.getService(reference);
                snaps.put(contextPath, snap);
                return contextPath;

            }

            logger.warn("Not adding snap service '{}' to service registry as context path is null", reference.toString());
            return null;
        }

        public void modifiedService(ServiceReference<Snap> reference, Object service) {
        }

        public void removedService(ServiceReference<Snap> reference, Object service) {
            String contextPath = getSnapContextPath(reference);
            if (contextPath != null) {
                logger.info("Removing snap service '{}' from service registry for context path '{}'", reference.toString(), contextPath);
                snaps.remove(contextPath);
            }

            logger.warn("Not removing snap service '{}' from registry as context path is null", reference.toString());
            bundleContext.ungetService(reference);
        }

        private String getSnapContextPath(ServiceReference<Snap> reference) {
            return (String) reference.getProperty(PROPERTY_SNAP_CONTEXT_PATH);
        }

    }


}
