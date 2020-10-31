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
        boolean b = scenicspotService.addScenicspot(new Scenicspot(UUIDUtil.getUUID(), "1", "测试景点01", 2, 1, "在外方知家乡意，海花相伴到佳节", "海南省", "/upload/1.png", "5:00-21:00"));
        boolean b1 = scenicspotService.addScenicspot(new Scenicspot(UUIDUtil.getUUID(), "1", "测试景点02", 2, 1, "在外方知家乡意，海花相伴到佳节", "海南省", "/upload/1.png", "5:00-21:00"));
        boolean b2 = scenicspotService.addScenicspot(new Scenicspot(UUIDUtil.getUUID(), "1", "测试景点03", 2, 1, "在外方知家乡意，海花相伴到佳节", "海南省", "/upload/1.png", "5:00-21:00"));
        boolean b3 = scenicspotService.addScenicspot(new Scenicspot(UUIDUtil.getUUID(), "1", "测试景点04", 2, 1, "在外方知家乡意，海花相伴到佳节", "海南省", "/upload/1.png", "5:00-21:00"));
        boolean b4 = scenicspotService.addScenicspot(new Scenicspot(UUIDUtil.getUUID(), "1", "测试景点05", 2, 1, "在外方知家乡意，海花相伴到佳节", "海南省", "/upload/1.png", "5:00-21:00"));
        System.out.println(b);
    }

    @Test
    public void testDel(){
        boolean b = scenicspotService.delScenicspotById("1");
        System.out.println(b);
    }

    @Test
    public void testUpdate(){
        boolean b = scenicspotService.updateScenicspotById(new Scenicspot("1", "嵩山", null, null, "嵩山少林", "河南省登封市", "ss", "全天候开放"));
        System.out.println(b);
    }

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
        Scenicspot scenicspot = scenicspotService.findScenicspotByName("山");
        System.out.println(scenicspot);
    }

    @Test
    public void testfindScenicspotByDescribe(){
        PageInfo<Scenicspot> allScenicspot = scenicspotService.findScenicspotByDescribe("小", 1, 1);
        System.out.println(allScenicspot);
    }

    @Test
    public void testfindScenicspotByCondition(){
        PageInfo<Scenicspot> allScenicspot = scenicspotService.findScenicspotByCondition(null, null,
                "嵩", "山", 1, 1);
        System.out.println(allScenicspot);
    }

    @Test
    public void testFindById(){
        System.out.println(scenicspotService.findScenicspotById("ss0001"));
    }
}
