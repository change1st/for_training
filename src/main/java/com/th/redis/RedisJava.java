package com.th.redis;

import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

/**
 * Created by tianhui on 16/9/16.
 */
public class RedisJava {

    private static void jedis() {
        Jedis jedis = new Jedis("127.0.0.1");
        System.out.println("connection to server successfully");
        jedis.lpush("fruit1", "apple");
        jedis.lpush("fruit1", "pear");
        jedis.lpush("fruit1", "banana");
        List<String> fruit = jedis.lrange("fruit1", 0, 2);
        Set<String> fruitKeys = jedis.keys("*");
        System.out.println(JSON.toJSONString(fruit));
        System.out.println(JSON.toJSONString(fruitKeys));
    }

    private static void jedisPoolTest() {
        Jedis jedis = RedisPool.getJedis();
        jedis.lpush("fruit2", "apple1");
        jedis.lpush("fruit2", "pear1");
        jedis.lpush("fruit2", "banana1");
        List<String> fruit = jedis.lrange("fruit2", 0, 2);
        System.out.println(JSON.toJSONString(fruit));
        RedisPool.returnJedis(jedis);
    }

    public static void main(String[] args) {
        jedisPoolTest();
    }
}
