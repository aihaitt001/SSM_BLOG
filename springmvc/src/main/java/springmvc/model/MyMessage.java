package springmvc.model;

public class MyMessage {
	String currentuser;

	String result;

	public void setCurrentuser(String user) {
		currentuser = user;
	}

	public String getCurrentuser() {
		return currentuser;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	@Override
	public String toString() {
		String message = "{message:[user:" + currentuser + ",result:" + result + "]}";
		return message;
	}
}
