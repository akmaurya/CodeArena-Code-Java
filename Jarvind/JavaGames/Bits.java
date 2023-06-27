import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Bits extends JApplet implements MouseMotionListener, MouseListener	
{
	th t=new th();
	
	int X=0,Y=0,ch=0;
	int i=0,j=0;
	JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bat,boll;
	Container cn;
	public void init()
	{
		cn=getContentPane();
		cn.setLayout(null);
		//cn.setBorder(new BevelBorder(BevelBorder.RAISED));
		
		b0=new JButton();
		b1=new JButton();
		b2=new JButton();
		b3=new JButton();
		b4=new JButton();
		b5=new JButton();
		b6=new JButton();
		b7=new JButton();
		b8=new JButton();
		b9=new JButton();
		
		
		bat=new JButton();
		boll=new JButton();
		
		b0.setBounds(0,0,50,30);
		b1.setBounds(50,0,50,30);
		b2.setBounds(100,0,50,30);
		b3.setBounds(150,0,50,30);
		b4.setBounds(200,0,50,30);
		b5.setBounds(250,0,50,30);
		b6.setBounds(300,0,50,30);
		b7.setBounds(350,0,50,30);
		b8.setBounds(400,0,50,30);
		b9.setBounds(450,0,50,30);
		
		bat.setBounds(0,570,100,20);
		boll.setBounds(0,560,10,10);
		
		cn.add(b0);
		cn.add(b1);
		cn.add(b2);
		cn.add(b3);
		cn.add(b4);
		cn.add(b5);
		cn.add(b6);
		cn.add(b7);
		cn.add(b8);
		cn.add(b9);
		
		cn.add(bat);
		cn.add(boll);
		
		cn.addMouseMotionListener(this);
		cn.addMouseListener(this);
		
		bat.addMouseMotionListener(this);
	}
	
	class th extends Thread
	{
		public void run()
		{
			for(i=X,j=570;i<=440&&j>=40;i++,j--)								//
			{																	//	
				if(i<440&&j>40)			
				{																//
					boll.setBounds(i,j-10,10,10);
					try															//
					{
						sleep(10);												//
					}
					catch(Exception e)
					{
						System.out.println("Error! "+e);						//
					}
																				//
				}
																				//
				if(i==440&&j>40)
				{																//
					for(i=440;i>=0&&j>40;i--,j--)								//	
					{
																				//
							boll.setBounds(i,j-10,10,10);						//	
							try													//	
							{													//
								sleep(10);
							}													//
							catch(Exception e)	
							{													//
								System.out.println("Error! "+e);				//
							}
					}	
				}																//Bottom to up
				
				
				
				if(i>0&&j==40)												//
				{				
					for(j=40;i<=440&&j<440;i++,j++)								//
					boll.setBounds(i,j-10,10,10);							
					try															//	
					{						
						sleep(10);												//	
					}															//
					catch(Exception e)
					{															//
						System.out.println("Error! "+e);						//
					}

					if(i==440&&j<40)
					{																//	
						for(i=440;i>=0&&j>40;i--,j--)
						{															//
							
								boll.setBounds(i,j-10,10,10);						//
								try
								{													//
									sleep(10);
								}													//		
								catch(Exception e)
								{
									System.out.println("Error! "+e);				//
								}
						}															//
					}																	//	
				}																//
																				//
																			//Top to bottom
				
				
				
				
			}
		}
	}
	
	public void mouseMoved(MouseEvent me)
	{
		int x,y;
		X=x=me.getX();
		Y=y=me.getY();
		if(me.getSource()==cn&&x>40&&x<390)
		bat.setBounds(x-40,570,100,20);
	}
	
	public void mouseDragged(MouseEvent me)
	{
	}
	
	public void mousePressed(MouseEvent me)
	{
	}
	
	public void mouseClicked(MouseEvent me)
	{
		if(me.getSource()==cn&&ch==0)
		{
			t.start();
			ch=1;
		}
		
		if(me.getSource()==cn&&ch==1)
		{
			
			t.resume();
		}
		
	}
	
	public void mouseReleased(MouseEvent me)
	{
	}
	
	public void mouseEntered(MouseEvent me)
	{
	}
	
	public void mouseExited(MouseEvent me)
	{
	}
}