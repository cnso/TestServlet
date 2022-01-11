package edu.zhuoxun.testservlet; /**
 * Created by Jash
 */

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TimeConsumingServlet", value = "/cache/time")
public class TimeConsumingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("<html lang='zh_CN'><head><title>等了很久吧</title><head></body><p>等了很久吧</p></body></html>");
    }
}
