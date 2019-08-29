package com.th.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by tianhui on 16/9/16.
 */
public class RedisPool {
    private static String ADDR = "127.0.0.1";

    private static int PORT = 6379;

    private static int MAX_TOTAL = 1024;

    private static int MAX_IDLE = 200;

    private static int MAX_WAIT_MILLIS = 10000;

    private static int TIME_OUT = 10000;

    private static boolean TEST_ON_BORROW = true;

    private static JedisPool jedisPool = null;

    static {
        try {
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(MAX_TOTAL);
            jedisPoolConfig.setMaxIdle(MAX_IDLE);
            jedisPoolConfig.setMaxWaitMillis(MAX_WAIT_MILLIS);
            jedisPoolConfig.setTestOnBorrow(TEST_ON_BORROW);
            jedisPool = new JedisPool(jedisPoolConfig, ADDR, PORT, TIME_OUT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized static Jedis getJedis() {
        Jedis jedis = null;
        try {
            if(jedisPool != null) {
                jedis = jedisPool.getResource();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jedis;
    }

    public static void returnJedis(final Jedis jedis) {
        if(jedis != null) {
            jedis.close();
        }
    }
}
