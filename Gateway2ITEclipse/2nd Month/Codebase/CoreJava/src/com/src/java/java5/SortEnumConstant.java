package com.src.java.java5;

import java.util.Arrays;
import java.util.Collections;

public class SortEnumConstant {
	public static void main(String[] args) {
		Collections.sort(Arrays.asList(Day.values()));
		for (Day day : Day.values()) {
			System.out.println(day);
		}
	}
}
