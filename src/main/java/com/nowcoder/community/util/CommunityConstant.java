package com.nowcoder.community.util;

/**
 * @author Hide on bush
 * @since 2022/7/14 - 15:59
 */
public interface CommunityConstant {

    // 接口的变量都是 public static final 开头的。

    /**
     * 激活成功
     */
    int ACTIVATION_SUCCESS = 0;

    /**
     * 重复激活
     */
    int ACTIVATION_REPEAT = 1;

    /**
     * 激活失败
     */
    int ACTIVATION_FAILURE = 2;

    /**
     * 默认状态的登录凭证的超时时间 - 12h
     */
    int DEFAULT_EXPIRED_SECONDS = 3600 * 12;

    /**
     * 记住状态下的登录凭证超时时间 - 100d
     */
    int REMEMBER_EXPIRED_SECONDS = 3600 * 24 * 100;
}