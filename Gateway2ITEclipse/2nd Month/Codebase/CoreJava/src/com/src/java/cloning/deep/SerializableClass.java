package com.src.java.cloning.deep;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SerializableClass implements Serializable {

	private static final long serialVersionUID = 1L;

	private String firstName = null;
	private String lastName = null;

	@SuppressWarnings("serial")
	private List<String> permissions = new ArrayList<String>() {
		{
			add("ADMIN");
			add("USER");
		}
	};

	public SerializableClass(final String fName, final String lName) {
		this.firstName = fName;
		this.lastName = lName;
	}

	public SerializableClass deepCopy() throws Exception {
		// Serialization of object
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(bos);
		out.writeObject(this);
		System.out.println(this.getFirstName() + "----" + this.getLastName() + "----" + permissions.get(0) + "----"
				+ permissions.get(1));

		// De-serialization of object
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream in = new ObjectInputStream(bis);
		SerializableClass copied = (SerializableClass) in.readObject();

		System.out.println(copied.getFirstName() + "----" + copied.getLastName() + "----" + permissions.get(0) + "----"
				+ permissions.get(1));

		return copied;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return new StringBuilder().append(getFirstName() + ",").append(getLastName() + ",").append(permissions)
				.toString();
	}

}
