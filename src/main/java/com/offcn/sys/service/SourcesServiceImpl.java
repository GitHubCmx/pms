package com.offcn.sys.service;

import com.offcn.sys.bean.Sources;
import com.offcn.sys.bean.SourcesExample;
import com.offcn.sys.mapper.SourcesMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SourcesServiceImpl  implements SourcesService{

    @Resource
    private SourcesMapper sourcesMapper;

    public List<Sources> getSourcesListByPid(int i) {
        SourcesExample example = new SourcesExample();
        SourcesExample.Criteria criteria = example.createCriteria();
        criteria.andPidEqualTo(i);
        List<Sources> sources = sourcesMapper.selectByExample(example);
        return sources;
    }

    public void addsources(Sources sources) {
        sourcesMapper.insert(sources);
    }

    public Sources getSourcesById(Integer id) {
        return sourcesMapper.selectByPrimaryKey(id);
    }

    public void updateInfo(Sources sources) {
        sourcesMapper.updateByPrimaryKeySelective(sources);
    }

    public void delete(Integer id) {
        sourcesMapper.deleteByPrimaryKey(id);
    }
}
