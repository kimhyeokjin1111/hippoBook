package com.example.hippobookproject.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        Long userId = (Long) session.getAttribute("userId");

        if(userId == null){
            HttpServletResponse resp = (HttpServletResponse) servletResponse;
            resp.sendRedirect("/user/login");
        }else if(userId != 1){
            HttpServletResponse resp = (HttpServletResponse) servletResponse;
            resp.sendRedirect("/");
        }
    }
}
