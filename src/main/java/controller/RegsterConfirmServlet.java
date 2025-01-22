package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserRegisterService;

/**
 * Servlet implementation class RegsterConfirmServlet
 */
@WebServlet("/registerConfirm")
public class RegsterConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegsterConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		UserRegisterService registerServise = new UserRegisterService(req, true);
		String nextPage = registerServise.userEntryDo();
		RequestDispatcher rd = req.getRequestDispatcher(nextPage);
		rd.forward(req, res);
		
		
		
	}

}
