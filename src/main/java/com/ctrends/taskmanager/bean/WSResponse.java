package com.ctrends.taskmanager.bean;

import java.util.UUID;


public class WSResponse {
	private String outcome;
	private String message;
	private UUID id;
	private String code;
	private String mode;
	private Object data;
	private Object error;

	public Object getError() {
		return error;
	}

	public void setError(Object error) {
		this.error = error;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public WSResponse(String outcome, String message, UUID id, String code, String mode, Object data) {
		super();
		this.outcome = outcome;
		this.message = message;
		this.id = id;
		this.code = code;
		this.mode = mode;
		this.data = data;
	}

	public WSResponse() {
		super();
	}

	public String getOutcome() {
		return outcome;
	}
	public String getMessage() {
		return message;
	}
	public UUID getId() {
		return id;
	}
	public String getCode() {
		return code;
	}
	public String getMode() {
		return mode;
	}
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}

	
	

}
