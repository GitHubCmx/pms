package com.offcn.pro.controller;

import com.offcn.cust.bean.Customer;
import com.offcn.cust.service.CustomerService;
import com.offcn.pro.bean.Project;
import com.offcn.pro.service.ProjectService;
import com.offcn.sys.service.EmployeeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pro")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    //搜索表单
    @RequestMapping(value = "/searchPro",method = RequestMethod.GET)
    public ModelAndView searchProject(Integer cid,String keyword,Integer orderby){
        ModelAndView mv = new ModelAndView("project-base");
       List<Project> list =  projectService.searchProject(cid,keyword,orderby);
        mv.addObject("projectList",list);
        for (Project project : list) {
            System.out.println(list);
        }
        return mv;
    }

    @RequestMapping(value = "/updateProject",method = RequestMethod.PUT)
    public String updateProject(Project project){
        System.out.println(project);
        return "redirect:/pro/listProject";
    }

    //编辑回填
    @RequestMapping(value = "/editProject/{pid}",method = RequestMethod.GET)
    public ModelAndView editProject(@PathVariable("pid") Integer pid){
        Project project =  projectService.selectProject(pid);
        ModelAndView mv = new ModelAndView("project-base-edit");
        mv.addObject("project",project);
        return mv;
    }

    //查询信息
    @RequestMapping(value = "/selectProject/{pid}",method = RequestMethod.GET)
    public ModelAndView selectProject(@PathVariable("pid") Integer pid){
       Project project =  projectService.selectProject(pid);
        ModelAndView mv = new ModelAndView("project-base-look");
        mv.addObject("project",project);
        return mv;
    }

    @RequestMapping(value = "/batchDelProject",method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,Object> batchDelProject(@RequestParam("ids[]") Integer[] ids){
        Map<String,Object> map = new HashMap<String, Object>();
        Boolean isSuccess = projectService.batchDelProject(ids);
        if(isSuccess){
            map.put("statusCode",200);
            map.put("message","删除成功");
        }else{
            map.put("statusCode",500);
            map.put("message","删除失败");
        }
        return map;
    }


      //添加项目信息
     @RequestMapping(value = "/addProject",method = RequestMethod.POST)
     public String addProject(Project project){
          projectService.addProject(project);
         return  "redirect:/pro/listProject";

     }
     //项目信息
    @RequestMapping(value = "/listProject",method = RequestMethod.GET)
    public ModelAndView listProject(){
        List<Project> list = projectService.listProject();
        ModelAndView mv = new ModelAndView("project-base");
        mv.addObject("projectList",list);
        return mv;

    }


}
