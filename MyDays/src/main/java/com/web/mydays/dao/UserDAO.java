package com.web.mydays.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.web.mydays.model.User;
import com.web.mydays.model.UserLogin;

public class UserDAO {
	private PreparedStatement pstmt;
	
	public User getUser(UserLogin userLogin) {
		User user = null;
		try (Connection con = DBConnection.getConnection()) {
			String query = "select USER_ID, USER_NAME, USER_AGE, CONTACTNO FROM USER WHERE USER_ID=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userLogin.getUserId());

			ResultSet rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				user = new User();
				user.setId(rs.getString(1));
				user.setName(rs.getString(2));
				user.setAge(rs.getInt(3));
				user.setContactNo(rs.getString(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
}
