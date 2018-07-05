package com.kyler.space.sys.service.impl;

import com.kyler.space.sys.dao.UserMapper;
import com.kyler.space.common.Criteria;
import com.kyler.space.sys.pojo.User;
import com.kyler.space.sys.service.UserService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public int countByParams(Criteria example) {
        int count = this.userMapper.countByParams(example);
        logger.debug("count: {}", count);
        return count;
    }

    public User selectByPrimaryKey(Long USER_SID) {
        return this.userMapper.selectByPrimaryKey(USER_SID);
    }

    public List<User> selectByParams(Criteria example) {
        return this.userMapper.selectByParams(example);
    }

    public int deleteByPrimaryKey(Long USER_SID) {
        return this.userMapper.deleteByPrimaryKey(USER_SID);
    }

    public int updateByPrimaryKeySelective(User record) {
        return this.userMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(User record) {
        return this.userMapper.updateByPrimaryKey(record);
    }

    public int deleteByParams(Criteria example) {
        return this.userMapper.deleteByParams(example);
    }

    public int updateByParamsSelective(User record, Criteria example) {
        return this.userMapper.updateByParamsSelective(record, example.getCondition());
    }

    public int updateByParams(User record, Criteria example) {
        return this.userMapper.updateByParams(record, example.getCondition());
    }

    public int insert(User record) {
        return this.userMapper.insert(record);
    }

    public int insertSelective(User record) {
        return this.userMapper.insertSelective(record);
    }
}