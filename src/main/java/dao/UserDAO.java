package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.UserDTO;

public class UserDAO extends BaseDAO {
	public UserDAO(Connection conn) {
		super(conn);
	}
	
	//アカウント参照ログイン用
	public UserDTO selectByLoginId(String loginid) {
		UserDTO dto =  null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM vegetable.account WHERE loginid = ? AND deleted_at IS NULL;");
			ps.setString(1,loginid);
			System.out.println(ps);
						
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				dto = new UserDTO();
				dto.setId(rs.getInt(1));
				dto.setLoginId(rs.getString(2));
				dto.setPassword(rs.getString(3));
				dto.setUsername(rs.getString(4));
				dto.setCreatedAt(rs.getTimestamp(5));
				dto.setDeletedAt(rs.getTimestamp(6));
					}
			return dto;
		} catch(SQLException e) {
			String errorMsg = "E:U12 Userテーブルに不正なSELECT処理が行われました。";
			throw new DAOException(errorMsg);
		}
	}
	
	//会員登録
	public int insert(UserDTO dto) {
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO vegetable.account(loginid,password,username) VALUES(?,?,?)");
			ps.setString(1, dto.getLoginId());
			ps.setString(2, dto.getPassword());
			ps.setString(3, dto.getUsername());
			System.out.println(dto.getLoginId() + ":" + dto.getPassword() + ":" + dto.getUsername());
			return ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace(); // debug
			String errorMsg = "E:U14 Usersテーブルに不正なINSERT文が行われました";
			throw new DAOException(errorMsg);
		}
		
	}
	
//会員削除
	public int delete(int loginid) {
		//UserDTO dto =  null;
		try {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM vegetable.accounts WHERE id = ?");
			
			ps.setInt(1, loginid);
			
			
			return ps.executeUpdate();
			
		} catch(SQLException e) {
			String errorMsg = "E:U12 Userテーブルに不正なSELECT処理が行われました。";
			throw new DAOException(errorMsg);
		
	}}
	
	}

	
	

