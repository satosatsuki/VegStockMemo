package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.user;
import dto.RefrigeratorDTO;
import dto.freezerDTO;
import service.LoginService;
import service.VegService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/jsp/login.jsp");
		rd.forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String loginid = req.getParameter("loginid");
		String password = req.getParameter("password");
		System.out.println("入力: "+loginid+" ," +password);

		boolean useDB = true;

		//ログインの処理を実行
		boolean result = new LoginService(req, useDB).LoginCheck(loginid, password);
//		System.out.println(result);

		if (result) {//ログイン成功はhome.jspにいく
			user u = (user) (req.getSession().getAttribute("user"));
			System.out.println(u.getId());
			
			// 冷蔵庫野菜一覧取得サービス呼び出し
			ArrayList<RefrigeratorDTO> refs = new VegService(req, useDB).findVegetables(u.getLoginId());
			// セッションに保存
			HttpSession session = req.getSession();
			session.setAttribute("refs", refs);
			
			//冷凍庫野菜一覧取得サービス呼び出し
			ArrayList<freezerDTO> fre = new VegService(req, useDB).findVegefreezer(u.getLoginId());
			// セッションに保存
			HttpSession sessionfree = req.getSession();
			sessionfree.setAttribute("fre", fre);
			
			
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/home.jsp");
			rd.forward(req, res);
		} else {//ログイン失敗はloginに戻る
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/login.jsp");
			rd.forward(req, res);
		}
	}
}
