package com.iwanvi.bigdata.inter.service.impl;


import com.iwanvi.bigdata.inter.dao.hadoop_data.ZwzxChapterReadUserNumMapper;
import com.iwanvi.bigdata.inter.domain.hadoop_data.ZwzxChapterReadUserNum;
import com.iwanvi.bigdata.inter.domain.hadoop_data.ZwzxChapterReadUserNumView;
import com.iwanvi.bigdata.inter.service.ZwzxChapterReadUserNumService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ZwzxChapterReadUserNumServiceImpl implements ZwzxChapterReadUserNumService {

    @Resource
    private ZwzxChapterReadUserNumMapper chapterReadUserNumMapper;


    public List<ZwzxChapterReadUserNum> selectChapterNumByPage(Integer startPage, Integer pageSize,
                                                               String startTime, String endTime,
                                                               String bookId, String bookName,
                                                               Integer begChap, Integer endChap) {
        return chapterReadUserNumMapper.selectChapterNumByPage(startPage,pageSize,startTime,endTime,bookId,bookName,begChap,endChap);
    }

    public int selectChapterNumCount(String startTime, String endTime,
                                                               String bookId, String bookName,
                                                               Integer begChap, Integer endChap) {
        return chapterReadUserNumMapper.selectChapterNumCount(startTime,endTime,bookId,bookName,begChap,endChap);
    }


    //章节阅读数
    public List<ZwzxChapterReadUserNumView> selectChapterNumViewByPage(Integer startPage, Integer pageSize,
                                                                       String startTime, String endTime,
                                                                       String bookId, String bookName,
                                                                       Integer begChap, Integer endChap) {
        List<ZwzxChapterReadUserNum> list = selectChapterNumByPage(startPage,pageSize,startTime,endTime,bookId,bookName,begChap,endChap);
        if (null == list || list.size() <= 0) return null;
        Map<String,HashMap<String,ZwzxChapterReadUserNumView>> resultMap = new HashMap<>();
        for (ZwzxChapterReadUserNum chapterReadUserNum : list) {
            String dt = chapterReadUserNum.getDt();
            String bid = chapterReadUserNum.getBookId();
            HashMap<String,ZwzxChapterReadUserNumView> mapTemp = resultMap.get(dt);
            if (null == mapTemp || mapTemp.size() <= 0) {
                mapTemp = new HashMap();
                ZwzxChapterReadUserNumView view = new ZwzxChapterReadUserNumView();
                view.setDt(dt);
                view.setBookId(bid);
                view.setBookName(chapterReadUserNum.getBookName());
                view.setBetweenChapter("第"+begChap+"~"+endChap+"章");
                setChapNumView(view, Integer.parseInt(chapterReadUserNum.getChapterNum()), chapterReadUserNum.getReadNum());
                mapTemp.put(bid, view);
                resultMap.put(dt,mapTemp);
            } else {
                ZwzxChapterReadUserNumView view = mapTemp.get(bid);
                if (null == view) {
                    view = new ZwzxChapterReadUserNumView();
                    view.setDt(dt);
                    view.setBookId(bid);
                    view.setBookName(chapterReadUserNum.getBookName());
                    view.setBetweenChapter("第"+begChap+"~"+endChap+"章");
                    setChapNumView(view, Integer.parseInt(chapterReadUserNum.getChapterNum()), chapterReadUserNum.getReadNum());
                    mapTemp.put(bid, view);
                } else {
                    setChapNumView(view, Integer.parseInt(chapterReadUserNum.getChapterNum()), chapterReadUserNum.getReadNum());
                }
            }
        }

        List<ZwzxChapterReadUserNumView> resultList = new ArrayList();
        for (HashMap<String,ZwzxChapterReadUserNumView> hashMapDt : resultMap.values()) {
            for (ZwzxChapterReadUserNumView view : hashMapDt.values())
                resultList.add(view);
        }
        return resultList;
    }

    /**
     * 设置章节阅读数
     * @param view 实体对象
     * @param chapNum 第几章
     * @param readNum 阅读数量
     */
    void setChapNumView (ZwzxChapterReadUserNumView view, Integer chapNum, Long readNum) {
        switch (chapNum%20) {
            case 1: view.setReadNum1(readNum); break;
            case 2: view.setReadNum2(readNum); break;
            case 3: view.setReadNum3(readNum); break;
            case 4: view.setReadNum4(readNum); break;
            case 5: view.setReadNum5(readNum); break;
            case 6: view.setReadNum6(readNum); break;
            case 7: view.setReadNum7(readNum); break;
            case 8: view.setReadNum8(readNum); break;
            case 9: view.setReadNum9(readNum); break;
            case 10: view.setReadNum10(readNum); break;
            case 11: view.setReadNum11(readNum); break;
            case 12: view.setReadNum12(readNum); break;
            case 13: view.setReadNum13(readNum); break;
            case 14: view.setReadNum14(readNum); break;
            case 15: view.setReadNum15(readNum); break;
            case 16: view.setReadNum16(readNum); break;
            case 17: view.setReadNum17(readNum); break;
            case 18: view.setReadNum18(readNum); break;
            case 19: view.setReadNum19(readNum); break;
            case 0: view.setReadNum20(readNum); break;
        }

    }

    public static void main(String[] args) {
        for (int i = 1; i <= 41; i++) {
            System.out.println(i%20);
            
        }
    }




}
