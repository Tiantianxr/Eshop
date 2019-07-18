package com.zy.bean;

public class User {

	private String id;
	private String username;
	private String password;
	private String mobile;

	public User() {
		super();
	}

	public User(String id, String username, String password, String mobile) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.mobile = mobile;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", mobile=" + mobile + "]";
	}

}
