package com.kyler.space.blog.service.impl;

import com.kyler.space.blog.dao.ArticleMapper;
import com.kyler.space.blog.pojo.Article;
import com.kyler.space.blog.service.ArticleService;
import com.kyler.space.common.Criteria;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
	
    @Autowired
    private ArticleMapper articleMapper;

    private static final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    public int countByParams(Criteria example) {
        int count = this.articleMapper.countByParams(example);
        logger.debug("count: {}", count);
        return count;
    }

    public Article selectByPrimaryKey(String id) {
        return this.articleMapper.selectByPrimaryKey(id);
    }

    public List<Article> selectByParams(Criteria example) {
        return this.articleMapper.selectByParams(example);
    }

    public int deleteByPrimaryKey(String id) {
        return this.articleMapper.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Article record) {
        return this.articleMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Article record) {
        return this.articleMapper.updateByPrimaryKey(record);
    }

    public int deleteByParams(Criteria example) {
        return this.articleMapper.deleteByParams(example);
    }

    public int insert(Article record) {
        return this.articleMapper.insert(record);
    }

    public int insertSelective(Article record) {
        return this.articleMapper.insertSelective(record);
    }

	@Override
	public List<Article> selectSummaryByParams(Criteria example) {
		// TODO Auto-generated method stub
		return this.articleMapper.selectSummaryByParams(example);
	}
}