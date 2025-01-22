package service;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import dao.TransactionManager;
import validation.Validation;

public class BaseService {
	protected HttpServletRequest req;
	protected TransactionManager tm;
	protected Connection conn;
	protected Validation validation;
	
	public BaseService(HttpServletRequest req, boolean useDB) {
		this.req = req;
		if(useDB) {
			this.tm = new TransactionManager();
			this.conn = tm.getConnection();
			// ↓11 章で使用します。10 章ではいらないのでコメントアウトしてください。
			this.validation = new Validation();
		}
	}
}

