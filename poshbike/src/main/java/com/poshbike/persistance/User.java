package com.poshbike.persistance;

import java.util.Date;

public class User {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isArchived() {
		return archived;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	public boolean isDefaultUser() {
		return defaultUser;
	}

	public void setDefaultUser(boolean defaultUser) {
		this.defaultUser = defaultUser;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	protected int id;

	protected boolean archived;
	/**
	 * Domain business guid.
	 */
	protected String guid;

	/**
	 * The domain create time.
	 */
	protected Date createTime = new Date();

	private String username;
	private String password;

	private String phone;
	private String email;
	// Default user is initial when create database, do not delete
	private boolean defaultUser = false;

	private Date lastLoginTime;
}
