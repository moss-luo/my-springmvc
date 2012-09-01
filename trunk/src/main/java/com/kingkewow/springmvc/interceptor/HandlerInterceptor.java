package com.kingkewow.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface HandlerInterceptor {
	// preHandle()方法在业务处理器处理请求之前被调用
	boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception;

	// postHandle()方法在业务处理器处理请求之后被调用
	void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception;

	// afterCompletion()方法在DispatcherServlet完全处理完请求后被调用
	void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception;
}
