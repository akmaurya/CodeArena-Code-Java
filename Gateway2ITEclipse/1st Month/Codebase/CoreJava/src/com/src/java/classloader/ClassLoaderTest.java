package com.src.java.classloader;

public class ClassLoaderTest {
	public static void main(String args[]) {
		try {
			// printing ClassLoader of this class
			System.out.println("ClassLoaderTest.getClass().getClassLoader() : "
					+ ClassLoaderTest.class.getClassLoader());

			Class.forName("com.src.java.classloader.TestClient", true, ClassLoaderTest.class.getClassLoader());
			System.out.println("Class [com.src.java.classloader.TestClient] loaded successfully");
		} catch (ClassNotFoundException ex) {
			System.out.println("Exception raised to load class - " + ClassLoaderTest.class.getName() + ex);
		}
	}
}
