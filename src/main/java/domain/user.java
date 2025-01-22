package domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class user implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String loginId;
	private String userName;
	private String password;
	private Timestamp createdAt;
	private Timestamp deletedAt;
	

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String username) {
		this.userName = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getDeletedAt() {
		return deletedAt;
	}
	public void setDeletedAt(Timestamp deletedAt) {
		this.deletedAt = deletedAt;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
