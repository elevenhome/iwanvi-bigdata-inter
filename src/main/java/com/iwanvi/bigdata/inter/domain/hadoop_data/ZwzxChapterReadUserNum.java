package com.iwanvi.bigdata.inter.domain.hadoop_data;


import com.iwanvi.bigdata.inter.common.CustomTag;

import java.io.Serializable;

/**
 * 章节阅读用户
 */
public class ZwzxChapterReadUserNum implements Serializable {

    @CustomTag(desc = "日期")
    private String dt;

    @CustomTag(desc = "图书ID")
    private String bookId;

    @CustomTag(desc = "图书名称")
    private String bookName;

    //第几章
    @CustomTag(desc = "章节数量")
    private String chapterNum;

    @CustomTag(desc = "阅读数量")
    private Long readNum;


    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId == null ? null : bookId.trim();
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getChapterNum() {
        return chapterNum;
    }

    public void setChapterNum(String chapterNum) {
        this.chapterNum = chapterNum == null ? null : chapterNum.trim();
    }

    public Long getReadNum() {
        return readNum;
    }

    public void setReadNum(Long readNum) {
        this.readNum = readNum;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt == null ? null : dt.trim();
    }
}