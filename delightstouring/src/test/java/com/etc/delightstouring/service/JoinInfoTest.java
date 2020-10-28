package com.etc.delightstouring.service;

import com.etc.delightstouring.domain.JoinInfo;
import net.sf.jsqlparser.statement.select.Join;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @ClassName JoinInfoTest
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/28 11:15
 * @Version 1.0
 **/
public class JoinInfoTest {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    JoinInfoService joinInfoService = context.getBean("joinInfoServiceImpl", JoinInfoService.class);

    @Test
    public void tesadd(){
        JoinInfo joinInfo = new JoinInfo();
        joinInfo.setJiName("aa44");
        joinInfo.setJiBusinesslicense("qq44q");
        joinInfo.setJiAddress("44sss");
        joinInfo.setJiPaotopath("");
        joinInfo.setJiPhone("4444");
        joinInfo.setJiJoinexplain("是");
        joinInfo.setJiApplyfordate(new Date());
        joinInfo.setuId("1");
        joinInfo.setpId(1);
        joinInfo.setrId(1);
        joinInfo.setsId(12);
        System.out.println(joinInfoService.addJoinInfo(joinInfo));
    }

    @Test
    public void testUpdate(){
        JoinInfo joinInfo = new JoinInfo();
        joinInfo.setJiName("aa1");
        joinInfo.setJiBusinesslicense("qqq1");
        joinInfo.setJiAddress("sss1");
        joinInfo.setJiPaotopath("1");
        joinInfo.setJiPhone("111122");
        joinInfo.setJiJoinexplain("是");
        joinInfo.setJiApplyfordate(new Date());
        joinInfo.setuId("12");
        joinInfo.setpId(1);
        joinInfo.setrId(1);
        joinInfo.setsId(12);
        System.out.println(joinInfoService.updateJoinInfoById(joinInfo));
    }

    @Test
    public void del(){
        JoinInfo joinInfo = new JoinInfo();
        System.out.println("joinInfoService.delJoinInfoById(\"3b8f43aa-4f9f-42cb-9ca0-9ac1b673eaf0\") = " + joinInfoService.delJoinInfoById("3b8f43aa-4f9f-42cb-9ca0-9ac1b673eaf0"));
    }

    @Test
    public void testfindJoinInfoByName(){
        System.out.println(joinInfoService.findJoinInfoByName("aa1"));
    }

    @Test
    public void testfindJoinInfoByUUID(){
        System.out.println(joinInfoService.findJoinInfoByUUID("f30ccc6d-723c-432a-87b4-22599e5e2e63"));
    }

    @Test
    public void testfindJoinInfoBySId(){
        System.out.println(joinInfoService.findJoinInfoBySId(2, 1, 1));
    }
    @Test
    public void testfindJoinInfoByCondition(){
        System.out.println(joinInfoService.findJoinInfoByCondition("a", 1, 1, 1, 1));
    }

    @Test
    public void testfindCount(){
        System.out.println(joinInfoService.findCount());
    }
}
