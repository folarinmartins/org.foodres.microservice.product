package org.foodres.microservice.product.common;

import org.springframework.http.HttpStatus;

public class RestResponse<T> {
	T data;
	HttpStatus status;
	int code;
	String message;

	public RestResponse(T data) {
		this(data, HttpStatus.OK);
	}

	public RestResponse(T data, HttpStatus status) {
		this(data, status, "");
	}

	public RestResponse(T data, HttpStatus status, String message) {
		this.data = data;
		this.status = status;
		this.code = status.value();
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
