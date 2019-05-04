package com.ebupt.service;

import com.ebupt.annotation.EnablePaging;
import com.ebupt.dao.UserDao;
import com.ebupt.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yushibo
 * @Date: 2019/5/1 0001 14:44
 * @Description:
 */

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @EnablePaging
    public  PageInfo<User> findAll(String pageNum,String pageSize){
        PageHelper.startPage(new Integer(pageNum),new Integer(pageSize));
        List<User> list = userDao.findAll();
        PageInfo<User> result = new PageInfo<>(list);
        return result;
    }
    public int insertUser(User user){
        return userDao.insertUser(user);
    }
}
