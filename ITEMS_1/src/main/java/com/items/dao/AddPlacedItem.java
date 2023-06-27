package com.items.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.items.model.PlacedItem;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class AddPlacedItem
{
	public void addPlacedItem(PlacedItem placedItem, MysqlDataSource ds) throws SQLException {
		Connection con=ds.getConnection();
		try {
			String sql = "insert into placedItem (clientId, itemId, placeId) values (?, ?, ?)";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, placedItem.getClientId());
			pstmt.setString(2, placedItem.getItemId());
			pstmt.setString(3, placedItem.getPlaceId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			con.rollback();
			throw e;
		}
	}

}
