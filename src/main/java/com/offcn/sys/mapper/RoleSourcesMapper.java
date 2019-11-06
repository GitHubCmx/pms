package com.offcn.sys.mapper;

import org.apache.ibatis.annotations.Param;

public interface RoleSourcesMapper {

    void addRoleSources(@Param("rid") int roleid,@Param("sid") String sid);
}
