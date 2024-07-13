package com.xcode.javas.preparation.general;

public class LongestPalindrome
{
    public static void main(String[] args)
    {
        String str = "abaaba";
        int next;
        int previous;
        int count;
        int max = 0;
        int index=0;
        for(int i=0;i<str.length();i++){
            next = previous = i;
            count = 1;
            while(next<str.length() && previous>=0){
                if(str.charAt(next++)==str.charAt(previous--)){
                    count++;
                }
                else break;
            }
            System.out.println(str.substring(i-count+2, i+count-1)+"---------"+count);
            if(max<count)
            {
                max = count;
                index = i;
            }
            //arr[i] = getMaxPalindrome(str,i);

        }
        System.out.println(str.length());
        System.out.println(max);
        System.out.println(index);
        System.out.println(str.substring(index-max+2, index+max-1));
    }
}
