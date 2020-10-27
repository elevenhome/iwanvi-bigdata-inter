package com.iwanvi.bigdata.inter.common;

public enum FallbackMsg {
	USER_FAIL(-1, "数据请求错误",null);

	private int code;
	private String info;
	private Object object;

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

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	private FallbackMsg(int code, String info, Object object) {
		this.code = code;
		this.info = info;
		this.object = object;
	}

}
