package com.th.mybatisTest.dao;

import com.th.mybatisTest.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by tianhui on 16/9/4.
 */
public interface UserMapper {

    List<User> getAllUser();

    List<User> getUserFromId(int id);

    List<User> getUserFromName(String userName);

    void updateUserFromName(String userName);

    void deleteUser(String userName);

    void insertUser(User user);
}
