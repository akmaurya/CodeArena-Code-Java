package com.xcode.javas.durgasoft.digging.employee;

import java.util.*;

public class EmployeeOperations
{
    static private Set employeeBox = new HashSet<EmployeeBean>();
    public static void main(String[] args)
    {
        EmployeeBean eb1 = new EmployeeBean("Arvind", (byte)23, "Gurgaon", "arvind@gmail.com");
        EmployeeBean eb2 = new EmployeeBean("Arvind", (byte)23, "Gurgaon", "arvind@gmail.com");
        EmployeeBean eb3 = new EmployeeBean("Rajat", (byte)23, "Gurgaon", "arvind@gmail.com");
        EmployeeBean eb4 = new EmployeeBean("Sanjay", (byte)23, "Gurgaon", "arvind@gmail.com");
        EmployeeBean eb5 = new EmployeeBean("Arvind", (byte)23, "Gurgaon", "arvind@gmail.com");
        //List employeeSet = new ArrayList<EmployeeBean>();
        System.out.println(addEmployee(eb1));
        System.out.println(addEmployee(eb2));
        System.out.println(addEmployee(eb3));
        System.out.println(addEmployee(eb4));
        System.out.println(addEmployee(eb5));

        System.out.println(eb1.hashCode());
        System.out.println(eb2.hashCode());
        System.out.println(eb3.hashCode());
        System.out.println(eb4.hashCode());
        System.out.println(eb5.hashCode());
        System.out.println(employeeBox.size());
        System.out.println(employeeBox);
        //Collections.sort(employeeBox);
        System.out.println(employeeBox);

        System.out.println(getEmployee("Rahul"));
    }

    public static boolean addEmployee(EmployeeBean eb){
        return employeeBox.add(eb);
    }

    public static Object getEmployee(String name){
        Iterator itr = employeeBox.iterator();
        while (itr.hasNext()){
            EmployeeBean eb = (EmployeeBean) itr.next();
            if(eb.getName().equals(name)){
                return eb;
            }
        }
        return false;
    }
}
