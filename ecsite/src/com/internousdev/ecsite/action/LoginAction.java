package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
	private String loginUserId;
	private String loginPassword;
	public Map<String,Object> session;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	private BuyItemDAO buyItemDAO = new BuyItemDAO();
	private ArrayList<BuyItemDTO> buyItemList = new ArrayList<BuyItemDTO>();

	public String execute(){
		String result = ERROR;

		loginDTO = loginDAO.getLoginUserInfo(loginUserId,loginPassword);
		session.put("loginUser",loginDTO);
		session.put("adminFlg", loginDTO.getAdminFlg());

		if(((LoginDTO) session.get("loginUser")).getLoginFlg()){

				if((session.get("adminFlg")) != null){
					result = "Admin";
				}else{
					result = SUCCESS;

					session.put("login_user_id",loginDTO.getLoginId());
					session.put("id",null);

					buyItemList=buyItemDAO.getBuyItemInfo();

				}

			return result;

			}
		return result;
	}

	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}

	public ArrayList<BuyItemDTO> getBuyItemList(){
		return this.buyItemList;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}
