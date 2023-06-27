package com.web.mydays.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.web.mydays.model.UserLogin;

public class LoginDAO {
	private PreparedStatement pstmt;
	public UserLogin getUserLogin(UserLogin userLogin) {
		try(Connection con = DBConnection.getConnection()) {
			
			String query = "select USER_ID FROM USER_LOGIN WHERE USER_ID=? AND PASSWORD=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,userLogin.getUserId());
			pstmt.setString(2,userLogin.getPassword());
						
			ResultSet rs = pstmt.executeQuery();
			if(rs!=null && rs.next()) {
				return userLogin;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}
