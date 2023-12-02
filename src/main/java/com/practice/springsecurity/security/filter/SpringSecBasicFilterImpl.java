package com.practice.springsecurity.security.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class SpringSecBasicFilterImpl implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //Execute any custom logic
        chain.doFilter(request, response);
    }
}
