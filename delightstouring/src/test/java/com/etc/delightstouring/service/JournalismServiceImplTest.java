package com.etc.delightstouring.service;

import com.etc.delightstouring.domain.Journalism;
import com.etc.delightstouring.mapper.JournalismMapper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @ClassName JournalismServiceImplTest
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/27 15:30
 * @Version 1.0
 **/
public class JournalismServiceImplTest {
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    private JournalismService journalismService = context.getBean("journalismServiceImpl", JournalismService.class);

    @Test
    public void testAdd(){
        Journalism journalism = new Journalism();
        journalism.setjDescribe("JS代码");
        journalism.setjIssuedate(new Date());
        journalism.setjSrc("https://www.jsdaima.com/webpage/?filt=1-94");
        journalism.setjHits(100);
        System.out.println("journalismService.addJournalism(journalism) = " + journalismService.addJournalism(journalism));
    }

    @Test
    public void testUpdate(){
        Journalism journalism = new Journalism();
        journalism.setjId(2);
        journalism.setjDescribe("JS代码");
        journalism.setjIssuedate(new Date());
        journalism.setjSrc("https://www.jsdaima.com/webpage/?filt=1-94");
        journalism.setjHits(99);
        System.out.println(journalismService.updateJournalismById(journalism));
    }

    @Test
    public void testFindAll(){
        PageInfo<Journalism> page = journalismService.findAllJournalism(1, 5);
        page.getList().forEach(System.out::println);
    }

    @Test
    public void testFindLike(){
        PageInfo<Journalism> page = journalismService.findJournalismLikeDescribe("js", 1, 5);
        page.getList().forEach(System.out::println);
    }
}
