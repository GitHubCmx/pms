package com.offcn.sys.mapper;

import org.apache.ibatis.annotations.Param;

public interface EmpRoleMapper {
    public void insert(@Param("eid")Integer eid, @Param("rid")Integer rid);
}
