package com.offcn.sys.service;

import com.offcn.sys.bean.Sources;

import java.util.List;

public interface SourcesService {
    List<Sources> getSourcesListByPid(int i);

    void addsources(Sources sources);

    Sources getSourcesById(Integer id);


    void updateInfo(Sources sources);

    void delete(Integer id);
}
