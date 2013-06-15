package com.isoftstone.agiledev.web.virgo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.virgo.medic.eventlog.EventLogger;
import org.eclipse.virgo.snaps.core.SnapRegistry;
import org.eclipse.virgo.snaps.core.internal.SnapsLogEvents;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SnapHostFilter  implements Filter {

    private static final String ATTRIBUTE_OSGI_CONTEXT = "osgi-bundlecontext";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final EventLogger eventLogger;
    
    private volatile String contextPath;

    private volatile RequestRouter router;

    public SnapHostFilter() {
        BundleContext bundleContext = FrameworkUtil.getBundle(SnapHostFilter.class).getBundleContext();
        EventLogger eventLogger = (EventLogger) bundleContext.getService(bundleContext.getServiceReference(EventLogger.class.getName()));
        this.eventLogger = eventLogger;
    }

    SnapHostFilter(EventLogger eventLogger) {
        this.eventLogger = eventLogger;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    	if ((request instanceof HttpServletRequest) && (response instanceof HttpServletResponse)) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            if(ResourcePositioning.tryLookup(httpRequest.getServletPath(),httpRequest.getContextPath(),response.getOutputStream()))
            	chain.doFilter(request, response);
            else
            	router.service(httpRequest, httpResponse, chain);            
        } else {
            chain.doFilter(request, response);
        }
    }    

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        SnapRegistry registry = createSnapRegistry(filterConfig.getServletContext());
        registry.init();
        
        this.router = new RequestRouter(registry, filterConfig.getServletContext());
        this.contextPath = filterConfig.getServletContext().getContextPath();
        this.eventLogger.log(SnapsLogEvents.HOST_CREATED, this.contextPath);
    }

    @Override
    public void destroy() {
        if (this.router != null) {
            this.router.destroy();
            this.router = null;
        }
        this.eventLogger.log(SnapsLogEvents.HOST_DESTROYED, this.contextPath);
    }

    protected SnapRegistry createSnapRegistry(ServletContext servletContext) throws ServletException {
        try {
            return new OsgiSnapRegistry(getRequiredBundleContext(servletContext));
        } catch (InvalidSyntaxException e) {
            logger.error("Unable to create OsgiSnapRegistry", e);
            throw new ServletException("Unable to create OsgiSnapRegistry.", e);
        }
    }

    protected final BundleContext getRequiredBundleContext(ServletContext servletContext) throws ServletException {
        Object attr = servletContext.getAttribute(ATTRIBUTE_OSGI_CONTEXT);
        if (attr == null) {
            logger.error("ServletContext attribute '{}' is missing.", ATTRIBUTE_OSGI_CONTEXT);
            throw new ServletException("ServletContext attribute '" + ATTRIBUTE_OSGI_CONTEXT + "' is missing.");
        }
        return (BundleContext) attr;
    }    
}
