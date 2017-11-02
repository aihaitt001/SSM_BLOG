package springmvc.model;

import java.sql.Date;

public class User {
	private int id;
	private String username;
	private String password;
	private String email;
	private Date createtime;
	private int admin;
	
	public int getId() {
		return id;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public int getAdmin() {
		return admin;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getemail() {
		return email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getpassword() {
		return password;
	}
	public Date getCreatetime() {
		return createtime;
	}
	@Override
	public String toString() {
		return "user [id="+id+",username="+username+
				",password="+password+",email="+email+
				",createtime="+createtime+"]";
	}
}
