package com.kyler.space.sys.service;

import com.kyler.space.common.Criteria;
import com.kyler.space.sys.pojo.Code;
import java.util.List;

public interface CodeService {
    int countByParams(Criteria example);

    Code selectByPrimaryKey(Long codeSid);

    List<Code> selectByParams(Criteria example);

    int deleteByPrimaryKey(Long codeSid);

    int updateByPrimaryKeySelective(Code record);

    int updateByPrimaryKey(Code record);

    int deleteByParams(Criteria example);

    int insert(Code record);

    int insertSelective(Code record);
}