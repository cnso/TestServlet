package edu.zhuoxun.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import edu.zhuoxun.testservlet.db.Utils;
import edu.zhuoxun.testservlet.entry.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Jash
 */
public class TestDB {
    @Test
    public void testDruid() throws SQLException {
        DataSource dataSource = Utils.getDataSource();
        System.out.println(dataSource);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        QueryRunner qr = new QueryRunner(dataSource);
        User user = qr.query("select * from user where username=?", new BeanHandler<>(User.class), "root");
        System.out.println(user);
    }
}
