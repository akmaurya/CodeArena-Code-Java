import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTac extends JApplet implements MouseListener
{
	int rc[][]=new int[3][3],chance,i,j;
	char O='O',X='X';
	JButton start,btO,btX;
	JLabel lb;
	Color containerColor;	
	Font fn,fn2;
	Container cn;
	Graphics g;
	
	public void init()
	{
		cn=getContentPane();
		cn.setLayout(null);
		g=getGraphics();
		
		fn=new Font("Arial",Font.PLAIN,100);
		fn2=new Font("Arial",Font.PLAIN,50);
		
		containerColor=new Color(238,238,238);
		
		lb=new JLabel("Select Who Draw First?");
		lb.setBounds(110,0,290,25);
		
		start=new JButton("Restart");
		start.setBounds(75,10,200,30);
		start.setBackground(Color.GREEN);
		btO=new JButton("O");
		btO.setBounds(100,30,50,25);
		btX=new JButton("X");
		btX.setBounds(200,30,50,25);
		btO.setBackground(Color.PINK);
		btX.setBackground(Color.ORANGE);
		start.setVisible(false);
		g.setColor(Color.BLACK);
		
		for(i=0;i<3;i++)
		for(j=0;j<3;j++)
		rc[i][j]=5;
		
		cn.add(start);
		cn.add(btO);
		cn.add(btX);
		cn.add(lb);
		cn.addMouseListener(this);
		start.addMouseListener(this);
		btX.addMouseListener(this);
		btO.addMouseListener(this);
	}
	
	public void win()
	{
		/*Checking Rows*/
		
		if((rc[0][0]==0&&rc[0][1]==0&&rc[0][2]==0)||(rc[0][0]==1&&rc[0][1]==1&&rc[0][2]==1)&&(chance==1||chance==0))
		{
			g.setColor(Color.BLUE);
			g.drawLine(24,99,325,99);
			g.drawLine(25,100,325,100);
			g.drawLine(26,101,325,101);
			g.setFont(fn2);
			if(chance==1)
			g.drawString("O Win",100,200);
			if(chance==0)
			g.drawString("X Win",100,200);
			chance=5;
		}
		
		if((rc[1][0]==0&&rc[1][1]==0&&rc[1][2]==0)||(rc[1][0]==1&&rc[1][1]==1&&rc[1][2]==1)&&(chance==1||chance==0))
		{
			g.setColor(Color.BLUE);
			g.drawLine(24,199,325,199);
			g.drawLine(25,200,325,200);
			g.drawLine(26,201,325,201);
			g.setFont(fn2);
			if(chance==1)
			g.drawString("O Win",100,200);
			if(chance==0)
			g.drawString("X Win",100,200);
			chance=5;
		}
		
		if((rc[2][0]==0&&rc[2][1]==0&&rc[2][2]==0)||(rc[2][0]==1&&rc[2][1]==1&&rc[2][2]==1)&&(chance==1||chance==0))
		{
			g.setColor(Color.BLUE);
			g.drawLine(24,299,325,299);
			g.drawLine(25,300,325,300);
			g.drawLine(26,301,325,301);
			g.setFont(fn2);
			if(chance==1)
			g.drawString("O Win",100,200);
			if(chance==0)
			g.drawString("X Win",100,200);
			chance=5;
		}
		
		
		/*Checking Columns*/
		
		if((rc[0][0]==0&&rc[1][0]==0&&rc[2][0]==0)||(rc[0][0]==1&&rc[1][0]==1&&rc[2][0]==1)&&(chance==1||chance==0))
		{
			g.setColor(Color.BLUE);
			g.drawLine(74,50,74,350);
			g.drawLine(75,50,75,350);
			g.drawLine(76,50,76,350);
			g.setFont(fn2);
			if(chance==1)
			g.drawString("O Win",100,200);
			if(chance==0)
			g.drawString("X Win",100,200);
			chance=5;
		}
		
		if((rc[0][1]==0&&rc[1][1]==0&&rc[2][1]==0)||(rc[0][1]==1&&rc[1][1]==1&&rc[2][1]==1)&&(chance==1||chance==0))
		{
			g.setColor(Color.BLUE);
			g.drawLine(174,50,174,350);
			g.drawLine(175,50,175,350);
			g.drawLine(176,50,176,350);
			g.setFont(fn2);
			if(chance==1)
			g.drawString("O Win",100,200);
			if(chance==0)
			g.drawString("X Win",100,200);
			chance=5;
		}
		
		if((rc[0][2]==0&&rc[1][2]==0&&rc[2][2]==0)||(rc[0][2]==1&&rc[1][2]==1&&rc[2][2]==1)&&(chance==1||chance==0))
		{
			g.setColor(Color.BLUE);
			g.drawLine(274,50,274,350);
			g.drawLine(275,50,275,350);
			g.drawLine(276,50,276,350);
			g.setFont(fn2);
			if(chance==1)
			g.drawString("O Win",100,200);
			if(chance==0)
			g.drawString("X Win",100,200);
			chance=5;
		}
		
		if((rc[0][0]==0&&rc[1][1]==0&&rc[2][2]==0)||(rc[0][0]==1&&rc[1][1]==1&&rc[2][2]==1)&&(chance==1||chance==0))
		{
			g.setColor(Color.BLUE);
			g.drawLine(25,49,325,349);
			g.drawLine(25,50,325,350);
			g.drawLine(25,51,325,351);
			g.setFont(fn2);
			if(chance==1)
			g.drawString("O Win",100,200);
			if(chance==0)
			g.drawString("X Win",100,200);
			chance=5;
		}
		
		if((rc[0][2]==0&&rc[1][1]==0&&rc[2][0]==0)||(rc[0][2]==1&&rc[1][1]==1&&rc[2][0]==1)&&(chance==1||chance==0))
		{
			g.setColor(Color.BLUE);
			g.drawLine(25,349,325,49);
			g.drawLine(25,350,325,50);
			g.drawLine(25,351,325,51);
			g.setFont(fn2);
			if(chance==1)
			g.drawString("O Win",100,200);
			if(chance==0)
			g.drawString("X Win",100,200);
			chance=5;
		}
	}
	
	public void restart()
	{
		g.setColor(containerColor);
		g.fillRect(25,50,325,350);
		for(i=0;i<3;i++)
		for(j=0;j<3;j++)
		rc[i][j]=5;
		
		g.setColor(Color.RED);
		
		g.drawLine(123,48,123,348);		//left verticle line
		g.drawLine(124,49,124,349);
		g.drawLine(125,50,125,350);
		
		g.drawLine(223,48,223,348);		//right verticle line
		g.drawLine(224,49,224,349);
		g.drawLine(225,50,225,350);
		
		g.drawLine(25,148,323,148);		//top horizontal line
		g.drawLine(26,149,324,149);
		g.drawLine(27,150,325,150);
			
		g.drawLine(25,248,323,248);		//bottom horizontal line
		g.drawLine(26,249,324,249);
		g.drawLine(27,250,325,250);
	}
	
	public void mousePressed(MouseEvent me)
	{
		if(me.getSource()==btO)
		{
			chance=0;
			btO.setVisible(false);
			btX.setVisible(false);
			lb.setVisible(false);
			start.setVisible(true);
			restart();
			
		}
		
		if(me.getSource()==btX)
		{
			chance=1;
			btO.setVisible(false);
			btX.setVisible(false);
			lb.setVisible(false);
			start.setVisible(true);
			restart();
		}
		
		if(me.getSource()==start)
		{
			start.setVisible(false);
			btO.setVisible(true);
			btX.setVisible(true);
			lb.setVisible(true);
			chance=5;
		}
	}
	
	public void mouseClicked(MouseEvent me)
	{
		int x=me.getX();
		int y=me.getY();
		
		
		/*First Three Columns*/
		if(me.getSource()==cn&&x>25&&x<123&&y>50&&y<123&&me.getModifiers()==16&&chance==0&&rc[0][0]==5)
		{
				chance=1;
				rc[0][0]=0;
				g.setColor(Color.BLACK);
				g.setFont(fn);
				g.drawString(""+O,40,135);
		}
		
		if(me.getSource()==cn&&x>25&&x<123&&y>50&&y<123&&me.getModifiers()==4&&chance==1&&rc[0][0]==5)
		{
				chance=0;
				rc[0][0]=1;
				g.setColor(Color.BLACK);
				g.setFont(fn);
				g.drawString(""+X,40,135);
		}
		
		if(me.getSource()==cn&&x>125&&x<223&&y>50&&y<123&&me.getModifiers()==16&&chance==0&&rc[0][1]==5)
		{
				chance=1;
				rc[0][1]=0;
				g.setColor(Color.BLACK);
				g.setFont(fn);
				g.drawString(""+O,140,135);
		}
		
		if(me.getSource()==cn&&x>125&&x<223&&y>50&&y<123&&me.getModifiers()==4&&chance==1&&rc[0][1]==5)
		{
				chance=0;
				rc[0][1]=1;
				g.setColor(Color.BLACK);
				g.setFont(fn);
				g.drawString(""+X,140,135);
		}
		
		if(me.getSource()==cn&&x>225&&x<323&&y>50&&y<123&&me.getModifiers()==16&&chance==0&&rc[0][2]==5)
		{
				chance=1;
				rc[0][2]=0;
				g.setColor(Color.BLACK);
				g.setFont(fn);
				g.drawString(""+O,240,135);
		}
		
		if(me.getSource()==cn&&x>225&&x<323&&y>50&&y<123&&me.getModifiers()==4&&chance==1&&rc[0][2]==5)
		{
				chance=0;
				rc[0][2]=1;
				g.setColor(Color.BLACK);
				g.setFont(fn);
				g.drawString(""+X,240,135);
		}
		
		
		
		/*Second Three Columns*/
		
		
		if(me.getSource()==cn&&x>25&&x<123&&y>150&&y<223&&me.getModifiers()==16&&chance==0&&rc[1][0]==5)
		{
				chance=1;
				rc[1][0]=0;
				g.setColor(Color.BLACK);
				g.setFont(fn);
				g.drawString(""+O,40,235);
		}
		
		if(me.getSource()==cn&&x>25&&x<123&&y>150&&y<223&&me.getModifiers()==4&&chance==1&&rc[1][0]==5)
		{
				chance=0;
				rc[1][0]=1;
				g.setColor(Color.BLACK);
				g.setFont(fn);
				g.drawString(""+X,40,235);
		}
		
		if(me.getSource()==cn&&x>125&&x<223&&y>150&&y<223&&me.getModifiers()==16&&chance==0&&rc[1][1]==5)
		{
				chance=1;
				rc[1][1]=0;
				g.setColor(Color.BLACK);
				g.setFont(fn);
				g.drawString(""+O,140,235);
		}
		
		if(me.getSource()==cn&&x>125&&x<223&&y>150&&y<223&&me.getModifiers()==4&&chance==1&&rc[1][1]==5)
		{
				chance=0;
				rc[1][1]=1;
				g.setColor(Color.BLACK);
				g.setFont(fn);
				g.drawString(""+X,140,235);
		}
		
		if(me.getSource()==cn&&x>225&&x<323&&y>150&&y<223&&me.getModifiers()==16&&chance==0&&rc[1][2]==5)
		{
				chance=1;
				rc[1][2]=0;
				g.setColor(Color.BLACK);
				g.setFont(fn);
				g.drawString(""+O,240,235);
		}
		
		if(me.getSource()==cn&&x>225&&x<323&&y>150&&y<223&&me.getModifiers()==4&&chance==1&&rc[1][2]==5)
		{
				chance=0;
				rc[1][2]=1;
				g.setColor(Color.BLACK);
				g.setFont(fn);
				g.drawString(""+X,240,235);
		}
		
		
		/*Third Three Columns*/
		
		
		if(me.getSource()==cn&&x>25&&x<123&&y>250&&y<323&&me.getModifiers()==16&&chance==0&&rc[2][0]==5)
		{
				chance=1;
				rc[2][0]=0;
				g.setColor(Color.BLACK);
				g.setFont(fn);
				g.drawString(""+O,40,335);
		}
		
		if(me.getSource()==cn&&x>25&&x<123&&y>250&&y<323&&me.getModifiers()==4&&chance==1&&rc[2][0]==5)
		{
				chance=0;
				rc[2][0]=1;
				g.setColor(Color.BLACK);
				g.setFont(fn);
				g.drawString(""+X,40,335);
		}
		
		if(me.getSource()==cn&&x>125&&x<223&&y>250&&y<323&&me.getModifiers()==16&&chance==0&&rc[2][1]==5)
		{
				chance=1;
				rc[2][1]=0;
				g.setColor(Color.BLACK);
				g.setFont(fn);
				g.drawString(""+O,140,335);
		}
		
		if(me.getSource()==cn&&x>125&&x<223&&y>250&&y<323&&me.getModifiers()==4&&chance==1&&rc[2][1]==5)
		{
				chance=0;
				rc[2][1]=1;
				g.setColor(Color.BLACK);
				g.setFont(fn);
				g.drawString(""+X,140,335);
		}
		
		if(me.getSource()==cn&&x>225&&x<323&&y>250&&y<323&&me.getModifiers()==16&&chance==0&&rc[2][2]==5)
		{
				chance=1;
				rc[2][2]=0;
				g.setColor(Color.BLACK);
				g.setFont(fn);
				g.drawString(""+O,240,335);
		}
		
		if(me.getSource()==cn&&x>225&&x<323&&y>250&&y<323&&me.getModifiers()==4&&chance==1&&rc[2][2]==5)
		{
				chance=0;
				rc[2][2]=1;
				g.setColor(Color.BLACK);
				g.setFont(fn);
				g.drawString(""+X,240,335);
		}
		
		win();
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