package edu.zhuoxun.testservlet.filter;

import edu.zhuoxun.testservlet.entry.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/auth/*")
public class F01LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("LoginFilter = " + ((HttpServletRequest) request).getRequestURI());
        User user = (User) ((HttpServletRequest) request).getSession().getAttribute("user");
        if (user == null) {
            ((HttpServletResponse) response).sendRedirect("/login.html");
        } else {
            chain.doFilter(request, response);
        }
    }
}
