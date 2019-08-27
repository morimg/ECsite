package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemDeleteCompleteAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private ItemDeleteCompleteDAO itemDeleteCompleteDAO = new ItemDeleteCompleteDAO();
	private String message;


	public String execute()throws SQLException{

		    String itemId = session.get("ItemId").toString();

			int res =itemDeleteCompleteDAO.itemDelete(itemId);
			if(res>0){
				setMessage("商品情報を正しく削除しました");
			}else if(res == 0){
				setMessage("商品情報の削除に失敗しました。");
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
