package com.src.java.java6;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Access {
	@XmlElement
	private User buyer;

	@XmlElement
	private User seller;

	@XmlElement
	private User administrator;

	public User getBuyer() {
		return buyer;
	}

	public User getSeller() {
		return seller;
	}

	public User getAdministrator() {
		return administrator;
	}

	public static class User {
		@XmlElement(name = "page")
		private List<String> pages;

		public List<String> getPages() {
			return pages;
		}
	}
}
