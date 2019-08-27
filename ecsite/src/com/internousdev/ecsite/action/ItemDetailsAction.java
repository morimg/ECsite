package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemDetailsDAO;
import com.internousdev.ecsite.dto.ItemDetailsDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemDetailsAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	private String itemName;
	private String result;

	public String execute()throws SQLException{
		ItemDetailsDAO itemDetailsDAO = new ItemDetailsDAO();
		ItemDetailsDTO itemDetailsDTO = new ItemDetailsDTO();

			itemDetailsDTO= (itemDetailsDAO).getItemDetailsInfo(itemName);
			session.put("ItemId", itemDetailsDTO.getId());
			session.put("ItemName", itemDetailsDTO.getItemName());
			session.put("ItemPrice", itemDetailsDTO.getItemPrice());
			session.put("ItemStock", itemDetailsDTO.getItemStock());
			session.put("InsertDate", itemDetailsDTO.getInsert_date());
			session.put("UpdateDate", itemDetailsDTO.getUpdate_date());

			result=SUCCESS;

			return result;

}
	public String getItemName(){
		return itemName;
	}
	public void setItemName(String ItemName){
		this.itemName = ItemName;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;

	}
}
