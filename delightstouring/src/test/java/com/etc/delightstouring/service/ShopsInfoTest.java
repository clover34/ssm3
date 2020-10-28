package com.etc.delightstouring.service;

import com.etc.delightstouring.domain.ShopsInfo;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @ClassName ShopsInfoTest
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/28 11:34
 * @Version 1.0
 **/
public class ShopsInfoTest {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    ShopsInfoService shopsInfoService = context.getBean("shopsInfoServiceImpl", ShopsInfoService.class);

    @Test
    public void testadd(){
        ShopsInfo shopsInfo = new ShopsInfo();
        shopsInfo.setSiName("ss");
        shopsInfo.setSiBusinesslicense("ss");
        shopsInfo.setSiPaotopath("");
        shopsInfo.setSiAddress("ddd");
        shopsInfo.setSiDescribe("rrrr");
        shopsInfo.setSiExists(1);
        shopsInfo.setSiOpendate("全天");
        shopsInfo.setSiPhone("7777777");
        shopsInfo.setuId("1");
        shopsInfo.setrId(1);
        shopsInfo.setpId(1);
        System.out.println(shopsInfoService.addShopsInfo(shopsInfo));
    }

    @Test
    public void testdel(){
        System.out.println(shopsInfoService.delShopsInfoById("si0002"));
    }

    @Test
    public void testupdate(){
        ShopsInfo shopsInfo = new ShopsInfo();
        shopsInfo.setSiName("dd");
        shopsInfo.setSiBusinesslicense("sss");
        shopsInfo.setSiPaotopath("");
        shopsInfo.setSiAddress("fff");
        shopsInfo.setSiDescribe("ffffff");
        shopsInfo.setSiExists(1);
        shopsInfo.setSiOpendate("全天");
        shopsInfo.setSiPhone("14456754564");
        shopsInfo.setuId("1");
        shopsInfo.setrId(1);
        shopsInfo.setpId(1);
        System.out.println(shopsInfoService.updateShopsInfoById(shopsInfo));
    }

    @Test
    public void testfindShopsInfoById(){
        System.out.println(shopsInfoService.findShopsInfoById("si0001"));
    }

    @Test
    public void testfindShopsInfoByName(){
        System.out.println(shopsInfoService.findShopsInfoByName("aa"));
    }

    @Test
    public void testfindShopsInfoByCondition(){
        System.out.println(shopsInfoService.findShopsInfoByCondition("a", "q", 1, 1, 1, 1, 1));
    }

    @Test
    public void findCount(){
        System.out.println(shopsInfoService.findCount());
    }

}
