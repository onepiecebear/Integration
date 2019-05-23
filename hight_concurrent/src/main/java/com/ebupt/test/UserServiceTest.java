package com.ebupt.test;

import com.ebupt.HightConcurrentApplication;
import com.ebupt.entity.User;
import com.ebupt.service.UserService;
import com.ebupt.utils.RedisUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: yushibo
 * @Date: 2019/5/22 0022 22:46
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HightConcurrentApplication.class)
public class UserServiceTest {


    private Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtils redisUtils;



    private static int count = 3000;

    //发令枪
    private CountDownLatch cdl = new CountDownLatch(count);

    private  String  id = "yushibo";

    //前置增强
    @Before
    public void checkCacheSystem(){
        //DB里面查询数据
        User user = userService.query(id);
        if(user == null){
            //初始化数据库 TODO

            //再查询一遍
            user = userService.query(id);
            logger.info(Thread.currentThread().getName()+"----->AOP思想从数据哭获取数据");

        }
        String result = redisUtils.get(id);
        if(result==null || result.trim().length()==0){
            redisUtils.set(id,user.toString());
            logger.info(Thread.currentThread().getName()+"----->AOP思想+策略模式思想初始化缓存数据完成");
        }
    }

    @Test
    public void testQuery() {
        userService.query("yushibo");
    }

    @Test
    public void testQueryRedis() {
        userService.queryByRedis3("yushibo");
    }

    @Test
    public void testQueryThread() {

        for (int i = 0; i < count; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //线程在这里面等待
                        cdl.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//					testQuery();
                    testQueryRedis();
                }
            }).start();
            //创建成功一个线程 count--
            cdl.countDown();
        }

        try {
            Thread.currentThread().join();
            logger.info("搞定");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
