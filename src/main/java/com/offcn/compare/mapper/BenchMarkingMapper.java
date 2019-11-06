package com.offcn.compare.mapper;

import com.offcn.compare.bean.BenchMarking;

import java.util.List;

public interface BenchMarkingMapper {
    void insert(BenchMarking benchMarking);

    List<BenchMarking> select();
}
