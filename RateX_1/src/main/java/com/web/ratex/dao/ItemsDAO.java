package com.web.ratex.dao;


import java.sql.Date;
import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.web.ratex.model.ItemsVO;

public class ItemsDAO
{
	
	/**
	 * @return
	 */
	public HashMap<String, ItemsVO> getAllItems()
	{
SessionFactory sessionFactroy = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactroy.openSession();
		session.beginTransaction();
		
//		ArrayList<ItemsVO> itemList = new ArrayList<ItemsVO>();
		HashMap<String, ItemsVO> itemsMap = new HashMap<String, ItemsVO>();
		
		for (Object oneObject : session.createQuery("FROM ItemsVO").getResultList()) {
//	        itemList.add((ItemsVO)oneObject);
			ItemsVO tempItem = (ItemsVO)oneObject;
			itemsMap.put(tempItem.getItem_id(), tempItem);
	    } 
		
		return itemsMap;
	}
	
	/**
	 * 
	 */
	public void insertItems()
	{
		SessionFactory sessionFactroy = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactroy.openSession();
		session.beginTransaction();
		
		for(int i = 1; i <= 100; i++)
		{
			ItemsVO item = new ItemsVO();
			item.setItem_id(""+(100+i));
			item.setName("Name-"+(100+i));
			item.setDescription("Description-"+(100+i));
			item.setCreated_on(Date.valueOf("2017-08-18"));
			item.setModified_on(Date.valueOf("2017-08-18"));
			item.setStatus(1);
			System.out.println(item.getName());
			
			session.save(item);
		}
		session.getTransaction().commit();
	}
	
	/**
	 * 
	 */
	public void truncateItems()
	{
		SessionFactory sessionFactroy = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactroy.openSession();
		session.beginTransaction();
	
		session.createQuery("delete from items").executeUpdate();
	    session.close();
	}
}
