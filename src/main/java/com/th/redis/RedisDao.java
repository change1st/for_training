package com.th.redis;

import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by tianhui on 16/9/17.
 */
@Repository("redisDaos")
public class RedisDao<T> {
    @Resource
    private RedisTemplate<String, T> redisTemplate;

    public void save(String key, T bean) {
        ValueOperations<String, T> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, bean);
    }

    public T read(String key) {
        ValueOperations<String, T> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }

    public void del(String key) {
        ValueOperations<String, T> valueOperations = redisTemplate.opsForValue();
        RedisOperations<String, T> redisOperations = valueOperations.getOperations();
        redisOperations.delete(key);
    }
}
