package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class UserCreateConfirmDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public int userCheck(String LoginUserId) throws SQLException{
		String sql="SELECT * FROM login_user_transaction where login_id = ?";
		PreparedStatement preparedStatement;
		int result = 0;

		try{
			preparedStatement  = connection.prepareStatement(sql);
			preparedStatement.setString(1, LoginUserId);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()){
				result = 1;
			}else{
				result = 0;
			}


		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return result ;
	}
}