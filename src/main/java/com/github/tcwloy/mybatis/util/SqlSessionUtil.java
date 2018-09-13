package com.github.tcwloy.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    private SqlSessionFactory sqlSessionFactory;

    private static final SqlSessionUtil INSTANCE = new SqlSessionUtil();

    private SqlSessionUtil(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionUtil getInstance(){
        return INSTANCE;
    }

    public SqlSession openSession() {
        return sqlSessionFactory.openSession();
    }
}
