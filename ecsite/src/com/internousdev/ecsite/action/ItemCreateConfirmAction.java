package com.internousdev.ecsite.action;

import java.util.Map;
import java.util.regex.Pattern;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateConfirmAction extends ActionSupport implements SessionAware{

	private String itemName;
	private String price;
	private String stock;
	public Map<String,Object> session;
	private String errorMessage;

	public String execute(){
		String result = SUCCESS;

		if(!(itemName.equals("")) && !(price.equals(""))  && !(stock.equals(""))){

			if(isHalfNumeric(price) && isHalfNumeric(stock)){

						session.put("ItemName", itemName);
						session.put("Price", price);
						session.put("Stock", stock);

			}else{
				setErrorMessage("無効な入力があります。");
				result = ERROR;
			}

		}else{
			setErrorMessage("未入力の項目があります。");
			result = ERROR;
		}

		return result;
	}

	public static boolean isHalfNumeric(String s) {
        return Pattern.matches("^[0-9]*$", s);
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
