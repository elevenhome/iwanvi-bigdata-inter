package com.iwanvi.bigdata.inter.domain.hadoop_data;

import com.iwanvi.bigdata.inter.common.CustomTag;

import java.io.Serializable;

public class ZwzxReadUserData implements Serializable {
    @CustomTag(desc = "日期")
    private String dt;
    @CustomTag(desc = "图书ID")
    private String bookId;
    @CustomTag(desc = "图书ID")
    private String bookName;
    @CustomTag(desc = "阅读人数")
    private Long readUser;
    @CustomTag(desc = "老用户阅读人数")
    private Long oldUser;
    @CustomTag(desc = "有效阅读章节数")
    private Long chapterNum;
    @CustomTag(desc = "平均阅读时长")
    private Double readDuration;

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

    public Long getReadUser() {
        return readUser;
    }

    public void setReadUser(Long readUser) {
        this.readUser = readUser;
    }

    public Long getOldUser() {
        return oldUser;
    }

    public void setOldUser(Long oldUser) {
        this.oldUser = oldUser;
    }

    public Long getChapterNum() {
        return chapterNum;
    }

    public void setChapterNum(Long chapterNum) {
        this.chapterNum = chapterNum;
    }

    public Double getReadDuration() {
        return readDuration;
    }

    public void setReadDuration(Double readDuration) {
        this.readDuration = readDuration;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt == null ? null : dt.trim();
    }
}