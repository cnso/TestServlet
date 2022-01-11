package edu.zhuoxun.testservlet;

import edu.zhuoxun.testservlet.db.Utils;
import edu.zhuoxun.testservlet.entry.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

//        if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
//            request.getSession().setAttribute("user", user);
//            request.getRequestDispatcher("/hello.jsp").forward(request, response);
//        } else {
//            response.sendRedirect("/login.html");
//        }
        QueryRunner qr = new QueryRunner(Utils.getDataSource());
        User user = null;
        try {
            user = qr.query("select * from user where username=?", new BeanHandler<>(User.class), username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user == null) {
            response.sendRedirect("/login.html");
        } else if (!user.getPassword().equals(toMD5(password))) {
            response.sendRedirect("/login.html");
        } else {
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("/auth/hello.jsp").forward(request, response);
        }
    }

    private String toMD5(String src) {
        StringBuilder builder = new StringBuilder();
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(src.getBytes(StandardCharsets.UTF_8));
            for (byte b : digest) {
                builder.append(String.format("%02x", b & 0xff));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
