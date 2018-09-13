package com.github.tcwloy.mybatis.test;

import com.github.tcwloy.mybatis.entity.User;
import com.github.tcwloy.mybatis.entity.UserExt;
import com.github.tcwloy.mybatis.mapper.UserExtMapper;
import com.github.tcwloy.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserTest {
    @Test
    public void testFindUserById(){
        SqlSession sqlSession = SqlSessionUtil.getInstance().openSession();
        UserExtMapper mapper = sqlSession.getMapper(UserExtMapper.class);
        User user = mapper.findUserById(9);
        System.out.println(user);
    }

    @Test
    public void testFindUserAndOrder(){
        SqlSession sqlSession = SqlSessionUtil.getInstance().openSession();
        UserExtMapper mapper = sqlSession.getMapper(UserExtMapper.class);
        UserExt user = mapper.findUserAndOrder(9);
        System.out.println(user);
    }
}
