package com.etc.delightstouring.service;

import com.etc.delightstouring.domain.Newmessage;
import com.etc.delightstouring.domain.Users;
import com.etc.delightstouring.utils.CounterUtil;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @ClassName NewmessageTest
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/28 10:23
 * @Version 1.0
 **/
public class NewmessageTest {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    NewmessageService newmessageService = context.getBean("newmessageServiceImpl", NewmessageService.class);


    @Test
    public void testaddNewmessage(){
        Users users = new Users();
        users.setuId("user0001");
        boolean b = newmessageService.addNewmessage(new Newmessage(CounterUtil.getCounterStr("new",1),"1111",new Date(),users));
        System.out.println(b);
    }

    @Test
    public void testdelNewmessageById(){
        System.out.println(newmessageService.delNewmessageById(1));
    }

    @Test
    public void testupdateNewmessageById(){
        Users users = new Users();
        users.setuId("user0001");
        Newmessage newmessage = new Newmessage();
        newmessage.setNmId(1);
        newmessage.setMessage("sss");
        newmessage.setNmDate(new Date());
        boolean b = newmessageService.updateNewmessageById(newmessage);
        System.out.println(b);
    }

    @Test
    public void testfindCount(){
        System.out.println(newmessageService.findCount());
    }

    @Test
    public void testfindAllNewmessage(){
        System.out.println(newmessageService.findAllNewmessage(1, 1));

    }

    @Test
    public void testfindNewmessageById(){
        System.out.println(newmessageService.findNewmessageById(1));
    }

    @Test
    public void testfindNewmessageByUid(){
        System.out.println(newmessageService.findNewmessageByUid("user0002", 1, 1));
    }
}
