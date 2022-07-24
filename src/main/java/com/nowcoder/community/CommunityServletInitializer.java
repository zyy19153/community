package com.nowcoder.community;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Hide on bush
 * @since 2022/7/24 - 15:50
 */
public class CommunityServletInitializer extends SpringBootServletInitializer {
    /**
     * tomcat会访问该方法，来找到该形目的主配置文件或者说启动类
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CommunityApplication.class);
    }
}
