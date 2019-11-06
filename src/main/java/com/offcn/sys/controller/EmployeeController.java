package com.offcn.sys.controller;

import com.offcn.sys.bean.Employee;
import com.offcn.sys.service.EmpRoleService;
import com.offcn.sys.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

     @Autowired
     private EmployeeService employeeService;

     @Autowired
     private EmpRoleService empRoleService;

     @RequestMapping(value = "/select",method = RequestMethod.GET)
     public ModelAndView selectUser(){
        List<Employee> list =  employeeService.selectUser();
         ModelAndView mv = new ModelAndView("user");
         mv.addObject("list",list);

         return mv;


     }

     @RequestMapping(value = "/addUser",method = RequestMethod.POST)
     public String addUser(Employee employee,Integer[] roleid){
        Integer eid = employeeService.addUser(employee);
         for (Integer rid : roleid) {
             empRoleService.insert(eid,rid);
         }
         return "redirect:/user.jsp";
     }
     @RequestMapping(value = "/login",method = RequestMethod.POST)
     public String login(Employee employee, String code, HttpSession session){
         String validateCode = (String)session.getAttribute("validateCode");
          //验证码如果通过就进入if
         if(code.equalsIgnoreCase(validateCode)){
             session.removeAttribute("validateCode");//验证码输入正确，删除图片随机验证码
             //验证用户是否登录
             employee = employeeService.login(employee);
             if(employee != null){//用户名和密码正确，登录成功
                 session.setAttribute("loginUser",employee);//登录成功的用户信息存入会话
                 return "redirect:/index.jsp";//跳转登录成功界面
             }else {//用户名或密码不正确，登录失败
                /* attributes.addFlashAttribute("errorMsg","用户名或者密码错误");*/
                 return "redirect:/login.jsp";//返回登录界面
             }
         }
         /*attributes.addFlashAttribute("errorMsg","验证码错误");*/
         return "redirect:/login.jsp";
     }


    @RequestMapping(value = "/managers",method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> managers(){
        List<Employee> list =  employeeService.managers();
       return list;
    }


}
