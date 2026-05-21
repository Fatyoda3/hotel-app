package com.hotel.app.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        Logger httpLogger = LoggerFactory.getLogger("http logger");
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpRes = (HttpServletResponse) res;
        httpLogger.info("method {} path {} status {}", httpReq.getMethod(), httpReq.getRequestURI(), httpRes.getStatus());
        chain.doFilter(req, res);
    }
}
