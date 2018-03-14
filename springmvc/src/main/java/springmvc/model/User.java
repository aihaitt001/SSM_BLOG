package springmvc.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5906018559014013477L;
	private Integer id;
	private String username;
	private String password;
	private String salt;
	private String email;
	private Timestamp createtime;
	private Timestamp lastchange;
	private Integer admin;

	public void setSalt(String salt) {
		// TODO Auto-generated method stub
		this.salt = salt;

	}

	public String getSalt() {
		return salt;
	}

	public String getRole() {
		String role = "";
		if (admin == 1) {
			role = "admin";
		} else if (admin == 2) {
			role = "user";
		} else {
			role = "people";
		}
		return role;
	}

	public ArrayList<String> getPermissions() {
		ArrayList<String> permissions = new ArrayList<String>(3);
		if (admin == 1) {
			permissions.add("admin:manage");
			permissions.add("user:manage");
		} else if (admin == 2) {
			permissions.add("user:manage");
		} else {
			permissions.add("visitor:read");
		}
		return permissions;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setAdmin(Integer admin) {
		this.admin = admin;
	}

	public Integer getAdmin() {
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

	public String getEmail() {
		return email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setLastchange(Timestamp lastchange) {
		this.lastchange = lastchange;
	}

	public Timestamp getLastchange() {
		return lastchange;
	}

	@Override
	public String toString() {
		return "{user: [{id=" + id + ",username=" + username + ",password=" + password + ",email=" + email + ",admin="
				+ admin + ",createtime=" + createtime + ",lastchange=" + lastchange + "}]}";
	}

}
