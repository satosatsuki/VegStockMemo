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
import service.VegRegService;
import service.VegService;

/**
 * Servlet implementation class vegConfirmServlet
 */
@WebServlet("/vegetable_comfirm")
public class vegConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public vegConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		VegRegService VegRegService = new VegRegService(req, true);
		user u=(user)req.getSession().getAttribute("user");
		System.out.println(u.getLoginId());
		String nextPage = VegRegService.vegEntryDo();
		// ここから
		// もう一度やさいのリストを取得してセッションに保存する処理（サービスを呼び出す）
		// ここまで
		boolean useDB = true;
		//冷蔵庫リストの再取得
		ArrayList<RefrigeratorDTO> refs = new VegService(req, useDB).findVegetables(u.getLoginId());
		// セッションに保存
		HttpSession session = req.getSession();
		session.setAttribute("refs", refs);


		RequestDispatcher rd = req.getRequestDispatcher(nextPage);
		rd.forward(req, res);
	}

}
