package com.src.java.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class CustomExceptionExample {
	public static void main(String[] args) throws MyException {
		try {
			processFile("file.txt");
		} catch (MyException e) {
			processErrorCodes(e);
		}

	}

	private static void processErrorCodes(MyException ex) throws MyException {
		if (ex.getErrorCode().equals("BAD_FILE_TYPE")) {
			System.out.println("Bad File Type, notify user");
		} else if (ex.getErrorCode().equals("FILE_NOT_FOUND_EXCEPTION")) {
			System.out.println("File Not Found, notify user");
		} else if (ex.getErrorCode().equals("FILE_CLOSE_EXCEPTION")) {
			System.out.println("File Close failed, just log it.");
		} else {
			System.out.println("Unknown exception occured, lets log it for further debugging." + ex.getMessage());
			ex.printStackTrace();
		}
		throw ex;
	}

	private static void processFile(String file) throws MyException {
		InputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			throw new MyException(e.getMessage(), "FILE_NOT_FOUND_EXCEPTION");
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				throw new MyException(e.getMessage(), "FILE_CLOSE_EXCEPTION");
			}
		}
	}
}
