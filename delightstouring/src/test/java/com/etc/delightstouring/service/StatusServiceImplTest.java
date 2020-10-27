package com.etc.delightstouring.service;

import com.alibaba.druid.support.spring.stat.annotation.Stat;
import com.etc.delightstouring.domain.Status;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName StatusServiceImplTest
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/27 11:47
 * @Version 1.0
 **/
public class StatusServiceImplTest {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    StatusService statusService = context.getBean("statusServiceImpl", StatusService.class);

    @Test
    public void tsetAdd(){
        // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // StatusService statusService = context.getBean("statusServiceImpl", StatusService.class);
        System.out.println(statusService.addStatus(new Status("审核中")) ? "添加成功" : "添加失败");
    }

    @Test
    public void testDel(){
        System.out.println(statusService.delStatusById(1) ? "删除成功" : "删除失败");
    }

    @Test
    public void testUpdate(){
        System.out.println(statusService.updateStatusById(new Status(1, "审核通过")) ? "修改成功" : "修改失败");
    }

    @Test
    public void testFindAll(){
        System.out.println(statusService.findAllStatus());
    }

    @Test
    public void testFindById(){
        System.out.println("statusService.findStatusById(2) = " + statusService.findStatusById(2));
    }

    @Test
    public void testFindByName(){
        System.out.println("statusService.findStatusByName(\"审核中\") = " + statusService.findStatusByName("审核中"));
    }

    @Test
    public void testFindCount(){
        System.out.println("statusService.findCount() = " + statusService.findCount());
    }
}
