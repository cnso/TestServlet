package edu.zhuoxun.testservlet.filter; /**
 * Created by Jash
 */

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter(filterName = "LogFilter",urlPatterns = "/*")
public class F02LogFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("LogFilter = " + ((HttpServletRequest) request).getRequestURI());
        chain.doFilter(request, response);
    }
}
