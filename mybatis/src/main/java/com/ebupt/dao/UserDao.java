package com.ebupt.dao;

import com.ebupt.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: yushibo
 * @Date: 2019/5/1 0001 14:35
 * @Description:
 */

@Repository
public interface UserDao {

    List<User> findAll();
    int insertUser(User user);
}
