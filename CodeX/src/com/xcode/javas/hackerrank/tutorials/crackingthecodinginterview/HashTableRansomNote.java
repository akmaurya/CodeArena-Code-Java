package com.xcode.javas.hackerrank.tutorials.crackingthecodinginterview;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by jarvis on 27/10/16.
 */
public class HashTableRansomNote
{
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;

    public HashTableRansomNote(String magazine, String note)
    {
        magazineMap = new HashMap<>();
        noteMap = new HashMap<>();
        String magzWords[] = magazine.split(" ");
        String noteWords[] = note.split(" ");

        for (int i = 0; i < magzWords.length; i++)
        {
            if (magazineMap.containsKey(magzWords[i]))
                magazineMap.replace(magzWords[i], magazineMap.get(magzWords[i])+1);
            else
                magazineMap.put(magzWords[i], 1);
        }

        for (int i = 0; i < noteWords.length; i++)
        {
            if (noteMap.containsKey(noteWords[i]))
                noteMap.replace(noteWords[i], noteMap.get(noteWords[i])+1);
            else
                noteMap.put(noteWords[i], 1);
        }
        for (String key: magazineMap.keySet())
        {
            System.out.println("  "+key+"--"+magazineMap.get(key));
        }
        for (String key: noteMap.keySet())
        {
            System.out.println("  "+key+"--"+noteMap.get(key));
        }
    }

    public boolean solve()
    {
        for (String key: noteMap.keySet())
        {
            if (!magazineMap.containsKey(key) || magazineMap.get(key) < noteMap.get(key) )
            {
                System.out.println("Mag--"+key+" - "+magazineMap.get(key));
                System.out.println("Not--"+key+" - "+noteMap.get(key));
                return false;

            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // Eat whitespace to beginning of next line
        scanner.nextLine();

        HashTableRansomNote s = new HashTableRansomNote(scanner.nextLine(), scanner.nextLine());
        scanner.close();

        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
    }
}


        /*
            Sample Input

            6 4
            give me one grand today night
            give one grand today
            Sample Output

            Yes
        */