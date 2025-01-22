package service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import dao.FreezerDAO;
import domain.freezer;
import domain.user;
import dto.freezerDTO;

public class FreezerService extends BaseService{
	public FreezerService (HttpServletRequest req, boolean userDB) {
		super(req,userDB);
	}
	//入力値チェック的な
	public String userEntryFreezer() {
		
		
		String tableName = req.getParameter("tableName");//テーブル名の確認
		String veg_name = req.getParameter("veg_name");
		String veg_date = req.getParameter("veg_date");
		String veg_level = req.getParameter("veg_level");
		String veg_count = req.getParameter("veg_count");
		user u = (user)req.getSession().getAttribute("user");
		String loginid = req.getParameter("loginid"); 
		
//		if (!tableName.equals("freezer")) {
//	        throw new IllegalArgumentException("指定されたテーブルが不正です: " + tableName);
//	    }
		
		validation.isBlank("野菜名", veg_name);
		validation.isBlank("登録日", veg_date);
		validation.isBlank("個数", veg_count);
		
		
		//veg情報セット
		freezer fre = new freezer();
		fre.setTableName(tableName);
		fre.setVeg_name(veg_name);
		//String dtStr = new SimpleDateFormat("yyyy-MM-dd").format(veg_date); 
		//fre.setVeg_date(dtStr);
		fre.setVeg_date(veg_date);
		fre.setVeg_level(veg_level);
		fre.setVeg_count(veg_count);
		fre.setLoginid(loginid);
		
		FreezerDAO FreezerDAO = new FreezerDAO(conn);
		freezerDTO freezerDTO = FreezerDAO.selectByvegLoginIdAndVegName(fre.getLoginid(),fre.getVeg_name());
		

		//すでに存在する場合		
		if (freezerDTO == null) {
				req.setAttribute("fre", fre);
					return "/jsp/freeconfirm.jsp";

					//ユーザーが存在しない場合→登録内容確認画面にさせる
				} else {
			
					validation.addErrorMsg("入力いただいたユーザーID「" + "loginId " + "」は既に使われております。");

				req.setAttribute("errorMsg", validation.getErrorMsgList());
					return "/jsp/register_vegetable.jsp";
        }

	}	
	
	
	//冷凍庫登録用
		public String vegEntryDo() {

		    String tableName = req.getParameter("tableName");
			String veg_name = req.getParameter("veg_name");
			String veg_date = req.getParameter("veg_date");
			String veg_level = req.getParameter("veg_level");
			String veg_count = req.getParameter("veg_count");
			user u = (user)req.getSession().getAttribute("user");
			String loginid = u.getLoginId();

			//veg情報セット
			freezer fre = new freezer();
			fre.setVeg_name(tableName);
			fre.setVeg_name(veg_name);
			//String dmStr = new SimpleDateFormat("yyyy-MM-dd").format(veg_date); // 正しいフォーマット
			fre.setVeg_date(veg_date);
			//fre.setVeg_date(dmStr);
			fre.setVeg_level(veg_level);
			fre.setVeg_count(veg_count);
			fre.setLoginid(loginid);
			
			//DAOをnewしてdomainの中身をdtoに格納
			FreezerDAO FreezerDAO = new FreezerDAO(conn);
			freezerDTO dto = new freezerDTO();
		
			//date型からstring型へ変換
			
			
			dto.setTableName(fre.getTableName());
			dto.setVeg_name(fre.getVeg_name());
			Date sqlDate = java.sql.Date.valueOf(veg_date);
		    dto.setVeg_date(sqlDate);
			dto.setVeg_level(fre.getVeg_level());
			dto.setVeg_count(Integer.parseInt(veg_count));
			dto.setLoginid(fre.getLoginid());
			
			

			
			//準備が整ったら、インサートするよーという記述　なお、DAOに遷移
			int result = FreezerDAO.insert(dto);

			//更新件数１件ならばtmをはさみ、リターン
			if (result == 1) {
				tm.commit();
				tm.close();
				return "/jsp/FreezerVegDone.jsp";
			} else {
				tm.rollback();
				tm.close();
				return "/jsp/register_vegetable.jsp";
			}
	
}
		}
