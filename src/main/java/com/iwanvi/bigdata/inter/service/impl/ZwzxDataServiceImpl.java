package com.iwanvi.bigdata.inter.service.impl;


import com.iwanvi.bigdata.inter.dao.hadoop_data.*;
import com.iwanvi.bigdata.inter.domain.hadoop_data.*;
import com.iwanvi.bigdata.inter.service.ZwzxDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ZwzxDataServiceImpl implements ZwzxDataService {

    @Resource
    private ZwzxActiveUserReadKeepMapper activeUserReadKeepMapper;

    @Resource
    private ZwzxChapterReadUserNumMapper chapterReadUserNumMapper;

    @Resource
    private ZwzxChapterUserReadOverMapper chapterUserReadOverMapper;

    @Resource
    private ZwzxDataChangeMapper dataChangeMapper;

    @Resource
    private ZwzxNewUserReadKeepMapper newUserReadKeepMapper;

    @Resource
    private ZwzxReadUserDataMapper readUserDataMapper;



    //活跃阅读留存
    @Override
    public List<ZwzxActiveUserReadKeep> selectActiveUserReadKeepByPage(Integer startPage, Integer pageSize, String startTime, String endTime,
                                                                       String bookId, String bookName) {
        return activeUserReadKeepMapper.selectByPage(startPage,pageSize,startTime,endTime,bookId,bookName);
    }
    @Override
    public int selectActiveUserReadKeepCount(String startTime, String endTime, String bookId, String bookName) {
        return activeUserReadKeepMapper.selectCount(startTime,endTime,bookId,bookName);
    }

    //活跃阅读留存
    @Override
    public List<ZwzxNewUserReadKeep> selectNewUserReadKeepByPage(Integer startPage, Integer pageSize, String startTime, String endTime,
                                                                 String bookId, String bookName) {
        return newUserReadKeepMapper.selectByPage(startPage,pageSize,startTime,endTime,bookId,bookName);
    }
    @Override
    public int selectZwzxNewUserReadKeepCount(String startTime, String endTime, String bookId, String bookName) {
        return newUserReadKeepMapper.selectCount(startTime,endTime,bookId,bookName);
    }

    //章节阅读数
    @Override
    public List<ZwzxChapterReadUserNum> selectZwzxChapterReadUserNumByPage(Integer startPage, Integer pageSize, String startTime, String endTime,
                                                                           String bookId, String bookName) {
        return chapterReadUserNumMapper.selectByPage(startPage,pageSize,startTime,endTime,bookId,bookName);
    }
    @Override
    public int selectZwzxChapterReadUserNumCount(String startTime, String endTime, String bookId, String bookName) {
        return chapterReadUserNumMapper.selectCount(startTime,endTime,bookId,bookName);
    }


    //阅读完成率
    @Override
    public List<ZwzxChapterUserReadOver> selectZwzxChapterUserReadOverByPage(Integer startPage, Integer pageSize, String startTime, String endTime,
                                                                             String bookId, String bookName) {
        return chapterUserReadOverMapper.selectByPage(startPage,pageSize,startTime,endTime,bookId,bookName);
    }
    @Override
    public int selectZwzxChapterUserReadOverCount(String startTime, String endTime, String bookId, String bookName) {
        return chapterUserReadOverMapper.selectCount(startTime,endTime,bookId,bookName);
    }


    //阅读转化
    @Override
    public List<ZwzxDataChange> selectZwzxDataChangeByPage(Integer startPage, Integer pageSize, String startTime, String endTime,
                                                           String bookId, String bookName) {
        return dataChangeMapper.selectByPage(startPage,pageSize,startTime,endTime,bookId,bookName);
    }
    @Override
    public int selectZwzxDataChangeCount(String startTime, String endTime, String bookId, String bookName) {
        return dataChangeMapper.selectCount(startTime,endTime,bookId,bookName);
    }


    //阅读用户数据
    @Override
    public List<ZwzxReadUserData> selectZwzxReadUserDataByPage(Integer startPage, Integer pageSize, String startTime, String endTime,
                                                           String bookId, String bookName) {
        return readUserDataMapper.selectByPage(startPage,pageSize,startTime,endTime,bookId,bookName);
    }
    @Override
    public int selectZwzxReadUserDataCount(String startTime, String endTime, String bookId, String bookName) {
        return readUserDataMapper.selectCount(startTime,endTime,bookId,bookName);
    }






}
