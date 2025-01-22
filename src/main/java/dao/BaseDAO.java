package dao;

import java.sql.Connection;

public class BaseDAO {
	//スコープの関係上コンストラクタの外で宣言
	protected Connection conn;
	// データベース接続オブジェクト（Connection）を受け取り、
	// このオブジェクト内で使用できるように保持。
	public BaseDAO(Connection conn) {
		this.conn = conn;
	}
}
