package com.xcode.javas.rough.oracle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by jarvis on 1/1/17.
 */
class Person
{
    private String surName;
    public Person(String name)
    {
        surName = name;
    }


    public String getSurName()
    {
        return surName;
    }

    public void printName()
    {
        System.out.println(surName);
    }
}

class LambdaExample_2 {

           public static void main(String[] args) {

             List<Person> personList = new ArrayList();
               personList.add(new Person("A"));
               personList.add(new Person("K"));
               personList.add(new Person("I"));
               personList.add(new Person("C"));

             // Sort with Inner Class
             Collections.sort(personList, new Comparator<Person>(){
       public int compare(Person p1, Person p2){
                         return p1.getSurName().compareTo(p2.getSurName());
                       }
     });

            System.out.println("=== Sorted Asc SurName ===");
             for(Person p:personList){
                  p.printName();
                 }

             // Use Lambda instead

             // Print Asc
             System.out.println("=== Sorted Asc SurName Using Lambda===");
             Collections.sort(personList, (Person p1, Person p2) -> p1.getSurName().compareTo(p2.getSurName()));

             for(Person p:personList){
                   p.printName();
                 }

             // Print Desc
             System.out.println("=== Sorted Desc SurName Using Lambda===");
             Collections.sort(personList, (p1,  p2) -> p2.getSurName().compareTo(p1.getSurName()));

             for(Person p:personList){
                   p.printName();
                 }

           }
 }