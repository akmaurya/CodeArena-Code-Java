package riperealtorspltd;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.event.*;

public class Cal  implements KeyListener,MouseListener,ActionListener
{
    
    	JLabel Sun,Mon,Tue,Wed,Thu,Fri,Sat;
		JButton premonth,postmonth,preyear,postyear,apply;
    	JTextField showmonth,showyear;
        String datevar,monthvar,yearvar,showdate; 
		JToggleButton datetoggle[];
		String setstring;
		int convertyear,convertmonth,once=7,twice=14,thrice=21,fourth=28,fifth=35,totaldays=0,before=0;
        int sun=1,mon=2,tue=3,wed=4,thu=5,fri=6,sat=7,holddata=0;
        java.util.Date date;
        String setstr;
        java.util.GregorianCalendar cal1=new java.util.GregorianCalendar();
	
		String msg="";
		JDialog jd=null;
		String applydate="";
		String applyday="";
		String applymonth="";
		String applyyear="",recieve=""; 
				
	public Cal()
	{
            //System.out.println("called.....");
		jd=new JDialog(new JFrame(),"",true);
		
		System.out.println("cunstructor is called.................");
                jd.setDefaultCloseOperation(jd.DISPOSE_ON_CLOSE);

		msg="ok";
		Container con= jd.getContentPane();
		con.setLayout(null);
		con.setBackground(Color.LIGHT_GRAY);
		date=new java.util.Date();
		datevar=""+date.getDate();
		convertmonth=date.getMonth()+1;
		convertyear=date.getYear()+1900;
		yearvar=""+convertyear;
					
			
//....................close.firstframe.............................		
		
		Font font=new Font("Arial",Font.BOLD,12);
                Font font1=new Font("Verdana",Font.BOLD,14);
		ImageIcon leftimage=new ImageIcon("left.bmp");
                Font font2=new Font("Verdana",Font.BOLD,12);
						
		premonth=new JButton("^");
		premonth.setOpaque(true);
		premonth.setFont(font);
		premonth.setBounds(135,10,50,15);
		con.add(premonth);

                postmonth=new JButton("v");
		postmonth.setFont(font);
		postmonth.setBounds(135,25,50,15);
		con.add(postmonth);
		
		showmonth=new JTextField();
		showmonth.setBounds(10,10,120,30);
                showmonth.setFocusable(false);
                showmonth.requestFocus(false);
                showmonth.setEditable(false);
                //showmonth.setBackground(Color.ORANGE);
                showmonth.setFont(font2);
		con.add(showmonth);
		
//......................ShowMonth in TextField............................
		if(convertmonth==1)
		{  showmonth.setText("JANUARY");monthvar="JANUARY";}
		else if(convertmonth==2)
		 { showmonth.setText("FEBRUARY");monthvar="FEBRUARY";}
		else if(convertmonth==3)
		 {showmonth.setText("MARCH");monthvar="MARCH";}
		else if(convertmonth==4)
		 { showmonth.setText("APRIL");monthvar="APRIL";}
		else if(convertmonth==5)
		  {showmonth.setText("MAY");monthvar="MAY";}
		else if(convertmonth==6)
		  {showmonth.setText("JUNE");monthvar="JUNE";}
		else if(convertmonth==7)
		  {showmonth.setText("JULY");monthvar="JULY";}
		else if(convertmonth==8)
		  {showmonth.setText("AUGUST");monthvar="AUGUST";}
		else if(convertmonth==9)
		  {showmonth.setText("SEPTEMBER");monthvar="SEPTEMBER";}
		else if(convertmonth==10)
		  {showmonth.setText("OCTOBER");monthvar="OCTOBER";}
		else if(convertmonth==11)
		  {showmonth.setText("NOVEMBER");monthvar="NOVEMBER";}
		else if(convertmonth==12)
		  {showmonth.setText("DECEMBER");monthvar="DECEMBER";}
		
		
		
		

		preyear=new JButton("^");
		preyear.setFont(font);
		preyear.setBounds(330,10,50,15);
		con.add(preyear);
                ButtonModel bModel=preyear.getModel();


		showyear=new JTextField(yearvar);
		showyear.setBounds(205,10,120,30);
                showyear.setEditable(false);
                //showyear.setBackground(Color.ORANGE);
                showyear.setFont(font2);
		con.add(showyear);
		
		postyear=new JButton("v");
		postyear.setFont(font);
		postyear.setBounds(330,25,50,15);
		con.add(postyear);
		
		Sun=new JLabel("Sun",JLabel.CENTER);
		Mon=new JLabel("Mon",JLabel.CENTER);
		Tue=new JLabel("Tue",JLabel.CENTER);
		Wed=new JLabel("Wed",JLabel.CENTER);
		Thu=new JLabel("Thu",JLabel.CENTER);
		Fri=new JLabel("Fri",JLabel.CENTER);
		Sat=new JLabel("Sat",JLabel.CENTER);
		
		Sun.setFont(font1);
		Mon.setFont(font1);
		Tue.setFont(font1);
		Wed.setFont(font1);
		Thu.setFont(font1);
		Fri.setFont(font1);
		Sat.setFont(font1);
		
		Sun.setBounds(5,45,50,25);
		Mon.setBounds(60,45,50,25);
		Tue.setBounds(115,45,50,25);
		Wed.setBounds(170,45,50,25);
		Thu.setBounds(225,45,50,25);
		Fri.setBounds(280,45,50,25);
		Sat.setBounds(335,45,50,25);
		
		con.add(Sun);
		con.add(Mon);
		con.add(Tue);
		con.add(Wed);
		con.add(Thu);
		con.add(Fri);
		con.add(Sat);
		
		ButtonGroup group=new ButtonGroup();

		datetoggle=new JToggleButton[42];
		for(int i=0;i<=41;i++)
		{
		   datetoggle[i]=new JToggleButton();
		   datetoggle[i].setFont(font);
		   group.add(datetoggle[i]);
		}
		for(int i=0,j=0;i<=6;i++)
		{
		   datetoggle[i].setBounds(5+j,75,50,25);
	       datetoggle[i+7].setBounds(5+j,105,50,25);
		   datetoggle[i+14].setBounds(5+j,135,50,25);
		   datetoggle[i+21].setBounds(5+j,165,50,25);
		   datetoggle[i+28].setBounds(5+j,195,50,25);
		   datetoggle[i+35].setBounds(5+j,225,50,25);
			j=j+55;
		}
		for(int i=0;i<=41;i++)
		{
		   con.add(datetoggle[i]);
		} 
		
		apply=new JButton("Apply");
		apply.setMnemonic('A');
                apply.setFont(font1);
		apply.setBounds(145,230,100,30);
		con.add(apply);
//.......................show date in togglebutton........................

/*total days of month setting*/
	
  
	    setmonth();
			
//..........................................


		String datestr=""+date;
                System.out.println("1.datestr="+datestr);
		datestr=datestr.substring(0,3);
		System.out.println("2.datestr="+datestr);
		if(datestr.equals("Sun"))
		    holddata=sun;
		else if(datestr.equals("Mon"))
		    holddata=mon;
		else if(datestr.equals("Tue"))
		    holddata=tue;
		else if(datestr.equals("Wed"))
		    holddata=wed;
		else if(datestr.equals("Thu"))
		    holddata=thu;
		else if(datestr.equals("Fri"))
		    holddata=fri;
		else if(datestr.equals("Sat"))
		    holddata=sat;
                System.out.println("holddata="+holddata);
                System.out.println("date.getDate()="+date.getDate());

		if(date.getDate()<=holddata)
	   		{
	   	System.out.println("inside="+holddata);
                	     setdate(holddata);
	   		
	   		}
		else if(date.getDate()<=holddata+once)
	   		{
	   	System.out.println("inside="+(holddata+once));

	   			setdate(holddata+once);
	   		}	
			else if(date.getDate()<=holddata+twice)
	   		{
	   	System.out.println("inside="+(holddata+twice));

	   		  	setdate(holddata+twice);
	   		
	   		}
			else if(date.getDate()<=holddata+thrice)
	   		{
	   	System.out.println("inside="+(holddata+thrice));

	   			setdate(holddata+thrice);
	   		}
	   		else if(date.getDate()<=holddata+fourth)
	   		{
	   	System.out.println("inside="+(holddata+fourth));

	   			setdate(holddata+fourth);
	   		}
                        else if(date.getDate()<=holddata+fifth)
	   		{
	   	System.out.println("inside="+(holddata+fifth));

	   			setdate(holddata+fifth);
	   		}
                        /*else
                        {
                            if(date.getDate()==30 && holddata==1)   setdate(29);
                            else if(date.getDate() == 31 && holddata == 2)   setdate(30);

                        }*/
	   			
//........................................................................		
	
	premonth.addMouseListener(this);
	premonth.addKeyListener(this);
	postmonth.addMouseListener(this);
	postmonth.addKeyListener(this);
	preyear.addMouseListener(this);
        //bModel.addChangeListener(this);
	preyear.addKeyListener(this);
	postyear.addMouseListener(this);
	postyear.addKeyListener(this);
	apply.addMouseListener(this);
	apply.addKeyListener(this);
	apply.addActionListener(this);
	for(int j=0;j<=41;j++)
	datetoggle[j].addKeyListener(this);
	 
	 
	 
	 jd.setSize(400,300);
	 jd.setVisible(true);

         showmonth.requestFocus(false);
         showmonth.setFocusable(false);
         premonth.requestFocus();
	}
	public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource()==apply)
            {
                        for(int a=0;a<=41;a++)
		 	{
		 		if(datetoggle[a].isSelected()==true)
		 		{
                                    datetoggle[a].setBackground(Color.red);
                                    applyday=datetoggle[a].getText();
		 		}
		 	}
		 	if(Integer.parseInt(applyday)<10)
                            applyday="0"+applyday;
		 	applymonth=showmonth.getText();
			applyyear=showyear.getText();
			jd.dispose();
            }
        }
        
	public void mousePressed(MouseEvent me)
	{
	   if(me.getSource()==premonth)
		{
		        premonthcoding();
		}  
		else if(me.getSource()==postmonth)
		{
		        postmonthcoding();
		} 
		else if(me.getSource()==preyear)
		{
                    
			pre();	       
		}
		else if(me.getSource()==postyear)
		{
		 	next();       
		}
		else if(me.getSource()==apply)
		{
			for(int a=0;a<=41;a++)
		 	{
		 		if(datetoggle[a].isSelected()==true)
		 		{
                                    datetoggle[a].setBackground(Color.red);
		 			applyday=datetoggle[a].getText();
		 		}
		 	}
		 	 if(Integer.parseInt(applyday)<10)
		 	 applyday="0"+applyday;
		 	applymonth=showmonth.getText();
		
			applyyear=showyear.getText();

			jd.dispose();
			//frame obj=new frame();
			//obj.setvalue(); 
		  //label.setText(getdate()+"/"+getmonth()+"/"+getyear());
	      //System.out.println("aaaa,,,,,,,,,");
	    }
		
    }
	public void mouseClicked(MouseEvent me)
	{}
	public void mouseExited(MouseEvent me)
	{}
	public void mouseEntered(MouseEvent me)
	{}
	public void mouseReleased(MouseEvent me)
	{}
	public void keyPressed(KeyEvent ke)
	{
		int i=ke.getKeyCode();
		if(ke.getSource()==premonth&&i==KeyEvent.VK_UP)
		{
			 premonthcoding();	
		}
                else if(ke.getSource()==premonth&&i==KeyEvent.VK_RIGHT)
		{
			 	postmonth.requestFocus();
		}
                else if(ke.getSource()==showmonth&&i==KeyEvent.VK_RIGHT)
		{
	     	  	premonth.requestFocus();
		}
                else if(ke.getSource()==apply&&i==KeyEvent.VK_LEFT)
		{
	     	  	datetoggle[totaldays].requestFocus();
		}
                else if(ke.getSource()==postmonth&&i==KeyEvent.VK_RIGHT)
		{
	     	  	preyear.requestFocus();
		}
                else if(ke.getSource()==preyear&&i==KeyEvent.VK_RIGHT)
		{
	     	  	postyear.requestFocus();
		}
                else if(ke.getSource()==postyear&&i==KeyEvent.VK_LEFT)
		{
	     	  	preyear.requestFocus();
		}
                else if(ke.getSource()==postyear&&i==KeyEvent.VK_RIGHT)
		{
	     	  	datetoggle[1].requestFocus();
		}
                else if(ke.getSource()==datetoggle[1]&&i==KeyEvent.VK_LEFT)
		{
	     	  	postyear.requestFocus();
		}
                else if(ke.getSource()==preyear&&i==KeyEvent.VK_LEFT)
		{
	     	  	postmonth.requestFocus();
		}
                else if(ke.getSource()==postmonth&&i==KeyEvent.VK_LEFT)
		{
	     	  	premonth.requestFocus();
		}
                else if(ke.getSource()==premonth&&i==KeyEvent.VK_LEFT)
		{
	     	  	apply.requestFocus();
		}
                else if(ke.getSource()==apply&&i==KeyEvent.VK_RIGHT)
		{
	     	  	premonth.requestFocus();
		}
		else if(ke.getSource()==postmonth&&i==KeyEvent.VK_DOWN)
		{
	     	  postmonthcoding();	
		}
		else if(ke.getSource()==preyear&&i==KeyEvent.VK_UP)
		{
	     	  pre();	
		}
		else if(ke.getSource()==postyear&&i==KeyEvent.VK_DOWN)
		{
	     	  next();	
		}
		else if(ke.getSource()==apply&&i==KeyEvent.VK_ENTER)
		{
                        for(int a=0;a<=41;a++)
		 	{
		 		if(datetoggle[a].isSelected()==true)
		 		{
                                    datetoggle[a].setBackground(Color.red);
                                    applyday=datetoggle[a].getText();
		 		}
		 	}
		 	if(Integer.parseInt(applyday)<10)
                            applyday="0"+applyday;
		 	applymonth=showmonth.getText();
			applyyear=showyear.getText();
			jd.dispose();
		}
                else if(i==KeyEvent.VK_ESCAPE)
		{
                    jd.dispose();
		}
		else
                {
                    for(int j=0;j<=41;j++)
                    {

			if(ke.getSource()==datetoggle[j]&&i==KeyEvent.VK_RIGHT)
			{
				datetoggle[j+1].setSelected(true);
				datetoggle[j+1].requestFocus();
                               setmonth();
				System.out.println("setmonth() ="+totaldays);
                                if(ke.getSource()==datetoggle[totaldays]&&i==KeyEvent.VK_RIGHT)
                                {
                                    apply.requestFocus();
                                }
			}
			if(ke.getSource()==datetoggle[j]&&i==KeyEvent.VK_LEFT)
			{
				datetoggle[j-1].setSelected(true);
				datetoggle[j-1].requestFocus();
			}
			if(ke.getSource()==datetoggle[j]&&i==KeyEvent.VK_UP)
			{
				if(j-7<0)
				{}
				else{
				datetoggle[j-7].setSelected(true);
				datetoggle[j-7].requestFocus();
				}
			}
			if(ke.getSource()==datetoggle[j]&&i==KeyEvent.VK_DOWN)
			{   if(j+7>41)
				{}
				else{
				datetoggle[j+7].setSelected(true);
				datetoggle[j+7].requestFocus();
				}
			}
			if(ke.getSource()==datetoggle[j]&&i==10)
			{
                            datetoggle[j].setSelected(true);
                            for(int a=0;a<=41;a++)
		 	{
		 		if(datetoggle[a].isSelected()==true)
		 		{
                                    System.out.println("j="+j);
		 			applyday=datetoggle[a].getText();
		 		}
		 	}
		 	 if(Integer.parseInt(applyday)<10)
		 	 applyday="0"+applyday;
		 	applymonth=showmonth.getText();

			applyyear=showyear.getText();

			jd.dispose();

			}
                    }
                }
		
	}
	public void keyReleased(KeyEvent ke)
	{}		
	public void keyTyped(KeyEvent ke)
	{}
	
	public String getday()
	{   
		 	return applyday;
	}
	public String getdate()
	{  
				if(applymonth.equals("JANUARY"))
		    	   recieve="01";
		    	if(applymonth.equals("FEBRUARY"))
		    	   recieve="02";
		    	if(applymonth.equals("MARCH"))
		    	   recieve="03";
		    	if(applymonth.equals("APRIL"))
		    	   recieve="04";
		    	if(applymonth.equals("MAY"))
		    	   recieve="05";         
		    	if(applymonth.equals("JUNE"))
		    	   recieve="06";
		    	if(applymonth.equals("JULY"))
		    	   recieve="07";
		    	if(applymonth.equals("AUGUST"))
		    	   recieve="08";
		    	if(applymonth.equals("SEPTEMBER"))
		    	   recieve="09";
		    	if(applymonth.equals("OCTOBER"))
		    	   recieve="10";          
		    	if(applymonth.equals("NOVEMBER"))
		    	   recieve="11";
		    	if(applymonth.equals("DECEMBER"))
		    	   recieve="12";           
                        if(!(applyday.length()<1&&recieve.length()<1&&applyyear.length()<1))
                        {
                            applydate=applyday+"-"+recieve+"-"+applyyear;
                            return applydate;
            }
		 	return "";
            
	}
	public String getmonth()
	{  
		 	return applymonth;
	}
	public String getyear()
	{  
		 	return applyyear;
	}
	public void setdate(int hold)
	{
                             int n=hold-1;
                             System.out.println("n="+n);
	   		     datetoggle[n].setSelected(true); 
	   		     for(int i=date.getDate();i>0;i--)
	   		     {
				   		String j=""+i;
	   			   		datetoggle[n].setText(j);
	   					n-- ;	
	   		     }
	   		     for(;n>=0;n--)
                                datetoggle[n].setVisible(false);

                            n=hold-1;
                            for(int i=date.getDate();i<=totaldays;i++)
	   		    {
	   		    	
	   		    	String j=""+i;
	   			    	datetoggle[n].setText(j);
	   			
	   				n++ ;
	   					
	   			}		
	   			for(;n<=41;n++)
	   		    	datetoggle[n].setVisible(false); 	
	}
	
	public void setmonth()
	{
		if(showmonth.getText().equals("DECEMBER"))
	  	    totaldays=31;
	  else if (showmonth.getText().equals("NOVEMBER"))
			totaldays=30;		 
	  else if (showmonth.getText().equals("OCTOBER")) 
			totaldays=31;
	  else if (showmonth.getText().equals("SEPTEMBER"))
			totaldays=30;	
	  else if (showmonth.getText().equals("AUGUST"))
	       totaldays=31;		
	  else if (showmonth.getText().equals("JULY"))
			totaldays=31;		 
	  else if (showmonth.getText().equals("JUNE"))
			totaldays=30;			
	  else if (showmonth.getText().equals("MAY"))
			totaldays=31;		
	  else if (showmonth.getText().equals("APRIL"))
			totaldays=30;																
	  else if (showmonth.getText().equals("MARCH"))
			totaldays=31;
	  else if (showmonth.getText().equals("FEBRUARY"))
	  {    
	  		 if(cal1.isLeapYear(Integer.parseInt(showyear.getText()))==true)
	  	     { 
	  	     	totaldays=29;
	  	     	
	  	     }
	  	    else
	  	    {
	  	        totaldays=28;
	  	        
	  	    }
	  }		
	  else if (showmonth.getText().equals("JANUARY"))
			totaldays=31;
			
			
			
	}
    
    public void setbeforemonth()
	{
		if(showmonth.getText().equals("DECEMBER"))
	  	    before=31;
	  else if (showmonth.getText().equals("NOVEMBER"))
			before=30;		 
	  else if (showmonth.getText().equals("OCTOBER")) 
			before=31;
	  else if (showmonth.getText().equals("SEPTEMBER"))
			before=30;	
	  else if (showmonth.getText().equals("AUGUST"))
	       before=31;		
	  else if (showmonth.getText().equals("JULY"))
			before=31;		 
	  else if (showmonth.getText().equals("JUNE"))
			before=30;			
	  else if (showmonth.getText().equals("MAY"))
			before=31;		
	  else if (showmonth.getText().equals("APRIL"))
			before=30;																
	  else if (showmonth.getText().equals("MARCH"))
			before=31;
	  else if (showmonth.getText().equals("FEBRUARY"))
	  {    
	  		 if(cal1.isLeapYear(Integer.parseInt(showyear.getText()))==true)
	  	     { 
	  	     	before=29;
	  	     	
	  	     }
	  	    else
	  	    {
	  	        before=28;
	  	        
	  	    }
	  }		
	  else if (showmonth.getText().equals("JANUARY"))
			before=31;
			
			
			
	}
    
	
	
	
	public int holdvalue()
	{
		int a=0;
		if(date.getDate()<=holddata)
	   		{
	   		    a=holddata;	
	   		
	   		}
		else if(date.getDate()<=holddata+once)
	   		{   
	   		    a=holddata+once; 	
	   			
	   		}	
			else if(date.getDate()<=holddata+twice)
	   		{
	   		     
	   		  	a=holddata+twice; 	
	   			
	   		
	   		}
			else if(date.getDate()<=holddata+thrice)
	   		{
	   		   
	   			a=holddata+thrice; 	
	   			
	   		}
	   		else if(date.getDate()<=holddata+fourth)
	   		{
	   		   	
	   			a=holddata+fourth; 	
	   			
	   		}
	   		return a;
	   			
	}
	public void pre()
	{
		int value=Integer.parseInt(showyear.getText());
		int set=Integer.parseInt(showyear.getText())-1;
		String tempstr=""+set; 
		showyear.setText(tempstr);
		int hold=holdvalue();
		int n=0;
		
		for(n=0;n<=41;n++)
		{
			 
		    if(datetoggle[n].getText().equals("1"))
		       break;	
		       
		}
				 
		if(cal1.isLeapYear(value)==true)
		{
			datetoggle[n].setText("");
			
			if(n==1)
			n=8;
			if(n==0)
			n=7;
			
			
			
			n=n-2;
			int j=n;
		    j--;
		  for(;j>=0;j--)
					{
						datetoggle[j].setVisible(false);
					}
		  for(int i=1;i<=totaldays;i++)
			{
			   String string=""+i;
		       datetoggle[n].setText(string);
		       datetoggle[n].setVisible(true);
		       if(Integer.parseInt(datetoggle[n].getText())==date.getDate())
		       datetoggle[n].setSelected(true);
		       n++;
		    }
		  for(int i=n;i<=41;i++)
			{
			  
		       datetoggle[n].setText("");
		       datetoggle[n].setVisible(false);
		       n++;
		    }
	  	    	    
	   }
	   else
	   {
	   	
	   	datetoggle[n].setText("");
	   	  if(n==0)
	   	  n=7;
	   		n=n-1;
			int j=n;
		    j--;
		
				for(;j>=0;j--)
					{
						datetoggle[j].setVisible(false);
					}
		 for(int i=1;i<=totaldays;i++)
			{
			   String string=""+i;
		       datetoggle[n].setText(string);
		       datetoggle[n].setVisible(true);
		       if(Integer.parseInt(datetoggle[n].getText())==date.getDate())
		       datetoggle[n].setSelected(true);
		       n++;
		    }
		for(int i=n;i<=41;i++)
			{
			  
		       datetoggle[n].setText("");
		       datetoggle[n].setVisible(false);
		       n++;
		    }
	   	
	   }	
	}
	public void next()
	{    
		int set=Integer.parseInt(showyear.getText())+1;
		String tempstr=""+set; 
		showyear.setText(tempstr);
		int hold=holdvalue();
		int n=0;
		for(n=0;n<=41;n++)
		{
		    if(datetoggle[n].getText().equals("1"))
		       break;	
		}
				 
		    
		
		 
		if(cal1.isLeapYear(set)==true)
		{
			datetoggle[n].setText("");
			n=n+2;
			int j=n;
		    j--;
		
				
				for(;j>=0;j--)
					{
						datetoggle[j].setVisible(false);
					}
			
			if(n>6)
			n=n-7;
		  for(int i=1;i<=totaldays;i++)
			{
			   String string=""+i;
		       datetoggle[n].setText(string);
		       datetoggle[n].setVisible(true);
		       if(Integer.parseInt(datetoggle[n].getText())==date.getDate())
		       datetoggle[n].setSelected(true);
		       n++;
		    }
		    
		  for(int i=n;i<=41;i++)
			{
			  
		       datetoggle[n].setText("");
		       datetoggle[n].setVisible(false);
		       n++;
		    }
	  	    	    
	   }
	   else
	   {
	   	
	   	datetoggle[n].setText("");
			n=n+1;
			int j=n;
		    j--;
		
				
				for(;j>=0;j--)
					{
						datetoggle[j].setVisible(false);
					}
			
			if(n>6)
			n=n-7;
		  for(int i=1;i<=totaldays;i++)
			{
			   String string=""+i;
		       datetoggle[n].setText(string);
		       datetoggle[n].setVisible(true);
		       if(Integer.parseInt(datetoggle[n].getText())==date.getDate())
		       datetoggle[n].setSelected(true);
		       n++;
		    }
		   
		   for(int i=n;i<=41;i++)
			{
			  
		       datetoggle[n].setText("");
		       datetoggle[n].setVisible(false);
		       n++;
		    }
	   	
	   }
	}	
	public void premonthcoding()
	{
		 if(showmonth.getText().equals("JANUARY"))
                
                     showmonth.setText("DECEMBER");
                 
            else if(showmonth.getText().equals("FEBRUARY"))
		  showmonth.setText("JANUARY");
		else if(showmonth.getText().equals("MARCH"))
		  showmonth.setText("FEBRUARY");
		else if(showmonth.getText().equals("APRIL"))
		  showmonth.setText("MARCH");
		else if(showmonth.getText().equals("MAY"))
		  showmonth.setText("APRIL");
		else if(showmonth.getText().equals("JUNE"))
		  showmonth.setText("MAY");
		else if(showmonth.getText().equals("JULY"))
		  showmonth.setText("JUNE");
		else if(showmonth.getText().equals("AUGUST"))
		  showmonth.setText("JULY");
		else if(showmonth.getText().equals("SEPTEMBER"))
		  showmonth.setText("AUGUST");
		else if(showmonth.getText().equals("OCTOBER"))
		  showmonth.setText("SEPTEMBER");
		else if(showmonth.getText().equals("NOVEMBER"))
		  showmonth.setText("OCTOBER");
		else if(showmonth.getText().equals("DECEMBER"))
		  showmonth.setText("NOVEMBER");
                //premonthcoding();
		 setmonth();
		 setpremonth();
		 
		  	
	}
	public void postmonthcoding()
	{
	     setmonth();
	     if(showmonth.getText().equals("DECEMBER"))
	        showmonth.setText("JANUARY");
            else if(showmonth.getText().equals("JANUARY"))
		  showmonth.setText("FEBRUARY");
		else if(showmonth.getText().equals("FEBRUARY"))
		  showmonth.setText("MARCH");
		else if(showmonth.getText().equals("MARCH"))
		  showmonth.setText("APRIL");
		else if(showmonth.getText().equals("APRIL"))
		  showmonth.setText("MAY");
		else if(showmonth.getText().equals("MAY"))
		  showmonth.setText("JUNE");
		else if(showmonth.getText().equals("JUNE"))
		  showmonth.setText("JULY");
		else if(showmonth.getText().equals("JULY"))
		  showmonth.setText("AUGUST");
		else if(showmonth.getText().equals("AUGUST"))
		  showmonth.setText("SEPTEMBER");
		else if(showmonth.getText().equals("SEPTEMBER"))
		  showmonth.setText("OCTOBER");
		else if(showmonth.getText().equals("OCTOBER"))
		  showmonth.setText("NOVEMBER");
		else if(showmonth.getText().equals("NOVEMBER"))
		  showmonth.setText("DECEMBER");
		   	setbeforemonth();
		   	setpostmonth();
		   	
		 
		   	
		
	}
	public void setpostmonth()
	{
		
		
		int n=0;
		for(n=0;n<=41;n++)
		{
		    if(datetoggle[n].getText().equals("1"))
		       break;	
		}
		
		if(totaldays==31)
		{   
			
			datetoggle[n].setText("");
			n=n+3;
			
			if(n>6)
			n=n-7;
			
				int j=n;
		    j--;
		
				for(;j>=0;j--)
					{
						datetoggle[j].setVisible(false);
					}
		  for(int i=1;i<=before;i++)
			{
			   String string=""+i;
		       datetoggle[n].setText(string);
		       datetoggle[n].setVisible(true);
		       if(Integer.parseInt(datetoggle[n].getText())==date.getDate())
		       datetoggle[n].setSelected(true);
		       n++;
		    }
		  for(int i=n;i<=41;i++)
			{
			  
		       datetoggle[n].setText("");
		       datetoggle[n].setVisible(false);
		       n++;
		    }  	
		}
	else if(totaldays==30)
		{
			
			datetoggle[n].setText("");
			n=n+2;
			
			if(n>6)
			n=n-7;
			
				int j=n;
		    j--;
		
				for(;j>=0;j--)
					{
						datetoggle[j].setVisible(false);
					}
		  for(int i=1;i<=before;i++)
			{
			   String string=""+i;
		       datetoggle[n].setText(string);
		       datetoggle[n].setVisible(true);
		       if(Integer.parseInt(datetoggle[n].getText())==date.getDate())
		       datetoggle[n].setSelected(true);
		       n++;
		    }
		  for(int i=n;i<=41;i++)
			{
			  
		       datetoggle[n].setText("");
		       datetoggle[n].setVisible(false);
		       n++;
		    }  	
		} 
		else if(totaldays==29)
		{
			datetoggle[n].setText("");
			n=n+1;
			
			if(n>6)
			n=n-7;
			
				int j=n;
		    j--;
		
				for(;j>=0;j--)
					{
						datetoggle[j].setVisible(false);
					}
		  for(int i=1;i<=before;i++)
			{
			   String string=""+i;
		       datetoggle[n].setText(string);
		       datetoggle[n].setVisible(true);
		       if(Integer.parseInt(datetoggle[n].getText())==date.getDate())
		       datetoggle[n].setSelected(true);
		       n++;
		    }
		  for(int i=n;i<=41;i++)
			{
			  
		       datetoggle[n].setText("");
		       datetoggle[n].setVisible(false);
		       n++;
		    }  	
		    
		} 
	   	else if(totaldays==28)
		{
			
			datetoggle[n].setText("");
			
			
			if(n>6)
			n=n-7;
			
				int j=n;
		    j--;
		
				for(;j>=0;j--)
					{
						datetoggle[j].setVisible(false);
					}
		  for(int i=1;i<=before;i++)
			{
			   String string=""+i;
		       datetoggle[n].setText(string);
		       datetoggle[n].setVisible(true);
		       if(Integer.parseInt(datetoggle[n].getText())==date.getDate())
		       datetoggle[n].setSelected(true);
		       n++;
		    }
		  for(int i=n;i<=41;i++)
			{
			  
		       datetoggle[n].setText("");
		       datetoggle[n].setVisible(false);
		       n++;
		    }  	
		} 		
				
	}
	
		public void setpremonth()
	{
		
		for(int a=0;a<=41;a++)
		{			 
		    datetoggle[a].setSelected(false);
		}
		
		int n=0;
		for(n=0;n<=41;n++)
		{
		    if(datetoggle[n].getText().equals("1"))
		       break;	
		}
		
		if(totaldays==31)
		{   
			
			datetoggle[n].setText("");
			n=n-3;
			
			if(n<0)
			n=7+n;
			
				int j=n;
		    j--;
		
				for(;j>=0;j--)
					{
						datetoggle[j].setVisible(false);
					}
		  for(int i=1;i<=totaldays;i++)
			{
			   String string=""+i;
		       datetoggle[n].setText(string);
		       datetoggle[n].setVisible(true);
		       if(Integer.parseInt(datetoggle[n].getText())==date.getDate())
		       datetoggle[n].setSelected(true);
		       n++;
		    }
		  for(int i=n;i<=41;i++)
			{
			  
		       datetoggle[n].setText("");
		       datetoggle[n].setVisible(false);
		       n++;
		    }  	
		}
	else if(totaldays==30)
		{
			
			datetoggle[n].setText("");
			n=n-2;
			
			if(n<0)
			n=7+n;
			
				int j=n;
		    j--;
		
				for(;j>=0;j--)
					{
						datetoggle[j].setVisible(false);
					}
		  for(int i=1;i<=totaldays;i++)
			{
			   String string=""+i;
		       datetoggle[n].setText(string);
		       datetoggle[n].setVisible(true);
		       if(Integer.parseInt(datetoggle[n].getText())==date.getDate())
		       datetoggle[n].setSelected(true);
		       n++;
		    }
		  for(int i=n;i<=41;i++)
			{
			  
		       datetoggle[n].setText("");
		       datetoggle[n].setVisible(false);
		       n++;
		    }  	
		} 
		else if(totaldays==29)
		{
			
			datetoggle[n].setText("");
			n=n+1;
			if(n<0)
			n=7+n;
			int j=n;
		    j--;
		
				for(;j>=0;j--)
					{
						datetoggle[j].setVisible(false);
					}
		  for(int i=1;i<=totaldays;i++)
			{
			   String string=""+i;
		       datetoggle[n].setText(string);
		       datetoggle[n].setVisible(true);
		       if(Integer.parseInt(datetoggle[n].getText())==date.getDate())
		       datetoggle[n].setSelected(true);
		       n++;
		    }
		  for(int i=n;i<=41;i++)
			{
			  
		       datetoggle[n].setText("");
		       datetoggle[n].setVisible(false);
		       n++;
		    }  	
		    
		} 
	   	else if(totaldays==28)
		{
			
			datetoggle[n].setText("");
			
			
			if(n<0)
			n=7+n;
			
				int j=n;
		    j--;
		
				for(;j>=0;j--)
					{
						datetoggle[j].setVisible(false);
					}
		  for(int i=1;i<=totaldays;i++)
			{
			   String string=""+i;
		       datetoggle[n].setText(string);
		       datetoggle[n].setVisible(true);
		       if(Integer.parseInt(datetoggle[n].getText())==date.getDate())
		       datetoggle[n].setSelected(true);
		       n++;
		    }
		  for(int i=n;i<=41;i++)
			{
			  
		       datetoggle[n].setText("");
		       datetoggle[n].setVisible(false);
		       n++;
		    }  	
		} 		
				
	}
}
















