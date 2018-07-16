package com.kyler.space.sys.service;

import com.kyler.space.common.Criteria;
import com.kyler.space.sys.pojo.CodeCategory;
import java.util.List;

public interface CodeCategoryService {
    int countByParams(Criteria example);

    CodeCategory selectByPrimaryKey(Long categorySid);

    List<CodeCategory> selectByParams(Criteria example);

    int deleteByPrimaryKey(Long categorySid);

    int updateByPrimaryKeySelective(CodeCategory record);

    int updateByPrimaryKey(CodeCategory record);

    int deleteByParams(Criteria example);

    int insert(CodeCategory record);

    int insertSelective(CodeCategory record);
}