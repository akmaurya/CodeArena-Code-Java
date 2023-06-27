package com.web.ratex.controller;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.ratex.model.ItemsVO;



/**
 * Servlet implementation class MoreController
 */
@Controller
public class MoreController{

	@Autowired
	ServletContext context;
	@Autowired
	HttpServletRequest request;
	private Logger logger;

	static {
		System.out.println("Working static block of Home Controller");
	}
	@RequestMapping("/more")
	public final ModelAndView more() {
		
		ModelAndView model = new ModelAndView("more");
		
		System.out.println("HomeController called...");

		logger = Logger.getLogger(MoreController.class);
		logger.debug("More Controller called...");
		
		System.out.println("Context object value in MoreController---------- "+context);
		
		HashMap<String, ItemsVO> allItemsMap = (HashMap<String, ItemsVO>)context.getAttribute("allItemsMap");
	
		System.out.println(">>>>>>>>>>>>"+allItemsMap);
		System.out.println("|||||||||"+request.getParameter("item_id"));
    	ItemsVO item = (ItemsVO)allItemsMap.get(request.getParameter("item_id"));
    	
        System.out.println(item);
       
        model.addObject("item", item);
        request.setAttribute("item", item);
        
		
        return model;
	}
}