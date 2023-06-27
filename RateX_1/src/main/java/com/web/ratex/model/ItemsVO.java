package com.web.ratex.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class ItemsVO
{
	@Id
	private String item_id;
	private String name;
	private String description;
	private Date created_on;
	private Date modified_on;
	private int status;
	
	
	
	public String getItem_id()
	{
		return item_id;
	}
	public void setItem_id(String item_id)
	{
		this.item_id = item_id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public Date getCreated_on()
	{
		return created_on;
	}
	public void setCreated_on(Date created_on)
	{
		this.created_on = created_on;
	}
	public Date getModified_on()
	{
		return modified_on;
	}
	public void setModified_on(Date modified_on)
	{
		this.modified_on = modified_on;
	}
	public int getStatus()
	{
		return status;
	}
	public void setStatus(int status)
	{
		this.status = status;
	}
	
	@Override
	public String toString()
	{
		//String str = "\n{\n\tItem ID = "+item_id+"\n\t"+"Name = "+name+"\n\t"+"Description = "+description+"\n\t"+"Created On = "+created_on+"\n\t"+"Modified On = "+modified_on+"\n\t"+"Status = "+status+"\n}";
		String str = "{Item ID = "+item_id+"Name = "+name+"Description = "+description+"Created On = "+created_on+"Modified On = "+modified_on+"Status = "+status+"}";
		return str;
	}
}
