package com.iwanvi.bigdata.inter.domain.hadoop_data;

import com.iwanvi.bigdata.inter.common.CustomTag;

import java.io.Serializable;

/**
 * 章节读完率
 */
public class ZwzxChapterUserReadOver implements Serializable {

    @CustomTag(desc = "日期")
    private String dt;

    @CustomTag(desc = "图书ID")
    private String bookId;

    @CustomTag(desc = "图书名称")
    private String bookName;

    @CustomTag(desc = "10章读完率")
    private Long readOver10;

    @CustomTag(desc = "20章读完率")
    private Long readOver20;

    @CustomTag(desc = "30章读完率")
    private Long readOver30;

    @CustomTag(desc = "40章读完率")
    private Long readOver40;

    @CustomTag(desc = "50章读完率")
    private Long readOver50;

    @CustomTag(desc = "100章读完率")
    private Long readOver100;

    @CustomTag(desc = "150章读完率")
    private Long readOver150;

    @CustomTag(desc = "200章读完率")
    private Long readOver200;

    @CustomTag(desc = "300章读完率")
    private Long readOver300;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Long getReadOver10() {
        return readOver10;
    }

    public void setReadOver10(Long readOver10) {
        this.readOver10 = readOver10;
    }

    public Long getReadOver20() {
        return readOver20;
    }

    public void setReadOver20(Long readOver20) {
        this.readOver20 = readOver20;
    }

    public Long getReadOver30() {
        return readOver30;
    }

    public void setReadOver30(Long readOver30) {
        this.readOver30 = readOver30;
    }

    public Long getReadOver40() {
        return readOver40;
    }

    public void setReadOver40(Long readOver40) {
        this.readOver40 = readOver40;
    }

    public Long getReadOver50() {
        return readOver50;
    }

    public void setReadOver50(Long readOver50) {
        this.readOver50 = readOver50;
    }

    public Long getReadOver100() {
        return readOver100;
    }

    public void setReadOver100(Long readOver100) {
        this.readOver100 = readOver100;
    }

    public Long getReadOver150() {
        return readOver150;
    }

    public void setReadOver150(Long readOver150) {
        this.readOver150 = readOver150;
    }

    public Long getReadOver200() {
        return readOver200;
    }

    public void setReadOver200(Long readOver200) {
        this.readOver200 = readOver200;
    }

    public Long getReadOver300() {
        return readOver300;
    }

    public void setReadOver300(Long readOver300) {
        this.readOver300 = readOver300;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }
}