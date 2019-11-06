package com.offcn.pro.service;

import com.offcn.cust.bean.Customer;
import com.offcn.cust.mapper.CustomerMapper;
import com.offcn.pro.bean.Project;
import com.offcn.pro.bean.ProjectExample;
import com.offcn.pro.mapper.ProjectMapper;
import com.offcn.sys.bean.Employee;
import com.offcn.sys.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Resource
    private ProjectMapper projectMapper;
    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private EmployeeMapper employeeMapper;

    //查询项目全部信息
    public List<Project> listProject() {
        ProjectExample projectExample = new ProjectExample();
        List<Project> projects = projectMapper.selectByExample(projectExample);
        for (Project project : projects) {
            Integer cid = project.getComname();
            Customer customer = customerMapper.selectByPrimaryKey(cid);//客户公司名称 comname 客户负责人companyperson
            project.setCustomer(customer);
            Integer eid = project.getEmpFk();
            Employee emp = employeeMapper.selectByPrimaryKey(eid);//项目经理 ename
            project.setEmployee(emp);
        }
        return projects;
    }

    //保存项目信息
    public void addProject(Project project) {

        projectMapper.insert(project);

    }
     //批量删除
    public Boolean batchDelProject(Integer[] ids) {
        ProjectExample example = new ProjectExample();
        List<Integer> list = Arrays.asList(ids);
        ProjectExample.Criteria criteria = example.createCriteria();
        criteria.andPidIn(list);
        int i = projectMapper.deleteByExample(example);
        return i==ids.length;
    }

    //单个查询
    public Project selectProject(Integer pid) {
        Project project = projectMapper.selectByPrimaryKey(pid);
        project.setCustomer(customerMapper.selectByPrimaryKey(project.getComname()));
        project.setEmployee(employeeMapper.selectByPrimaryKey(project.getEmpFk()));
        return project;
    }

    //搜索表单
    public List<Project> searchProject(Integer cid, String keyword, Integer orderby) {
        List<Project> list = projectMapper.searchProjectList(cid, keyword, orderby);
        return list;
    }
}
