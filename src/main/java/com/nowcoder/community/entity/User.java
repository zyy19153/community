package com.nowcoder.community.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Hide on bush
 * @since 2022/7/13 - 11:19
 */
@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String salt;
    private String email;
    private int type;
    private int status;
    private String activationCode;
    private String headerUrl;
    private Date createTime;
}
