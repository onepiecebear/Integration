package com.ebupt.service;

import com.ebupt.dao.UserDao;
import com.ebupt.entity.User;
import com.ebupt.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @Author: yushibo
 * @Date: 2019/5/20 0020 22:29
 * @Description:
 */
@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Resource
    private UserDao userDao;
    @Autowired
    private RedisUtils redisUtils;

    public User query(String id) {
        logger.info(Thread.currentThread().getName()+"----->从DB里面获取数据");
        return userDao.findById(id);
    }

    public String queryByRedis(String id) {
        String result = redisUtils.get(id);
        if (result != null) {
            //缓存里面拿数据
            logger.info(Thread.currentThread().getName() + "----->从Redis缓存获取数据:" + result);
            return result;
        } else {
            //缓存没有数据从数据库中查询
            User user = userDao.findById(id);
            logger.info(Thread.currentThread().getName() + "----->从DB里面获取数据:" + user.toString());
            redisUtils.set(id, user.toString());
            return user.toString();
        }
    }


    public String queryByRedis1(String id) {
        String result = redisUtils.get(id);
        if (result != null) {
            //缓存里面拿数据
            logger.info(Thread.currentThread().getName() + "----->从Redis缓存获取数据:" + result);
            return result;
        } else {
            synchronized (this){
                //缓存没有数据从数据库中查询
                User user = userDao.findById(id);
                logger.info(Thread.currentThread().getName() + "----->从DB里面获取数据:" + user.toString());
                redisUtils.set(id, user.toString());
                return user.toString();
            }

        }
    }

    public String queryByRedis2(String id) {
        String result = redisUtils.get(id);
        if (result != null) {
            //缓存里面拿数据
            logger.info(Thread.currentThread().getName() + "----->从Redis缓存获取数据:" + result);
            return result;
        } else {
            synchronized (this){
                //双重检查DCL
                //去缓存里面查询一把
                result = redisUtils.get(id);
                if (result != null) {
                    //缓存里面拿数据
                    logger.info(Thread.currentThread().getName() + "----->从Redis缓存获取数据:" + result);
                    return result;
                }
                //缓存没有数据从数据库中查询
                User user = userDao.findById(id);
                logger.info(Thread.currentThread().getName() + "----->从DB里面获取数据:" + user.toString());
                redisUtils.set(id, user.toString());
                return user.toString();
            }

        }
    }
    //经过AOP前置增强后else后面的代码可以取消掉
    public String queryByRedis3(String id) {
        String result = redisUtils.get(id);
        if (result != null) {
            //缓存里面拿数据
            logger.info(Thread.currentThread().getName() + "----->从Redis缓存获取数据:" + result);
            return result;
        }
        return null;
        /*else {
            synchronized (this){
                //双重检查DCL
                //去缓存里面查询一把
                result = redisUtils.get(id);
                if (result != null) {
                    //缓存里面拿数据
                    logger.info(Thread.currentThread().getName() + "----->从Redis缓存获取数据:" + result);
                    return result;
                }
                //缓存没有数据从数据库中查询
                User user = userDao.findById(id);
                logger.info(Thread.currentThread().getName() + "----->从DB里面获取数据:" + user.toString());
                redisUtils.set(id, user.toString());
                return user.toString();
            }
        }*/
    }
}