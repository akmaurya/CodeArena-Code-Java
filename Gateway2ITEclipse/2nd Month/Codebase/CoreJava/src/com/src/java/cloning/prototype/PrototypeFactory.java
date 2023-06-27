package com.src.java.cloning.prototype;

import java.util.Map;

/**
 * We need a single Instance of this factory class through out my application,
 * then in that case we design this class as per Singleton Design pattern
 * 
 * @author GPS
 * 
 */
public final class PrototypeFactory {

	private static final PrototypeFactory prototypeFactory = new PrototypeFactory();

	public static class ModelType {
		public static final String MOVIE = "movie";
		public static final String ALBUM = "album";
		public static final String SHOW = "show";
	}

	private static Map<String, PrototypeCapable> prototypes = new java.util.HashMap<String, PrototypeCapable>();

	// Construct Object only once & use it as template
	static {
		prototypes.put(ModelType.MOVIE, new Movie());
		prototypes.put(ModelType.ALBUM, new Album());
		prototypes.put(ModelType.SHOW, new Show());
	}

	public static PrototypeCapable getInstance(final String s) throws CloneNotSupportedException {
		return ((PrototypeCapable) prototypes.get(s)).clone();
	}

	/**
	 * Return instance of PrototypeFactory
	 * 
	 * @return
	 */
	public static PrototypeFactory getInstance() {
		System.out.println("Returning already created instance of PrototypeFactory...");
		return prototypeFactory;
	}

	// Private constructor
	private PrototypeFactory() {
		System.out.println("PrototypeFactory new Instance get created...");
	}
}
