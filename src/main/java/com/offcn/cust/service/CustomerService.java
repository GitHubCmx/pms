package com.offcn.cust.service;

import com.offcn.cust.bean.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {


    public void addCustomer(Customer customer);

    public  List<Customer> getCustomerList();

    Customer getCustomerRead(Integer id);

    void updateCustomer(Customer customer);

    Boolean delCustomer(Integer[] ids);

    List<Customer> search(Integer cid, String keyword, Integer orderby);
}
