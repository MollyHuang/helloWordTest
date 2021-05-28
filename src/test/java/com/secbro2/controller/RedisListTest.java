package com.secbro2.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
class RedisListTest {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @BeforeEach
    void init() {
        redisTemplate.setKeySerializer(RedisSerializer.string());
    }

    /**
     * Redis - List
     */
    @Test
    void testObject() {
        ListOperations<String, String> operations = redisTemplate.opsForList();
        operations.leftPush("testList", "1");
        operations.leftPush("testList", "2");
        operations.leftPush("testList", "3");

//		log.info("rightPop:{}", operations.rightPop("testList"));
//		log.info("rightPop:{}", operations.rightPop("testList"));
//		log.info("rightPop:{}", operations.rightPop("testList"));

//		log.info("leftPop:{}", operations.leftPop("testList"));
//		log.info("leftPop:{}", operations.leftPop("testList"));
//		log.info("leftPop:{}", operations.leftPop("testList"));

    }

}
