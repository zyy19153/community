package com.nowcoder.community.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Hide on bush
 * @since 2022/7/13 - 15:03
 */
@Data
public class DiscussPost {
    private int id;
    private int userId;
    private String title;
    private String content;
    private int type;
    private int status;
    private Date createTime;
    private int commentCount;
    private double score;
}
