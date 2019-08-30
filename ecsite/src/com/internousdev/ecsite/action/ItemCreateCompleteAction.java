package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateCompleteAction extends ActionSupport implements SessionAware{

	private String itemName;
	private String price;
	private String stock;
	public Map<String,Object> session;
	private ItemCreateCompleteDAO ItemCreateCompleteDAO = new ItemCreateCompleteDAO();

	public String execute()throws SQLException{

		ItemCreateCompleteDAO.createItem(
			session.get("ItemName").toString(),
			session.get("Price").toString(),
			session.get("Stock").toString());

		String result = SUCCESS;

		return result;
	}

	public String getItemName(){
		return itemName;
	}
	public void setItemName(String itemName){
		this.itemName = itemName;
	}

	public String getPrice(){
		return price;
	}
	public void setPrice(String price){
		this.price = price;
	}

	public String getStock(){
		return stock;
	}
	public void setStock(String stock){
		this.stock = stock;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}

}
