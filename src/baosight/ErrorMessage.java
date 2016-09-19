package baosight;

import java.io.Serializable;

public class ErrorMessage implements Serializable {
	private String errorCode;
	private String message;

	public ErrorMessage(){}

	public ErrorMessage(String ecode,String msg){
		this.message = msg;
		this.errorCode = ecode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
