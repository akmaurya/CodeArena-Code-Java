package com.xcode.javas.durgasoft._a_fundamental;

//import com.sun.org.apache.xpath.internal.SourceTree;

public class _2_Enum
{
    enum days {SUNDAY(1), MONDAY(2), TUESDAY(3), WEDNESDAY(4), THURSDAY(5), FRIDAY(6), SATURDAY(7);
        private int dayNo;

        days(int dayNo)
        {
            this.dayNo = dayNo;
        }

        public int getDayNo()
        {
            return dayNo;
        }
    }
    enum color {RED, GREEN, BLUE}
    public static void main(String[] args)
    {
        System.out.println(color.BLUE);
        System.out.println(days.SUNDAY);
        System.out.println(days.SUNDAY.getDayNo());
    }
}
