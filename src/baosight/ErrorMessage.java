package baosight;

public class ErrorMessage {
	private String errorCode;
	private String message;
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
	
	/*public ErrorMessage() {
		super();
	}
	public ErrorMessage(String errorCode,Throwable message) {
		super(errorCode,message);
	}*/
	
	
}
