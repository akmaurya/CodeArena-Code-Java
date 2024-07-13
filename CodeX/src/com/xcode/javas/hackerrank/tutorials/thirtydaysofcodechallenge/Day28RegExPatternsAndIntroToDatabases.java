package com.xcode.javas.hackerrank.tutorials.thirtydaysofcodechallenge;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jarvis on 25/10/16.
 */
class Day28RegExPatternsAndIntroToDatabases
{
    static final String EMAIL_REGEX = ".*@gmail.com$";

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        Email[] emails = new Email[N];
        for (int i = 0; i < N; i++)
        {
            String firstName = input.next();
            String emailId = input.next();
            emails[i] = new Email(firstName, emailId);
        }

        Arrays.stream(emails).filter(email -> email.emailId.matches(EMAIL_REGEX))
                .sorted((email1, email2) -> email1.firstName.compareTo(email2.firstName))
                .forEach(email -> System.out.println(email.firstName));
    }
}

class Email {
    String firstName;
    String emailId;

    Email(String firstName, String emailId) {
        this.firstName = firstName;
        this.emailId = emailId;
    }
}


        /*
            Sample Input

            6
            riya riya@gmail.com
            julia julia@julia.me
            julia sjulia@gmail.com
            julia julia@gmail.com
            samantha samantha@gmail.com
            tanya tanya@gmail.com
            Sample Output

            julia
            julia
            riya
            samantha
            tanya
        */