package com.iwanvi.bigdata.inter.service;


import com.iwanvi.bigdata.inter.domain.hadoop_data.ZwzxChapterReadUserNum;
import com.iwanvi.bigdata.inter.domain.hadoop_data.ZwzxChapterReadUserNumView;

import java.util.List;

public interface ZwzxChapterReadUserNumService {


    List<ZwzxChapterReadUserNum> selectChapterNumByPage(Integer startPage, Integer pageSize,
                                                        String startTime, String endTime,
                                                        String bookId, String bookName,
                                                        Integer begChap, Integer endChap);

    int selectChapterNumCount(String startTime, String endTime,
                              String bookId, String bookName,
                              Integer begChap, Integer endChap);

    List<ZwzxChapterReadUserNumView> selectChapterNumViewByPage(Integer startPage, Integer pageSize,
                                                                String startTime, String endTime,
                                                                String bookId, String bookName,
                                                                Integer begChap, Integer endChap);
}
