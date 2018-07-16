package com.kyler.space.blog.dao;

import com.kyler.space.blog.pojo.Article;
import com.kyler.space.common.Criteria;

import java.util.List;

public interface ArticleMapper {
	
    /**
     * 根据条件查询记录总数
     */
    int countByParams(Criteria example);

    /**
     * 根据条件删除记录
     */
    int deleteByParams(Criteria example);

    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(Article record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(Article record);

    /**
     * 根据条件查询记录集
     */
    List<Article> selectByParams(Criteria example);
    
    List<Article> selectSummaryByParams(Criteria example);
    
    /**
     * 根据主键查询记录
     */
    Article selectByPrimaryKey(String id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(Article record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(Article record);
}