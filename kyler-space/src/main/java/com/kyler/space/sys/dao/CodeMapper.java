package com.kyler.space.sys.dao;

import com.kyler.space.common.Criteria;
import com.kyler.space.sys.pojo.Code;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public interface CodeMapper {
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
    int deleteByPrimaryKey(Long codeSid);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(Code record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(Code record);

    /**
     * 根据条件查询记录集
     */
    List<Code> selectByParams(Criteria example);

    /**
     * 根据主键查询记录
     */
    Code selectByPrimaryKey(Long codeSid);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(Code record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(Code record);
}