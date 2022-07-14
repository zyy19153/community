package com.nowcoder.community.dao.impl;

import com.nowcoder.community.dao.AlphaDao;
import org.springframework.stereotype.Repository;

/**
 * @author Hide on bush
 * @since 2022/7/12 - 15:11
 */
@Repository("alphaHibernate")
public class AlphaDaoHibernateImpl implements AlphaDao {
    @Override
    public String select() {
        return "Hibernate";
    }
}
