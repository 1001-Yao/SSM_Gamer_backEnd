package com.ygq.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class t1 {
    @Test
    public void testSqlSessionFactoryBean() {
//1、创建 SpringIOC 容器
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(ac.getBean("pooledDataSource"));
        System.out.println(ac.getBean("sqlSessionFactory"));
    }

}
