package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport {

	private UserListDAO userListDAO = new UserListDAO();
	private ArrayList<UserListDTO> userList = new ArrayList<UserListDTO>();
	private String userListMessage;

	public String execute()throws SQLException{
		String result = SUCCESS;

		userList=userListDAO.getUserInfo();

		if(userList.isEmpty()){
			setUserListMessage("enpty");
		}else{
			setUserListMessage("in");
		}

		return result;
	}

	public ArrayList<UserListDTO> getUserList(){
		return this.userList;
	}

	public String getUserListMessage(){
		return this.userListMessage;
	}
	public void setUserListMessage(String userListMessage){
		this.userListMessage= userListMessage;
	}


}
