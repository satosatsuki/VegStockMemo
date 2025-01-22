package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import domain.user;
import dto.UserDTO;
import validation.Validation;

public class LoginService extends BaseService {
	public LoginService(HttpServletRequest req, boolean useDB) {
		super(req, useDB);
	}

	public boolean LoginCheck(String loginid, String password) {

		//Validationオブジェクトのインスタンス化
		Validation validation = new Validation();

		//loginId と　password のバリデーションを行う
		validation.isBlank("ログインID", loginid);
		validation.isBlank("パスワード", password);
		validation.length("ログインID", loginid, 1, 50);
		//例：ログインIDは１文字以上、５０文字以下
		validation.length("パスワード", password, 6, 20);
		//例：パスワードは６文字以上、２０文字以下

		//エラーメッセージ存在するかどうかをチェック
		if (validation.hasErrorMsg()) {
			//エラーメッセージをリクエストスコープにせっとして、ログイン画面に表示
			req.setAttribute("errorMsgList", validation.getErrorMsgList());
			return false;
		}

		UserDAO userDAO = new UserDAO(conn);
		UserDTO userDTO = userDAO.selectByLoginId(loginid);
		System.out.println("DBの値: " + userDTO.getLoginId() + ", " + userDTO.getPassword());

		//ユーザーが入力した値とDBの値が等しいかチェック
		if (userDTO != null && userDTO.getPassword().equals(password)) {

			//等しい場合はDB情報をDomainに保存
			user user = new user();
			user.setId(userDTO.getId());
			user.setLoginId(userDTO.getLoginId());//intをStringに変換
			user.setUserName(userDTO.getUsername());
			user.setPassword(userDTO.getPassword());
			System.out.println(user.getLoginId());

			//セッションスコープにユーザー情報が入ったdomainを保存
			HttpSession session = req.getSession(true);
			session.setAttribute("user", user);
			return true;
		} else {
			//ログインIDまたはパスワードが間違っていた場合の処理
			//例えばエラーメッセージをリクエストスコープにセットしてログイン画面に表示する
			req.setAttribute("loginError", "ログインIDまたはパスワードが間違っています");
			return false;
		}
	}
//	public boolean VegCheck(String vag_name) {
//		Validation validation = new Validation();
//
//		validation.isBlank("野菜名", vag_name);
//		
//		if (validation.hasErrorMsg()) {
//			//エラーメッセージをリクエストスコープにせっとして、ログイン画面に表示
//			req.setAttribute("errorMsgList", validation.getErrorMsgList());
//			return false;
//		}
//		UserDAO userDAO = new UserDAO(conn);
//		UserDTO userDTO = userDAO.selectByvegLoginId(Veg_name);
//		
//		
//		
//	}
	
		
	
}
