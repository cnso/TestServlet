package edu.zhuoxun.testservlet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        response.setContentType("text/html");
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("<p>请求来自Address" +  request.getRemoteAddr() + "</p>");
//        out.println("<p>请求来自user-agent" +  request.getHeader("user-agent") + "</p>");
//        out.println("<p>请求来自Host" +  request.getRemoteHost() + "</p>");
//        out.println("<p>用户名:" +   username + "</p>");
//        out.println("<p>密码:" + password + "</p>");
//        out.println("</body></html>");

//        response.sendRedirect("/jsplogin.jsp");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(String.format("来自 Hello Servlet 的数据 %03d", i));
        }
        request.setAttribute("list", list);
        request.getRequestDispatcher("/jsplogin.jsp").forward(request, response);
    }

    public void destroy() {
    }
}