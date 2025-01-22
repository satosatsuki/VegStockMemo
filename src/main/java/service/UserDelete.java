package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import domain.user;

public class UserDelete extends BaseService {
	
	//コンストラクタ
	public UserDelete(HttpServletRequest req, boolean useDB) {
	       super(req, useDB);
	}
	
	public String userDeleteConfirm() {
		
		// セッションスコープからユーザーのid情報を取得
		HttpSession session = req.getSession(); 
		user loginUser= (user)session.getAttribute("user");
		int id = loginUser.getId();
		
		// DAOをnewして
		UserDAO userDAO = new UserDAO(conn);
		
		// deleteメソッドを実行
		int result = userDAO.delete(id);
		if(result == 1) {
			// resultが1(削除成功)だったら...
			tm.commit();
			tm.close();
			return "/jsp/deleteDone.jsp";
		}else {
			// それ以外は失敗
			tm.rollback();
			tm.close();
			return "/jsp/delete.jsp";
		}

	}
}