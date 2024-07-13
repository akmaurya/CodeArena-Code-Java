package com.xcode.javas.zedsoftware.swing.salecart;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

class SaleCart extends JFrame implements ActionListener, MouseListener
{
	static int i=0;
	String row[]=new String[5];
	JComboBox comboBox;
    JLabel Electronics,Vehicals,Clothes,Quantity;
    JTextField tfQuantity;
    JButton btAdd,btDelete;
    JMenuItem m1it1,m1it2,m1it3,m1it4,m1it5,m2it1,m2it2,m2it3,m2it4,m2it5,m3it1,m3it2,m3it3,m3it4,m3it5,delete,update;
    JMenu m1,m2,m3,m4,m5,m6,m7,m8,m9;
    JPopupMenu electronicsPopupMenu, electronicsMenu,vehicalsMenu,clothesMenu,editItem;
    JTable t;
    DefaultTableModel dtm;
    Container cn;
    Color limesky=new Color(133,216,216);
    Color slate=new Color(200,200,200);

    public static void main(String args[])
    {
        SaleCart frame=new SaleCart();
        frame.setSize(900,700);
        frame.setVisible(true);
    };

    public SaleCart()
    {
        cn=getContentPane();
        cn.setLayout(null);
        Electronics =new JLabel("  Electronics    >");
        Electronics.setBounds(20,20,100,30);
        Electronics.setOpaque(true);
        Electronics.setBackground(slate);
        cn.add(Electronics);
        	Vehicals =new JLabel("  Vehicals         >");
	        Vehicals.setBounds(20,50,100,30);
	        Vehicals.setOpaque(true);
	        Vehicals.setBackground(slate);
	        cn.add(Vehicals);
	        	Clothes =new JLabel("  Clothes           >");
		        Clothes.setBounds(20,80,100,30);
		        Clothes.setOpaque(true);
		        Clothes.setBackground(slate);
		        cn.add(Clothes);

		electronicsPopupMenu=new JPopupMenu();
			m1=new JMenu("Mobile");
			m2=new JMenu("Laptops & Tabs");
			m3=new JMenu("Mobile Laptops & Tabs Accessories");
			m4=new JMenu("Telivision");

				electronicsPopupMenu.add(m1);

					m1it1=new JMenuItem("Karbonn-5999");
					m1it2=new JMenuItem("Samsung-9990");
					m1it3=new JMenuItem("Nokia-12990");
					m1it4=new JMenuItem("MotoG-6990");
					m1it5=new JMenuItem("Micromax-6999");
						m1.add(m1it1);
						m1.add(m1it2);
						m1.add(m1it3);
						m1.add(m1it4);
						m1.add(m1it5);

				electronicsPopupMenu.add(m2);

					m2it1=new JMenuItem("HCL Tablet-5990");
					m2it2=new JMenuItem("Samsung Tablet-9990");
					m2it3=new JMenuItem("Vaio Laptop-43990");
					m2it4=new JMenuItem("Dell Laptop-31099");
					m2it5=new JMenuItem("Micromax Tablet-6999");
						m2.add(m2it1);
						m2.add(m2it2);
						m2.add(m2it3);
						m2.add(m2it4);
						m2.add(m2it5);

				electronicsPopupMenu.add(m3);

					m3it1=new JMenuItem("Sony-80990");
					m3it2=new JMenuItem("Samsung-63090");
					m3it3=new JMenuItem("Bravo-43990");
					m3it4=new JMenuItem("Videocon-35999");
					m3it5=new JMenuItem("Sansui-38000");
						m3.add(m3it1);
						m3.add(m3it2);
						m3.add(m3it3);
						m3.add(m3it4);
						m3.add(m3it5);


		vehicalsMenu=new JPopupMenu();
			m1=new JMenu("2 Wheeler");
			m2=new JMenu("3 Wheeler");
			m3=new JMenu("4 Wheeler");

				vehicalsMenu.add(m1);

					m1it1=new JMenuItem("Honda Passion-51000");
					m1it2=new JMenuItem("Discover-48990");
					m1it3=new JMenuItem("Hero Honda Splender-50000");
					m1it4=new JMenuItem("Bajaj-40000");
					m1it5=new JMenuItem("Bullet-70000");
						m1.add(m1it1);
						m1.add(m1it2);
						m1.add(m1it3);
						m1.add(m1it4);
						m1.add(m1it5);

				vehicalsMenu.add(m2);

					m2it1=new JMenuItem("Mahindra-5990");
					m2it2=new JMenuItem("Piagio-9990");
					m2it3=new JMenuItem("Vaio Laptop-43990");
					m2it4=new JMenuItem("Dell Laptop-31099");
					m2it5=new JMenuItem("Micromax Tablet-6999");
						m2.add(m2it1);
						m2.add(m2it2);
						m2.add(m2it3);
						m2.add(m2it4);
						m2.add(m2it5);

				vehicalsMenu.add(m3);

					m3it1=new JMenuItem("Sony-80990");
					m3it2=new JMenuItem("Samsung-63090");
					m3it3=new JMenuItem("Bravo-43990");
					m3it4=new JMenuItem("Videocon-35999");
					m3it5=new JMenuItem("Sansui-38000");
						m3.add(m3it1);
						m3.add(m3it2);
						m3.add(m3it3);
						m3.add(m3it4);
						m3.add(m3it5);


		comboBox=new JComboBox();
		comboBox.setBounds(300,20,300,30);
		comboBox.addItem("Karbonn-5999");
		comboBox.addItem("Samsung-9990");
		comboBox.addItem("HCL Tablet-6999");
		comboBox.addItem("Nokia-12990");
		comboBox.addItem("MotoG-6990");
		comboBox.addItem("Vaio Laptop-43990");
		comboBox.addItem("Samsung Tablet-9990");
		comboBox.addItem("Dell Laptop-31099");
		comboBox.addItem("Micromax Tablet-5990");
		comboBox.addItem("Sony TV-80990");
		comboBox.addItem("Samsung TV-63090");
		comboBox.addItem("Bravo-43990");
		comboBox.addItem("Videocon-35999");
		comboBox.addItem("Honda Passion-51000");
		comboBox.addItem("Discover-48990");
		comboBox.addItem("Hero Splender-50000");
		comboBox.addItem("Bajaj-40000");
		comboBox.addItem("Bullet-70000");
		cn.add(comboBox);


		Quantity=new JLabel("  Quantity");
		Quantity.setBounds(300,70,70,30);
		Quantity.setOpaque(true);
		Quantity.setBackground(limesky);
		cn.add(Quantity);


		tfQuantity=new JTextField();
		tfQuantity.setBounds(400,70,100,30);
		cn.add(tfQuantity);


		btAdd=new JButton("Add to Cart");
		btAdd.setBounds(400,130,100,30);
		cn.add(btAdd);

		btDelete=new JButton("Delete Selected");
		btDelete.setBounds(520,130,100,30);
		cn.add(btDelete);


		editItem=new JPopupMenu();
		delete=new JMenuItem("Delete");
		update=new JMenuItem("Update");
		editItem.add(delete);
		editItem.add(update);




/*Tabl*/String H[]={"SN","Item Name","Quantity","Rate","Amount"};
		dtm=new DefaultTableModel(H,0);
		t=new JTable(dtm);
			JScrollPane pane=new JScrollPane(t);
			pane.setBounds(20,300,700,300);
			cn.add(pane);

/*Lsnr*/cn.addMouseListener(this);
		Electronics.addMouseListener(this);
		Vehicals.addMouseListener(this);
		Clothes.addMouseListener(this);
		comboBox.addMouseListener(this);
		btAdd.addActionListener(this);
		btDelete.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae)
    {
    	if(ae.getSource()==btDelete)
    	{
    		int conferm=JOptionPane.showConfirmDialog(cn,"Are you sure you want to delete selected item?");

    	}

    	if(ae.getSource()==btAdd)
    	{
    		String splitString[]=(""+comboBox.getSelectedItem()).split("-");
    		//System.out.print("\n\n"+splitString[0]+"\n"+splitString[1]);
    		i=dtm.getRowCount();
    		int rate=Integer.parseInt(splitString[1]);
    		int qty=Integer.parseInt(tfQuantity.getText());
    		row[0]=""+(++i);
    		row[1]=splitString[0];
    		row[2]=""+qty;
    		row[3]=""+rate;
    		row[4]=""+rate*qty;
    		dtm.addRow(row);
    	}
    }

    public void mousePressed(MouseEvent me)
    {

    }
    public void mouseClicked(MouseEvent me)
    {
    	if((me.getSource()==Quantity))
    	{
    		editItem.show(this,me.getX(),me.getY());
    	}
    }
    public void mouseReleased(MouseEvent me)
    {

    }
    public void mouseEntered(MouseEvent me)
    {
    	if(me.getSource()==Electronics)
    	{
    		Electronics.setBackground(limesky);
    		Vehicals.setBackground(slate);
    		Clothes.setBackground(slate);
    		electronicsPopupMenu.show(this,130,50);
       	}

    	if(me.getSource()==Vehicals)
    	{
    		Vehicals.setBackground(limesky);
    		Electronics.setBackground(slate);
    		Clothes.setBackground(slate);
    		vehicalsMenu.show(this,130,80);

    	}

    	if(me.getSource()==Clothes)
    	{
    		Clothes.setBackground(limesky);
    		Vehicals.setBackground(slate);
    		Electronics.setBackground(slate);
    		//clothesMenu.show(this,130,50);
    	}



    }
    public void mouseExited(MouseEvent me)
    {

    }


};
