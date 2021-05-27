package com.secbro2.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
public class RedisTest {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void testSimple() throws Exception {
        redisTemplate.opsForValue().set("newWeb","google.com");
        Assertions.assertEquals("google.com", redisTemplate.opsForValue().get("newWeb"));
    }
}
