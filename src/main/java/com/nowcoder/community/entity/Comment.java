package com.nowcoder.community.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Hide on bush
 * @since 2022/7/17 - 14:52
 */
@Data
public class Comment {
    private int id;
    private int userId;
    private int entityType;
    private int entityId;
    private int targetId;
    private String content;
    private int status;
    private Date createTime;
}
