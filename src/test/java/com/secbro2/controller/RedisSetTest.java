package com.secbro2.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.Resource;
import java.util.Set;

@Slf4j
@SpringBootTest
class RedisSetTest {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @BeforeEach
    void init() {
        redisTemplate.setKeySerializer(RedisSerializer.string());
    }

    /**
     * Redis操作Set类型数据，去重特性
     */
    @Test
    void testSet() {
        SetOperations<String, String> operations = redisTemplate.opsForSet();
        operations.add("testSet", "1");
        operations.add("testSet", "2");
        operations.add("testSet", "3");
        operations.add("testSet", "3");
        operations.add("testSet", "5");

        Set<String> orderIds = operations.members("testSet");

        log.info("testSet: {}", orderIds);
    }


    /**
     * Redis操作ZSet类型数据
     */
    @Test
    void testZSet() {
        ZSetOperations<String, String> operations = redisTemplate.opsForZSet();
        operations.add("testZSet", "A", 3);
        operations.add("testZSet", "B", 2);
        operations.add("testZSet", "C", 1);
        operations.add("testZSet", "D", 4);

        operations.add("testZSet", "E", 3);
        operations.add("testZSet", "F", 2);
        operations.add("testZSet", "G", 1);
        operations.add("testZSet", "H", 4);

        Set<String> orderIds = operations.range("testZSet", 0, 3);
        for (String orderId : orderIds) {
            log.info("testZSet: {}", orderId);
        }
    }

}