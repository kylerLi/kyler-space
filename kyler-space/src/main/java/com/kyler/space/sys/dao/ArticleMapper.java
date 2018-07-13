package com.kyler.space.sys.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

import com.kyler.space.common.Criteria;
import com.kyler.space.sys.pojo.Article;

public interface ArticleMapper {
	
	int insertSelective(Article article);
	
	int insert(Article article);
	
    int countByParams(Criteria example);

    int deleteByParams(Criteria example);

    int deleteByPrimaryKey(String id);

    List<Article> selectByParams(Criteria example);

    List<Article> selectSummaryByParams(Criteria example);
    
    int updateByParams(@Param("record") Article record, @Param("condition") Map<String, Object> condition);

    int updateByPrimaryKey(Article record);
    
    Article selectByPrimaryKey(String id);
    
	int updateByPrimaryKeySelective(Article record);

}