package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.freezerDTO;

public class FreezerDAO extends BaseDAO {

	public FreezerDAO(Connection conn) {
		super(conn);
	}

	//冷凍庫野菜登録
	public int insert(freezerDTO dto) {
		try {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO vegetable.freezer(veg_name, veg_date, veg_level, veg_count, loginid) VALUES (?, ?, ?, ?, ?)");
			ps.setString(1, dto.getVeg_name());
			ps.setDate(2, dto.getVeg_date());
			ps.setString(3, dto.getVeg_level());
			ps.setInt(4, dto.getVeg_count());
			ps.setString(5, dto.getLoginid());

			System.out.println(
					dto.getVeg_name() + ":" + dto.getVeg_date() + ":" + dto.getVeg_level() + ":" + dto.getVeg_count());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;

		}

	}

	//冷凍庫野菜一覧表示用
	public ArrayList<freezerDTO> freselectAll(String loginid) {
		ArrayList<freezerDTO> list = new ArrayList<freezerDTO>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Freezer WHERE loginid =?");
			ps.setString(1, loginid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				freezerDTO dto = new freezerDTO();
				// dtoに値を設定
				dto.setFreezer_veg_id(rs.getInt(1));
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

	//冷凍庫野菜　登録変更   
	public int update(freezerDTO dto) {
		try {
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE vegetable.freezer SET loginid = '?', created_at = CURRENT_TIMESTAMP WHERE veg_name = ?;");
			ps.setString(1, dto.getVeg_name());
			ps.setDate(2, dto.getVeg_date());
			ps.setString(3, dto.getVeg_level());
			ps.setInt(4, dto.getVeg_count());
			ps.setString(5, dto.getLoginid());

			System.out.println(
					dto.getVeg_name() + ":" + dto.getVeg_date() + ":" + dto.getVeg_level() + ":" + dto.getVeg_count());
			return ps.executeUpdate();
		} catch (SQLException e) {
			String errorMsg = "E:U14 Usersテーブルに不正なUPDATE文が行われました";
			throw new DAOException(errorMsg);
		}
	}
	//冷凍庫野菜の　削除　

	public int delete(freezerDTO dto) {
		//UserDTO dto =  null;
		try {
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE vegetable.freezer SET deleted_at = CURRENT_TIMESTAMP WHERE veg_name = ?;");

			ps.setString(1, dto.getVeg_name());

			return ps.executeUpdate();

		} catch (SQLException e) {
			String errorMsg = "E:U12 Userテーブルに不正なSELECT処理が行われました。";
			throw new DAOException(errorMsg);

		}
	}

	//テーブル参照用
	public freezerDTO selectByvegLoginId(String loginid) {
		freezerDTO dto = null;
		try {
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM vegetable.freezer WHERE loginid = ? AND deleted_at IS NULL;");
			ps.setString(1, loginid);
			System.out.println(ps);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dto.setFreezer_veg_id(rs.getInt(1));
				dto.setVeg_name(rs.getString(2));
				dto.setVeg_date(rs.getDate(3));
				dto.setVeg_level(rs.getString(4));
				dto.setVeg_count(rs.getInt(5));
				dto.setLoginid(rs.getString(6));
			}
			return dto;
		} catch (SQLException e) {
			String errorMsg = "E:U12 Userテーブルに不正なSELECT処理が行われました。";
			throw new DAOException(errorMsg);
		}

	}
//ユーザーネームとユーザーID取得用
	public freezerDTO selectByvegLoginIdAndVegName(String loginid, String veg_name) {
		freezerDTO dto = null;
		try {
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM vegetable.freezer WHERE loginid = ? AND veg_name=? AND deleted_at IS NULL;");
			ps.setString(1, loginid);
			ps.setString(2, veg_name);
			System.out.println(ps);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dto = new freezerDTO();
				dto.setFreezer_veg_id(rs.getInt(1));
				dto.setVeg_name(rs.getString(2));
				dto.setVeg_date(rs.getDate(3));
				dto.setVeg_level(rs.getString(4));
				dto.setVeg_count(rs.getInt(5));
				dto.setLoginid(rs.getString(6));
			}
			return dto;
		} catch (SQLException e) {
			String errorMsg = "E:U12 Userテーブルに不正なSELECT処理が行われました。";
			throw new DAOException(errorMsg);
		}
	}
}