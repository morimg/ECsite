package com.internousdev.ecsite.dto;

public class BuyItemConfirmDTO {
	private String buyItemId;
	private String buyItemName;
	private String buyItemPrice;
	private String buyItemCount;
	private String errorMessage;


	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getBuyItemId() {
		return buyItemId;
	}
	public void setBuyItemId(String buyItemId) {
		this.buyItemId = buyItemId;
	}
	public String getBuyItemName() {
		return buyItemName;
	}
	public void setBuyItemName(String buyItemName) {
		this.buyItemName = buyItemName;
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



}
