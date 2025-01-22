package dao;

public class DAOException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	// エラー発生時に原因となった例外をキャッチするためのコンストラクタ。
	//引数は例外の一番上の親クラスで全包括してる。
	public DAOException(Throwable cause) {
		super(cause);
	}

	// 特定のエラーメッセージを持つ例外を生成するためのコンストラクタ。
	//オーバーロードしているので同名のメソッドが定義可能。
	public DAOException(String msg) {
		super(msg);
	}


//DAOException.java


	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}
}
