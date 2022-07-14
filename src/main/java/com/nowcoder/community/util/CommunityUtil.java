package com.nowcoder.community.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * @author Hide on bush
 * @since 2022/7/14 - 13:18
 */
public class CommunityUtil {
    // 生成随机的字符串
    public static String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    // MD5加密
    // hello -> abc123
    // hello + randomString(salt) -> qweqweqwe
    public static String MD5(String key) {
        if (StringUtils.isBlank(key)) return null;
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }
}
