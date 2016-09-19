package baosight;

import java.io.Serializable;

public class RequestMessage implements Serializable {
	private String verb;
	private String noun;
	private User user;
	private Message message;

	public String getVerb() {
		return verb;
	}

	public void setVerb(String verb) {
		this.verb = verb;
	}

	public String getNoun() {
		return noun;
	}

	public void setNoun(String noun) {
		this.noun = noun;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
}
