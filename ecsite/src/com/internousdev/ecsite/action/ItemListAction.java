package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport {

	private ItemListDAO itemListDAO = new ItemListDAO();
	private ArrayList<ItemListDTO> itemList = new ArrayList<ItemListDTO>();
	private String itemListMessage;


	public String execute()throws SQLException{
		String result = SUCCESS;

		itemList=itemListDAO.getItemInfo();

		if(itemList.isEmpty()){
			setItemListMessage("enpty");
		}else{
			setItemListMessage("in");
		}
		return result;
	}

	public ArrayList<ItemListDTO> getItemList(){
		return this.itemList;
	}

	public String getItemListMessage(){
		return this.itemListMessage;
	}
	public void setItemListMessage(String itemListMessage){
		this.itemListMessage = itemListMessage;
	}

}
