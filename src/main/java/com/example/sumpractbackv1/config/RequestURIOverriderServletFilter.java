package com.example.sumpractbackv1.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class RequestURIOverriderServletFilter {
    public static HttpServletRequestWrapper getFilter(HttpServletRequest request) {
        return new HttpServletRequestWrapper(request) {
            @Override
            public String getRequestURI() {
                String url = request.getRequestURI();

                if (url.startsWith("/api")) {
                    url = url.substring(4);
                }

                return url.endsWith("/") ? url.substring(0, url.length() - 1) : url;
            }
        };
    }
}
