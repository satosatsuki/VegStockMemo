package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.UserDTO;

public class accountDAO extends BaseDAO{
	public accountDAO(Connection conn) {
		super(conn);
	}

	//ログイン用に一人分のデータを持ってくる 一覧表示
	public ArrayList<UserDTO> selectAll() {
        ArrayList<UserDTO> list = new ArrayList<UserDTO>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM freezer");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	UserDTO dto = new UserDTO();
                // dtoに値を設定
                dto.setId(rs.getInt("id"));
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

	
	//更新する
	




	//削除
	
	
	

}
