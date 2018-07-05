package com.kyler.space.sys.dao;

import com.kyler.space.common.Criteria;
import com.kyler.space.sys.pojo.Project;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public interface ProjectMapper {
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
    int deleteByPrimaryKey(Long projectSid);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(Project record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(Project record);

    /**
     * 根据条件查询记录集
     */
    List<Project> selectByParams(Criteria example);

    /**
     * 根据主键查询记录
     */
    Project selectByPrimaryKey(Long projectSid);

    /**
     * 根据条件更新属性不为空的记录
     */
    int updateByParamsSelective(@Param("record") Project record, @Param("condition") Map<String, Object> condition);

    /**
     * 根据条件更新记录
     */
    int updateByParams(@Param("record") Project record, @Param("condition") Map<String, Object> condition);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(Project record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(Project record);
}