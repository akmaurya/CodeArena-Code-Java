package com.web.ratex.utility;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.web.ratex.model.ItemsVO;

import net.sf.json.JSONObject;

public class ConvertObject
{
	public JSONObject[] toJson(Map<String, ItemsVO> itemsMap)
	{
		JSONObject[] jsonItem = new JSONObject[itemsMap.size()];
	
		int i = 0;
		Set<String> itemsKeySet = (Set<String>) itemsMap.keySet();
		Iterator<String> itr = itemsKeySet.iterator();
		while (itr.hasNext())
		{
			ItemsVO tempItem = (ItemsVO) itemsMap.get(itr.next());
			jsonItem[i] = new JSONObject();
			jsonItem[i].put("item_id", tempItem.getItem_id());
			jsonItem[i].put("name", tempItem.getName());
			jsonItem[i].put("description", tempItem.getDescription());
			jsonItem[i].put("created_on", "" + tempItem.getCreated_on());
			jsonItem[i].put("modified_on", "" + tempItem.getModified_on());
			jsonItem[i].put("status", "" + tempItem.getStatus());
			i++;
		}

		
		return jsonItem;
	}
}
