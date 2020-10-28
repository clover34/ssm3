package com.etc.delightstouring.service.impl;

import com.etc.delightstouring.domain.Journalism;
import com.etc.delightstouring.mapper.JournalismMapper;
import com.etc.delightstouring.service.JournalismService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName JournalismServiceImpl
 * @Description TODO 新闻资讯
 * @Author Administrator
 * @Date 20/10/27 15:16
 * @Version 1.0
 **/
@Service
public class JournalismServiceImpl implements JournalismService {
    @Autowired
    private JournalismMapper journalismMapper;

    /**
     * 增：新增一条记录
     * @param journalism
     * @return
     */
    @Override
    public boolean addJournalism(Journalism journalism) {
        return journalismMapper.addJournalism(journalism) > 0 ? true : false;
    }

    /**
     * 删：根据编号删除记录
     * @param jid
     * @return
     */
    @Override
    public boolean delJournalismById(Integer jid) {
        return journalismMapper.delJournalismById(jid) > 0 ? true : false;
    }

    /**
     * 改：根据编号修改信息
     * @param journalism
     * @return
     */
    @Override
    public boolean updateJournalismById(Journalism journalism) {
        return journalismMapper.updateJournalismById(journalism) > 0 ? true : false;
    }

    /**
     * 分页降序查询：查询所有记录
     * @return
     */
    @Override
    public PageInfo<Journalism> findAllJournalism(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Journalism> journalisms = journalismMapper.findAllJournalism();
        return new PageInfo<Journalism>(journalisms);
    }

    /**
     * 分页降序条件查询：根据新闻描述查询信息
     * @param jDescribe
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Journalism> findJournalismLikeDescribe(String jDescribe, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Journalism> journalisms = journalismMapper.findJournalismLikeDescribe(jDescribe);
        return new PageInfo<Journalism>(journalisms);
    }
}
