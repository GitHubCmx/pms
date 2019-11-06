package com.offcn.cust.service;

import com.offcn.cust.bean.Customer;
import com.offcn.cust.bean.CustomerExample;
import com.offcn.cust.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

     @Resource
    private CustomerMapper customerMapper;




    public void addCustomer(Customer customer) {
        customer.setAddtime(new Date());
        customerMapper.insert(customer);
    }

    public List<Customer> getCustomerList() {
        CustomerExample customerExample = new CustomerExample();
        return customerMapper.selectByExample(customerExample);
    }

    public Customer getCustomerRead(Integer id) {
        Customer customer =  customerMapper.selectByPrimaryKey(id);
        return customer;
    }

    public void updateCustomer(Customer customer) {
        customerMapper.updateByPrimaryKeySelective(customer);
    }

    public Boolean delCustomer(Integer[] ids) {
        List<Integer> list = Arrays.asList(ids);
        CustomerExample example = new CustomerExample();
        CustomerExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(list);
        int row = customerMapper.deleteByExample(example);
        return ids.length==row;
    }

    //搜索表单
    public List<Customer> search(Integer cid, String keyword, Integer orderby) {
        CustomerExample example = new CustomerExample();
        CustomerExample.Criteria criteria = example.createCriteria();
        if(cid == 0){
            criteria.andComnameLike("%"+keyword+"%");
            CustomerExample.Criteria criteria1=  example.createCriteria();
            criteria1.andCompanypersonLike("%"+keyword+"%");
            example.or(criteria1);
        }else if (cid == 1){
            criteria.andComnameLike("%"+keyword+"%");
        }else{
            criteria.andCompanypersonLike("%"+keyword+"%");
        }
        if(orderby == 1){
            example.setOrderByClause("id desc");
        }
        List<Customer> customers = customerMapper.selectByExample(example);
        return customers;
    }
}
