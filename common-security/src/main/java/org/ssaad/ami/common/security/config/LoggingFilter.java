package org.ssaad.ami.common.security.config;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.UUID;

@Component
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            //String mdcData = String.format("[userId:%s | requestId:%s] ", user(), requestId());
            String mdcData = String.format("[userId:%s] ", user());
            MDC.put("mdcData", mdcData); //Referenced from logging configuration.
            chain.doFilter(request, response);
        } finally {
            MDC.clear();
        }
    }

    private String requestId() {
        return UUID.randomUUID().toString();
    }

    private String user() {
        return SecurityContextUtils.getUserName();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
