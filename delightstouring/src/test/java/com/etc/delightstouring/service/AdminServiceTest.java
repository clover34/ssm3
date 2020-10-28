package com.etc.delightstouring.service;

import com.etc.delightstouring.domain.Admin;
import com.etc.delightstouring.utils.CounterUtil;
import com.etc.delightstouring.utils.UUIDUtil;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName AdminServiceTest
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/28 11:00
 * @Version 1.0
 **/
public class AdminServiceTest {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    AdminService adminService = context.getBean("adminServiceImpl", AdminService.class);

    @Test
    public void testaddAdmin(){
        Admin admin = new Admin();
        admin.setaName("管路员02");
        admin.setaPhone("11111");
        admin.setaRole("admin");
        admin.setPassword("123");
        System.out.println(adminService.addAdmin(admin));
    }

    @Test
    public void tsetDel(){
        System.out.println(adminService.delAdminById("admin0002"));
    }

    @Test
    public void testUpdate(){
        Admin admin = new Admin();
        admin.setaId("admin0001");
        admin.setaName("管路员03");
        admin.setaPhone("22222");
        admin.setaRole("admin");
        admin.setPassword("123");
        System.out.println("adminService.updateAdminById(admin) = " + adminService.updateAdminById(admin));
    }

    @Test
    public void testfindAdminById(){
        System.out.println(adminService.findAdminById("admin0003"));
    }

    @Test
    public void testfindAdminByName(){
        System.out.println(adminService.findAdminByName("管理员02"));
    }

    @Test
    public void testfindAdminLikeName(){
        System.out.println(adminService.findAdminLikeName("3","1", 1, 1));
    }

    @Test
    public void testfindAdminByNameAndPwd(){
        System.out.println(adminService.findAdminByNameAndPwd("管理员03", "123"));
    }

    @Test
    public void testfindCount(){
        System.out.println(adminService.findCount());
    }
}
