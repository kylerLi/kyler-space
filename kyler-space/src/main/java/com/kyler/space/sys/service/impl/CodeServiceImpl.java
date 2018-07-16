package com.kyler.space.sys.service.impl;

import com.kyler.space.common.Criteria;
import com.kyler.space.sys.dao.CodeMapper;
import com.kyler.space.sys.pojo.Code;
import com.kyler.space.sys.service.CodeService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeServiceImpl implements CodeService {
    @Autowired
    private CodeMapper codeMapper;

    private static final Logger logger = LoggerFactory.getLogger(CodeServiceImpl.class);

    public int countByParams(Criteria example) {
        int count = this.codeMapper.countByParams(example);
        logger.debug("count: {}", count);
        return count;
    }

    public Code selectByPrimaryKey(Long codeSid) {
        return this.codeMapper.selectByPrimaryKey(codeSid);
    }

    public List<Code> selectByParams(Criteria example) {
        return this.codeMapper.selectByParams(example);
    }

    public int deleteByPrimaryKey(Long codeSid) {
        return this.codeMapper.deleteByPrimaryKey(codeSid);
    }

    public int updateByPrimaryKeySelective(Code record) {
        return this.codeMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Code record) {
        return this.codeMapper.updateByPrimaryKey(record);
    }

    public int deleteByParams(Criteria example) {
        return this.codeMapper.deleteByParams(example);
    }

    public int insert(Code record) {
        return this.codeMapper.insert(record);
    }

    public int insertSelective(Code record) {
        return this.codeMapper.insertSelective(record);
    }
}