package com.offcn.sys.service;

import com.offcn.sys.bean.Role;

import java.util.List;

public interface RoleService {


    int addRole(Role role);

    List<Role> roleList();


}
