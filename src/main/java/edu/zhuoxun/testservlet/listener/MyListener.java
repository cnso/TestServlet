package edu.zhuoxun.testservlet.listener; /**
 * Created by Jash
 */

import edu.zhuoxun.testservlet.db.Utils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebListener
public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        System.out.println("Servlet 创建");
        Utils.initDataSource();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
        System.out.println("Servlet 销毁");
        Utils.destroyDataSource();
    }

}
