package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class HomeService extends BaseService  {
	public HomeService(HttpServletRequest req, boolean useDB) {
		super(req,useDB);
	}
	public String selectByusername(String username) {
		
		HttpSession session = req.getSession(true);
        session.setAttribute("username", username);
        
        if (username != null) {
            // さらに詳細情報をセッションに保存したい場合
            session.setAttribute("userDetails", username);
            return username;
        }
        return null; // ユーザーが見つからなかった場合
		
		
	}
	
}


