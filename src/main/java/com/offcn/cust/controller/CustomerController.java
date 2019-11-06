package com.offcn.cust.controller;

import com.offcn.cust.bean.Customer;
import com.offcn.cust.service.CustomerService;
import com.offcn.pro.bean.Project;
import com.offcn.pro.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cust")
public class CustomerController {


    @Autowired
    private CustomerService customerService;


    //根据id查询客户信息
    @RequestMapping(value = "/info/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Customer info(@PathVariable("id") Integer id){
        return customerService.getCustomerRead(id);
    }
     //获取客户信息
    @RequestMapping(value = "/jsonList",method = RequestMethod.GET)
    @ResponseBody
    public  List<Customer> getCustomerJsonList(){
        List<Customer> list = customerService.getCustomerList();
        return list;
    }

    //搜索
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public ModelAndView search(Integer cid,String keyword,Integer orderby){
        List<Customer> list = customerService.search(cid,keyword,orderby);
        ModelAndView mv = new ModelAndView("customer");
        mv.addObject("customerList",list);
        return mv;
    }

    //批量删除
    @RequestMapping(value = "/delCustomer",method = RequestMethod.DELETE)
    @ResponseBody
   public Map<String,Object>  delCustomer(@RequestParam("ids[]") Integer[] ids){
        for (Integer id : ids) {
            System.out.println(id);
        }
       Boolean isSuccess =  customerService.delCustomer(ids);
        Map<String,Object> map = new HashMap<String, Object>();
       if(isSuccess){
           map.put("statusCode",200);
           map.put("message","删除成功");
       }else{
           map.put("statusCode",500);
           map.put("message","删除失败");
       }
        return map;
    }
    //编辑
    @RequestMapping(value = "/updateCustomer",method = RequestMethod.PUT)
    public String updateCustomer(Customer customer){
        customerService.updateCustomer(customer);
        return "redirect:/cust/list";
    }

     //编辑回填
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable("id") Integer id, Map<String,Object> map){
        Customer customer  = customerService.getCustomerRead(id);
        map.put("customer",customer);
        return "customer-edit";
    }
    //查询详情
    @RequestMapping(value = "/read/{id}",method = RequestMethod.GET)
    public String read(@PathVariable("id") Integer id, Map<String,Object> map){
       Customer customer  = customerService.getCustomerRead(id);
        map.put("customer",customer);
        return "customer-look";
    }
    //添加
    @RequestMapping(value = "/addCustomer",method = RequestMethod.POST)
    public String addCustomer(Customer customer){
        customerService.addCustomer(customer);
       return "redirect:/cust/list";
    }

    //客户信息
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView getCustomerList(){
       List<Customer> list = customerService.getCustomerList();
        ModelAndView mv = new ModelAndView("customer");
       mv.addObject("customerList",list);
        return mv;
    }
}
