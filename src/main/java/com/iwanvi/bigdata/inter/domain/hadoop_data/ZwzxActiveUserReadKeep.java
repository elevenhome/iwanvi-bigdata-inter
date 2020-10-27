package com.iwanvi.bigdata.inter.domain.hadoop_data;

import com.iwanvi.bigdata.inter.common.CustomTag;

import java.io.Serializable;

/**
 * 活跃-用户阅读留存
 */
public class ZwzxActiveUserReadKeep implements Serializable {
    @CustomTag(desc = "日期")
    private String dt;

    @CustomTag(desc = "图书ID")
    private String bookId;

    @CustomTag(desc = "图书名称")
    private String bookName;

    @CustomTag(desc = "次日留存")
    private Long nextKeep;

    @CustomTag(desc = "三日留存")
    private Long threeKeep;

    @CustomTag(desc = "七日留存")
    private Long sevenKeep;

    @CustomTag(desc = "十四日留存")
    private Long fourteenKeep;

    @CustomTag(desc = "三十日留存")
    private Long thirtyKeep;


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

    public Long getNextKeep() {
        return nextKeep;
    }

    public void setNextKeep(Long nextKeep) {
        this.nextKeep = nextKeep;
    }

    public Long getThreeKeep() {
        return threeKeep;
    }

    public void setThreeKeep(Long threeKeep) {
        this.threeKeep = threeKeep;
    }

    public Long getSevenKeep() {
        return sevenKeep;
    }

    public void setSevenKeep(Long sevenKeep) {
        this.sevenKeep = sevenKeep;
    }

    public Long getFourteenKeep() {
        return fourteenKeep;
    }

    public void setFourteenKeep(Long fourteenKeep) {
        this.fourteenKeep = fourteenKeep;
    }

    public Long getThirtyKeep() {
        return thirtyKeep;
    }

    public void setThirtyKeep(Long thirtyKeep) {
        this.thirtyKeep = thirtyKeep;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt == null ? null : dt.trim();
    }
}