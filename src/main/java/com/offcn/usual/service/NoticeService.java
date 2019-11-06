package com.offcn.usual.service;

import com.offcn.usual.bean.Notice;

import java.util.List;

public interface NoticeService {
    void addNotice(Notice notice);

    List<Notice> selectNoticeList();

    List<Notice> newNoticeList();

    Notice windowShow(Integer nid);
}
