package com.iwanvi.bigdata.inter.domain.hadoop_data;

import com.iwanvi.bigdata.inter.common.CustomTag;

import java.io.Serializable;

/**
 * 章节阅读用户
 */
public class ZwzxChapterReadUserNumView implements Serializable {

    @CustomTag(desc = "日期")
    private String dt;

    @CustomTag(desc = "图书ID")
    private String bookId;

    @CustomTag(desc = "图书名称")
    private String bookName;

    //第几章 ~ 第几章
    @CustomTag(desc = "章节区间")
    private String betweenChapter;

    @CustomTag(desc = "第一章阅读人数")
    private Long readNum1 = 0l;
    @CustomTag(desc = "第二章阅读人数")
    private Long readNum2 = 0l;
    @CustomTag(desc = "第三章阅读人数")
    private Long readNum3 = 0l;
    @CustomTag(desc = "第四章阅读人数")
    private Long readNum4 = 0l;
    @CustomTag(desc = "第五章阅读人数")
    private Long readNum5 = 0l;
    @CustomTag(desc = "第六章阅读人数")
    private Long readNum6 = 0l;
    @CustomTag(desc = "第七章阅读人数")
    private Long readNum7 = 0l;
    @CustomTag(desc = "第八章阅读人数")
    private Long readNum8 = 0l;
    @CustomTag(desc = "第九章阅读人数")
    private Long readNum9 = 0l;
    @CustomTag(desc = "第十章阅读人数")
    private Long readNum10 = 0l;
    @CustomTag(desc = "第十一章阅读人数")
    private Long readNum11 = 0l;
    @CustomTag(desc = "第十二章阅读人数")
    private Long readNum12 = 0l;
    @CustomTag(desc = "第十三章阅读人数")
    private Long readNum13 = 0l;
    @CustomTag(desc = "第十四章阅读人数")
    private Long readNum14 = 0l;
    @CustomTag(desc = "第十五章阅读人数")
    private Long readNum15 = 0l;
    @CustomTag(desc = "第十六章阅读人数")
    private Long readNum16 = 0l;
    @CustomTag(desc = "第十七章阅读人数")
    private Long readNum17 = 0l;
    @CustomTag(desc = "第十八章阅读人数")
    private Long readNum18 = 0l;
    @CustomTag(desc = "第十九章阅读人数")
    private Long readNum19 = 0l;
    @CustomTag(desc = "第二十章阅读人数")
    private Long readNum20 = 0l;


    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

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

    public String getBetweenChapter() {
        return betweenChapter;
    }

    public void setBetweenChapter(String betweenChapter) {
        this.betweenChapter = betweenChapter;
    }

    public Long getReadNum1() {
        return readNum1;
    }

    public void setReadNum1(Long readNum1) {
        this.readNum1 = readNum1;
    }

    public Long getReadNum2() {
        return readNum2;
    }

    public void setReadNum2(Long readNum2) {
        this.readNum2 = readNum2;
    }

    public Long getReadNum3() {
        return readNum3;
    }

    public void setReadNum3(Long readNum3) {
        this.readNum3 = readNum3;
    }

    public Long getReadNum4() {
        return readNum4;
    }

    public void setReadNum4(Long readNum4) {
        this.readNum4 = readNum4;
    }

    public Long getReadNum5() {
        return readNum5;
    }

    public void setReadNum5(Long readNum5) {
        this.readNum5 = readNum5;
    }

    public Long getReadNum6() {
        return readNum6;
    }

    public void setReadNum6(Long readNum6) {
        this.readNum6 = readNum6;
    }

    public Long getReadNum7() {
        return readNum7;
    }

    public void setReadNum7(Long readNum7) {
        this.readNum7 = readNum7;
    }

    public Long getReadNum8() {
        return readNum8;
    }

    public void setReadNum8(Long readNum8) {
        this.readNum8 = readNum8;
    }

    public Long getReadNum9() {
        return readNum9;
    }

    public void setReadNum9(Long readNum9) {
        this.readNum9 = readNum9;
    }

    public Long getReadNum10() {
        return readNum10;
    }

    public void setReadNum10(Long readNum10) {
        this.readNum10 = readNum10;
    }

    public Long getReadNum11() {
        return readNum11;
    }

    public void setReadNum11(Long readNum11) {
        this.readNum11 = readNum11;
    }

    public Long getReadNum12() {
        return readNum12;
    }

    public void setReadNum12(Long readNum12) {
        this.readNum12 = readNum12;
    }

    public Long getReadNum13() {
        return readNum13;
    }

    public void setReadNum13(Long readNum13) {
        this.readNum13 = readNum13;
    }

    public Long getReadNum14() {
        return readNum14;
    }

    public void setReadNum14(Long readNum14) {
        this.readNum14 = readNum14;
    }

    public Long getReadNum15() {
        return readNum15;
    }

    public void setReadNum15(Long readNum15) {
        this.readNum15 = readNum15;
    }

    public Long getReadNum16() {
        return readNum16;
    }

    public void setReadNum16(Long readNum16) {
        this.readNum16 = readNum16;
    }

    public Long getReadNum17() {
        return readNum17;
    }

    public void setReadNum17(Long readNum17) {
        this.readNum17 = readNum17;
    }

    public Long getReadNum18() {
        return readNum18;
    }

    public void setReadNum18(Long readNum18) {
        this.readNum18 = readNum18;
    }

    public Long getReadNum19() {
        return readNum19;
    }

    public void setReadNum19(Long readNum19) {
        this.readNum19 = readNum19;
    }

    public Long getReadNum20() {
        return readNum20;
    }

    public void setReadNum20(Long readNum20) {
        this.readNum20 = readNum20;
    }
}