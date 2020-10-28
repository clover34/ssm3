package com.etc.delightstouring.mapper;

import com.etc.delightstouring.domain.Journalism;

import java.util.List;

/**
 * @interface JournalismMapper
 * @Description TODO
 * @Author Administrator
 * @Date 20/10/27 14:53
 * @Version 1.0
 **/
public interface JournalismMapper {
    /**
     * 增：新增用户信息
     * @param journalism
     * @return
     */
    int addJournalism(Journalism journalism);

    /**
     * 删：根据编号删除新闻信息
     * @param jid
     * @return
     */
    int delJournalismById(Integer jid);

    /**
     * 改：根据编号修改用户信息
     * @param journalism
     * @return
     */
    int updateJournalismById(Journalism journalism);

    /**
     * 降序查询：查询所有信息信息
     * @return
     */
    List<Journalism> findAllJournalism();

    /**
     * 模糊降序查询：根据新闻描述查询
     * @param jDescribe
     * @return
     */
    List<Journalism> findJournalismLikeDescribe(String jDescribe);
}
