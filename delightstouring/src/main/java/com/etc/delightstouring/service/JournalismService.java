package com.etc.delightstouring.service;

import com.etc.delightstouring.domain.Journalism;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @interface JournalismService
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/27 15:09
 * @Version 1.0
 **/
public interface JournalismService {

    /**
     * 增：新增用户信息
     * @param journalism
     * @return
     */
    boolean addJournalism(Journalism journalism);

    /**
     * 删：根据编号删除新闻信息
     * @param jid
     * @return
     */
    boolean delJournalismById(Integer jid);

    /**
     * 改：根据编号修改用户信息
     * @param journalism
     * @return
     */
    boolean updateJournalismById(Journalism journalism);

    /**
     * 降序查询：查询所有信息信息
     * @return
     */
    PageInfo<Journalism> findAllJournalism(Integer pageNum, Integer pageSize);

    /**
     * 模糊降序查询：根据新闻描述查询
     * @param jDescribe
     * @return
     */
    PageInfo<Journalism> findJournalismLikeDescribe(String jDescribe, Integer pageNum, Integer pageSize);
}
