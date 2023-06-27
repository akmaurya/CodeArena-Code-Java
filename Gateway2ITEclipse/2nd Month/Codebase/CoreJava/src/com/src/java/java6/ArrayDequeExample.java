package com.src.java.java6;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class ArrayDequeExample {
public static void main(String... args){
		
		Deque<String> deque= new ArrayDeque<String>();
		deque.add("A");
		deque.add("B");
		deque.add("C");
		
		//offerFirst-adds elements at the front of the ArrayDeque 
		deque.offerFirst("D");
		
		//offerLast inserts the element at the last of ArrayDeque 
		deque.offerLast("E");
		
		Iterator<String> itr= deque.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
	}
}
