package com.nowcoder.community.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Hide on bush
 * @since 2022/7/23 - 16:18
 */
@Configuration
@EnableScheduling // 启用定时任务
@EnableAsync
public class ThreadPoolConfig {
}
