package com.xcode.javas.durgasoft._g_collection.collections;

/**
 * Created by jarvis on 7/7/17.
 */
import java.util.*;

public class _10_UnmodifiableCollection {

    public static void main(String args[]) {
        List<String> list = new ArrayList<String>();

        list.add("This");
        list.add("is");
        list.add("Unmodifiable Collection");

        System.out.println("Element added to list: " + list.get(2));

        Collection<String> immutableCol = Collections.unmodifiableCollection(list);

        Iterator<String> iterator = immutableCol.iterator();

        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

        ListIterator litr = list.listIterator();
        while (litr.hasNext())
        {
            if (litr.next().equals("is"))
                litr.set("are");
        }

        System.out.println(list);
    }
}