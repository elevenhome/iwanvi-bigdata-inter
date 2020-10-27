package com.iwanvi.bigdata.inter.dao.hadoop_data;

import com.iwanvi.bigdata.inter.domain.hadoop_data.ZwzxChapterReadUserNum;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZwzxChapterReadUserNumMapper {

    List<ZwzxChapterReadUserNum> selectByPage(@Param("startPage") Integer startPage,
                                              @Param("pageSize")Integer pageSize,
                                              @Param("startTime")String startTime,
                                              @Param("endTime")String endTime,
                                              @Param("bookId")String bookId,
                                              @Param("bookName")String bookName);

    int selectCount(@Param("startTime")String startTime,
                    @Param("endTime")String endTime,
                    @Param("bookId")String bookId,
                    @Param("bookName")String bookName);

    List<ZwzxChapterReadUserNum> selectChapterNumByPage(@Param("startPage") Integer startPage,
                                              @Param("pageSize")Integer pageSize,
                                              @Param("startTime")String startTime,
                                              @Param("endTime")String endTime,
                                              @Param("bookId")String bookId,
                                              @Param("bookName")String bookName,
                                              @Param("begChap")Integer begChap,
                                              @Param("endChap")Integer endChap);

    int selectChapterNumCount(@Param("startTime")String startTime,
                    @Param("endTime")String endTime,
                    @Param("bookId")String bookId,
                    @Param("bookName")String bookName,
                    @Param("begChap")Integer begChap,
                    @Param("endChap")Integer endChap);


}