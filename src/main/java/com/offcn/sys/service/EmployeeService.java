package com.offcn.sys.service;

import com.offcn.sys.bean.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {


    List<Employee> managers();

    Employee login(Employee employee);

    Integer addUser(Employee employee);

    List<Employee> selectUser();
}
