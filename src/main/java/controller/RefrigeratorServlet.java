package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.VegRegService;

/**
 * Servlet implementation class RefrigeratorServlet
 */
@WebServlet("/refrigerator_table")
public class RefrigeratorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RefrigeratorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/jsp/refrigerator_table");
        rd.forward(req,res);
	
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		VegRegService VegRegService = new VegRegService(req, true);
		String nextPage = VegRegService.EntiryVegRefrigerator();
		RequestDispatcher rd = req.getRequestDispatcher(nextPage);
		rd.forward(req, res);		
	}
	}


