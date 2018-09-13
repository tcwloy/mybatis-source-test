package com.github.tcwloy.mybatis.mapper;

import com.github.tcwloy.mybatis.entity.User;
import com.github.tcwloy.mybatis.entity.UserExt;

public interface UserExtMapper {
    User findUserById(Integer id);
    UserExt findUserAndOrder(Integer id);
}
