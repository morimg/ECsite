package com.internousdev.ecsite.action;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dto.BuyItemConfirmDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private String pay;
	private String errorMessage;
	private String id;
	private String itemName;
	private String checkItem;
	private String count;



	public String execute(){

		System.out.println(id);
		System.out.println(checkItem);
		System.out.println(itemName);
		System.out.println(count);


		String[] checkItemList = checkItem.split(", ",0);
		String[] idList = id.split(", ",0);
		for (int i=0; i<checkItemList.length; i++) {
			for (int j=0; j<idList.length; j++) {
				if (checkItemList[i].equals(idList[j])) {
					//画面に表示させるための変数に値を入れる。

					ArrayList<BuyItemConfirmDTO> buyItemConfirmDTO = new ArrayList<BuyItemConfirmDTO>();
					BuyItemConfirmDTO dto = new

					BuyList.add(itemName);


					break;
				}

			}

		}

		String result = SUCCESS;

		String payment;
		if(pay.equals("1")){
			payment="現金払い";
			session.put("pay",payment);
		}else{
			payment="クレジットカード";
			session.put("pay",payment);


	}
		return result;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPay(String pay){
		this.pay = pay;
	}

	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;
	}

	public String getErrorMessage(){
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}

	public String getCount(){
		return count;
	}
	public void setCount(String count){
		this.count = count;
	}

	public String getCheckItem() {
		return checkItem;
	}

	public void setCheckItem(String checkItem) {
		this.checkItem = checkItem;
	}

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

}

