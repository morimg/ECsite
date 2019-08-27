package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserDetailsDAO;
import com.internousdev.ecsite.dto.UserDetailsDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserDetailsAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	private String loginId;
	private String result;

	public String execute()throws SQLException{
		UserDetailsDAO userDetailsDAO = new UserDetailsDAO();
		UserDetailsDTO userDetailsDTO = new UserDetailsDTO();

			userDetailsDTO= (userDetailsDAO).getUserDetailsInfo(loginId);
			session.put("Id", userDetailsDTO.getId());
			session.put("AdminFlg", userDetailsDTO.getAdminFlg());
			session.put("LoginId", userDetailsDTO.getLoginId());
			session.put("LoginPass", userDetailsDTO.getLoginPass());
			session.put("UserName", userDetailsDTO.getUserName());
			session.put("InsertDate", userDetailsDTO.getInsert_date());
			session.put("UpdateDate", userDetailsDTO.getUpdate_date());

			result=SUCCESS;

			return result;

}
	public String getLoginId(){
		return loginId;
	}
	public void setLoginId(String loginId){
		this.loginId = loginId;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;

	}
}
