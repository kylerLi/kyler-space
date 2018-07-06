package com.kyler.space.sys.service;

import java.util.List;

import com.kyler.space.common.Criteria;
import com.kyler.space.sys.pojo.Article;

public interface ArticleService {
    int countByParams(Criteria example);

    Article selectByPrimaryKey(String id);

    List<Article> selectByParams(Criteria example);

    int deleteByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    int deleteByParams(Criteria example);

    int updateByParamsSelective(Article record, Criteria example);

    int insert(Article record);

    int insertSelective(Article record);
}