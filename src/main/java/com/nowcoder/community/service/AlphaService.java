package com.nowcoder.community.service;

import com.nowcoder.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author Hide on bush
 * @since 2022/7/12 - 15:20
 */
@Service
//@Scope("single") // 默认值，单例模式
//@Scope("prototype") // 非单例的模式
public class AlphaService {

    @Autowired
    private AlphaDao alphaDao;

    public AlphaService() {
//        System.out.println("实例化AlphaService");
    }
    // 注解：方法会在构造之后调用
    @PostConstruct
    public void init() {
//        System.out.println("初始化alphaService");
    }

    // 在销毁之前调用
    @PreDestroy
    public void destroy() {
//        System.out.println("销毁AlphaService");
    }

    public String find() {
        return alphaDao.select();
    }
}
