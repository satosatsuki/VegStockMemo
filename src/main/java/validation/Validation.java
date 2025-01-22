package validation;

import java.util.ArrayList;
import java.util.List;

public class Validation {
	//エラーメッセージを保持するString型のerrorMsgListという名前のリスト
		private List<String> errorMsgList;
		
		public Validation() {
			this.errorMsgList = new ArrayList<>();
		}
		
		public boolean hasErrorMsg() {
			if(errorMsgList.size() > 0){
				return true;
			} else {
				return false;
			}
		}
		
	//指定されたテキストがnullまたは空文字かどうかをチェックし、trueならメッセージを追加
		public void isBlank(String textName , String text) {
			if(text ==null || text.isEmpty()) {
				this.errorMsgList.add(textName + "が入力されていません");
			}
		}
	//テキストの長さが最大値以下かどうかをチェック、超えている場合はエラーメッセージを追加
		
		public void length(String textName,String text,int min,int max) {
			if((text == null || text.length() < min || text.length() > max)) {
				this.errorMsgList.add(textName + "は" + min + "文字以上" + max + "文字以内で入力してください");
			}
		}
	//テキストの長さが最大値以下かどうかをチェック、超えている場合はエラーメッセージを追加
		public void length(String textName, String text,int max) {
			if(text == null || text.length() > max) {
				this.errorMsgList.add(textName + "は" + max + "文字以内で入力してください"); 
			}
		}
	//エラーメッセージをリストに追加
		public void addErrorMsg(String msg) {
			errorMsgList.add(msg);
		}
	//保持しているエラーメッセージのリストを渡す
		public List<String> getErrorMsgList() {
			return errorMsgList;
		}
}
