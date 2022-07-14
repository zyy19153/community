package com.nowcoder.community;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author Hide on bush
 * @since 2022/7/13 - 20:01
 */
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class LoggerTests {
    private static final Logger logger = LoggerFactory.getLogger(LoggerTests.class);
    @Test
    public void testLogger() {
        System.out.println(logger.getName());
        logger.debug("debug...");
        logger.info("debug...");
        logger.warn("warning...");
        logger.error("error...");
    }
}
