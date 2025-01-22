package service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import dao.FreezerDAO;
import dao.RefrigeratorDAO;
import dto.RefrigeratorDTO;
import dto.freezerDTO;

public class VegService extends BaseService {
	private static final String loginId = null;

	public VegService(HttpServletRequest req, boolean useDB) {
		super(req, useDB);
	}

	//arraylistを呼び出す実行くらす 
	public ArrayList<RefrigeratorDTO> findVegetables(String loginId) {

		RefrigeratorDAO RefrigeratorDAO = new RefrigeratorDAO(conn);
		// ログイン中のユーザ情報(ユーザID)をセッションからとってくる
		ArrayList<RefrigeratorDTO> list = RefrigeratorDAO.refselectAll(loginId);

		return list;

	}
	
	public ArrayList<freezerDTO> findVegefreezer(String loginId) {

		FreezerDAO FreezerDAO = new FreezerDAO(conn);
		// ログイン中のユーザ情報(ユーザID)をセッションからとってくる
		ArrayList<freezerDTO> list =FreezerDAO.freselectAll(loginId);

		return list;

	}
	

	

}
