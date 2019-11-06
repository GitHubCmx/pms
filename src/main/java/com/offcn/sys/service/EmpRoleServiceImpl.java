package com.offcn.sys.service;

import com.offcn.sys.mapper.EmpRoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmpRoleServiceImpl implements EmpRoleService{

    @Resource
    private EmpRoleMapper empRoleMapper;

    public void insert(Integer eid, Integer rid) {
        empRoleMapper.insert(eid,rid);
    }
}
