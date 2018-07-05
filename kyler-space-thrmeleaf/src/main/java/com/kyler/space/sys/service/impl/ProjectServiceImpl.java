package com.kyler.space.sys.service.impl;

import com.kyler.space.sys.dao.ProjectMapper;
import com.kyler.space.common.Criteria;
import com.kyler.space.sys.pojo.Project;
import com.kyler.space.sys.service.ProjectService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
	
    @Autowired
    private ProjectMapper projectMapper;

    private static final Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);

    public int countByParams(Criteria example) {
        int count = this.projectMapper.countByParams(example);
        logger.debug("count: {}", count);
        return count;
    }

    public Project selectByPrimaryKey(Long projectSid) {
        return this.projectMapper.selectByPrimaryKey(projectSid);
    }

    public List<Project> selectByParams(Criteria example) {
        return this.projectMapper.selectByParams(example);
    }

    public int deleteByPrimaryKey(Long projectSid) {
        return this.projectMapper.deleteByPrimaryKey(projectSid);
    }

    public int updateByPrimaryKeySelective(Project record) {
        return this.projectMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Project record) {
        return this.projectMapper.updateByPrimaryKey(record);
    }

    public int deleteByParams(Criteria example) {
        return this.projectMapper.deleteByParams(example);
    }

    public int updateByParamsSelective(Project record, Criteria example) {
        return this.projectMapper.updateByParamsSelective(record, example.getCondition());
    }

    public int updateByParams(Project record, Criteria example) {
        return this.projectMapper.updateByParams(record, example.getCondition());
    }

    public int insert(Project record) {
        return this.projectMapper.insert(record);
    }

    public int insertSelective(Project record) {
        return this.projectMapper.insertSelective(record);
    }
}