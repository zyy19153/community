package com.nowcoder.community.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Hide on bush
 * @since 2022/7/15 - 10:45
 */
@Data
public class LoginTicket {
    private int id;
    private int userId;
    private String ticket;
    private int status;
    private Date expired;
}
