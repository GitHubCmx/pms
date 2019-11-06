package com.offcn.sys.controller;

import com.offcn.common.ResultEntity;
import com.offcn.sys.bean.Sources;
import com.offcn.sys.service.SourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sources")
public class SourcesController {

    @Autowired
    private SourcesService sourcesService;

    //删
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    @ResponseBody
    public ResultEntity delete(Integer id){
        sourcesService.delete(id);
        return ResultEntity.success();
    }
    //回填
    @RequestMapping(value = "/updateInfo",method = RequestMethod.PUT)
    public String updateInfo(Sources sources){
        sourcesService.updateInfo(sources);
        return "redirect:/pm.jsp";
    }


    //回填查
    @RequestMapping(value = "/getSourcesById/{id}",method = RequestMethod.GET)
    public ModelAndView getSourcesById(@PathVariable("id") Integer id){
        Sources sources =  sourcesService.getSourcesById(id);
        ModelAndView mv = new ModelAndView("pm-edit");
        mv.addObject("onesource",sources);
        return mv;
    }


    //增
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addsources(Sources sources){
        sourcesService.addsources(sources);
        return "redirect:/pm.jsp";
    }

    //查
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public List<Sources> getSourcesList(){
        List<Sources> list =  sourcesService.getSourcesListByPid(0);
        QueryChildList(list.get(0));//查询子节点对象
        return list;
    }

    //递归查询
    private void QueryChildList(Sources source) {
        Integer id = source.getId();//父节点对象的id
        //父节点对象的id作为子节点对象的pid 查询出子节点对象们
        List<Sources> sources = sourcesService.getSourcesListByPid(id);
        for (Sources source1 : sources) {
            QueryChildList(source1);
        }
        source.setChildren(sources);
    }

}
