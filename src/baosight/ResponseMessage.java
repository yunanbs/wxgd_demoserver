package baosight;

import java.io.Serializable;
import java.util.List;

public class ResponseMessage implements Serializable {
	private String state;
	private String content;
	private ErrorMessage errorMessage;

	private List<Result> resultList;//修改于2016-12-1

	public List<Result> getResultList() {//修改于2016-12-1
		return resultList;
	}

	public void setResultList(List<Result> resultList) {
		this.resultList = resultList;
	}//修改于2016-12-1

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
}
