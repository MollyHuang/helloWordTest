package com.secbro2.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
public class RedisTest {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void testSimple() {
        redisTemplate.opsForValue().set("testSimple", "google.com");
        Assertions.assertEquals("google.com", redisTemplate.opsForValue().get("testSimple"));
    }

    @Test
    void testStringTemplate() {
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set("testStringTemplate", "541075754");
        Assertions.assertEquals("541075754", operations.get("testStringTemplate"));
    }

    @Test
    void testKeySerializer() {
        redisTemplate.setKeySerializer(RedisSerializer.string());
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        operations.set("testKeySerializer", "google.com");
        Assertions.assertEquals("google.com", operations.get("testKeySerializer"));
    }

    @Test
    void testKeySerializer1() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());    // 結果同上，另一種序列化的方式
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        operations.set("testKeySerializer1", "google.com");
        Assertions.assertEquals("google.com", operations.get("testKeySerializer1"));
    }
}
