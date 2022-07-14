package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

/**
 * @author Hide on bush
 * @since 2022/7/13 - 11:43
 */
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Test
    public void testSelectUser() {
        User user = userMapper.selectById(101);
        System.out.println(user);
    }

    @Test
    public void testSelectDiscussPosts() {
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0, 0, 10);
        list.stream().forEach(System.out::println);
        int rows = discussPostMapper.selectDiscussPostRows(149);
        System.out.println(rows);
    }
}
