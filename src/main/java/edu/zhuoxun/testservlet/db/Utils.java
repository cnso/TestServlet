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
    private static final DataSource dataSource;
    static {
        Properties properties = new Properties();
        try {
            properties.load(Utils.class.getClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        dataSource = new DruidDataSource();
//        dataSource.configFromPropety(properties);
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
}
