package com.secbro2.controller;

import com.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
public class RedisObjectTest {

    @Resource
    private RedisTemplate<String, Order> redisTemplate;

    @BeforeEach
    void init() {
        redisTemplate.setKeySerializer(RedisSerializer.string());
    }

    /**
     * 对象操作
     */
    @Test
    void testObject() {
        Order order = new Order();
        order.setId(1);
        order.setAmount(6666);
        order.setOrderNo("N110");
        ValueOperations<String, Order> operations = redisTemplate.opsForValue();

        operations.set("RedisObjectOrderTest", order);
        Order cachedOrder = operations.get("RedisObjectOrderTest");      // 需類型轉換，下面才能取得 getOrderNo()

        Assertions.assertEquals("N110", cachedOrder.getOrderNo());
    }

    /**
     * 删除对象操作
     */
    @Test
    void testDeleteObject() {
        redisTemplate.delete("RedisObjectOrderTest");

        boolean exists = redisTemplate.hasKey("RedisObjectOrderTest");

        Assertions.assertFalse(exists);     // 預期 false
    }
}
