package com.th.redis;

import com.th.mybatisTest.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by tianhui on 16/9/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:redis.xml")
public class RedisDaoTest {

    private final Logger logger = LoggerFactory.getLogger(RedisDaoTest.class);

    @Resource
    private RedisDao<String> redisDao;

    @Test
    public void save() throws Exception {
        redisDao.save("light", "blue");
    }

    @Test
    public void read() throws Exception {
        String light = redisDao.read("light");
        System.out.println("灯光色:" + light);
    }

    @Test
    public void del() throws Exception {
        redisDao.del("light");
    }

}