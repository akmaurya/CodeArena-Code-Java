package com.xcode.javas.durgasoft._g_collection.mapi.hashtable;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Create Java Hashtable from HashMap example
  This Java Example shows how to copy all key value pairs from HashMap Object to
  Hashtable Object using putAll method of java Hashtable class.
*/

import java.util.*;

public class _3_CreateHashtableFromHashMap {

    public static void main(String[] args) {

        //create HashMap
        HashMap hMap = new HashMap();

        //populate HashMap
        hMap.put("1","One");
        hMap.put("2","Two");
        hMap.put("3","Three");
        System.out.println(hMap);
        //create new Hashtable
        Hashtable ht = new Hashtable();

        //populate Hashtable
        ht.put("1","This value would be REPLACED !!");
        ht.put("4","Four");

        //print values of Hashtable before copy from HashMap
        System.out.println("Hashtable contents before copy");
        System.out.println(ht);
        Enumeration e = ht.elements();
        while(e.hasMoreElements())
            System.out.println(e.nextElement());

    /*
      To copy values from HashMap to Hashtable use
      void putAll(Map m) method of Hashtable class.

      Please note that this method will REPLACE existing mapping of
      a key if any in the Hashtable
    */

        ht.putAll(hMap);

        //display contents of Hashtable
        System.out.println("Hashtable contents after copy");
        System.out.println(ht);
        e = ht.elements();
        while(e.hasMoreElements())
            System.out.println(e.nextElement());

        Collection cll = ht.entrySet();
        Iterator itr1 = cll.iterator();
        while (itr1.hasNext())
        {
            Map.Entry ent = (Map.Entry)itr1.next();
            System.out.println(ent.getKey()+" = "+ent.getValue());
        }
    }
}

/*
Output would be
Hashtable contents before copy
Four
This value would be REPLACED !!
Hashtable contents after copy
Four
Three
Two
One
*/