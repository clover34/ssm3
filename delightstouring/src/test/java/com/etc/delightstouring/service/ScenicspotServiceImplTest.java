package com.etc.delightstouring.service;

import com.etc.delightstouring.domain.Scenicspot;
import com.etc.delightstouring.utils.UUIDUtil;
import com.github.pagehelper.PageInfo;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName ScenicspotServiceImplTest
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/27 16:31
 * @Version 1.0
 **/
public class ScenicspotServiceImplTest {
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    private ScenicspotService scenicspotService = context.getBean("scenicspotServiceImpl",ScenicspotService.class);

    @Test
    public void testAdd(){
        boolean b = scenicspotService.addScenicspot(new Scenicspot(UUIDUtil.getUUID(), "1", "泰山", 1, 1, "一览众山小", "山东省", "11", "全天候开放"));
        System.out.println(b);
    }

    @Test
    public void testDel(){
        boolean b = scenicspotService.delScenicspotById(1);
        System.out.println(b);
    }

    @Test
    public void testUpdate(){
        boolean b = scenicspotService.updateScenicspotById(new Scenicspot("1", "嵩山", null, null, "嵩山少林", "河南省登封市", "ss", "全天候开放"));
        System.out.println(b);
    }

    /*@Test
    public void testfindCount(){
        int count = scenicspotService.findCount(1);
        System.out.println(count);
    }*/

    @Test
    public void testfindAllScenicspot(){
        PageInfo<Scenicspot> allScenicspot = scenicspotService.findAllScenicspot(1, 1);
        System.out.println(allScenicspot);
    }

    @Test
    public void testfindScenicspotByPid(){
        PageInfo<Scenicspot> allScenicspot = scenicspotService.findScenicspotByPid(1, 1,1);
        System.out.println(allScenicspot);
    }

    @Test
    public void testfindScenicspotByRid(){
        PageInfo<Scenicspot> allScenicspot = scenicspotService.findScenicspotByRid(1, 1, 1);
        System.out.println(allScenicspot);
    }

    @Test
    public void testfindScenicspotByName(){
        PageInfo<Scenicspot> allScenicspot = scenicspotService.findScenicspotByName("山", 1,1);
        System.out.println(allScenicspot);
    }

    @Test
    public void testfindScenicspotByDescribe(){
        PageInfo<Scenicspot> allScenicspot = scenicspotService.findScenicspotByDescribe("小", 1, 1);
        System.out.println(allScenicspot);
    }

    @Test
    public void testfindScenicspotByCondition(){
        PageInfo<Scenicspot> allScenicspot = scenicspotService.findScenicspotByCondition(null, "嵩", "山", 1, 1);
        System.out.println(allScenicspot);
    }
}
