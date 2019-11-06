package com.offcn.sys.service;

import com.offcn.sys.bean.Employee;
import com.offcn.sys.bean.EmployeeExample;
import com.offcn.sys.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Resource
    private EmployeeMapper employeeMapper;

    public List<Employee> managers() {
        EmployeeExample employee = new EmployeeExample();
        EmployeeExample.Criteria criteria = employee.createCriteria();
        criteria.andPFkEqualTo(4);//id等于4的项目经理
        List<Employee> list = employeeMapper.selectByExample(employee);
        return list;
    }

    public Employee login(Employee employee) {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(employee.getUsername());
        criteria.andPasswordEqualTo(employee.getPassword());
        List<Employee> employees = employeeMapper.selectByExample(example);
        if(employees != null && employees.size()>0){
             employee = employees.get(0);
             return employee;

        }
        return null;
    }

    public Integer addUser(Employee employee) {
        employeeMapper.addUser(employee);
        Integer eid = employee.getEid();
        return eid;
    }

    public List<Employee> selectUser() {
        return employeeMapper.selectListUser();
    }


}
