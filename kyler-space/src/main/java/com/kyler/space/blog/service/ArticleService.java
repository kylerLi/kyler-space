package com.kyler.space.blog.service;

import com.kyler.space.blog.pojo.Article;
import com.kyler.space.common.Criteria;

import java.util.List;

public interface ArticleService {
    int countByParams(Criteria example);

    Article selectByPrimaryKey(String id);

    List<Article> selectByParams(Criteria example);
    
    List<Article> selectSummaryByParams(Criteria example);

    int deleteByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    int deleteByParams(Criteria example);

    int insert(Article record);

    int insertSelective(Article record);
}