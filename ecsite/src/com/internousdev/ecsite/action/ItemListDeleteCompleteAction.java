package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;
import com.internousdev.ecsite.dto.ItemListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListDeleteCompleteAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private ItemListDeleteCompleteDAO itemListDeleteCompleteDAO = new ItemListDeleteCompleteDAO();
	private ItemListDAO itemListDAO = new ItemListDAO();
	private ArrayList<ItemListDTO> ItemList = new ArrayList<ItemListDTO>();
	private String message;


	public String execute()throws SQLException{
			ItemList=itemListDAO.getItemInfo();

			int res =itemListDeleteCompleteDAO.itemListDelete();
			if(res>0){
				ItemList = null;
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

	public ArrayList<ItemListDTO> getItemList(){
		return this.ItemList;
	}

	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message = message;
	}



}
