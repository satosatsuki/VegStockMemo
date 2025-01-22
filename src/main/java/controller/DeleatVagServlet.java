package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RefrigeratorDAO;

/**
 * Servlet implementation class DeleatVagServlet
 */
@WebServlet("/deleteVegetableServlet")
public class DeleatVagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleatVagServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 String id = req.getParameter("loginid"); // リクエストからIDを取得
	        if (id == null || id.isEmpty()) {
	            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	            return;
	        }

	        try (Connection conn = DriverManager.getConnection(id)) {
	            // DAOを使って削除処理を実行
	        	
	            RefrigeratorDAO dao = new RefrigeratorDAO(conn);
	            boolean success = dao.deleteById(Integer.parseInt(id)); // IDを削除

	            if (success) {
	                res.setStatus(HttpServletResponse.SC_OK);
	            } else {
	                res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	        }
	    }
	}

