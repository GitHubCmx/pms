package com.offcn.sys.controller;

import com.offcn.sys.bean.Position;
import com.offcn.sys.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/pos")
public class PositionController {

      @Autowired
      private PositionService positionService;

      @RequestMapping(value = "/jsonList",method = RequestMethod.GET)
      @ResponseBody
      public List<Position> jsonList(){
          return positionService.jsonList();
      }


}
