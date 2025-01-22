package dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class RefrigeratorDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String tableName;
	private int refrigerator_veg_id;//主キー
	private String veg_name;
	private Date veg_date; 
	private String veg_level;
	private int veg_count;
	private String loginid;//外部キー
	private Timestamp createdAt;
	private Timestamp deletedAt;
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public int getRefrigerator_veg_id() {
		return refrigerator_veg_id;
	}
	public void setRefrigerator_veg_id(int refrigerator_veg_id) {
		this.refrigerator_veg_id = refrigerator_veg_id;
	}
	public String getVeg_name() {
		return veg_name;
	}
	public void setVeg_name(String veg_name) {
		this.veg_name = veg_name;
	}
	public Date getVeg_date() {
		return veg_date;
	}
	public void setVeg_date(Date string) {
		this.veg_date = string;
	}
	public String getVeg_level() {
		return veg_level;
	}
	public void setVeg_level(String veg_level) {
		this.veg_level = veg_level;
	}
	public int getVeg_count() {
		return veg_count;
	}
	public void setVeg_count(int veg_count) {
		this.veg_count = veg_count;
	}
	
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
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
