package com.offcn.usual.service;

import com.offcn.usual.bean.Notice;
import com.offcn.usual.bean.NoticeExample;
import com.offcn.usual.mapper.NoticeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Resource
    private NoticeMapper noticeMapper;

    public void addNotice(Notice notice) {
        notice.setNdate(new Date());
        noticeMapper.insert(notice);
    }

    public List<Notice> selectNoticeList() {
        NoticeExample example = new NoticeExample();
        List<Notice> list = noticeMapper.selectByExample(example);
        return list;
    }

    public List<Notice> newNoticeList() {
        NoticeExample example = new NoticeExample();
        NoticeExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("ndate desc limit 3");
        List<Notice> list = noticeMapper.selectByExample(example);
        return list;
    }

    public Notice windowShow(Integer nid) {
        return noticeMapper.selectByPrimaryKey(nid);
    }

}
