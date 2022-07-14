package com.nowcoder.community.dao.impl;

import com.nowcoder.community.dao.AlphaDao;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @author Hide on bush
 * @since 2022/7/12 - 15:14
 */
@Repository
@Primary
public class AlphaDaoMybatisImpl implements AlphaDao {
    @Override
    public String select() {
        return "Mybatis";
    }
}
