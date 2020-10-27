package com.iwanvi.bigdata.inter.controller;

import com.iwanvi.bigdata.inter.common.CommonUtils;
import com.iwanvi.bigdata.inter.common.ResponseResult;
import com.iwanvi.bigdata.inter.domain.hadoop_data.*;
import com.iwanvi.bigdata.inter.service.ZwzxChapterReadUserNumService;
import com.iwanvi.bigdata.inter.service.ZwzxDataService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@Api(description = "中文在线数据")
public class ZwzxDataController {

    @Autowired
    private ZwzxDataService zwzxDataService;
    @Autowired
    private ZwzxChapterReadUserNumService chapterReadUserNumService;


    /**
     * 活跃用户阅读留存
     */
    @GetMapping("/zwzx/activeUserReadKeep")
    public ModelAndView activeUserReadKeep(ModelAndView mav) {
        mav.setViewName("zwzx/activeUserReadKeep");
        return mav;
    }


    @PostMapping(value = "/zwzx/getActiveUserReadKeep")
    public ResponseResult<List<ZwzxActiveUserReadKeep>> getActiveUserReadKeep(@RequestParam("page") Integer page,
                                                                              @RequestParam(value="limit") Integer limit,
                                                                              @RequestParam(value="bookId",required = false) String bookId,
                                                                              @RequestParam(value="bookName",required = false) String bookName,
                                                                              @RequestParam(value="startTime",required = false) String startTime,
                                                                              @RequestParam(value="endTime",required = false) String endTime) {
        ResponseResult<List<ZwzxActiveUserReadKeep>> result = new ResponseResult<>();
        Integer startPage = CommonUtils.getStartPage(page, limit);
        startTime = setStartTime(startTime);
        endTime = setEndTime(endTime);
        List<ZwzxActiveUserReadKeep> list = zwzxDataService.selectActiveUserReadKeepByPage(startPage, limit, startTime, endTime, bookId,bookName);
        result.setData(list);
        if (null == list || list.isEmpty()) {
            result.setCount(0);
        } else {
            result.setCount(zwzxDataService.selectActiveUserReadKeepCount(startTime, endTime, bookId, bookName));
        }
        return result;
    }



    /**
     * 新增用户阅读留存
     */
    @GetMapping("/zwzx/newUserReadKeep")
    public ModelAndView newUserReadKeep(ModelAndView mav) {
        mav.setViewName("zwzx/activeUserReadKeep");
        return mav;
    }
    @PostMapping(value = "/zwzx/getNewUserReadKeep")
    public ResponseResult<List<ZwzxNewUserReadKeep>> newUserReadKeep(@RequestParam("page") Integer page,
                                                                              @RequestParam(value="limit") Integer limit,
                                                                              @RequestParam(value="bookId",required = false) String bookId,
                                                                              @RequestParam(value="bookName",required = false) String bookName,
                                                                              @RequestParam(value="startTime",required = false) String startTime,
                                                                              @RequestParam(value="endTime",required = false) String endTime) {
        ResponseResult<List<ZwzxNewUserReadKeep>> result = new ResponseResult<>();
        Integer startPage = CommonUtils.getStartPage(page, limit);
        startTime = setStartTime(startTime);
        endTime = setEndTime(endTime);
        List<ZwzxNewUserReadKeep> list = zwzxDataService.selectNewUserReadKeepByPage(startPage, limit, startTime, endTime, bookId,bookName);
        result.setData(list);
        if (null == list || list.isEmpty()) {
            result.setCount(0);
        } else {
            result.setCount(zwzxDataService.selectZwzxNewUserReadKeepCount(startTime, endTime, bookId, bookName));
        }
        return result;
    }



    /**
     * 章节阅读用户数据
     */
    @GetMapping("/zwzx/chapterReadUserNum")
    public ModelAndView chapterReadUserNum(ModelAndView mav) {
        mav.setViewName("zwzx/chapterReadUserNum");
        return mav;
    }
    @PostMapping(value = "/zwzx/getChapterReadUserNum")
    public ResponseResult<List<ZwzxChapterReadUserNumView>> getChapterReadUserNum(@RequestParam("page") Integer page,
                                                                                  @RequestParam(value="limit") Integer limit,
                                                                                  @RequestParam(value="bookId",required = false) String bookId,
                                                                                  @RequestParam(value="bookName",required = false) String bookName,
                                                                                  @RequestParam(value="startTime",required = false) String startTime,
                                                                                  @RequestParam(value="endTime",required = false) String endTime,
                                                                                  @RequestParam(value="betweenChapter",required = false) String betweenChapter) {
        ResponseResult<List<ZwzxChapterReadUserNumView>> result = new ResponseResult<>();
        if (limit > 0 && limit <20) {
            limit = 20;
        }
        Integer startPage = CommonUtils.getStartPage(page, limit);
        startTime = setStartTime(startTime);
        endTime = setEndTime(endTime);
        if (null == betweenChapter || "".equals(betweenChapter)) betweenChapter = "1~20";
        String[] chapNum = betweenChapter.split("~");
        Integer begChap = Integer.parseInt(chapNum[0]);
        Integer endChap = Integer.parseInt(chapNum[1]);
        List<ZwzxChapterReadUserNumView> list = chapterReadUserNumService.selectChapterNumViewByPage(startPage, limit, startTime, endTime, bookId, bookName, begChap, endChap);
        result.setData(list);
        if (null == list || list.isEmpty()) {
            result.setCount(0);
        } else {
            result.setCount(chapterReadUserNumService.selectChapterNumCount(startTime, endTime, bookId, bookName, begChap, endChap));
        }
        return result;
    }
//    public ResponseResult<List<ZwzxChapterReadUserNum>> getChapterReadUserNum(@RequestParam("page") Integer page,
//                                                                              @RequestParam(value="limit") Integer limit,
//                                                                              @RequestParam(value="bookId",required = false) String bookId,
//                                                                              @RequestParam(value="bookName",required = false) String bookName,
//                                                                              @RequestParam(value="startTime",required = false) String startTime,
//                                                                              @RequestParam(value="endTime",required = false) String endTime) {
//        ResponseResult<List<ZwzxChapterReadUserNum>> result = new ResponseResult<>();
//        Integer startPage = CommonUtils.getStartPage(page, limit);
//        startTime = setStartTime(startTime);
//        endTime = setEndTime(endTime);
//        List<ZwzxChapterReadUserNum> list = zwzxDataService.selectZwzxChapterReadUserNumByPage(startPage, limit, startTime, endTime, bookId,bookName);
//        result.setData(list);
//        if (null == list || list.isEmpty()) {
//            result.setCount(0);
//        } else {
//            result.setCount(zwzxDataService.selectZwzxChapterReadUserNumCount(startTime, endTime, bookId, bookName));
//        }
//        return result;
//    }

    /**
     * 阅读完成率
     */
    @GetMapping("/zwzx/chapterUserReadOver")
    public ModelAndView chapterUserReadOver(ModelAndView mav) {
        mav.setViewName("zwzx/chapterUserReadOver");
        return mav;
    }
    @PostMapping(value = "/zwzx/getChapterUserReadOver")
    public ResponseResult<List<ZwzxChapterUserReadOver>> getChapterUserReadOver(@RequestParam("page") Integer page,
                                                                              @RequestParam(value="limit") Integer limit,
                                                                              @RequestParam(value="bookId",required = false) String bookId,
                                                                              @RequestParam(value="bookName",required = false) String bookName,
                                                                              @RequestParam(value="startTime",required = false) String startTime,
                                                                              @RequestParam(value="endTime",required = false) String endTime) {
        ResponseResult<List<ZwzxChapterUserReadOver>> result = new ResponseResult<>();
        Integer startPage = CommonUtils.getStartPage(page, limit);
        startTime = setStartTime(startTime);
        endTime = setEndTime(endTime);
        List<ZwzxChapterUserReadOver> list = zwzxDataService.selectZwzxChapterUserReadOverByPage(startPage, limit, startTime, endTime, bookId,bookName);
        result.setData(list);
        if (null == list || list.isEmpty()) {
            result.setCount(0);
        } else {
            result.setCount(zwzxDataService.selectZwzxChapterUserReadOverCount(startTime, endTime, bookId, bookName));
        }
        return result;
    }


    /**
     * 阅读转化
     */
    @GetMapping("/zwzx/dataChange")
    public ModelAndView dataChange(ModelAndView mav) {
        mav.setViewName("zwzx/dataChange");
        return mav;
    }
    @PostMapping(value = "/zwzx/getDataChange")
    public ResponseResult<List<ZwzxDataChange>> getDataChange(@RequestParam("page") Integer page,
                                                              @RequestParam(value="limit") Integer limit,
                                                              @RequestParam(value="bookId",required = false) String bookId,
                                                              @RequestParam(value="bookName",required = false) String bookName,
                                                              @RequestParam(value="startTime",required = false) String startTime,
                                                              @RequestParam(value="endTime",required = false) String endTime) {
        ResponseResult<List<ZwzxDataChange>> result = new ResponseResult<>();
        Integer startPage = CommonUtils.getStartPage(page, limit);
        startTime = setStartTime(startTime);
        endTime = setEndTime(endTime);
        List<ZwzxDataChange> list = zwzxDataService.selectZwzxDataChangeByPage(startPage, limit, startTime, endTime, bookId,bookName);
        result.setData(list);
        if (null == list || list.isEmpty()) {
            result.setCount(0);
        } else {
            result.setCount(zwzxDataService.selectZwzxDataChangeCount(startTime, endTime, bookId, bookName));
        }
        return result;
    }


    /**
     * 阅读用户数据
     */
    @GetMapping("/zwzx/readUserData")
    public ModelAndView readUserData(ModelAndView mav) {
        mav.setViewName("zwzx/readUserData");
        return mav;
    }
    @PostMapping(value = "/zwzx/getReadUserData")
    public ResponseResult<List<ZwzxReadUserData>> getReadUserData(@RequestParam("page") Integer page,
                                                                  @RequestParam(value="limit") Integer limit,
                                                                  @RequestParam(value="bookId",required = false) String bookId,
                                                                  @RequestParam(value="bookName",required = false) String bookName,
                                                                  @RequestParam(value="startTime",required = false) String startTime,
                                                                  @RequestParam(value="endTime",required = false) String endTime) {
        ResponseResult<List<ZwzxReadUserData>> result = new ResponseResult<>();
        startTime = setStartTime(startTime);
        endTime = setEndTime(endTime);
        List<ZwzxReadUserData> list = zwzxDataService.selectZwzxReadUserDataByPage(page, limit, startTime, endTime, bookId,bookName);
        result.setData(list);
        if (null == list || list.isEmpty()) {
            result.setCount(0);
        } else {
            result.setCount(zwzxDataService.selectZwzxReadUserDataCount(startTime, endTime, bookId, bookName));
        }
        return result;
    }



    //设置默认开始和结束日期
    String setStartTime (String startTime) {
        if (null == startTime || "".equals(startTime)) {
            startTime = CommonUtils.getyestDate();;
        }
        return startTime;
    }
    String setEndTime (String endTime) {
        if (null == endTime || "".equals(endTime)) {
            endTime = CommonUtils.getyestDate();;
        }
        return endTime;
    }



}
