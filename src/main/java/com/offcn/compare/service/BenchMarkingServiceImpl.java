package com.offcn.compare.service;

import com.offcn.compare.bean.BenchMarking;
import com.offcn.compare.mapper.BenchMarkingMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BenchMarkingServiceImpl implements BenchMarkingService {

    @Resource
    private BenchMarkingMapper benchMarkingMapper;

    public void add(BenchMarking benchMarking) {
        benchMarkingMapper.insert(benchMarking);
    }

    public List<BenchMarking> BenchMarkingList() {
        return benchMarkingMapper.select();
    }
}
