package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();
	private String buyItemId;
	private String buyItemPrice;
	private String buyItemCount;

	public String execute() throws SQLException{

		String[] buyItemIdList = buyItemId.split(", ",0);
		String[] buyItemPriceList = buyItemPrice.split(", ",0);
		String[] buyItemCountList = buyItemCount.split(", ",0);


		for (int i=0; i<buyItemIdList.length; i++) {

			buyItemCompleteDAO.buyItemInfo(
					buyItemIdList[i],
					buyItemPriceList[i],
					buyItemCountList[i],
					session.get("login_user_id").toString(),
					session.get("pay").toString());

			buyItemCompleteDAO.buyItemComplete(
					buyItemCountList[i],
					buyItemIdList[i]);

		}

		String result = SUCCESS;
		return result;
	}

	public String getBuyItemPrice() {
		return buyItemPrice;
	}

	public void setBuyItemPrice(String buyItemPrice) {
		this.buyItemPrice = buyItemPrice;
	}

	public String getBuyItemCount() {
		return buyItemCount;
	}

	public void setBuyItemCount(String buyItemCount) {
		this.buyItemCount = buyItemCount;
	}

	public String getBuyItemId() {
		return buyItemId;
	}

	public void setBuyItemId(String buyItemId) {
		this.buyItemId = buyItemId;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}

}
