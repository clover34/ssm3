package com.etc.delightstouring.service;

import com.etc.delightstouring.domain.Province;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.security.PrivateKey;

/**
 * @ClassName ProvinceService
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/26 19:14
 * @Version 1.0
 **/
public class ProvinceServiceTest {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    ProvinceService provinceService = context.getBean("provinceServiceImpl", ProvinceService.class);
    @Test
    public void testFindAll(){
        System.out.println("provinceService.findAllProvince() = " + provinceService.findAllProvince());
    }

    @Test
    public void testFindById(){
        Province province = provinceService.findProvinceById(1);
        System.out.println("province = " + province);
    }

    @Test
    public void testAdd(){
        System.out.println(provinceService.addProvince(new Province("海大")) ? "添加成功" : "添加失败");
    }

    @Test
    public void testUpdate(){
        System.out.println(provinceService.updateProvinceById(new Province(5, "海南")) ? "修改成功" : "修改失败");
    }

    @Test
    public void testFindByName(){
        System.out.println(provinceService.findProvinceByName("北京"));
    }

    @Test
    public void testFindCount(){
        System.out.println(provinceService.findCount());
    }
}
