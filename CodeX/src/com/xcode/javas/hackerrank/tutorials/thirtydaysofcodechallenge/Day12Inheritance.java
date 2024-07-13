package com.xcode.javas.hackerrank.tutorials.thirtydaysofcodechallenge;

import java.util.Scanner;

/**
 * Created by jarvis on 18/10/16.
 */
class Person
{
    protected String firstName;
    protected String lastName;
    protected int idNumber;

    // Constructor
    Person(String firstName, String lastName, int identification){
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = identification;
    }

    // Print person data
    public void printPerson(){
        System.out.println(
                "Name: " + lastName + ", " + firstName
                        + 	"\nID: " + idNumber);
    }
}
class Student extends Person{
    private int[] testScores;
    public Student(String firstName, String lastName, int id, int[] scores)
    {
        super(firstName,lastName,id);
        this.testScores = scores;
    }

    public char calculate()
    {
        char grade = 0;
        int total = 0;
        for (int i = 0; i < testScores.length; i++)
        {
            total = testScores[i]+total;
        }
        int percentage = total/testScores.length;
        if(percentage < 40)
            grade = 'T';
        else if (percentage >= 40 && percentage <55)
            grade = 'D';
        else if (percentage >= 55 && percentage <70)
            grade = 'P';
        else if (percentage >= 70 && percentage <80)
            grade = 'A';
        else if (percentage >= 80 && percentage <90)
            grade = 'E';
        else if (percentage >= 90 && percentage <=100)
            grade = 'O';
        return grade;
    }
}
class Day12Inheritance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstName = scan.next();
        String lastName = scan.next();
        int id = scan.nextInt();
        int numScores = scan.nextInt();
        int[] testScores = new int[numScores];
        for(int i = 0; i < numScores; i++){
            testScores[i] = scan.nextInt();
        }
        scan.close();

        Student s = new Student(firstName, lastName, id, testScores);
        s.printPerson();
        System.out.println("Grade: " + s.calculate() );
    }
}


        /*
            Sample Input

            Heraldo Memelli 8135627
            2
            100 80
            Sample Output

            Name: Memelli, Heraldo
            ID: 8135627
            Grade: O
        */