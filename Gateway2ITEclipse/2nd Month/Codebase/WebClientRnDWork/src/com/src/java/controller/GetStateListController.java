package com.src.java.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@SuppressWarnings("serial")
@WebServlet(name = "SignUpController", urlPatterns = "/stateList.asp")
public class GetStateListController extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doPost(req, res);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String country = request.getParameter("countryname");
		Map<String, String> ind = new LinkedHashMap<String, String>();
		ind.put("1", "New delhi");
		ind.put("2", "Tamil Nadu");
		ind.put("3", "Kerala");
		ind.put("4", "Andhra Pradesh");

		Map<String, String> us = new LinkedHashMap<String, String>();
		us.put("1", "Washington");
		us.put("2", "California");
		us.put("3", "Florida");
		us.put("4", "New York");
		String json = null;
		if (country.equals("India")) {
			json = new Gson().toJson(ind);
		} else if (country.equals("US")) {
			json = new Gson().toJson(us);
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
		System.out.println(json);
	}
}
