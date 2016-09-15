package baosight;

public class ResponseMessage {
	private String state;
	private String content;
	private ErrorMessage errorMessage;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	/*public static void errorMsg(String error,Throwable message) throws ErrorMessage{
		switch (error) {
		case "301":
			throw new ErrorMessage("301",new Exception("“动词”有误"));
		case "302":
			throw new ErrorMessage("302",new Exception("“名词”有误"));
		case "303":
			throw new ErrorMessage("303",new Exception("“条件”有误"));
		case "305":
			throw new ErrorMessage("305",new Exception("“用户信息”有误"));
		case "310":
			throw new ErrorMessage("310",new Exception("服务器内部异常"));
		default:
			break;
		}
		
	}*/
	
	static ErrorMessage errorMsg=new ErrorMessage();
	static ResponseMessage output =new ResponseMessage();
	public static ResponseMessage getInstance(String errorCode,String message,String state,String content){
		errorMsg.setErrorCode(errorCode);
		errorMsg.setMessage(message);
		output.setContent(content);
		output.setState(state);
		return output;
	}
}
