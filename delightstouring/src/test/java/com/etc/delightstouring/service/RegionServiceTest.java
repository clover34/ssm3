package com.etc.delightstouring.service;

import com.etc.delightstouring.domain.Region;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @ClassName RegionServiceTest
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/27 9:00
 * @Version 1.0
 **/
public class RegionServiceTest {
    @Test
    public void testFindByPid(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RegionService regionService = context.getBean("regionServiceImpl", RegionService.class);
        List<Region> regions = regionService.findRegionByPid(1);
        regions.forEach(System.out::println);
    }

    @Test
    public void testFindByIdTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RegionService regionService = context.getBean("regionServiceImpl", RegionService.class);
        Region region = regionService.findRegionById(1);
        System.out.println("region = " + region);
    }

    @Test
    public void testFindByName(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RegionService regionServiceImpl = (RegionService) context.getBean("regionServiceImpl");
        Region region = regionServiceImpl.findRegionByName("东城区");
        System.out.println(region);
    }

    @Test
    public void testFindCount(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RegionService region = (RegionService) context.getBean("regionServiceImpl");
        System.out.println("region.findCount() = " + region.findCount());
    }

    @Test
    public void testFindAll(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RegionService region = (RegionService) context.getBean("regionServiceImpl");
        System.out.println("region.findAllRegion() = " + region.findAllRegion());
    }

    @Test
    public void testAdd(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RegionService region = (RegionService) context.getBean("regionServiceImpl");
        System.out.println(region.addRegion(new Region("通州区", 1)) ? "添加成功" : "添加失败");
    }

    @Test
    public void testUpdate(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RegionService regionService = (RegionService) context.getBean("regionServiceImpl");
        Region region = new Region( );
        region.setrId(7);
        region.setrName("昌平区");
        region.setpId(1);
        System.out.println(regionService.updateRegionById(region) ? "修改成功" : "修改失败");
    }
}
