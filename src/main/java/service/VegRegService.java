package service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import dao.RefrigeratorDAO;
import domain.refrigerator;
import domain.user;
import dto.RefrigeratorDTO;

//冷蔵庫登録用
public class VegRegService extends BaseService {
	public VegRegService(HttpServletRequest req, boolean userDB) {
		super(req, userDB);
	}

	//	public void saveToRefrigerator(RefrigeratorDTO dto) {
	//	    String tableName = "refrigerator"; // テーブル名をサービス層で管理
	//	    // DAOなどで保存処理必要に応じて
	//	}
	public String EntiryVegRefrigerator() {

		
		String tableName = req.getParameter("tableName");//テーブル名の確認
		String veg_name = req.getParameter("veg_name");
		String veg_date = req.getParameter("veg_date");
		String veg_level = req.getParameter("veg_level");
		String veg_count = req.getParameter("veg_count");
		user u = (user)req.getSession().getAttribute("user");
		String loginid = u.getLoginId();

		//テーブル名の入力値チェック
		if (!"refrigerator".equals(tableName) && !"freezer".equals(tableName)) {
			throw new IllegalArgumentException("指定されたテーブルが不正です: " + tableName);
		}

		System.out.println("登録vegetableの値：" + veg_name); // ここまでOK

		validation.isBlank("野菜名", veg_name);
		validation.isBlank("登録日", veg_date);
		validation.isBlank("個数", veg_count);

		//veg情報セット
		refrigerator ref = new refrigerator();
		ref.setTableName(tableName);
		ref.setVeg_name(veg_name);
		//dateからStringに変換
//		String dtStr = new SimpleDateFormat("yyyy-MM-dd").format(veg_date);
//		ref.setVeg_date(dtStr);
		ref.setVeg_date(veg_date);
		ref.setVeg_level(veg_level);
		ref.setVeg_count(veg_count);
		ref.setLoginid(loginid);
		

		//バリデーションエラーがあった場合
		if (validation.hasErrorMsg()) {
			System.out.println(validation.getErrorMsgList());
			req.setAttribute("errorMsg", validation.getErrorMsgList());
			return "/jsp/register_vegetable.jsp"; // 飛べてない
		}
		
		
		//DBにユーザーがすでに存在するかチェック

		RefrigeratorDAO RefrigeratorDAO = new RefrigeratorDAO(conn);
		RefrigeratorDTO RefrigeratorDTO = RefrigeratorDAO.selectByvegLoginIdAndVegName(ref.getLoginid(),ref.getVeg_name());
		System.out.println("dto:"+RefrigeratorDTO);

		//ユーザーが存在しない場合→登録内容確認画面にさせる
		if (RefrigeratorDTO == null) {
			req.setAttribute("ref", ref);
			return "/jsp/refcomfirm.jsp";
		} else {
			//すでに存在する場合
			validation.addErrorMsg("入力いただいたユーザーID「" + "loginId " + "」は既に使われております。");

			req.setAttribute("errorMsg", validation.getErrorMsgList());
			return "/jsp/regster_vegetable.jsp";
		}
	}

	//冷蔵庫登録用
	public String vegEntryDo() {

		String tableName = req.getParameter("tableName");
		String veg_name = req.getParameter("veg_name");
		String veg_date = req.getParameter("veg_date");
		String veg_level = req.getParameter("veg_level");
		String veg_count = req.getParameter("veg_count");
		user u = (user)req.getSession().getAttribute("user");
		String loginid = u.getLoginId();

		//getparameterした私たちをdomainに保存する
		refrigerator ref = new refrigerator();
		ref.setTableName(tableName);
		ref.setVeg_name(veg_name);
		//dateからStirngに変換
//		String dmStr = new SimpleDateFormat("yyyy-MM-dd").format(veg_date); // 正しいフォーマット
		ref.setVeg_date(veg_date);
		ref.setVeg_level(veg_level);
		ref.setVeg_count(veg_count);
		ref.setLoginid(loginid);

		//DAOをnewしてdomainの中身をdtoに格納
		RefrigeratorDAO refrigeratorDAO = new RefrigeratorDAO(conn);
		RefrigeratorDTO dto = new RefrigeratorDTO();
		
		dto.setTableName(ref.getTableName());
		dto.setVeg_name(ref.getVeg_name());
        //StringからDateに変換
		Date sqlDate = java.sql.Date.valueOf(veg_date);
		dto.setVeg_date(sqlDate);
		dto.setVeg_level(ref.getVeg_level());
		dto.setVeg_count(Integer.parseInt(veg_count));
		dto.setLoginid(ref.getLoginid());

		//準備が整ったら、インサートするよーという記述　なお、DAOに遷移
		int result = refrigeratorDAO.insertveg(dto);

		//更新件数１件ならばtmをはさみ、リターン
		if (result == 1) {
			tm.commit();
			tm.close();
			return "/jsp/registerVegDone.jsp";
		} else {
			tm.rollback();
			tm.close();
			return "/jsp/regster_vegetable.jsp";
		}
	}

	//public ArrayList<RefrigeratorDTO> getVegetableList() {
	    // 登録内容をデータベースまたはデータソースから取得
	    //return RefrigeratorDAO.getArrayList<RefrigeratorDTO>();
	//}
	
	//yasai登録変更用
	//public String change() {

	//}
}
