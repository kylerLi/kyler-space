package com.kyler.space.sys.service;

import com.kyler.space.common.Criteria;
import com.kyler.space.sys.pojo.Project;
import java.util.List;

public interface ProjectService {
    int countByParams(Criteria example);

    Project selectByPrimaryKey(Long projectSid);

    List<Project> selectByParams(Criteria example);

    int deleteByPrimaryKey(Long projectSid);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

    int deleteByParams(Criteria example);

    int updateByParamsSelective(Project record, Criteria example);

    int updateByParams(Project record, Criteria example);

    int insert(Project record);

    int insertSelective(Project record);
}