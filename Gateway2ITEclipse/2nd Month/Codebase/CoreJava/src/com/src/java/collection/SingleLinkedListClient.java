package com.src.java.collection;

public class SingleLinkedListClient {
	public static void main(String a[]) {
		SinglyLinkedListImpl<Integer> sl = new SinglyLinkedListImpl<Integer>();
		sl.add(3);
		sl.add(32);
		sl.add(54);
		sl.add(89);
		sl.addAfter(76, 54);
		sl.traverse();
		sl.deleteFront();
		sl.deleteAfter(76);
		sl.traverse();

		System.out.println("\nString Operation...");
		SinglyLinkedListImpl<String> s2 = new SinglyLinkedListImpl<String>();
		s2.add("amit");
		s2.add("sumit");
		s2.add("amit1");
		s2.add("sumit1");
		s2.addAfter("amit0", "amit1");
		s2.traverse();
		s2.deleteFront();
		s2.deleteAfter("amit0");
		s2.traverse();
	}
}
