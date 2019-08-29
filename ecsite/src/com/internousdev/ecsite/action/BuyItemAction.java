package com.internousdev.ecsite.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.ItemDetailsDAO;
import com.internousdev.ecsite.dto.BuyItemConfirmDTO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.ItemDetailsDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private ArrayList<BuyItemDTO> buyItemList = new ArrayList<BuyItemDTO>();
	ArrayList<BuyItemConfirmDTO> buyItemConfirmList = new ArrayList<BuyItemConfirmDTO>();
	private String errorMessage;
	private String id;
	private String checkItem;
	private String itemName;
	private String itemPrice;
	private String count;
	private String pay;


	public String execute() throws SQLException{
		String result = SUCCESS;

		String payment;

		if(pay.equals("1")){
			payment="現金払い";
			session.put("pay",payment);
		}else{
			payment="クレジットカード";
			session.put("pay",payment);
		}


		if(checkItem==null){
			setErrorMessage("商品が選択されていません。");
			result = ERROR;
			BuyItemDAO buyItemDAO = new BuyItemDAO();
			buyItemList=buyItemDAO.getBuyItemInfo();
		}else{
			String[] checkItemList = checkItem.split(", ",0);
			String[] idList = id.split(", ",0);

			ArrayList<BuyItemConfirmDTO> buyItemConfirmDTO = new ArrayList<BuyItemConfirmDTO>();
			buyItemConfirmList=buyItemConfirmDTO;

			for (int i=0; i<checkItemList.length; i++) {
				for (int j=0; j<idList.length; j++) {
					if (checkItemList[i].equals(idList[j])) {

						String[] countList = count.split(", ",0);

						ItemDetailsDAO itemDetailsDAO = new ItemDetailsDAO();
						ItemDetailsDTO itemDetailsDTO = new ItemDetailsDTO();
						itemDetailsDTO= (itemDetailsDAO).getItemDetailsInfoById(idList[j]);

						int intItemStock = Integer.parseInt(itemDetailsDTO.getItemStock());
						int intCount = Integer.parseInt(countList[j]);

						if(intItemStock<intCount){
							setErrorMessage((itemDetailsDTO.getItemName())+"の在庫が足りません。");
							result = ERROR;

							BuyItemDAO buyItemDAO = new BuyItemDAO();
							buyItemList=buyItemDAO.getBuyItemInfo();

						}else{

							BuyItemConfirmDTO dto = new BuyItemConfirmDTO();

							dto.setBuyItemId(idList[j]);
							dto.setBuyItemName(itemDetailsDTO.getItemName());
							dto.setBuyItemPrice(itemDetailsDTO.getItemPrice());
							dto.setBuyItemCount(countList[j]);
							buyItemConfirmDTO.add(dto);

							break;
						}
					}
				}
			}
		}

		return result;
	}

	 public ArrayList<BuyItemConfirmDTO> getBuyItemConfirmList() {
		return buyItemConfirmList;
	}
	public void setBuyItemConfirmList(ArrayList<BuyItemConfirmDTO> buyItemConfirmList) {
		this.buyItemConfirmList = buyItemConfirmList;
	}

	public ArrayList<BuyItemDTO> getBuyItemList(){
		return this.buyItemList;
	}

	public String getErrorMessage(){
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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

	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getCount(){
		return count;
	}
	public void setCount(String count){
		this.count = count;
	}

	public void setPay(String pay){
		this.pay = pay;
	}

	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;
	}
}

