package domain;

import java.io.Serializable;
import java.sql.Date;

public class freezer implements Serializable{

	private static final long serialVersionUID = 1L;
		
		private Integer freezer_veg_id;
		private String veg_name;
		private Date createdAt;
		private String createStr;
		private String veg_level;
		private String veg_count;
		private Date deletedAt;
		private String loginid; 
		private String veg_date;  //登録日を表す　DATE型からStringに変えてみた
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
		public String getLoginid() {
			return loginid;
		}
		public void setLoginid(String loginid) {
			this.loginid = loginid;
		}
		public Integer getFreezer_veg_id() {
			return freezer_veg_id;
		}
		public void setFreezer_veg_id(Integer freezer_veg_id) {
			this.freezer_veg_id = freezer_veg_id;
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
		
		
		
		

}
