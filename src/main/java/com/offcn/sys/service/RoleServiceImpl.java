package com.offcn.sys.service;

import com.offcn.sys.bean.Role;
import com.offcn.sys.bean.RoleExample;
import com.offcn.sys.mapper.RoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
     private  RoleMapper roleMapper;

    public int addRole(Role role) {
       roleMapper.addRole(role);//添加角色并返回添加后的角色roleid
        Integer roleid = role.getRoleid();
        return roleid;
    }

    public List<Role> roleList() {
        RoleExample example = new RoleExample();
        return roleMapper.selectByExample(example);
    }



}
