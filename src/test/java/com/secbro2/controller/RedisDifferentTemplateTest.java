package com.secbro2.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
class RedisDifferentTemplateTest {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @BeforeEach
    void init(){
        redisTemplate.setKeySerializer(RedisSerializer.string());
        redisTemplate.setValueSerializer(RedisSerializer.string());
    }

    @Test
    void testSimple() {
//        redisTemplate.opsForValue().set("myWeb", "www.choupangxia.com");  // OK
        stringRedisTemplate.opsForValue().set("Google Web", "google.com");  // OK

        log.info("redisTemplate: {}", redisTemplate.opsForValue().get("Google Web"));
        log.info("stringRedisTemplate: {}", stringRedisTemplate.opsForValue().get("Google Web"));

        //Assertions.assertEquals("www.choupangxia.com", redisTemplate.opsForValue().get("myWeb"));
        //Assertions.assertEquals("www.choupangxia.com", stringRedisTemplate.opsForValue().get("myWeb"));
    }
}
