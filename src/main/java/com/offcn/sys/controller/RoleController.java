package com.offcn.sys.controller;

import com.offcn.common.ResultEntity;
import com.offcn.sys.bean.Role;
import com.offcn.sys.service.RoleService;
import com.offcn.sys.service.RoleSourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleSourcesService roleSourcesService;

    @RequestMapping(value = "/jsonList",method = RequestMethod.GET)
    @ResponseBody
    public List<Role> jsonList(){//给Position对象赋角色

       return roleService.roleList();
    }

    //增
    @RequestMapping(value = "/addRole",method = RequestMethod.POST)
    @ResponseBody
    public ResultEntity addRole(Role role,String ids){
       int roleid =  roleService.addRole(role);
        String[] sids = ids.split(",");
        for (String sid : sids) {
            roleSourcesService.addRoleSources(roleid,sid);
        }
        return ResultEntity.success();
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView roleList(){
      List<Role> roleList = roleService.roleList();
      ModelAndView mv =new ModelAndView("role");
      mv.addObject("roleList",roleList);
      return mv;
    }
}
