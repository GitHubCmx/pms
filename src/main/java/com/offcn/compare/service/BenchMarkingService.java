package com.offcn.compare.service;

import com.offcn.compare.bean.BenchMarking;

import javax.annotation.Resource;
import java.util.List;

public interface BenchMarkingService {


    void add(BenchMarking benchMarking);

    List<BenchMarking> BenchMarkingList();
}
