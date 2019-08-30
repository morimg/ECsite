package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserDeleteCompleteAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private UserDeleteCompleteDAO userDeleteCompleteDAO = new UserDeleteCompleteDAO();
	private String message;


	public String execute()throws SQLException{

			String loginId = session.get("LoginId").toString();

			int res = userDeleteCompleteDAO.userDelete(loginId);

			if(res>0){
				setMessage("ユーザー情報を正しく削除しました。");
			}else if(res == 0){
				setMessage("ユーザーの削除に失敗しました。");
			}
			String result = SUCCESS;

			return result;
		}


	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message = message;
	}



}
