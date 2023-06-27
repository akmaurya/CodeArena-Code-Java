/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calender;

import java.util.Calendar;

/**
 *
 * @author Arvind
 */
public final class Calender extends javax.swing.JFrame {

    /**
     * Creates new form Calender
     */
    int Month=0,Year=0,days=0,tempYear,i,leap;
    String MonthName[]={"January","February","March","April","May","June","July","August","September","October","November","December"};
    
    
    public void fillDate()
    {
        jButton8.setVisible(false);
        jButton9.setVisible(false);
        jButton10.setVisible(false);
        jButton11.setVisible(false);
        jButton12.setVisible(false);
        jButton13.setVisible(false);
        jButton14.setVisible(false);
        jButton15.setVisible(false);
        jButton16.setVisible(false);
        jButton17.setVisible(false);
        jButton18.setVisible(false);
        jButton19.setVisible(false);
        jButton20.setVisible(false);
        jButton21.setVisible(false);
        jButton22.setVisible(false);
        jButton23.setVisible(false);
        jButton24.setVisible(false);
        jButton25.setVisible(false);
        jButton26.setVisible(false);
        jButton27.setVisible(false);
        jButton28.setVisible(false);
        jButton29.setVisible(false); 
        jButton30.setVisible(false);
        jButton31.setVisible(false);
        jButton32.setVisible(false);
        jButton33.setVisible(false);
        jButton34.setVisible(false);
        jButton35.setVisible(false);
        jButton36.setVisible(false);
        jButton37.setVisible(false);
        jButton38.setVisible(false);
        jButton39.setVisible(false);
        jButton40.setVisible(false);
        jButton41.setVisible(false);
        jButton42.setVisible(false);
        jButton43.setVisible(false);
        jButton44.setVisible(false);
        
        
        jButton8.setText("");
        jButton9.setText("");
        jButton10.setText("");
        jButton11.setText("");
        jButton12.setText("");
        jButton13.setText("");
        jButton14.setText("");
        jButton15.setText("");
        jButton16.setText("");
        jButton17.setText("");
        jButton18.setText("");
        jButton19.setText("");
        jButton20.setText("");
        jButton21.setText("");
        jButton22.setText("");
        jButton23.setText("");
        jButton24.setText("");
        jButton25.setText("");
        jButton26.setText("");
        jButton27.setText("");
        jButton28.setText("");
        jButton29.setText("");
        jButton30.setText("");
        jButton31.setText("");
        jButton32.setText("");
        jButton33.setText("");
        jButton34.setText("");
        jButton35.setText("");
        jButton36.setText("");
        jButton37.setText("");
        jButton38.setText("");
        jButton39.setText("");
        jButton40.setText("");
        jButton41.setText("");
        jButton42.setText("");
        jButton43.setText("");
        jButton44.setText("");
        
        String tempM;
        tempM=jButton6.getText();
        int tempY=Integer.parseInt(jButton7.getText());
        
        switch(days)
        {
            case 0:
                    jButton8.setVisible(true);
                    jButton9.setVisible(true);
                    jButton10.setVisible(true);
                    jButton11.setVisible(true);
                    jButton12.setVisible(true);
                    jButton13.setVisible(true);
                    jButton14.setVisible(true);
                    jButton15.setVisible(true);
                    jButton16.setVisible(true);
                    jButton17.setVisible(true);
                    jButton18.setVisible(true);
                    jButton19.setVisible(true);
                    jButton20.setVisible(true);
                    jButton21.setVisible(true);
                    jButton22.setVisible(true);
                    jButton23.setVisible(true);
                    jButton24.setVisible(true);
                    jButton25.setVisible(true);
                    jButton26.setVisible(true);
                    jButton27.setVisible(true);
                    jButton28.setVisible(true);
                    jButton29.setVisible(true); 
                    jButton30.setVisible(true);
                    jButton31.setVisible(true);
                    jButton32.setVisible(true);
                    jButton33.setVisible(true);
                    jButton34.setVisible(true);
                    jButton35.setVisible(true);
                    
                    
                    
                    jButton8.setText("1");
                    jButton9.setText("2");
                    jButton10.setText("3");
                    jButton11.setText("4");
                    jButton12.setText("5");
                    jButton13.setText("6");
                    jButton14.setText("7");
                    jButton15.setText("8");
                    jButton16.setText("9");
                    jButton17.setText("10");
                    jButton18.setText("11");
                    jButton19.setText("12");
                    jButton20.setText("13");
                    jButton21.setText("14");
                    jButton22.setText("15");
                    jButton23.setText("16");
                    jButton24.setText("17");
                    jButton25.setText("18");
                    jButton26.setText("19");
                    jButton27.setText("20");
                    jButton28.setText("21");
                    jButton29.setText("22");
                    jButton30.setText("23");
                    jButton31.setText("24");
                    jButton32.setText("25");
                    jButton33.setText("26");
                    jButton34.setText("27");
                    jButton35.setText("28");
                    
                    
                    if(tempM.equals("January")||tempM.equals("March")||tempM.equals("May")||tempM.equals("July")||tempM.equals("August")||tempM.equals("October")||tempM.equals("December"))
                    {
                        jButton36.setVisible(true);
                        jButton37.setVisible(true);
                        jButton38.setVisible(true);
                        jButton36.setText("29");
                        jButton37.setText("30");
                        jButton38.setText("31");
                        
                    }
                    else if(tempM.equals("April")||tempM.equals("June")||tempM.equals("September")||tempM.equals("November"))
                    {
                        jButton36.setVisible(true);
                        jButton37.setVisible(true);
                        
                        jButton36.setText("29");
                        jButton37.setText("30");
                    }
                    else if(tempM.equals("February")&&(tempY%4==0&&tempY%100!=0||tempY%400==0))
                    {
                        jButton36.setVisible(true);
                        
                        jButton36.setText("29");
                    }
            break;
            case 1:
                    jButton9.setVisible(true);
                    jButton10.setVisible(true);
                    jButton11.setVisible(true);
                    jButton12.setVisible(true);
                    jButton13.setVisible(true);
                    jButton14.setVisible(true);
                    jButton15.setVisible(true);
                    jButton16.setVisible(true);
                    jButton17.setVisible(true);
                    jButton18.setVisible(true);
                    jButton19.setVisible(true);
                    jButton20.setVisible(true);
                    jButton21.setVisible(true);
                    jButton22.setVisible(true);
                    jButton23.setVisible(true);
                    jButton24.setVisible(true);
                    jButton25.setVisible(true);
                    jButton26.setVisible(true);
                    jButton27.setVisible(true);
                    jButton28.setVisible(true);
                    jButton29.setVisible(true); 
                    jButton30.setVisible(true);
                    jButton31.setVisible(true);
                    jButton32.setVisible(true);
                    jButton33.setVisible(true);
                    jButton34.setVisible(true);
                    jButton35.setVisible(true);
                    jButton36.setVisible(true);
                    
                    
                    
                    jButton9.setText("1");
                    jButton10.setText("2");
                    jButton11.setText("3");
                    jButton12.setText("4");
                    jButton13.setText("5");
                    jButton14.setText("6");
                    jButton15.setText("7");
                    jButton16.setText("8");
                    jButton17.setText("9");
                    jButton18.setText("10");
                    jButton19.setText("11");
                    jButton20.setText("12");
                    jButton21.setText("13");
                    jButton22.setText("14");
                    jButton23.setText("15");
                    jButton24.setText("16");
                    jButton25.setText("17");
                    jButton26.setText("18");
                    jButton27.setText("19");
                    jButton28.setText("20");
                    jButton29.setText("21");
                    jButton30.setText("22");
                    jButton31.setText("23");
                    jButton32.setText("24");
                    jButton33.setText("25");
                    jButton34.setText("26");
                    jButton35.setText("27");
                    jButton36.setText("28");
                   
                    
                    if(tempM.equals("January")||tempM.equals("March")||tempM.equals("May")||tempM.equals("July")||tempM.equals("August")||tempM.equals("October")||tempM.equals("December"))
                    {
                        jButton37.setVisible(true);
                        jButton38.setVisible(true);
                        jButton39.setVisible(true);
                        jButton37.setText("29");
                        jButton38.setText("30");
                        jButton39.setText("31");
                        
                    }
                    else if(tempM.equals("April")||tempM.equals("June")||tempM.equals("September")||tempM.equals("November"))
                    {
                        jButton37.setVisible(true);
                        jButton38.setVisible(true);
                        
                        jButton37.setText("29");
                        jButton38.setText("30");
                    }
                    else if(tempM.equals("February")&&(tempY%4==0&&tempY%100!=0||tempY%400==0))
                    {
                        jButton37.setVisible(true);
                        
                        jButton37.setText("29");
                    }
            break;
            
            case 2:
                    jButton10.setVisible(true);
                    jButton11.setVisible(true);
                    jButton12.setVisible(true);
                    jButton13.setVisible(true);
                    jButton14.setVisible(true);
                    jButton15.setVisible(true);
                    jButton16.setVisible(true);
                    jButton17.setVisible(true);
                    jButton18.setVisible(true);
                    jButton19.setVisible(true);
                    jButton20.setVisible(true);
                    jButton21.setVisible(true);
                    jButton22.setVisible(true);
                    jButton23.setVisible(true);
                    jButton24.setVisible(true);
                    jButton25.setVisible(true);
                    jButton26.setVisible(true);
                    jButton27.setVisible(true);
                    jButton28.setVisible(true);
                    jButton29.setVisible(true); 
                    jButton30.setVisible(true);
                    jButton31.setVisible(true);
                    jButton32.setVisible(true);
                    jButton33.setVisible(true);
                    jButton34.setVisible(true);
                    jButton35.setVisible(true);
                    jButton36.setVisible(true);
                    jButton37.setVisible(true);
                    
                    
                    
                    jButton10.setText("1");
                    jButton11.setText("2");
                    jButton12.setText("3");
                    jButton13.setText("4");
                    jButton14.setText("5");
                    jButton15.setText("6");
                    jButton16.setText("7");
                    jButton17.setText("8");
                    jButton18.setText("9");
                    jButton19.setText("10");
                    jButton20.setText("11");
                    jButton21.setText("12");
                    jButton22.setText("13");
                    jButton23.setText("14");
                    jButton24.setText("15");
                    jButton25.setText("16");
                    jButton26.setText("17");
                    jButton27.setText("18");
                    jButton28.setText("19");
                    jButton29.setText("20");
                    jButton30.setText("21");
                    jButton31.setText("22");
                    jButton32.setText("23");
                    jButton33.setText("24");
                    jButton34.setText("25");
                    jButton35.setText("26");
                    jButton36.setText("27");
                    jButton37.setText("28");
                  
                    
                    if(tempM.equals("January")||tempM.equals("March")||tempM.equals("May")||tempM.equals("July")||tempM.equals("August")||tempM.equals("October")||tempM.equals("December"))
                    {
                        jButton38.setVisible(true);
                        jButton39.setVisible(true);
                        jButton40.setVisible(true);
                        jButton38.setText("29");
                        jButton39.setText("30");
                        jButton40.setText("31");
                        
                    }
                    else if(tempM.equals("April")||tempM.equals("June")||tempM.equals("September")||tempM.equals("November"))
                    {
                        jButton38.setVisible(true);
                        jButton39.setVisible(true);
                        
                        jButton38.setText("29");
                        jButton39.setText("30");
                    }
                    else if(tempM.equals("February")&&(tempY%4==0&&tempY%100!=0||tempY%400==0))
                    {
                        jButton38.setVisible(true);
                        
                        jButton38.setText("29");
                    }
            break;
            
            case 3:
                    jButton11.setVisible(true);
                    jButton12.setVisible(true);
                    jButton13.setVisible(true);
                    jButton14.setVisible(true);
                    jButton15.setVisible(true);
                    jButton16.setVisible(true);
                    jButton17.setVisible(true);
                    jButton18.setVisible(true);
                    jButton19.setVisible(true);
                    jButton20.setVisible(true);
                    jButton21.setVisible(true);
                    jButton22.setVisible(true);
                    jButton23.setVisible(true);
                    jButton24.setVisible(true);
                    jButton25.setVisible(true);
                    jButton26.setVisible(true);
                    jButton27.setVisible(true);
                    jButton28.setVisible(true);
                    jButton29.setVisible(true); 
                    jButton30.setVisible(true);
                    jButton31.setVisible(true);
                    jButton32.setVisible(true);
                    jButton33.setVisible(true);
                    jButton34.setVisible(true);
                    jButton35.setVisible(true);
                    jButton36.setVisible(true);
                    jButton37.setVisible(true);
                    jButton38.setVisible(true);
                    
                    
                    
                    jButton11.setText("1");
                    jButton12.setText("2");
                    jButton13.setText("3");
                    jButton14.setText("4");
                    jButton15.setText("5");
                    jButton16.setText("6");
                    jButton17.setText("7");
                    jButton18.setText("8");
                    jButton19.setText("9");
                    jButton20.setText("10");
                    jButton21.setText("11");
                    jButton22.setText("12");
                    jButton23.setText("13");
                    jButton24.setText("14");
                    jButton25.setText("15");
                    jButton26.setText("16");
                    jButton27.setText("17");
                    jButton28.setText("18");
                    jButton29.setText("19");
                    jButton30.setText("20");
                    jButton31.setText("21");
                    jButton32.setText("22");
                    jButton33.setText("23");
                    jButton34.setText("24");
                    jButton35.setText("25");
                    jButton36.setText("26");
                    jButton37.setText("27");
                    jButton38.setText("28");
                 
                    
                    if(tempM.equals("January")||tempM.equals("March")||tempM.equals("May")||tempM.equals("July")||tempM.equals("August")||tempM.equals("October")||tempM.equals("December"))
                    {
                        jButton39.setVisible(true);
                        jButton40.setVisible(true);
                        jButton41.setVisible(true);
                        jButton39.setText("29");
                        jButton40.setText("30");
                        jButton41.setText("31");
                        
                    }
                    else if(tempM.equals("April")||tempM.equals("June")||tempM.equals("September")||tempM.equals("November"))
                    {
                        jButton39.setVisible(true);
                        jButton40.setVisible(true);
                        
                        jButton39.setText("29");
                        jButton40.setText("30");
                    }
                    else if(tempM.equals("February")&&(tempY%4==0&&tempY%100!=0||tempY%400==0))
                    {
                        jButton39.setVisible(true);
                        
                        jButton39.setText("29");
                    }
            break;
                
            case 4:
                    jButton12.setVisible(true);
                    jButton13.setVisible(true);
                    jButton14.setVisible(true);
                    jButton15.setVisible(true);
                    jButton16.setVisible(true);
                    jButton17.setVisible(true);
                    jButton18.setVisible(true);
                    jButton19.setVisible(true);
                    jButton20.setVisible(true);
                    jButton21.setVisible(true);
                    jButton22.setVisible(true);
                    jButton23.setVisible(true);
                    jButton24.setVisible(true);
                    jButton25.setVisible(true);
                    jButton26.setVisible(true);
                    jButton27.setVisible(true);
                    jButton28.setVisible(true);
                    jButton29.setVisible(true); 
                    jButton30.setVisible(true);
                    jButton31.setVisible(true);
                    jButton32.setVisible(true);
                    jButton33.setVisible(true);
                    jButton34.setVisible(true);
                    jButton35.setVisible(true);
                    jButton36.setVisible(true);
                    jButton37.setVisible(true);
                    jButton38.setVisible(true);
                    jButton39.setVisible(true);
                    
                    
                    
                    jButton12.setText("1");
                    jButton13.setText("2");
                    jButton14.setText("3");
                    jButton15.setText("4");
                    jButton16.setText("5");
                    jButton17.setText("6");
                    jButton18.setText("7");
                    jButton19.setText("8");
                    jButton20.setText("9");
                    jButton21.setText("10");
                    jButton22.setText("11");
                    jButton23.setText("12");
                    jButton24.setText("13");
                    jButton25.setText("14");
                    jButton26.setText("15");
                    jButton27.setText("16");
                    jButton28.setText("17");
                    jButton29.setText("18");
                    jButton30.setText("19");
                    jButton31.setText("20");
                    jButton32.setText("21");
                    jButton33.setText("22");
                    jButton34.setText("23");
                    jButton35.setText("24");
                    jButton36.setText("25");
                    jButton37.setText("26");
                    jButton38.setText("27");
                    jButton39.setText("28");
      
                    
                    if(tempM.equals("January")||tempM.equals("March")||tempM.equals("May")||tempM.equals("July")||tempM.equals("August")||tempM.equals("October")||tempM.equals("December"))
                    {
                        jButton40.setVisible(true);
                        jButton41.setVisible(true);
                        jButton42.setVisible(true);
                        jButton40.setText("29");
                        jButton41.setText("30");
                        jButton42.setText("31");
                    }
                    else if(tempM.equals("April")||tempM.equals("June")||tempM.equals("September")||tempM.equals("November"))
                    {
                        jButton40.setVisible(true);
                        jButton41.setVisible(true);
                        
                        jButton40.setText("29");
                        jButton41.setText("30");
                    }
                    else if(tempM.equals("February")&&(tempY%4==0&&tempY%100!=0||tempY%400==0))
                    {
                        jButton40.setVisible(true);
                        
                        jButton40.setText("29");
                    }
            break;
            
            case 5:
                    jButton13.setVisible(true);
                    jButton14.setVisible(true);
                    jButton15.setVisible(true);
                    jButton16.setVisible(true);
                    jButton17.setVisible(true);
                    jButton18.setVisible(true);
                    jButton19.setVisible(true);
                    jButton20.setVisible(true);
                    jButton21.setVisible(true);
                    jButton22.setVisible(true);
                    jButton23.setVisible(true);
                    jButton24.setVisible(true);
                    jButton25.setVisible(true);
                    jButton26.setVisible(true);
                    jButton27.setVisible(true);
                    jButton28.setVisible(true);
                    jButton29.setVisible(true); 
                    jButton30.setVisible(true);
                    jButton31.setVisible(true);
                    jButton32.setVisible(true);
                    jButton33.setVisible(true);
                    jButton34.setVisible(true);
                    jButton35.setVisible(true);
                    jButton36.setVisible(true);
                    jButton37.setVisible(true);
                    jButton38.setVisible(true);
                    jButton39.setVisible(true);
                    jButton40.setVisible(true);
                    
                    
                    
                    jButton13.setText("1");
                    jButton14.setText("2");
                    jButton15.setText("3");
                    jButton16.setText("4");
                    jButton17.setText("5");
                    jButton18.setText("6");
                    jButton19.setText("7");
                    jButton20.setText("8");
                    jButton21.setText("9");
                    jButton22.setText("10");
                    jButton23.setText("11");
                    jButton24.setText("12");
                    jButton25.setText("13");
                    jButton26.setText("14");
                    jButton27.setText("15");
                    jButton28.setText("16");
                    jButton29.setText("17");
                    jButton30.setText("18");
                    jButton31.setText("19");
                    jButton32.setText("20");
                    jButton33.setText("21");
                    jButton34.setText("22");
                    jButton35.setText("23");
                    jButton36.setText("24");
                    jButton37.setText("25");
                    jButton38.setText("26");
                    jButton39.setText("27");
                    jButton40.setText("28");
      
                    
                    if(tempM.equals("January")||tempM.equals("March")||tempM.equals("May")||tempM.equals("July")||tempM.equals("August")||tempM.equals("October")||tempM.equals("December"))
                    {
                        jButton41.setVisible(true);
                        jButton42.setVisible(true);
                        jButton43.setVisible(true);
                        jButton41.setText("29");
                        jButton42.setText("30");
                        jButton43.setText("31");
                    }
                    else if(tempM.equals("April")||tempM.equals("June")||tempM.equals("September")||tempM.equals("November"))
                    {
                        jButton41.setVisible(true);
                        jButton42.setVisible(true);
                        
                        jButton41.setText("29");
                        jButton42.setText("30");
                    }
                    else if(tempM.equals("February")&&(tempY%4==0&&tempY%100!=0||tempY%400==0))
                    {
                        jButton41.setVisible(true);
                       
                        jButton41.setText("29");
                    }
            break;
            
            case 6:
                    jButton14.setVisible(true);
                    jButton15.setVisible(true);
                    jButton16.setVisible(true);
                    jButton17.setVisible(true);
                    jButton18.setVisible(true);
                    jButton19.setVisible(true);
                    jButton20.setVisible(true);
                    jButton21.setVisible(true);
                    jButton22.setVisible(true);
                    jButton23.setVisible(true);
                    jButton24.setVisible(true);
                    jButton25.setVisible(true);
                    jButton26.setVisible(true);
                    jButton27.setVisible(true);
                    jButton28.setVisible(true);
                    jButton29.setVisible(true); 
                    jButton30.setVisible(true);
                    jButton31.setVisible(true);
                    jButton32.setVisible(true);
                    jButton33.setVisible(true);
                    jButton34.setVisible(true);
                    jButton35.setVisible(true);
                    jButton36.setVisible(true);
                    jButton37.setVisible(true);
                    jButton38.setVisible(true);
                    jButton39.setVisible(true);
                    jButton40.setVisible(true);
                    jButton41.setVisible(true);
                    
                    
                    
                    jButton14.setText("1");
                    jButton15.setText("2");
                    jButton16.setText("3");
                    jButton17.setText("4");
                    jButton18.setText("5");
                    jButton19.setText("6");
                    jButton20.setText("7");
                    jButton21.setText("8");
                    jButton22.setText("9");
                    jButton23.setText("10");
                    jButton24.setText("11");
                    jButton25.setText("12");
                    jButton26.setText("13");
                    jButton27.setText("14");
                    jButton28.setText("15");
                    jButton29.setText("16");
                    jButton30.setText("17");
                    jButton31.setText("18");
                    jButton32.setText("19");
                    jButton33.setText("20");
                    jButton34.setText("21");
                    jButton35.setText("22");
                    jButton36.setText("23");
                    jButton37.setText("24");
                    jButton38.setText("25");
                    jButton39.setText("26");
                    jButton40.setText("27");
                    jButton41.setText("28");
     
                    
                    if(tempM.equals("January")||tempM.equals("March")||tempM.equals("May")||tempM.equals("July")||tempM.equals("August")||tempM.equals("October")||tempM.equals("December"))
                    {
                        jButton42.setVisible(true);
                        jButton43.setVisible(true);
                        jButton44.setVisible(true);
                        jButton42.setText("29");
                        jButton43.setText("30");
                        jButton44.setText("31");
                    }
                    else if(tempM.equals("April")||tempM.equals("June")||tempM.equals("September")||tempM.equals("November"))
                    {
                        jButton42.setVisible(true);
                        jButton43.setVisible(true);
                        
                        jButton42.setText("29");
                        jButton43.setText("30");
                    }
                    else if(tempM.equals("February")&&(tempY%4==0&&tempY%100!=0||tempY%400==0))
                    {
                        jButton42.setVisible(true);
                       
                        jButton42.setText("29");
                    }
            break;
        }
    }
    
    public void setDay()
    {
        tempYear=Year%400;
        for(i=Year-tempYear+1;i<Year;i++)
        {
            if(i%4==0&&i%100!=0||i%400==0)
            leap++;
        }
        
        days=(leap*2)+(tempYear-leap);
        days=(days%7);
        switch(Month)
        {
            case 0: days=(days)%7;break;
            case 1: days=(days+3)%7;break;
            case 2: if(Year%4==0&&Year%100!=0||Year%400==0)
                    days=(days+4)%7;
                    else
                    days=(days+3)%7;
                break;
            case 3: if(Year%4==0&&Year%100!=0||Year%400==0)
                    days=(days)%7;
                    else
                    days=(days+6)%7;
                break;
            case 4: if(Year%4==0&&Year%100!=0||Year%400==0)
                    days=(days+2)%7;
                    else
                    days=(days+1)%7;
                break;
            case 5: if(Year%4==0&&Year%100!=0||Year%400==0)
                    days=(days+5)%7;
                    else
                    days=(days+4)%7;
                break;
            case 6: if(Year%4==0&&Year%100!=0||Year%400==0)
                    days=(days)%7;
                    else
                    days=(days+6)%7;
                break;
            case 7: if(Year%4==0&&Year%100!=0||Year%400==0)
                    days=(days+3)%7;
                    else
                    days=(days+2)%7;
                break;
            case 8: if(Year%4==0&&Year%100!=0||Year%400==0)
                    days=(days+6)%7;
                    else
                    days=(days+5)%7;
                break;
            case 9: if(Year%4==0&&Year%100!=0||Year%400==0)
                    days=(days+1)%7;
                    else
                    days=(days)%7;
                break;
            case 10: if(Year%4==0&&Year%100!=0||Year%400==0)
                    days=(days+4)%7;
                    else
                    days=(days+3)%7;
                break;
            case 11: if(Year%4==0&&Year%100!=0||Year%400==0)
                    days=(days+6)%7;
                    else
                    days=(days+5)%7;
                break;
        }
        jTextArea1.setText("temp-->"+tempYear+"      i-->"+i+"     leap-->"+leap+"     Days-->"+days);
        tempYear=0;
        i=0;
        leap=0;
    }
    
    public void setMonth(int x)
    {
        jButton6.setText(MonthName[Month]+"");
        if(x==11)
        jButton2.setText(MonthName[0]+"");
        else
        jButton2.setText(MonthName[Month+1]+"");
        if(x==0)
        jButton1.setText(MonthName[11]+"");
        else
        jButton1.setText(MonthName[Month-1]+"");
        
    }
    public void setYear(int x)
    {
        jButton7.setText(Year+"");
        jButton5.setText((Year+1)+"");
        jButton4.setText(Year-1+"");
        
    }
    
    public void getDate(int x)
    {
        jButton50.setText(x+" - "+jButton6.getText()+" - "+jButton7.getText());
    }
    
    public Calender() {
        initComponents();
        Calendar clnd=Calendar.getInstance();
        Month=clnd.get(Calendar.MONTH);
        Year=clnd.get(Calendar.YEAR);
        
         setMonth(Month);
         setYear(Year);
         setDay();
         fillDate();
         getDate(clnd.get(Calendar.DATE));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton50 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(new java.awt.Color(102, 102, 255));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(null);

        jButton1.setBackground(new java.awt.Color(51, 51, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Previous");
        jButton1.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(33, 47, 100, 30);

        jButton2.setBackground(new java.awt.Color(51, 51, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Next");
        jButton2.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(313, 47, 100, 30);

        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(885, 533, 51, 23);

        jButton4.setBackground(new java.awt.Color(51, 51, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("Previous");
        jButton4.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(33, 11, 100, 30);

        jButton5.setBackground(new java.awt.Color(51, 51, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setText("Next");
        jButton5.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);
        jButton5.setBounds(313, 11, 100, 30);

        jPanel3.setBackground(new java.awt.Color(255, 153, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setPreferredSize(new java.awt.Dimension(380, 352));
        jPanel3.setLayout(null);

        jButton8.setActionCommand("");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton8);
        jButton8.setBounds(12, 50, 45, 40);

        jButton9.setActionCommand("");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton9);
        jButton9.setBounds(63, 50, 45, 40);

        jButton10.setActionCommand("");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10);
        jButton10.setBounds(114, 50, 45, 40);

        jButton11.setActionCommand("");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton11);
        jButton11.setBounds(165, 50, 45, 40);

        jButton12.setActionCommand("");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton12);
        jButton12.setBounds(216, 50, 45, 40);

        jButton13.setActionCommand("");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton13);
        jButton13.setBounds(267, 50, 45, 40);

        jButton14.setActionCommand("");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton14);
        jButton14.setBounds(318, 50, 45, 40);

        jButton15.setActionCommand("");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton15);
        jButton15.setBounds(12, 96, 45, 40);

        jButton16.setActionCommand("");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton16);
        jButton16.setBounds(63, 96, 45, 40);

        jButton17.setActionCommand("");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton17);
        jButton17.setBounds(114, 96, 45, 40);

        jButton18.setActionCommand("");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton18);
        jButton18.setBounds(165, 96, 45, 40);

        jButton19.setActionCommand("");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton19);
        jButton19.setBounds(216, 96, 45, 40);

        jButton20.setActionCommand("");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton20);
        jButton20.setBounds(267, 96, 45, 40);

        jButton21.setActionCommand("");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton21);
        jButton21.setBounds(318, 96, 45, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MON");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(63, 18, 45, 25);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("TUE");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(114, 18, 45, 25);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("WED");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(165, 18, 45, 25);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("SUN");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(12, 18, 45, 25);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("THU");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(216, 18, 45, 25);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("FRI");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(267, 18, 45, 25);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("SAT");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(318, 18, 45, 25);

        jButton22.setActionCommand("");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton22);
        jButton22.setBounds(12, 142, 45, 40);

        jButton23.setActionCommand("");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton23);
        jButton23.setBounds(63, 142, 45, 40);

        jButton24.setActionCommand("");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton24);
        jButton24.setBounds(114, 142, 45, 40);

        jButton25.setActionCommand("");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton25);
        jButton25.setBounds(165, 142, 45, 40);

        jButton26.setActionCommand("");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton26);
        jButton26.setBounds(216, 142, 45, 40);

        jButton27.setActionCommand("");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton27);
        jButton27.setBounds(267, 142, 45, 40);

        jButton28.setActionCommand("");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton28);
        jButton28.setBounds(318, 142, 45, 40);

        jButton29.setActionCommand("");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton29);
        jButton29.setBounds(12, 188, 45, 40);

        jButton30.setActionCommand("");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton30);
        jButton30.setBounds(63, 188, 45, 40);

        jButton31.setActionCommand("");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton31);
        jButton31.setBounds(114, 188, 45, 40);

        jButton32.setActionCommand("");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton32);
        jButton32.setBounds(165, 188, 45, 40);

        jButton33.setActionCommand("");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton33);
        jButton33.setBounds(216, 188, 45, 40);

        jButton34.setActionCommand("");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton34);
        jButton34.setBounds(267, 188, 45, 40);

        jButton35.setActionCommand("");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton35);
        jButton35.setBounds(318, 188, 45, 40);

        jButton36.setActionCommand("");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton36);
        jButton36.setBounds(12, 234, 45, 40);

        jButton37.setActionCommand("");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton37);
        jButton37.setBounds(63, 234, 45, 40);

        jButton38.setActionCommand("");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton38);
        jButton38.setBounds(114, 234, 45, 40);

        jButton39.setActionCommand("");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton39);
        jButton39.setBounds(165, 234, 45, 40);

        jButton40.setActionCommand("");
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton40);
        jButton40.setBounds(216, 234, 45, 40);

        jButton41.setActionCommand("");
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton41);
        jButton41.setBounds(267, 234, 45, 40);

        jButton42.setActionCommand("");
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton42);
        jButton42.setBounds(318, 234, 45, 40);

        jButton43.setActionCommand("");
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton43);
        jButton43.setBounds(12, 280, 45, 40);

        jButton44.setActionCommand("");
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton44);
        jButton44.setBounds(63, 280, 45, 40);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(33, 95, 380, 340);

        jButton6.setBackground(new java.awt.Color(0, 0, 153));
        jButton6.setFont(new java.awt.Font("Monotype Corsiva", 1, 24)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 255, 255));
        jButton6.setText("Text");
        jButton6.setBorder(null);
        jPanel2.add(jButton6);
        jButton6.setBounds(139, 48, 168, 29);

        jButton7.setBackground(new java.awt.Color(0, 0, 153));
        jButton7.setFont(new java.awt.Font("Monotype Corsiva", 1, 24)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 255, 255));
        jButton7.setText("Text");
        jButton7.setBorder(null);
        jPanel2.add(jButton7);
        jButton7.setBounds(139, 12, 168, 29);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(450, 333, 429, 212);

        jButton50.setBackground(new java.awt.Color(0, 255, 255));
        jButton50.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton50.setForeground(new java.awt.Color(0, 51, 255));
        jPanel2.add(jButton50);
        jButton50.setBounds(490, 20, 220, 30);

        jButton45.setBackground(new java.awt.Color(153, 255, 255));
        jButton45.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton45.setForeground(new java.awt.Color(0, 0, 204));
        jButton45.setText("Add Event");
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton45);
        jButton45.setBounds(540, 50, 120, 30);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 938, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Year++;
        setYear(Year);
        setDay();
        fillDate();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Year--;
        setYear(Year);
        setDay();
        fillDate();
        Calendar clnd=Calendar.getInstance();
        int date=clnd.get(Calendar.DATE);
        jTextArea1.setText(date+"");
        getDate(date);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(Month==11)
        Month=0;
        else
        Month=Month+1;
        setMonth(Month);
        setDay();
        fillDate();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(Month==0)
        Month=11;
        else
        Month=Month-1;
        setMonth(Month);
        setDay();
        fillDate();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton8.getText()));
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton9.getText()));
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton10.getText()));
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton11.getText()));
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton12.getText()));
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton13.getText()));
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton14.getText()));
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton15.getText()));
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton16.getText()));
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton17.getText()));
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton18.getText()));
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton19.getText()));
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton20.getText()));
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton21.getText()));
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton22.getText()));
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton23.getText()));
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton24.getText()));
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton25.getText()));
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton26.getText()));
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton27.getText()));
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton28.getText()));
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton29.getText()));
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton30.getText()));
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton31.getText()));
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton32.getText()));
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton33.getText()));
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton34.getText()));
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton35.getText()));
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton36.getText()));
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton37.getText()));
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton38.getText()));
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton39.getText()));
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton40.getText()));
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton41.getText()));
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton42.getText()));
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton43.getText()));
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        // TODO add your handling code here:
        getDate(Integer.parseInt(jButton44.getText()));
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
        // TODO add your handling code here:
        AddEvent ae=new AddEvent(this,true);
        ae.setBounds(400, 200, 390, 340);
        ae.setVisible(true);
        
    }//GEN-LAST:event_jButton45ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Calender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calender().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton5;
    public javax.swing.JButton jButton50;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}