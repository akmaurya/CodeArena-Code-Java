package com.src.java.cloning.deep;

public class SerializeDeepClone {
	public static void main(String[] args) throws Exception {
		// Create instance of serializable object
		SerializableClass original = new SerializableClass("Lokesh", "Gupta");
		

		// Now create a deep copy of it
		SerializableClass deepCopiedInstance = original.deepCopy();
		deepCopiedInstance.setFirstName("Amit");
		deepCopiedInstance.setLastName("GPS");
		
		// Verify the content
		System.out.println(original);
		// Again verify the content
		System.out.println(deepCopiedInstance);
	}
}
