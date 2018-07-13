package com.kyler.space.sys.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyler.space.common.Criteria;
import com.kyler.space.sys.dao.ArticleMapper;
import com.kyler.space.sys.pojo.Article;
import com.kyler.space.sys.service.ArticleService;

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

    public int deleteByPrimaryKey(String id) {
        return this.articleMapper.deleteByPrimaryKey(id);
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
	public List<Article> selectByParams(Criteria example) {
		// TODO Auto-generated method stub
		return this.articleMapper.selectByParams(example);
	}

	@Override
	public int updateByPrimaryKeySelective(Article record) {
		// TODO Auto-generated method stub
		return this.articleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Article record) {
		// TODO Auto-generated method stub
		return this.articleMapper.updateByPrimaryKey(record);
	}

	@Override
	public Article selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return this.articleMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Article> selectSummaryByParams(Criteria example) {
		// TODO Auto-generated method stub
		return this.articleMapper.selectSummaryByParams(example);
	}

}