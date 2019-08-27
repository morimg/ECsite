package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateConfirmAction extends ActionSupport implements SessionAware{

	private String itemName;
	private int price;
	private int stock;
	public Map<String,Object> session;
	private String errorMessage;

	public String execute(){
		String result = SUCCESS;

		if(!(itemName.equals("")) && price >= 0 && stock > 0){
			session.put("ItemName", itemName);
			session.put("Price", price);
			session.put("Stock", stock);
		}else{
			setErrorMessage("未入力、あるいは無効な数値の入力があります。");
			result = ERROR;
		}
		return result;
	}

	public String getItemName(){
		return itemName;
	}
	public void setItemName(String itemName){
		this.itemName = itemName;
	}

	public int getPrice(){
		return price;
	}
	public void setPrice(int price){
		this.price = price;
	}

	public int getStock(){
		return stock;
	}
	public void setStock(int stock){
		this.stock = stock;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public String getErrorMessage(){
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}

}
