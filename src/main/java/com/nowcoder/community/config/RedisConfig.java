package com.nowcoder.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author Hide on bush
 * @since 2022/7/19 - 11:28
 */
@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        // 设置 key 的序列化方式，
        template.setKeySerializer(RedisSerializer.string());
        // 设置普通的value的序列化方式，
        template.setValueSerializer(RedisSerializer.json());
        // 设置hash的key的序列化方式，
        template.setHashKeySerializer(RedisSerializer.string());
        // 设置hash的value的序列化机制
        template.setHashValueSerializer(RedisSerializer.json());
        template.afterPropertiesSet(); // 当设置完后触发生效
        return template;
    }
}
