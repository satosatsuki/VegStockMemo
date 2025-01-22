package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.FreezerService;
import service.VegRegService;

/**
 * Servlet implementation class VagConfirm
 */
@WebServlet("/regster_veg")
public class RegsterVegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegsterVegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/jsp/register_vegtable.jsp");
		rd.forward(req, res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		// JSPから送信されたテーブル名を取得
	    String tableName = req.getParameter("tableName");
	    System.out.println("tableName: "+tableName);
	    //入力値チェック
//		boolean useDB = true;
//		boolean result = new LoginService(req, useDB).VegCheck(vag_name);

	    try {
	        // テーブル名に基づいて処理を振り分け
	    	System.out.println("IS REFRIGERATOR: "+tableName.equals("refrigerator"));
	    	System.out.println("IS FREEZER: "+tableName.equals("freezer"));
	        if (tableName.equals("refrigerator")) {

	            // 冷蔵庫テーブル用のサービスメソッドを呼び出し
	        	String nextPage = new VegRegService(req,true).EntiryVegRefrigerator();
	        	System.out.println("nextPage: "+nextPage);
	    		RequestDispatcher rd = req.getRequestDispatcher(nextPage);
	    		rd.forward(req, res);
	    		
	        	
	        } else if (tableName.equals("freezer")) {
		    	System.out.println("try"+tableName.equals("freezer"));

	            // 冷凍庫テーブル用のサービスメソッドを呼び出し
	        	String nextPage = new FreezerService(req, true).userEntryFreezer();
	    		RequestDispatcher rd = req.getRequestDispatcher(nextPage);
	    		rd.forward(req, res);

	        } else {
	            // 不正なテーブル名の場合
	            throw new IllegalArgumentException("不正なテーブル名が指定されました: " + tableName);
	        }
	    } catch (Exception e) {
	    	e.printStackTrace();
	        // エラーハンドリング: エラーメッセージを設定し、エラー画面に遷移
	        req.setAttribute("errorMsg", "エラーが発生しました: " + e.getMessage());
	        //req.getRequestDispatcher("/jsp/home.jsp").forward(req, res);
	    }
	}

		
	}
		
	

