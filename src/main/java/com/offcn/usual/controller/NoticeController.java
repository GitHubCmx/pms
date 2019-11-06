package com.offcn.usual.controller;

import com.offcn.common.ResultEntity;
import com.offcn.usual.bean.Notice;
import com.offcn.usual.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "/windowShow/{nid}",method = RequestMethod.GET)
    @ResponseBody
    public  ResultEntity windowShow(@PathVariable("nid") Integer nid){
       Notice notice =  noticeService.windowShow(nid);
        return ResultEntity.success().put("notice",notice);
    }

    @RequestMapping(value = "/newNoticeList",method = RequestMethod.GET)
    @ResponseBody
    public ResultEntity newNoticeList(){
        List<Notice> list = noticeService.newNoticeList();
        return  ResultEntity.success().put("list",list);
    }

    @RequestMapping(value = "/jsonList",method = RequestMethod.GET)
    @ResponseBody
    public ResultEntity selectNoticeList(){
       List<Notice> list =  noticeService.selectNoticeList();
        return   ResultEntity.success().put("list",list);

    }

    @RequestMapping(value = "/addNotice",method = RequestMethod.POST)
    @ResponseBody
    public ResultEntity addNotice(Notice notice){
        noticeService.addNotice(notice);
        return   ResultEntity.success();

    }

}
