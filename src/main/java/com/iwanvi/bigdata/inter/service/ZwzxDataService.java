package com.iwanvi.bigdata.inter.service;

import com.iwanvi.bigdata.inter.domain.hadoop_data.*;

import java.util.List;

public interface ZwzxDataService {

    //活跃-阅读留存
    List<ZwzxActiveUserReadKeep> selectActiveUserReadKeepByPage(Integer startPage, Integer pageSize, String startTime, String endTime,
                                                                String bookId, String bookName);
    int selectActiveUserReadKeepCount(String startTime, String endTime, String bookId, String bookName);

    //新增-阅读留存
    List<ZwzxNewUserReadKeep> selectNewUserReadKeepByPage(Integer startPage, Integer pageSize, String startTime, String endTime,
                                                          String bookId, String bookName);
    int selectZwzxNewUserReadKeepCount(String startTime, String endTime, String bookId, String bookName);


    //章节阅读数
    List<ZwzxChapterReadUserNum> selectZwzxChapterReadUserNumByPage(Integer startPage, Integer pageSize, String startTime, String endTime,
                                                                    String bookId, String bookName);
    int selectZwzxChapterReadUserNumCount(String startTime, String endTime, String bookId, String bookName);


    //阅读完成率
    List<ZwzxChapterUserReadOver> selectZwzxChapterUserReadOverByPage(Integer startPage, Integer pageSize, String startTime, String endTime,
                                                                      String bookId, String bookName);
    int selectZwzxChapterUserReadOverCount(String startTime, String endTime, String bookId, String bookName);


    //阅读转化
    List<ZwzxDataChange> selectZwzxDataChangeByPage(Integer startPage, Integer pageSize, String startTime, String endTime,
                                                    String bookId, String bookName);
    int selectZwzxDataChangeCount(String startTime, String endTime, String bookId, String bookName);


    //阅读用户数据
    List<ZwzxReadUserData> selectZwzxReadUserDataByPage(Integer startPage, Integer pageSize, String startTime, String endTime,
                                                        String bookId, String bookName);
    int selectZwzxReadUserDataCount(String startTime, String endTime, String bookId, String bookName);




}
