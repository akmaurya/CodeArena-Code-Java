package com.src.java.exception;

public class TestExceptions {
	public static void main(String[] args) {
		try {
			throw new DBExeption.NoData("No row found for id : x");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}