package com.src.java.java6;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaScriptRunner {
	public static void main(String[] args) {
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");

		// Now we have a script engine instance that can execute some Java
		// script
		try {
			engine.eval("print('Hello')");
		} catch (ScriptException ex) {
			ex.printStackTrace();
		}
	}
}
