package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.ItemDetailsDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemDetailsDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private ItemDetailsDTO dto = new ItemDetailsDTO();

	public ItemDetailsDTO getItemDetailsInfo(String itemName) throws SQLException{
		String sql = "SELECT * FROM item_info_transaction where item_name = ?";

		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, itemName);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				dto.setId(resultSet.getString("id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setItemPrice(resultSet.getString("item_price"));
				dto.setItemStock(resultSet.getString("item_stock"));
				dto.setInsert_date(resultSet.getString("insert_date"));
				dto.setUpdate_date(resultSet.getString("update_date"));

			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return dto;
	}

	public ItemDetailsDTO getItemDetailsInfoById(String itemId) throws SQLException{
		String sql = "SELECT * FROM item_info_transaction where id = ?";

		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, itemId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				dto.setId(resultSet.getString("id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setItemPrice(resultSet.getString("item_price"));
				dto.setItemStock(resultSet.getString("item_stock"));
				dto.setInsert_date(resultSet.getString("insert_date"));
				dto.setUpdate_date(resultSet.getString("update_date"));

			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return dto;
	}

}
