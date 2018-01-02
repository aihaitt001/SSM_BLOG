package springmvc.model;

public class Report {
	private String name = "name";
	private String phone = "phone";
	private String email = "email";
	private String message = "message";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "name:" + name + ",phone:" + phone + ",email:" + email + ",message:" + message;

	}
}
