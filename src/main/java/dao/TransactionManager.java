package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TransactionManager implements AutoCloseable {
	//AutoCloseable というインターフェースを実装（あまり気にしなくてよい）
		private static final String DRIVER_NAME = "org.postgresql.Driver";
		private static final String DB_URL = "jdbc:postgresql://localhost:5432/1001pyjava";
		private static final String SCHEMA = "?currentSchema=vegetable";
		private static final String DB_USER = "postgres";
		private static final String DB_PASSWORD = "password";
		private Connection conn;
		private boolean isCommit;
		
		// データベース接続を取得。既に接続がある場合はそれを返し、なければ作成。
		public Connection getConnection() {
			if(conn == null) {
				try {
					Class.forName(DRIVER_NAME);
					conn = DriverManager.getConnection(DB_URL + SCHEMA, DB_USER, DB_PASSWORD);
					conn.setAutoCommit(false);// 自動コミットモードをオフに設定(トランザクションの開始)
				} catch(ClassNotFoundException | SQLException e) {
					String message = "E:TM01 トランザクションが開始できませんでした";
					throw new TransactionException(message);
				}
			}
			return conn;
		}
		
		// トランザクションをコミット（=処理を確定）
		//DB 接続がない場合は例外をスローする。
		public void commit() {
			if (conn == null) {
				String message = "E:TM02 トランザクションが開始されていません";
				throw new TransactionException(message);
			} else {
				isCommit = true;
			}
		}

	// トランザクションをロールバック（処理を巻き戻す） 
	//DB 接続がない場合は例外をスローする。
		public void rollback() {
			if (conn == null) {
				String message = "E:TM04 トランザクションが開始されていません";
				throw new TransactionException(message);
			} else {
				isCommit = false;
			}
		}

		// AutoCloseable インターフェイスが備えてる close メソッドをオーバーライド。
		//トランザクションを終了し、接続を閉じる。
		@Override
		public void close() {
			try {
				if(conn != null) {
					if (isCommit) {
						conn.commit();// コミットが指示されていればコミット
					} else {
						conn.rollback();// そうでなければロールバック
					}
					conn.close();// 接続を閉じる
					conn = null;
				}
			} catch(SQLException e) {
				String message = "E:TM03 トランザクション終了中にエラーが発生しました";
				throw new TransactionException(message);
			}
		}
	}


