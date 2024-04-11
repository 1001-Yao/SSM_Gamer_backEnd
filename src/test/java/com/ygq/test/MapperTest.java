package com.ygq.test;

import com.ygq.furn.bean.Furn;
import com.ygq.furn.dao.FurnMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class MapperTest {
    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void insertTest(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        FurnMapper furnMapper = ioc.getBean(FurnMapper.class);
        Furn furn = new Furn(null, "英雄联盟", "拳头游戏工作时", new BigDecimal(1), 990, 10, "assets/images/product-image/7.jpg");
        int insert = furnMapper.insert(furn);
        System.out.println("insert  "+insert);
        System.out.println("添加成功");
    }
    @Test
    public void deleteTest(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        FurnMapper furnMapper = ioc.getBean(FurnMapper.class);
        int i = furnMapper.deleteByPrimaryKey(7);
        System.out.println("i "+i);
        System.out.println("删除成功");
    }

    @Test
    public void updateTest(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        FurnMapper furnMapper = ioc.getBean(FurnMapper.class);
        Furn furn = new Furn(8, "英雄联盟", "拳头游戏工作时", new BigDecimal(2), 990, 10, "assets/images/product-image/7.jpg");

        furnMapper.updateByPrimaryKey(furn);
        int affectedRow = furnMapper.updateByPrimaryKey(furn);
        System.out.println(affectedRow > 0 ? "操作成功" : "没有影响表数据");
    }
    @Test
    public void SelectTest(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        FurnMapper furnMapper = ioc.getBean(FurnMapper.class);

        Furn furn = furnMapper.selectByPrimaryKey(8);
        System.out.println(furn);
    }


}
