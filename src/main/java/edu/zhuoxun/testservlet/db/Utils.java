package edu.zhuoxun.testservlet.db;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Jash
 */
public class Utils {
    private static DataSource dataSource;
    public static void initDataSource() {
        Properties properties = new Properties();
        try {
            properties.load(Utils.class.getClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        DataSource temp = null;
        try {
            temp = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            temp = new DruidDataSource();
        }
        dataSource = temp;
    }
    public static DataSource getDataSource() {
        return dataSource;
    }
    public static void destroyDataSource() {
        ((DruidDataSource) dataSource).close();
        dataSource = null;
    }
}
