package com.xcode.javas.myproject.whatsappplay;

import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException, InterruptedException
    {

        /*String str = "This is a simple text for test the length splitter for the longest word text.";
        System.out.println(str.length());
        System.out.println(str);
        System.out.println("123456789123456789123456789");
        System.out.println(getFormatedString(str,false));
        System.exit(0);*/

        File file = new File("C:\\Users\\Jarvis\\Desktop\\WhatsApp1.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        String me = "Arvind Kumar Maurya"+": ";
        String other = "Giraja Shankar \\(Home\\)"+": ";

        while ((st = br.readLine()) != null){
            String first[] = st.split(me);
            String second[] = st.split(other);
            if(first.length==2)
            {
                System.out.print(getFormatedString(first[1],true));
            }
            if(second.length==2)
            {
                System.out.print(getFormatedString(second[1],false));
            }
        }

    }

    private static String getFormatedString(String input, boolean tab)
    {
        String finalString = "";
        String[] splittedWord = input.split(" ");
        String insertTab = tab?"\t\t\t\t\t\t\t":"";

        int carpetLength = 25;
        for(int i=0;i<splittedWord.length;i++){
            if(splittedWord[i].length()>carpetLength){

            }else if (splittedWord[i].length()<=carpetLength){
                int count = 0;
                while (count<carpetLength && i<splittedWord.length){
                    count = count+splittedWord[i].length()+1;
                    if(count<carpetLength){
                        finalString = finalString +splittedWord[i]+" ";
                        i++;
                    }
                }
                i--;

                if(i==splittedWord.length-1)
                    finalString = finalString+"\n";
                else
                    finalString = finalString+"\n"+insertTab;
            }
        }


        return insertTab+finalString;
    }
}

/*
for(int i=0;i<splittedWord.length;i++){
        if(splittedWord[i].length()>carpetLength){

        }else if (splittedWord[i].length()<=carpetLength){
        int count = 0;
        while (count<carpetLength && i<splittedWord.length){
        finalString = finalString +splittedWord[i]+" ";
        count = count+splittedWord[i].length();
        i++;
        }
        i--;

        if(i==splittedWord.length-1)
        finalString = finalString+"\n";
        else
        finalString = finalString+"\n"+insertTab;
        }
        }*/
