package org.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dto.CreateUserDto;
import org.example.dto.UserDto;

import java.io.IOException;

@WebFilter("/admin")
public class UnsafeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var user = (CreateUserDto) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");

        if (user != null){
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            ((HttpServletResponse) servletResponse).sendRedirect("/registration");
        }

        System.out.println("new file to commit");
    }
}
