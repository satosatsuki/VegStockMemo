package service;

import javax.servlet.http.HttpServletRequest;

import dao.UserDAO;
import domain.user;
import dto.UserDTO;

public class UserRegisterService extends BaseService {
	public UserRegisterService(HttpServletRequest req, boolean userDB) {
		super(req, userDB);
	}

	public String userEntiryConfirm() {
		String loginid = req.getParameter("loginid"); // ここなおした
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		System.out.println("LOGIN ID: " + loginid);
		System.out.println("PASSWORD: " + password);
		System.out.println("    NAME: " + name);

		//バリデーション
		validation.isBlank("ユーザーID", loginid);
		validation.isBlank("パスワード", password);
		validation.isBlank("お名前", name);
		validation.length("ユーザーID", loginid, 4, 50);
		validation.length("パスワード", password, 8, 50);
		validation.length("お名前", name, 2, 50);

		//ユーザー情報のセット
		user user = new user();
		user.setLoginId(loginid);
		user.setPassword(password);
		user.setUserName(name);

		//バリデーションエラーがあった場合
		if (validation.hasErrorMsg()) {
			req.setAttribute("errorMsg", validation.getErrorMsgList());
			return "/jsp/register.jsp";
		}

		//DBにユーザーがすでに存在するかチェック

		UserDAO userDAO = new UserDAO(conn);
		UserDTO userDTO = userDAO.selectByLoginId(user.getLoginId());
		//ユーザーが存在しない場合→登録内容確認画面にさせる
		if (userDTO == null) {
			req.setAttribute("user", user);
			return "/jsp/registerConfirm.jsp";
		} else {
			//すでに存在する場合
			validation.addErrorMsg("入力いただいたユーザーID「" + "loginId " + "」は既に使われております。");

			req.setAttribute("errorMsg", validation.getErrorMsgList());
			return "/jsp/register.jsp";
		}
	}

	public String userEntryDo() {

		String Loginid = req.getParameter("loginId");
		String password = req.getParameter("password");
		String Username = req.getParameter("userName");

		System.out.println(password + " " + Username);

		user user = new user();
		user.setLoginId(Loginid);
		user.setPassword(password);
		user.setUserName(Username);

		UserDAO userDAO = new UserDAO(conn);
		UserDTO dto = new UserDTO();
		dto.setLoginId(user.getLoginId());
		dto.setPassword(user.getPassword());
		dto.setUsername(user.getUserName());

		int result = userDAO.insert(dto);

		if (result == 1) {
			tm.commit();
			tm.close();
			return "/jsp/registerDone.jsp";
		} else {
			tm.rollback();
			tm.close();
			return "/jsp/regster.jsp";
		}

	}
}
