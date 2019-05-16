package com.ebupt.service;

import com.ebupt.annotation.EnablePaging;
import com.ebupt.dao.UserDao;
import com.ebupt.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    @EnablePaging
    public  Object findAll(String pageNum,String pageSize){
        logger.info("查询数据库");

//        PageHelper.startPage(new Integer(pageNum),new Integer(pageSize));
        logger.info("findAll()前");
        List<User> list = userDao.findAll();
        logger.info("findAll()后");
//        PageInfo<User> result = new PageInfo<>(list);
        return list;
    }

    public int insertUser(User user){
        return userDao.insertUser(user);
    }

    public User findById(String  id){
        logger.info("findById是否操作数据库");
        return userDao.findById(id);
    }
}
