package com.nowcoder.community.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Hide on bush
 * @since 2022/7/17 - 19:49
 */
@Data
public class Message {
    private int id;
    private int fromId;
    private int toId;
    private String conversationId;
    private String content;
    private int status;
    private Date createTime;
}
