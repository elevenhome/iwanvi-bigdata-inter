package com.iwanvi.bigdata.inter.dao.hadoop_data;
import com.iwanvi.bigdata.inter.domain.hadoop_data.ZwzxChapterUserReadOver;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZwzxChapterUserReadOverMapper {

    List<ZwzxChapterUserReadOver> selectByPage(@Param("startPage") Integer startPage,
                                               @Param("pageSize")Integer pageSize,
                                               @Param("startTime")String startTime,
                                               @Param("endTime")String endTime,
                                               @Param("bookId")String bookId,
                                               @Param("bookName")String bookName);

    int selectCount(@Param("startTime")String startTime,
                    @Param("endTime")String endTime,
                    @Param("bookId")String bookId,
                    @Param("bookName")String bookName);


}