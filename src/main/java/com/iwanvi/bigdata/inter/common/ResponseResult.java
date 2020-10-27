package com.iwanvi.bigdata.inter.common;

public class ResponseResult<T> {
	/**
     * 接口返回代码
     */
    private int code;

	/**
	 * 数据总条数
	 */
    private int count;

    /**
     * 接口返回消息,此消息为对 @code 字段的解读
     * 应当与返回 @code 含义保持一致
     * 如果参与业务逻辑,请使用 @code 字段
     */
    private String msg;

    /**
     * 返回的具体数据
     */
    private T data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
    

	public void setResponseByResultMsg(ResultMsg msg) {
		this.code = msg.getCode();
		this.msg = msg.getInfo();
	}

	public ResponseResult(ResultMsg msg) {
		this.setResponseByResultMsg(msg);
	}

	public ResponseResult() {
		super();
	}


	public void setResponseByResultMsg(FallbackMsg msg) {
		this.code = msg.getCode();
		this.msg = msg.getInfo();
	}
}
