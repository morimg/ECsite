package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dao.UserListDeleteCompleteDAO;
import com.internousdev.ecsite.dto.UserListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListDeleteCompleteAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private UserListDeleteCompleteDAO userListDeleteCompleteDAO = new UserListDeleteCompleteDAO();
	private UserListDAO userListDAO = new UserListDAO();
	private ArrayList<UserListDTO> UserList = new ArrayList<UserListDTO>();
	private String message;


	public String execute()throws SQLException{
			UserList=userListDAO.getUserInfo();

			int res =userListDeleteCompleteDAO.userListDelete();
			if(res>0){
				UserList = null;
				setMessage("ユーザー情報を正しく削除しました");
			}else if(res == 0){
				setMessage("ユーザー情報の削除に失敗しました。");
			}
			String result = SUCCESS;

			return result;
		}


	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public ArrayList<UserListDTO> getUserList(){
		return this.UserList;
	}

	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message = message;
	}



}
