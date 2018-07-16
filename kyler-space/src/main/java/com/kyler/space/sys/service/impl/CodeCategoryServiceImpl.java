package com.kyler.space.sys.service.impl;

import com.kyler.space.common.Criteria;
import com.kyler.space.sys.dao.CodeCategoryMapper;
import com.kyler.space.sys.pojo.CodeCategory;
import com.kyler.space.sys.service.CodeCategoryService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeCategoryServiceImpl implements CodeCategoryService {
    @Autowired
    private CodeCategoryMapper codeCategoryMapper;

    private static final Logger logger = LoggerFactory.getLogger(CodeCategoryServiceImpl.class);

    public int countByParams(Criteria example) {
        int count = this.codeCategoryMapper.countByParams(example);
        logger.debug("count: {}", count);
        return count;
    }

    public CodeCategory selectByPrimaryKey(Long categorySid) {
        return this.codeCategoryMapper.selectByPrimaryKey(categorySid);
    }

    public List<CodeCategory> selectByParams(Criteria example) {
        return this.codeCategoryMapper.selectByParams(example);
    }

    public int deleteByPrimaryKey(Long categorySid) {
        return this.codeCategoryMapper.deleteByPrimaryKey(categorySid);
    }

    public int updateByPrimaryKeySelective(CodeCategory record) {
        return this.codeCategoryMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(CodeCategory record) {
        return this.codeCategoryMapper.updateByPrimaryKey(record);
    }

    public int deleteByParams(Criteria example) {
        return this.codeCategoryMapper.deleteByParams(example);
    }

    public int insert(CodeCategory record) {
        return this.codeCategoryMapper.insert(record);
    }

    public int insertSelective(CodeCategory record) {
        return this.codeCategoryMapper.insertSelective(record);
    }
}