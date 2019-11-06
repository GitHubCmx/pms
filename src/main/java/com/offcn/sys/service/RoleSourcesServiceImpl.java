package com.offcn.sys.service;

import com.offcn.sys.mapper.RoleSourcesMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleSourcesServiceImpl implements RoleSourcesService {

    @Resource
    private RoleSourcesMapper roleSourcesMapper;

    public void addRoleSources(int roleid, String sid) {
        roleSourcesMapper.addRoleSources(roleid,sid);
    }
}
