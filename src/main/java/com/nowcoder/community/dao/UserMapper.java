package com.nowcoder.community.dao;

import com.nowcoder.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Hide on bush
 * @since 2022/7/13 - 11:23
 */
//@Repository // spring提供的注解
@Mapper // mybatis提供的注解
public interface UserMapper {
    User selectById(int id);
    User selectByName(String username);
    User selectByEmail(String email);
    int insertUser(User user);
    int updateStatus(int id, int status);
    int updateHeader(int id, String headerUrl);
    int updatePassword(int id, String password);
}
