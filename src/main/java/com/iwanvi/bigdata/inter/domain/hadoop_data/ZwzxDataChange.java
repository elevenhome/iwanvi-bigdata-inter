package com.iwanvi.bigdata.inter.domain.hadoop_data;

import com.iwanvi.bigdata.inter.common.CustomTag;

import java.io.Serializable;

public class ZwzxDataChange implements Serializable {
    @CustomTag(desc = "日期")
    private String dt;
    @CustomTag(desc = "图书ID")
    private String bookId;
    @CustomTag(desc = "图书名称")
    private String bookName;
    @CustomTag(desc = "详情页pv")
    private Long detailsPv;
    @CustomTag(desc = "详情页uv")
    private Long detailsUv;
    @CustomTag(desc = "进入阅读pv")
    private Long continuePv;
    @CustomTag(desc = "进入阅读uv")
    private Long continueUv;
    @CustomTag(desc = "累计下载次数")
    private Long downloadPv;
    @CustomTag(desc = "累计有效加入书架次数")
    private Long addbookshelfPv;

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

    public Long getDetailsPv() {
        return detailsPv;
    }

    public void setDetailsPv(Long detailsPv) {
        this.detailsPv = detailsPv;
    }

    public Long getDetailsUv() {
        return detailsUv;
    }

    public void setDetailsUv(Long detailsUv) {
        this.detailsUv = detailsUv;
    }

    public Long getContinuePv() {
        return continuePv;
    }

    public void setContinuePv(Long continuePv) {
        this.continuePv = continuePv;
    }

    public Long getContinueUv() {
        return continueUv;
    }

    public void setContinueUv(Long continueUv) {
        this.continueUv = continueUv;
    }

    public Long getDownloadPv() {
        return downloadPv;
    }

    public void setDownloadPv(Long downloadPv) {
        this.downloadPv = downloadPv;
    }

    public Long getAddbookshelfPv() {
        return addbookshelfPv;
    }

    public void setAddbookshelfPv(Long addbookshelfPv) {
        this.addbookshelfPv = addbookshelfPv;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt == null ? null : dt.trim();
    }
}