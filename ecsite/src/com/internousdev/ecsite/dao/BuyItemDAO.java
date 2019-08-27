package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public ArrayList<BuyItemDTO> getBuyItemInfo(){
		String sql = "SELECT id,item_name,item_price,item_stock FROM item_info_transaction";

		ArrayList<BuyItemDTO> buyItemDTO = new ArrayList<BuyItemDTO>();

		try{
			PreparedStatement preparedstatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedstatement.executeQuery();

			while(resultSet.next()){
				BuyItemDTO dto = new BuyItemDTO();
				dto.setId(resultSet.getInt("id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setItemPrice(resultSet.getString("item_price"));
				dto.setItemStock(resultSet.getString("item_stock"));
				buyItemDTO.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		return buyItemDTO;
	}


}
