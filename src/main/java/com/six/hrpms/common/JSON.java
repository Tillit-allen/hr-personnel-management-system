package com.six.hrpms.common;

public class JSON {

	private Integer status;

	private String msg;

	private Object data;

	public static JSON build(Integer status, String msg, Object data) {
		return new JSON(status, msg, data);
	}

	public static JSON ok(Object data) {
		return new JSON(data);
	}

	public static JSON ok() {
		return new JSON(null);
	}

	public static JSON errorMsg(String msg) {
		return new JSON(500, msg, null);
	}

	public static JSON errorMap(Object data) {
		return new JSON(501, "error", data);
	}

	public static JSON errorTokenMsg(String msg) {
		return new JSON(502, msg, null);
	}

	public static JSON errorException(String msg) {
		return new JSON(555, msg, null);
	}

	public JSON() {

	    }

	public JSON(Integer status, String msg, Object data) {
	        this.status = status;
	        this.msg = msg;
	        this.data = data;
	    }

	public JSON(Object data) {
	        this.status = 200;
	        this.msg = "OK";
	        this.data = data;
	    }

	public Boolean isOK() {
		return this.status == 200;
	}

	@Override
	public String toString() {
		return "JSONResult{" + "status=" + status + ", msg='" + msg + '\'' + ", object=" + data + '}';
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
