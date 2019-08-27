package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;


public class BuyItemCompleteDAO {



	public void buyItemInfo(String item_transaction_id,String total_price,String total_count,String user_master_id,String pay)throws SQLException{
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		DateUtil dateUtil = new DateUtil();
		String sql = "INSERT INTO user_buy_item_transaction(item_transaction_id,total_price,total_count,user_master_id,pay,insert_date) VALUES(?,?,?,?,?,?)";

		try{
			PreparedStatement preparedStatememnt = connection.prepareStatement(sql);
			preparedStatememnt.setString(1, item_transaction_id);
			preparedStatememnt.setString(2, total_price);
			preparedStatememnt.setString(3, total_count);
			preparedStatememnt.setString(4, user_master_id);
			preparedStatememnt.setString(5, pay);
			preparedStatememnt.setString(6, dateUtil.getDate());
			preparedStatememnt.execute();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}

	}

	public void buyItemComplete(String count,String id)throws SQLException{
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		DateUtil dateUtil = new DateUtil();
		String sql = "UPDATE item_info_transaction SET item_stock = item_stock - ? , update_date = ? WHERE id = ?";

		try{
			PreparedStatement preparedStatememnt = connection.prepareStatement(sql);
			preparedStatememnt.setString(1, count);
			preparedStatememnt.setString(2, dateUtil.getDate());
			preparedStatememnt.setString(3, id);
			preparedStatememnt.execute();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}

	}

}
