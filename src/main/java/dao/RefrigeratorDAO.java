package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.RefrigeratorDTO;



public class RefrigeratorDAO extends BaseDAO {

	


	public RefrigeratorDAO(Connection conn) {
		super(conn);
	}
	
	//冷蔵庫野菜登録

	public  int insertveg(RefrigeratorDTO dto) {
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO vegetable.refrigerator(veg_name, veg_date, veg_level, veg_count, loginid) VALUES (?, ?, ?, ?, ?)");
//			ps.setString(1, dto.getTableName());
			ps.setString(1, dto.getVeg_name());
	        ps.setDate(2, dto.getVeg_date());
	        ps.setString(3, dto.getVeg_level());
	        ps.setInt(4, dto.getVeg_count());
	        ps.setString(5, dto.getLoginid());
			return ps.executeUpdate();

			//System.out.println(dto.equals());
		} catch(SQLException e) {
			e.printStackTrace();
			return 0;
			}
	        }
	

	
	
	//冷蔵庫野菜一覧表示 //外部キーに設定しているuser_id を入力された際にそのuser_id の一覧が反映される仕組みになりたい（願望）
	public ArrayList<RefrigeratorDTO> refselectAll(String loginid) {
        ArrayList<RefrigeratorDTO> list = new ArrayList<RefrigeratorDTO>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Refrigerator WHERE loginid =?");
            //System.out.println();
            ps.setString(1, loginid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	RefrigeratorDTO dto = new RefrigeratorDTO();
                // dtoに値を設定
                dto.setRefrigerator_veg_id(rs.getInt(1));
                dto.setVeg_name(rs.getString(2));
                dto.setVeg_date(rs.getDate(3));
                dto.setVeg_level(rs.getString(4));
                dto.setVeg_count(rs.getInt(5));
                dto.setLoginid(rs.getString(6)); //外部キー
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	
	
	
	//冷蔵庫野菜　登録変更   sql 見直し
	public int update(RefrigeratorDTO dto) {
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE vegetable.refrigerator SET veg_name = '?', created_at = CURRENT_TIMESTAMP WHERE veg_name = ?;");
			ps.setString(1, dto.getVeg_name());
			ps.setDate(2, dto.getVeg_date());
			ps.setString(3, dto.getVeg_level());
			ps.setInt(4, dto.getVeg_count());
			ps.setString(5, dto.getLoginid());
			
			System.out.println(dto.getVeg_name() + ":" + dto.getVeg_date() + ":" + dto.getVeg_level()+ ":" +dto.getVeg_count());
			return ps.executeUpdate();
		} catch(SQLException e) {
			String errorMsg = "E:U14 Usersテーブルに不正なUPDATE文が行われました";
			throw new DAOException(errorMsg);
		}
	}
	//冷蔵庫野菜の　削除　
	
	public int deleteById(RefrigeratorDTO dto) {
		//UserDTO dto =  null;
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE vegetable.refrigerator SET deleted_at = CURRENT_TIMESTAMP WHERE veg_name = ?;" );
			
			ps.setString(1, dto.getVeg_name());
			
			
			return ps.executeUpdate();
			
		} catch(SQLException e) {
			String errorMsg = "E:U12 Userテーブルに不正なSELECT処理が行われました。";
			throw new DAOException(errorMsg);
		
	}}
	
	//テーブル参照用
		public RefrigeratorDTO selectByvegLoginId(String loginid) {
			RefrigeratorDTO dto =  null;
			try {
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM vegetable.refrigerator WHERE loginid = ? AND deleted_at IS NULL;");
				ps.setString(1,loginid);
				System.out.println(ps);
							
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					dto = new RefrigeratorDTO();
					dto.setRefrigerator_veg_id(rs.getInt(1));
	                dto.setVeg_name(rs.getString(2));
	                dto.setVeg_date(rs.getDate(3));
	                dto.setVeg_level(rs.getString(4));
	                dto.setVeg_count(rs.getInt(5));
	                dto.setLoginid(rs.getString(6));
						}
				return dto;
			} catch(SQLException e) {
				String errorMsg = "E:U12 Userテーブルに不正なSELECT処理が行われました。";
				throw new DAOException(errorMsg);
			}
		}

		public RefrigeratorDTO selectByvegLoginIdAndVegName(String loginid, String veg_name) {
			// TODO 自動生成されたメソッド・スタブ
			RefrigeratorDTO dto =  null;
			try {
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM vegetable.refrigerator WHERE loginid = ? AND veg_name=? AND deleted_at IS NULL;");
				ps.setString(1,loginid);
				ps.setString(2, veg_name);
				System.out.println("冷蔵庫daoのログインID受け渡しloginid"+loginid);
							
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					dto = new RefrigeratorDTO();
					dto.setRefrigerator_veg_id(rs.getInt(1));
	                dto.setVeg_name(rs.getString(2));
	                dto.setVeg_date(rs.getDate(3));
	                dto.setVeg_level(rs.getString(4));
	                dto.setVeg_count(rs.getInt(5));
	                dto.setLoginid(rs.getString(6));
						}
				//System.out.println("冷蔵庫だおでDTOに受け渡したdto "+dto);
				return dto;
			} catch(SQLException e) {
				String errorMsg = "E:U12 Userテーブルに不正なSELECT処理が行われました。";
				throw new DAOException(errorMsg);
			}
		}

		
//		public boolean deleteById(int id) {
//		    String sql = "DELETE FROM refrigerator WHERE loginid = ?";
//		    try (PreparedStatement ps = conn.prepareStatement(sql)) {
//		        ps.setInt(1, id);
//		        int rowsAffected = ps.executeUpdate();
//		        return rowsAffected > 0;
//		    } catch (SQLException e) {
//		        e.printStackTrace();
//		        return false;
//		    }
		}

	

	

		


	
	
		
	
