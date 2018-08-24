package com.m520it.jdmall03.bean;

public class RResult {

	private boolean success;
	private String errorMsg;
	private String result;// JSON 数据是一直在变的 FastJson不支持解析嵌套的Bean

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public String getResult() {
		return result;
	}

}
