package com.items.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.items.dao.AddPlacedItem;
import com.items.model.Client;
import com.items.model.Item;
import com.items.model.Place;
import com.items.model.PlacedItem;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

@SuppressWarnings("serial")
@WebServlet(name = "AddItemController", urlPatterns = { "/addItem" })
public class AddItemController extends HttpServlet {

	private MysqlDataSource ds = null;
	
	String itemExist;
	String placeExist;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		doPost(req, resp);
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// We can use BasicDataSource provided by drivers
		ds = new MysqlDataSource();
		ds.setURL("jdbc:mysql://localhost:3306/items");
		ds.setUser("root");
		ds.setPassword("root");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException{
		Item item = new Item();
		item.setItemName(req.getParameter("InputItemName"));
		item.setItemId(item.getItemName());
		
		Place place = new Place();
		place.setPlaceName(req.getParameter("InputPlace"));
		place.setPlaceId(place.getPlaceName());
		
		HttpSession session = req.getSession(false);
		Client client = (Client)session.getAttribute("client");
				
		System.out.println(client.getClientEmail());
		System.out.println(item.getItemId());
		System.out.println(place.getPlaceId());
		
		
		PlacedItem placedItem = new PlacedItem();
		
		try
		{
			placedItem.setItemId(getItemId(item));
			placedItem.setClientId(client.getClientEmail());
			placedItem.setPlaceId(getPlaceId(place));
			System.out.println(placedItem.getClientId());
			System.out.println(placedItem.getItemId());
			System.out.println(placedItem.getPlaceId());
		} catch (SQLException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			if (isPlacedItemExists(placedItem)) {
				RequestDispatcher dispatcher = req
						.getRequestDispatcher("/index.jsp");
				// Forces caches to obtain a new copy of the page from the
				// origin server
				resp.setHeader("Cache-Control", "no-cache");
				// Directs caches not to store the page under any circumstance
				resp.setHeader("Cache-Control", "no-store");
				System.out.println("Working");
				// Causes the proxy cache to see the page as "stale"
				resp.setDateHeader("Expires", 0);
				// HTTP 1.0 backward compatibility
				resp.setHeader("Pragma", "no-cache");
				req.setAttribute("messageItem",
						"This Item is already exist");
				dispatcher.forward(req, resp);
			} else {
				
				AddPlacedItem addplacedItem = new AddPlacedItem();
				addplacedItem.addPlacedItem(placedItem, ds);
				// ---
				// Database
				RequestDispatcher dispatcher = req
						.getRequestDispatcher("/index.jsp");
				// Forces caches to obtain a new copy of the page from the
				// origin server
				resp.setHeader("Cache-Control", "no-cache");
				// Directs caches not to store the page under any circumstance
				resp.setHeader("Cache-Control", "no-store");
				System.out.println("Working");
				// Causes the proxy cache to see the page as "stale"
				resp.setDateHeader("Expires", 0);
				// HTTP 1.0 backward compatibility
				resp.setHeader("Pragma", "no-cache");
				req.setAttribute("messageItem",
						"You have Sucessfully Added an Item...");
				dispatcher.forward(req, resp);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	private boolean isPlacedItemExists(PlacedItem placedItem) throws SQLException {
		boolean placedItemFound = false;
		PlacedItem tempPlacedItem = new PlacedItem();
		Connection con = null;

		try {
			con = ds.getConnection();
			ResultSet rs = null;
			String sql = "select * from placeditem where clientId = ? and itemId = ? and placeId = ?";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, placedItem.getClientId());
			pstmt.setString(2, placedItem.getItemId());
			pstmt.setString(3, placedItem.getPlaceId());
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				tempPlacedItem.setClientId(rs.getString(1));
				tempPlacedItem.setItemId(rs.getString(2));
				tempPlacedItem.setPlaceId(rs.getString(3));	
			}

			if (tempPlacedItem.getItemId()!=null && tempPlacedItem.getClientId().equalsIgnoreCase(placedItem.getClientId()) && tempPlacedItem.getItemId().equalsIgnoreCase(placedItem.getItemId()) && tempPlacedItem.getPlaceId().equalsIgnoreCase(placedItem.getPlaceId()))
			{
				placedItemFound = true;
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return placedItemFound;
	}
	
	
	
	
	
	
	public String getItemId(Item item) throws SQLException
	{
		if (isItemIdExist(item))
		{
			return itemExist;
		}
		return item.getItemId();
	}

	public String getPlaceId(Place place) throws SQLException
	{
		if (isPlaceIdExist(place))
		{
			return placeExist;
		}
		return place.getPlaceId();
	}

	private boolean isItemIdExist(Item item) throws SQLException
	{
		boolean itemFound = false;
		Connection con = null;

		try
		{
			con = ds.getConnection();
			Item tempItem = new Item();
			ResultSet rs = null;
			String sql = "select * from item where itemId = ?";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, item.getItemId());

			rs = pstmt.executeQuery();
System.out.println("till this working-1");
			while (rs.next())
			{
				tempItem.setItemId(rs.getString(1));
				System.out.println("till this working-2"+"--------"+tempItem);
			}
			System.out.println("till this working-2.5");
			if (tempItem.getItemId()!=null && tempItem.getItemId().equalsIgnoreCase(item.getItemId()))
			{
				itemFound = true;
				itemExist = tempItem.getItemId();
				System.out.println("till this working-3");
			} 
			else
			{
				System.out.println("till this working-4");
				sql = "insert into item (itemId, itemName) values (?, ?)";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, item.getItemId());
				pstmt.setString(2, item.getItemName());
				pstmt.executeUpdate();
				System.out.println("till this working-5");
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		finally
		{
			if (con != null)
			{
				con.close();
			}
		}
		return itemFound;
	}

	private boolean isPlaceIdExist(Place place) throws SQLException
	{
		boolean placeFound = false;
		Connection con = null;

		try
		{
			con = ds.getConnection();
			Place tempPlace = new Place();
			ResultSet rs = null;
			String sql = "select * from place where placeId = ?";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, place.getPlaceId());

			rs = pstmt.executeQuery();
System.out.println("till this working-1");
			while (rs.next())
			{
				tempPlace.setPlaceId(rs.getString(1));
				System.out.println("till this working-2"+"--------"+tempPlace);
			}
			System.out.println("till this working-2.5");
			if (tempPlace.getPlaceId()!=null && tempPlace.getPlaceId().equalsIgnoreCase(place.getPlaceId()))
			{
				placeFound = true;
				placeExist = tempPlace.getPlaceId();
				System.out.println("till this working-3");
			} 
			else
			{
				System.out.println("till this working-4");
				sql = "insert into place (placeId, placeName) values (?, ?)";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, place.getPlaceId());
				pstmt.setString(2, place.getPlaceName());
				pstmt.executeUpdate();
				System.out.println("till this working-5");
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		finally
		{
			if (con != null)
			{
				con.close();
			}
		}
		return placeFound;
	}
	
	
	
}
