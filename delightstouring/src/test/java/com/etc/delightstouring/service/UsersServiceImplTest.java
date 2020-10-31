package com.etc.delightstouring.service;

import com.etc.delightstouring.domain.Users;
import com.etc.delightstouring.utils.CounterUtil;
import com.etc.delightstouring.utils.UUIDUtil;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName UsersServiceImplTest
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/27 18:37
 * @Version 1.0
 **/
public class UsersServiceImplTest {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    UsersService usersService = context.getBean("usersServiceImpl", UsersService.class);

    @Test
    public void tsetAdd(){
        Users user = new Users();
        user.setuPhotopath("11");
        user.setUsername("李四");
        user.setPassword("123");
        user.setuPhone("18389333565");
        boolean b = usersService.addUser(user);
        System.out.println(b);
    }

    @Test
    public void testupdateUserById(){
        Users user = new Users();
        user.setUUID(UUIDUtil.getUUID());
        user.setuId("user0001");
        user.setuPhotopath("11111111111111");
        user.setUsername("qq1qqqqqqqqqq");
        user.setPassword("123");
        user.setuPhone("123456789");
        user.setuExists(1);
        boolean b = usersService.updateUserById(user);
        System.out.println(b);
    }

    @Test
    public void testdelUserById(){
        Users user = new Users();
        user.setUUID(UUIDUtil.getUUID());
        boolean user0001 = usersService.delUserById("user0001");
        System.out.println(user0001);
    }


    @Test
    public void testfindUserByNameAndPwd(){
        Users user = usersService.findUserByNameAndPwd("qq1qqqqqqqqqq", "123");
        System.out.println(user);
    }

    @Test
    public void testfindUserByPhone(){
        Users userByPhone = usersService.findUserByPhone("17608994857");
        System.out.println(userByPhone);
    }

    @Test
    public void testfindUserById(){
        Users users = usersService.findUserById("user0001");
        System.out.println(users);
    }

    @Test
    public void testfindUserByName(){
        Users qq = usersService.findUserByName("qq");
        System.out.println(qq);
    }

    @Test
    public void testfindUserLikeName(){
        PageInfo<Users> qq = usersService.findUserLikeName("qq", 1, 1);
        System.out.println(qq);
    }

    @Test
    public void testfindUsersLikeByNameAndExists(){
        PageInfo<Users> qq = usersService.findUsersLikeByNameAndExists("qq", 1, 1, 1);
        System.out.println(qq);
    }

    @Test
    public void testfindCount(){
        int count = usersService.findCount();
        System.out.println(count);
    }
}
