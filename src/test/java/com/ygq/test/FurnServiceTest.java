package com.ygq.test;

import com.ygq.furn.bean.Furn;
import com.ygq.furn.dao.FurnMapper;
import com.ygq.furn.service.FurnService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.List;


public class FurnServiceTest {

   private ClassPathXmlApplicationContext ioc;
   private FurnService furnService;

    @Before
    public void init(){
        ioc=new ClassPathXmlApplicationContext("applicationContext.xml");

        furnService=ioc.getBean(FurnService.class);

    }


    @Test
    public void SaveTest(){

        Furn furn = new Furn(null, "穿越火线CF", "腾讯代理工作室", new BigDecimal(1), 990, 10, "assets/images/product-image/8.jpg");

        furnService.save(furn);
        System.out.println("添加成功...");
    }
    @Test
    public void DeleteTest(){
       furnService.deleteById(0);
        System.out.println("删除成功...");
    }

    @Test
    public void findAll(){
        List<Furn> furnList = furnService.findAll();
        for (Furn furn : furnList) {
            System.out.println(furn);
        }
    }

    @Test
    public void updateTest(){
        Furn furn = new Furn();
        furn.setId(13);
        furn.setName("消逝的光芒2");
        furn.setPrice(new BigDecimal(99));
        furn.setMaker("TechLand");
        furnService.upDate(furn);


    }

}
