package com.kyler.space.sys.service;

import com.kyler.space.common.Criteria;
import com.kyler.space.sys.pojo.User;
import java.util.List;

public interface UserService {
    int countByParams(Criteria example);

    User selectByPrimaryKey(Long USER_SID);

    List<User> selectByParams(Criteria example);

    int deleteByPrimaryKey(Long USER_SID);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int deleteByParams(Criteria example);

    int updateByParamsSelective(User record, Criteria example);

    int updateByParams(User record, Criteria example);

    int insert(User record);

    int insertSelective(User record);
}