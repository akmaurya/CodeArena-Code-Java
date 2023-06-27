package com.src.java.students;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class ExceptionLogging {

	public ExceptionLogging() {
	}

	public static void main(String[] args) {
		
		Logger logger = Logger.getLogger("ExceptionLogging");

		try {
			throw new Exception("Shiiiiiit");
		} catch(Exception e) {
			StringWriter trace = new StringWriter();
			e.printStackTrace(new PrintWriter(trace));
			logger.severe(trace.toString());
		}
	}

}
