package com.github.tcwloy.mybatis.test;

import com.github.tcwloy.mybatis.entity.User;
import com.github.tcwloy.mybatis.entity.UserExt;
import com.github.tcwloy.mybatis.mapper.UserExtMapper;
import com.github.tcwloy.mybatis.mapper.UserMapper;
import com.github.tcwloy.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class DataSourceTest {

    @Test
    public void testDruidDataSource(){
        SqlSession sqlSession = SqlSessionUtil.getInstance().openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.withUsername("zhangsan").withPassword("123456");
        mapper.insert(user);
        sqlSession.commit();
        sqlSession.close();
    }
}
