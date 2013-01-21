package com.isoftstone.luckydraw.common.vo;

/**
 * ajax请求返回信息包装类
 * success:是否成功
 * msg：操作结果
 * code:错误码
 * 
 * @author luoting
 *
 */
public class Resultval {
	private boolean success;
	private String msg;
	private int code;
	
	
	public Resultval() {
		super();
	}
	public Resultval(boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}
	
	public Resultval(boolean success, String msg, int code) {
		super();
		this.success = success;
		this.msg = msg;
		this.code = code;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	
}
