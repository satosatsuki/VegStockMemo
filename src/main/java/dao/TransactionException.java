package dao;

public class TransactionException extends RuntimeException{
	// エラー発生時に原因となった例外をキャッチするためのコンストラクタ。
	//引数は例外の一番上の親クラスで全包括してる。
	public TransactionException(Throwable cause) {
		super(cause);
	}
	// 特定のエラーメッセージを持つ例外を生成するためのコンストラクタ。
	//オーバーロードしているので同名メソッドが定義可能。
	public TransactionException(String message) {
		super(message);
	}
}


