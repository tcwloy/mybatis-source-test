package com.github.tcwloy.mybatis.datasource;

import com.github.tcwloy.mybatis.entity.User;
import com.github.tcwloy.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class DataSourceTest {

    @Test
    public void testDruidDataSource() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.withUsername("zhangsan").withPassword("123456");
        mapper.insert(user);
        sqlSession.commit();
        sqlSession.close();
    }
}
