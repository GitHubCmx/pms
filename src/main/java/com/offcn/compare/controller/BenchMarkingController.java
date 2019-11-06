package com.offcn.compare.controller;

import com.offcn.compare.bean.BenchMarking;
import com.offcn.compare.service.BenchMarkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/marking")
public class BenchMarkingController {

    @Autowired
    private BenchMarkingService benchMarkingService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(BenchMarking benchMarking){
        benchMarkingService.add(benchMarking);
        return  "redirect:/indexvalue-base.jsp";
    }
    @RequestMapping(value = "/BenchMarkingList",method = RequestMethod.GET)
    public ModelAndView BenchMarkingList(){
        ModelAndView mv = new ModelAndView("indexvalue-base");
        List<BenchMarking> list = benchMarkingService.BenchMarkingList();
        mv.addObject("list",list);
        return mv;
    }
}
