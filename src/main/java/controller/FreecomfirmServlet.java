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
import dto.freezerDTO;
import service.FreezerService;
import service.VegService;

/**
 * Servlet implementation class FreecomfirmServlet
 */
@WebServlet("/FreecomfirmServlet")
public class FreecomfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreecomfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		FreezerService FreezerService = new FreezerService(req, true);
		user u=(user)req.getSession().getAttribute("user");
		String nextPage = FreezerService.vegEntryDo();
		RequestDispatcher rd = req.getRequestDispatcher(nextPage);
		rd.forward(req, res);
		
		boolean useDB = true;
		//冷凍庫リストの再取得
		ArrayList<freezerDTO> fre = new VegService(req, useDB).findVegefreezer(u.getLoginId());
		// セッションに保存
		HttpSession session = req.getSession();
		session.setAttribute("fre", fre);
		
	}

}
