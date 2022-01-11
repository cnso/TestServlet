package edu.zhuoxun.testservlet.filter; /**
 * Created by Jash
 */

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

import java.io.IOException;
import java.net.CacheResponse;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebFilter(filterName = "F03CacheFilter", urlPatterns = "/cache/*")
public class F03CacheFilter implements Filter {
    private Map<String,byte[]> cache;
    private Map<String,String> contentType;
    public void init(FilterConfig config) throws ServletException {
        cache = new ConcurrentHashMap<>();
        contentType = new ConcurrentHashMap<>();
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String url = ((HttpServletRequest) request).getRequestURI();
        byte[] data = cache.get(url);
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setHeader("X-Cache-Hit", data == null ? "NO" : "YES");
        if (data == null) {
            CachedHttpServletResponse cachedResponse = new CachedHttpServletResponse(resp);
            chain.doFilter(request, cachedResponse);
            data = cachedResponse.getContent();
            contentType.put(url, cachedResponse.getContentType());
            cache.put(url, data);
        }
        resp.setContentType(contentType.get(url));
        ServletOutputStream output = resp.getOutputStream();
        output.write(data);
        output.flush();
    }
}
