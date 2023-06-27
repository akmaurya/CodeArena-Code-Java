package com.web.ratex.controller;

import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.ratex.dao.ItemsDAO;
import com.web.ratex.model.ItemsVO;
import com.web.ratex.utility.ConvertObject;

import net.sf.json.JSONObject;

/*
 * Servlet implementation class HomeController
 */

@Component
@RequestMapping(value = "/home")
public class HomeController
{

	@Autowired
	ServletContext context;
	private Logger logger;

	@RequestMapping(method = RequestMethod.GET)
	public final ModelAndView home()
	{

		ModelAndView model = new ModelAndView("home");

		System.out.println("HomeController called...");

		logger = Logger.getLogger(HomeController.class);
		logger.info("HomeController Called.");
		/*
		 * InsertItemsDAO insert = new InsertItemsDAO();
		 * insert.insertIntoItems();
		 */

		/*
		 * TruncateItemsTableDAO tit = new TruncateItemsTableDAO();
		 * tit.truncateItemTable();
		 */

		if (context.getAttribute("allItemsMap") == null)
		{
			System.out.print("Working well");
			ItemsDAO itemsDAO = new ItemsDAO();
			Map<String, ItemsVO> itemsMap = itemsDAO.getAllItems();

			ConvertObject convertObject = new ConvertObject();
			JSONObject mainObj = new JSONObject();
			mainObj.put("items", convertObject.toJson(itemsMap));

			System.out.println(mainObj);

			context.setAttribute("allItemsMap", itemsMap);
			context.setAttribute("objkey", mainObj);

		}
		model.addObject("allItemsMap", context.getAttribute("allItemsMap"));
		model.addObject("objkey", context.getAttribute("mainObj"));
		return model;
	}

}
