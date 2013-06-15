package com.isoftstone.agiledev.web.virgo.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.virgo.snaps.core.SnapRegistry;
import org.eclipse.virgo.snaps.core.internal.Snap;
import org.eclipse.virgo.snaps.core.internal.SnapUtils;

public class RequestRouter {

    
    private final SnapRegistry snapRegistry;
    
    private final ServletContext servletContext;
    
    public RequestRouter(SnapRegistry snapRegistry, ServletContext servletContext) {
        this.snapRegistry = snapRegistry;
        this.servletContext = servletContext;
    }
    
    public void service(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        Snap snap = findSnap(request);
        
        if (snap != null) {
            snap.handleRequest(request, response);
            return;
        }
        
        chain.doFilter(request, response);
    }
    
    public void forward(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contextPath = SnapUtils.determineSnapContextPath(request);
        servletContext.getRequestDispatcher(contextPath + path).forward(request, response);
    }
    
    public void include(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contextPath = SnapUtils.determineSnapContextPath(request);
        servletContext.getRequestDispatcher(contextPath + path).include(request, response);
    }    
    
    private Snap findSnap(HttpServletRequest request) {
        String contextPath = SnapUtils.determineSnapContextPath(request);
        return this.snapRegistry.findSnapByContextPath(contextPath);
    }
    
    public void destroy() {
        this.snapRegistry.destroy();
    }

}
