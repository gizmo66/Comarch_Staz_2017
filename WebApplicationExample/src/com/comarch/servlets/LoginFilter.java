package com.comarch.servlets;

import com.comarch.controller.UserManager;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Adam Kołodziejek
 * @since 09-07-2017
 */

@Slf4j
public class LoginFilter implements Filter {
    
    public static final String LOGIN_PAGE = "/login.xhtml";

    @Override
    public void doFilter(ServletRequest servletRequest,
            ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        // managed bean name is exactly the session attribute name
        UserManager userManager = (UserManager) httpServletRequest
                .getSession().getAttribute("userManager");

        if (userManager != null) {
            if (userManager.isLoggedIn()) {
                log.debug("user is logged in");
                // user is logged in, continue request
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                log.debug("user is not logged in");
                // user is not logged in, redirect to login page
                httpServletResponse.sendRedirect(
                        httpServletRequest.getContextPath()
                                + LOGIN_PAGE);
            }
        } else {
            log.debug("userManager not found");
            // user is not logged in, redirect to login page
            httpServletResponse.sendRedirect(
                    httpServletRequest.getContextPath() + LOGIN_PAGE);
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        log.debug("LoginFilter initialized");
    }

    @Override
    public void destroy() {
        // close resources
    }
}
