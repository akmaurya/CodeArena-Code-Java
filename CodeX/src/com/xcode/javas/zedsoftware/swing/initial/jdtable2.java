package com.xcode.javas.zedsoftware.swing.initial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

class jdtable1 extends JFrame implements MouseListener,KeyListener
{
	JScrollPane pane;
	JToggleButton jb1;
	JMenuItem it,it1;
	JPopupMenu pm;
	JTextField tf,tf1;
	JComboBox cb;
	String arr[]=new String [4];
	JLabel jl,jl1,jl2,jl3,jl4;
	DefaultTableModel dtm;
	double total=0;
	JTable  tab;
	int i;
	
	Graphics g;
	public static void main(String args[])
	{
		jdtable1 frm=new jdtable1();
		frm.setSize(1000,1000);
		frm.setVisible(true);

	}
	public jdtable1()
	{
		super("Invoice System");
		Container cn=getContentPane();
		cn.setLayout(null);
		cb=new JComboBox();
		pm=new JPopupMenu();
		g=getGraphics();
		it=new JMenuItem("Delete");
		it1=new JMenuItem("Update");
		cb.addItem("Laptop");
		cb.addItem("Mobile");
		cb.addItem("Softwere");
		cb.addItem("Desktop");
		cb.addItem("TV");
		cb.addItem("Accessories");
		jb1=new JToggleButton("Add");
		jl=new JLabel("Item name");
		jl1=new JLabel("Rate");
		jl2=new JLabel("Quantity");
		jl3=new JLabel("Total in $");
		tf=new JTextField();
		tf1=new JTextField();
		jl4=new JLabel();
		cn.setBackground(Color.white);

		String[] colHeads = { "Itemname", "rate", "quantity","amount"};
		 dtm=new DefaultTableModel(colHeads,0);
		tab=new JTable(dtm);
		pane =new JScrollPane(tab,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jl.setBounds(0,0,100,30);
		tab.setBackground(Color.white);
		Font f=new Font("San Serif",Font.BOLD,18);
		cb.setBounds(100,0,150,30);
		jl1.setBounds(0,40,100,30);
		tf.setBounds(100,40,150,30);
		jl2.setBounds(0,80,100,30);
		tf1.setBounds(100,80,150,30);
		jb1.setBounds(60,120,100,30);
		pane.setBounds(10,210,500,400);
		jl3.setBounds(50,630,100,40);
		jl4.setBounds(160,630,100,40);
		Color cl=new Color(128,255,255);
		jb1.setBackground(cl);
		jl.setFont(f);
		jl1.setFont(f);
		jl2.setFont(f);
		jl3.setFont(f);
		jl4.setFont(f);
		tab.setFont(f);
		pm.add(it);
		pm.add(it1);
		cn.add(pane);	
		cn.add(jb1);
		cn.add(tf);
		cn.add(tf1);
		cn.add(jl4);
		cn.add(cb);
		cn.add(jl);
		cn.add(jl1);
		cn.add(jl2);
		cn.add(jl3);
		jb1.addMouseListener(this);
		tab.addMouseListener(this);
		it.addMouseListener(this);
		it1.addMouseListener(this);
		jb1.addKeyListener(this);
		tab.addKeyListener(this);
	}
	public void mousePressed(MouseEvent ae)
	{
		if(ae.getSource()==jb1&&jb1.getText().equals("Add"))
		{
			arr[0]=cb.getSelectedItem()+"";
			arr[1]=tf.getText()+"";
			arr[2]=tf1.getText()+"";
			double amt=Double.valueOf(arr[1])*Double.valueOf(arr[2]);
			arr[3]=""+amt;
			dtm.addRow(arr);
			total=total+amt;
			jl4.setText(total+"");		
		}
		else if(ae.getSource()==tab&&ae.getModifiers()==4)
		{
			pm.show(this,ae.getX(),ae.getY()+210);

		}
		else if(ae.getSource()==it)
		{
			JOptionPane.showConfirmDialog(pm,"are you sure to delete this row","invoice",JOptionPane.WARNING_MESSAGE);
			int i=tab.getSelectedRow();
			String str=tab.getValueAt(i,3)+"";
			total=total-Double.valueOf(str);
			jl4.setText(total+"");
			dtm.removeRow(i);
		}
		else if(ae.getSource()==it1)
		{
			jb1.setText("Update");
		}
	 	else if(ae.getSource()==jb1&&jb1.getText().equals("Update"))
		{
			i=tab.getSelectedRow();
		    arr[3]=tab.getValueAt(i,3)+"";
		    total=total-Double.valueOf(arr[3]);
		    arr[1]=tab.getValueAt(i,1)+"";
			arr[2]=tab.getValueAt(i,2)+"";
			double amt=Double.valueOf(arr[1])*Double.valueOf(arr[2]);
			total=total+amt;
			arr[3]=""+amt;
			tab.setValueAt(arr[3],i,3);
			jl4.setText(total+"");
			tf.setText(arr[1]+"");
			tf1.setText(arr[2]+"");

		}
		
		
	}	
	public void mouseExited(MouseEvent me){}
	public void mouseEntered(MouseEvent me){}
	public void mouseReleased(MouseEvent me)
	{
	}
	public void mouseClicked(MouseEvent me){}
	public void keyPressed(KeyEvent ke)
	{

		if(ke.getKeyCode()==ke.VK_ESCAPE&&ke.getSource()==tab)
		{
			jb1.requestFocus();
			jb1.setText("Add");
		}
	}
	public void keyReleased(KeyEvent ke){}
	public void keyTyped(KeyEvent ke){}
}