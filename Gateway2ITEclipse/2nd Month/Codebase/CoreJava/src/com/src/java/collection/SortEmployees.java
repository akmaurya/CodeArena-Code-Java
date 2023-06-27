package com.src.java.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class SortEmployees {
	public static void main(String[] args) {
		List<Employee> list = new ArrayList<Employee>();
        list.add(new Employee("Ram",6000));
        list.add(new Employee("John",3000));
        list.add(new Employee("Crish",1000));
        list.add(new Employee("Tom",500));
        Collections.sort(list);
        System.out.println("Sorted Array list entries: ");
        for(Employee e:list){
            System.out.println(e.toString());
        }
		
		list = new LinkedList<Employee>();
        list.add(new Employee("Ram",3000));
        list.add(new Employee("John",6000));
        list.add(new Employee("Crish",2000));
        list.add(new Employee("Tom",2400));
        Collections.sort(list);
        System.out.println("\nSorted Linked list entries: ");
        for(Employee e:list){
            System.out.println(e);
        }
        
        list = new Vector<Employee>();
        list.add(new Employee("Ram",3000));
        list.add(new Employee("John",6000));
        list.add(new Employee("Crish",2000));
        list.add(new Employee("Tom",2400));
        Collections.sort(list);
        System.out.println("\nSorted Vector entries: ");
        for(Employee e:list){
            System.out.println(e.toString());
        }
	}
}
