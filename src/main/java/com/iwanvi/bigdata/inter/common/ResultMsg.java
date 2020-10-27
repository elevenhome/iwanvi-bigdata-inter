package com.iwanvi.bigdata.inter.common;

public enum ResultMsg {
	SUCCESS(0, "SUCCESS", ""),
	FAIL(1, "FAIL", ""),

	ACCT_INSUFFICIENT(2, "余额不足", "余额不足"),

	LOST_PARAMS(1000, "校验参数缺失", "请稍后再试");

	private int code;
	private String info;
	private String toolTip;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getToolTip() {
		return toolTip;
	}

	public void setToolTip(String toolTip) {
		this.toolTip = toolTip;
	}

	private ResultMsg(int code, String info, String toolTip) {
		this.code = code;
		this.info = info;
		this.toolTip = toolTip;
	}

}
