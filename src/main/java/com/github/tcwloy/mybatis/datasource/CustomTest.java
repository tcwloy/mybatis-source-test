package com.github.tcwloy.mybatis.datasource;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Properties;
import java.util.ServiceLoader;

public class CustomTest {
    @Test
    public void test() {
        DataSource dataSource = null;
//        dataSource = new UnpooledDataSource("org.hsqldb.jdbcDriver", "jdbc:hsqldb:mem:multipledrivers", "sa", "");
        DataSourceFactory dataSourceFactory = new UnpooledDataSourceFactory();
        Properties properties = new Properties();
        properties.setProperty("driver", "org.hsqldb.jdbcDriver");
        properties.setProperty("url", "jdbc:hsqldb:mem:multipledrivers");
        properties.setProperty("username", "sa");
        properties.setProperty("password", "");
        dataSourceFactory.setProperties(properties);
        dataSource = dataSourceFactory.getDataSource();
        try (Connection connection = dataSource.getConnection()){
            testSql(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJdbc(){
        try {
            //1.加载驱动
            Class.forName("org.hsqldb.jdbcDriver");
            //2.获取数据库连接
            try(Connection connection = DriverManager.getConnection("jdbc:hsqldb:mem:multipledrivers", "sa", "")) {
                testSql(connection);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void testSql(Connection connection) throws SQLException {
        //建表
        PreparedStatement createStatement = connection.prepareStatement("create table test (id integer not null , name varchar(25) not null )");
        createStatement.execute();
        createStatement.close();

        //插入
        PreparedStatement insertStatement = connection.prepareStatement("insert into test values (?, ?)");
        insertStatement.setInt(1, 1);
        insertStatement.setString(2, "xiaoming");
        insertStatement.executeUpdate();
        insertStatement.setInt(1, 2);
        insertStatement.setString(2, "zhangsan");
        insertStatement.executeUpdate();
        insertStatement.close();

        //查询
        PreparedStatement queryStatement = connection.prepareStatement("select id, name from test");
        ResultSet resultSet = queryStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("id:" + id + "->" + "name:" + name);
        }
        resultSet.close();
        queryStatement.close();
    }

    @Test
    public void testSPI(){
        ServiceLoader<Driver> drivers = ServiceLoader.load(Driver.class);
        drivers.forEach(driver -> {
            System.out.println(driver.getClass().getName());
        });
    }
}
