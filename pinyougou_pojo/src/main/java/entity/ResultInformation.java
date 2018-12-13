package entity;

import java.io.Serializable;

public class ResultInformation implements Serializable{
	private Boolean success;
	private String message;
	
	
	
	
	public ResultInformation() {
		super();
	}
	public ResultInformation(Boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
