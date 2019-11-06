package com.offcn.pro.service;

import com.offcn.pro.bean.Project;

import java.util.List;

public interface ProjectService {

    List<Project> listProject();


    void addProject(Project project);

    Boolean batchDelProject(Integer[] ids);

    Project selectProject(Integer pid);

    List<Project> searchProject(Integer cid, String keyword, Integer orderby);
}
