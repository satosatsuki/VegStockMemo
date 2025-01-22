package domain;

import java.io.Serializable;
import java.sql.Date;

public class refrigerator implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer refrigerator_veg_id;
	private String veg_name;
	private Date createdAt;
	private String veg_date;  //登録日を表す　DATE型からStringに変えてみた
	private String createStr;
	private String veg_level;
	private String veg_count; //いいのかわからないけど、Stringに変えてみた
	private Date deletedAt;
	private String loginid; //よくわかんないけどStringに変えてみた
	private String tableName;

	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	
	public String getVeg_date() {
		return veg_date;
	}
	public void setVeg_date(String veg_date) {
		this.veg_date = veg_date;
	}
	public Integer getRefrigerator_veg_id() {
		return refrigerator_veg_id;
	}
	public void setRefrigerator_veg_id(Integer refrigerator_veg_id) {
		this.refrigerator_veg_id = refrigerator_veg_id;
	}
	public String getVeg_name() {
		return veg_name;
	}
	public void setVeg_name(String veg_name) {
		this.veg_name = veg_name;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getCreateStr() {
		return createStr;
	}
	public void setCreateStr(String createStr) {
		this.createStr = createStr;
	}
	public String getVeg_level() {
		return veg_level;
	}
	public void setVeg_level(String veg_level) {
		this.veg_level = veg_level;
	}
	public String getVeg_count() {
		return veg_count;
	}
	public void setVeg_count(String veg_count) {
		this.veg_count = veg_count;
	}
	public Date getDeletedAt() {
		return deletedAt;
	}
	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	
	
	
	
	

	
}
