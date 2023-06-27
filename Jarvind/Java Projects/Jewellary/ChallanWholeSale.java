import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.math.*;
import javax.swing.table.*;
import java.io.*;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import javax.swing.event.InternalFrameListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.TableModelListener ;
import javax.swing.event.TableModelEvent;
public class ChallanWholeSale extends JFrame implements ActionListener,MouseListener,KeyListener,FocusListener,InternalFrameListener,TableModelListener
{
	Container con;
	JInternalFrame frm;
	JButton addBtn,deleteBtn,exitBtn,resetBtn;
	static JComboBox categoryCb,partyCb,itemCb,categoryCb1,itemCb1;
	JComboBox gmOrBhari;
	JTextField openTf,tounchTf,pieceTf,dateTf,openTf1,tounchTf1,pieceTf1;//openTf->for gross wt.
	JLabel fineWtLb,fineWtLb1;
	DefaultTableModel dtm,dtm1;
	JTable grid,grid1;
	JLabel totalPurWtL,totalPurFineWtL;
	JLabel lastBal1L,lastBal2L,lastBal3L,lastBal4L;
	JLabel curBal1L,curBal2L,curBal3L,curBal4L;
	JLabel totalPurWtL1,totalPurFineWtL1;
	JTextField curRateTf,adjustmentWtTf,adjustmentAmtTf,depositeTf;
	JToggleButton adjustTb,pendingTb;
	JLabel depositeTb;
	JButton addNewBtn,updateBtn,addNewBtn1,updateBtn1,depositeBtn,newPartyBtn,newCategoryBtn,newItemBtn,nextBillBtn,preBillBtn,newCategoryBtn1,newItemBtn1,printBtn;
	int flag=0;
	double curBalance=0;
	JDesktopPane desk;
	JLabel billNoLb,drCrLb,drCrLb1,lastTounchLb,lastTounchLb1;
	boolean updateFlag=false;
	JComboBox drCrCb;
	double flag1=0.0,flag3=0.0;
	double flag2=0,flag4=0;
	double flag5=0,flag6=0,flag7=0,flag8=0;
	JLabel lab21,lab22,lab9,lab10;
	boolean newRowFlag=true;
	boolean errorInTableFlag=false;
	//new components
	JLabel totalAmountL,totalSilverFineWtL;
	JLabel totalAmountL1,totalSilverFineWtL1;
	JTextField discounttf;
	JLabel totalPaybleAmtL,vatAmtL,netPaybleAmtL;
	JButton dateBtn;	
	JPopupMenu pm,pm1;
	JMenuItem deletePM,deletePM1;

	public ChallanWholeSale(JDesktopPane desk,int billno)
	{
		this.desk=desk;
		frm=new JInternalFrame("Make Challan # Wholesale",false,true,false,true);
		con=frm.getContentPane();
		con.setLayout(null);


		JLabel lab1=new JLabel("Category");
		JLabel lab2=new JLabel("Item Name");
		JLabel lab3=new JLabel("Gross Wt.(In gm)");
		JLabel lab4=new JLabel("Tounch");
		JLabel lab5=new JLabel("Fine Wt.(In gm)");
		JLabel lab6=new JLabel("No. Of Piece(s)");
		JLabel lab7=new JLabel("Date");
		JLabel lab8=new JLabel("Party Name");
		lab9=new JLabel("Old Balance Wt.(gm)");
		lab10=new JLabel("Closing Balance Wt.(gm)");
		JLabel lab11=new JLabel("Category");
		JLabel lab12=new JLabel("Item Name");
		JLabel lab13=new JLabel("Gross Wt.(In gm)");
		JLabel lab14=new JLabel("Tounch");
		JLabel lab15=new JLabel("Fine Wt.(In gm)");
		JLabel lab16=new JLabel("No. Of Piece(s)");
		JLabel lab17=new JLabel("Calculate Weight As :");
		JLabel lab18=new JLabel("Rate",JLabel.CENTER);
		JLabel lab19=new JLabel("Weight",JLabel.CENTER);
		JLabel lab20=new JLabel("Amount",JLabel.CENTER);
		 lab21=new JLabel("Old Balance (Rs.)",JLabel.RIGHT);
		 lab22=new JLabel("Closing Balance (Rs.)",JLabel.RIGHT);
		JLabel lab23=new JLabel("Challan No.",JLabel.RIGHT);
		drCrLb=new JLabel("Dr");
		drCrLb1=new JLabel("Dr");
		lastTounchLb=new JLabel("0");
		lastTounchLb1=new JLabel("0");
		drCrCb=new JComboBox();
		partyCb=new JComboBox();
		dateTf=new JTextField();
		dateBtn=new JButton(new ImageIcon("calender.gif"));
		categoryCb=new JComboBox();
		itemCb=new JComboBox();
		openTf=new JTextField();
		tounchTf=new JTextField();
		fineWtLb=new JLabel("",JLabel.RIGHT);
		pieceTf=new JTextField();
		categoryCb1=new JComboBox();
		itemCb1=new JComboBox();
		openTf1=new JTextField();
		tounchTf1=new JTextField();
		fineWtLb1=new JLabel("",JLabel.RIGHT);
		pieceTf1=new JTextField();
		addBtn=new JButton("Save");
		deleteBtn=new JButton("Delete");
		exitBtn=new JButton("Close");
		resetBtn=new JButton("Reset");
		String heading[]={"Item Category","Item Name","Gross Wt.","Stone Wt.","Stone Rate","Net Wt.","Tounch","Wastage","Rate","Making Charge","Amount","Gold Fine Wt.","Silver Fine Wt."};
		dtm=new MyDefaultTableModel(heading,10);//DefaultTableModel(heading,0);
		grid=new JTable(dtm);
		JScrollPane jsp=new JScrollPane(grid);
		String blankrow[]=new String[12];
		dtm.addRow(blankrow);
		String list[]=getCategoryName();
		setComboBoxInCell(grid,0,list);
		System.out.println(grid.getRowCount());
		//String list1[]=getItemName();
		//setComboBoxInCell(grid,1,list1);

		totalPurWtL=new JLabel("03",JLabel.LEFT);
		totalPurFineWtL=new JLabel("04",JLabel.LEFT);
		totalAmountL=new JLabel("0",JLabel.RIGHT);
		totalSilverFineWtL=new JLabel("0",JLabel.RIGHT);
		int r=grid.getRowCount();
		System.out.println("row="+r);

		lastBal1L=new JLabel("0a",JLabel.RIGHT);
		lastBal2L=new JLabel("0b",JLabel.RIGHT);
		lastBal3L=new JLabel("0c",JLabel.RIGHT);//RIGHT
		lastBal4L=new JLabel("0d",JLabel.RIGHT);
		curBal1L=new JLabel("0e",JLabel.RIGHT);
		curBal2L=new JLabel("0f",JLabel.RIGHT);
		curBal3L=new JLabel("0g",JLabel.RIGHT);
		curBal4L=new JLabel("0h",JLabel.RIGHT);


		//String heading1[]={"Category Name","Item Name","Weight","Tounch","Pieces","Fine Wt."};
		String heading1[]={"Item Category","Item Name","Gross Wt.","Stone Wt.","Stone Rate","Net Wt.","Tounch","Wastage","Rate","Making Charge","Amount","Gold Fine Wt.","Silver Fine Wt."};
		dtm1=new MyDefaultTableModel(heading1,10);
		grid1=new JTable(dtm1);
		JScrollPane jsp1=new JScrollPane(grid1);
		//String blankrow[]=new String[12];
		dtm1.addRow(blankrow);
		//String list[]=getCategoryName();
		setComboBoxInCell(grid1,0,list);

		totalPurWtL1=new JLabel("0",JLabel.RIGHT);
		totalPurFineWtL1=new JLabel("0",JLabel.RIGHT);
		totalAmountL1=new JLabel("0",JLabel.RIGHT);
		totalSilverFineWtL1=new JLabel("0",JLabel.RIGHT);
		gmOrBhari=new JComboBox();
		curRateTf=new JTextField();
		adjustmentWtTf=new JTextField();
		adjustmentAmtTf=new JTextField();
		adjustTb=new JToggleButton("Adjust");
		depositeTb=new JLabel("Any Deposite Amt.");
		pendingTb=new JToggleButton("Pending");
		addNewBtn=new JButton(new ImageIcon("images/closeFile.gif"));
		updateBtn=new JButton(new ImageIcon("images/edit.gif"));
		addNewBtn1=new JButton(new ImageIcon("images/closeFile.gif"));
		updateBtn1=new JButton(new ImageIcon("images/edit.gif"));
		depositeBtn=new JButton("OK");
		printBtn=new JButton("Print");
		depositeTf=new JTextField();
		newPartyBtn=new JButton(new ImageIcon("images/editor.gif"));
		newCategoryBtn=new JButton(new ImageIcon("images/editor.gif"));
		newItemBtn=new JButton(new ImageIcon("images/editor.gif"));
		nextBillBtn=new JButton(new ImageIcon("images/nextarrow.gif"));
		preBillBtn=new JButton(new ImageIcon("images/prevarrow.gif"));
		newCategoryBtn1=new JButton(new ImageIcon("images/editor.gif"));
		newItemBtn1=new JButton(new ImageIcon("images/editor.gif"));
		billNoLb=new JLabel("",JLabel.CENTER);
		lab8.setBounds(10,10,150,20);
		lab7.setBounds(500,10,150,25);
		lab23.setBounds(865,10,100,25);
		lab1.setBounds(10,45,150,20);
		lab2.setBounds(250,45,150,20);
		lab3.setBounds(490,45,150,20);
		lab4.setBounds(610,45,150,20);
		lab5.setBounds(735,45,100,20);
		lab6.setBounds(855,45,100,20);
		lab9.setBounds(10,230,200,20);//540,240,200,20);
		lab10.setBounds(10,470,200,20);
		lab11.setBounds(10,270,150,20);
		lab12.setBounds(250,270,150,20);
		lab13.setBounds(490,270,150,20);
		lab14.setBounds(610,270,150,20);
		lab15.setBounds(735,270,150,20);
		lab16.setBounds(855,270,150,20);
		lab17.setBounds(10,550,150,20);
		lab18.setBounds(270,530,150,20);
		lab19.setBounds(420,530,150,20);
		lab20.setBounds(570,530,150,20);
		lab21.setBounds(280,230,150,20);
		lab22.setBounds(280,470,150,20);
		drCrLb.setBounds(535,470,40,20);
		partyCb.setBounds(100,10,250,25);
		dateTf.setBounds(550,10,110,25);
		dateBtn.setBounds(665,10,25,25);
		categoryCb.setBounds(10,65,190,20);
		itemCb.setBounds(250,65,190,20);
		openTf.setBounds(490,65,100,20);
		tounchTf.setBounds(610,65,50,20);lastTounchLb.setBounds(665,65,50,20);
		fineWtLb.setBounds(735,65,100,20);
		pieceTf.setBounds(855,65,100,20);
		addNewBtn.setBounds(1000,60,40,25);
		updateBtn.setBounds(1050,60,40,25);
		totalPurWtL.setBounds(430,240,70,20);
		totalAmountL.setBounds(870,240,70,20);
		totalPurFineWtL.setBounds(960,240,70,20);
		totalSilverFineWtL.setBounds(1050,240,70,20);
		lastBal1L.setBounds(140,230,90,20);
		lastBal2L.setBounds(440,230,88,20);
		lastBal3L.setBounds(440,230,88,20);
		lastBal4L.setBounds(1022,240,88,20);
		curBal1L.setBounds(160,470,90,20);
		curBal2L.setBounds(842,500,88,20);
		curBal3L.setBounds(440,470,88,20);
		curBal4L.setBounds(1022,500,88,20);
		//down side objects
		categoryCb1.setBounds(10,290,190,20);
		itemCb1.setBounds(250,290,190,20);
		openTf1.setBounds(490,290,100,20);
		tounchTf1.setBounds(610,290,50,20);lastTounchLb1.setBounds(665,290,50,20);
		fineWtLb1.setBounds(735,290,100,20);
		pieceTf1.setBounds(855,290,100,20);
		addNewBtn1.setBounds(1000,285,40,25);
		updateBtn1.setBounds(1050,285,40,25);
		totalPurWtL1.setBounds(430,470,70,20);
		totalAmountL1.setBounds(870,470,70,20);
		totalPurFineWtL1.setBounds(960,470,70,20);
		totalSilverFineWtL1.setBounds(1050,470,70,20);
		gmOrBhari.setBounds(140,550,100,20);
		curRateTf.setBounds(270,550,150,20);
		adjustmentWtTf.setBounds(420,550,150,20);
		adjustmentAmtTf.setBounds(570,550,150,20);
		adjustTb.setBounds(740,550,120,20);
		pendingTb.setBounds(870,550,120,20);
		depositeBtn.setBounds(1000,590,120,20);
		billNoLb.setBounds(980,10,100,25);//1000,10,120,20);
		drCrLb1.setBounds(535,230,88,20);
		depositeTb.setBounds(10,550,120,25);
		depositeTf.setBounds(120,550,100,25);
		drCrCb.setBounds(220,550,40,25);

		//addBtn.setBounds(144,600,100,25);
		addBtn.setBounds(10,590,275,25);
		printBtn.setBounds(289,590,275,25);
		resetBtn.setBounds(568,590,275,25);
		exitBtn.setBounds(847,590,275,25);
		jsp.setBounds(10,70,1110,170);
		jsp1.setBounds(10,300,1110,170);

		newPartyBtn.setBounds(360,10,20,20);
		newCategoryBtn.setBounds(210,65,20,20);
		newItemBtn.setBounds(450,65,20,20);
		preBillBtn.setBounds(960,10,20,20);//750,10,20,20);
		nextBillBtn.setBounds(1080,10,20,20);//780,10,20,20);
		newCategoryBtn1.setBounds(210,290,20,20);
		newItemBtn1.setBounds(450,290,20,20);

		drCrLb.setText("Dr");
		drCrCb.addItem("");
		drCrCb.addItem("Dr");
		drCrCb.addItem("Cr");
		//drCrCb.setVisible(false);
		drCrLb.setForeground(Color.blue);
		categoryCb.setMaximumRowCount(5);
		openTf.setHorizontalAlignment(JTextField.RIGHT);
		tounchTf.setHorizontalAlignment(JTextField.RIGHT);
		pieceTf1.setHorizontalAlignment(JTextField.RIGHT);
		categoryCb1.setMaximumRowCount(5);
		openTf1.setHorizontalAlignment(JTextField.RIGHT);
		tounchTf1.setHorizontalAlignment(JTextField.RIGHT);
		pieceTf1.setHorizontalAlignment(JTextField.RIGHT);
		dateTf.setHorizontalAlignment(JTextField.CENTER);
		totalPurWtL.setHorizontalAlignment(JLabel.RIGHT);
		totalPurFineWtL.setHorizontalAlignment(JLabel.RIGHT);
		addBtn.setMnemonic('s');
		deleteBtn.setMnemonic('d');
		printBtn.setMnemonic('p');
		resetBtn.setMnemonic('r');
		exitBtn.setMnemonic('c');
		adjustTb.setMnemonic('a');
		pendingTb.setMnemonic('n');
		//depositeTb.setMnemonic('d');
		lastTounchLb.setOpaque(true);
		lastTounchLb.setForeground(new Color(255,0,0));
		lastTounchLb1.setForeground(new Color(255,0,0));
		billNoLb.setOpaque(true);
		billNoLb.setBackground(new Color(255,242,180));

		fineWtLb.setOpaque(true);
		fineWtLb1.setOpaque(true);
		fineWtLb.setBackground(new Color(123,255,219));
		fineWtLb1.setBackground(new Color(123,255,219));
		//table design
		DefaultTableCellRenderer CRLeft = new DefaultTableCellRenderer();
   		DefaultTableCellRenderer CRRight = new DefaultTableCellRenderer();
   		DefaultTableCellRenderer CRCenter = new DefaultTableCellRenderer();
   		CRLeft.setHorizontalAlignment(JLabel.LEFT);
      	CRRight.setHorizontalAlignment(JLabel.RIGHT);
   		CRCenter.setHorizontalAlignment(JLabel.CENTER);
   		//TableColumn column;
   		TableColumn tm = grid.getColumnModel().getColumn(5);
      	tm.setCellRenderer(new ColorColumnRenderer(new Color(254,233,218), Color.black));
      	tm = grid.getColumnModel().getColumn(10);
      	tm.setCellRenderer(new ColorColumnRenderer(new Color(253,254,218), Color.black));
   		tm = grid.getColumnModel().getColumn(11);
      	tm.setCellRenderer(new ColorColumnRenderer(new Color(230,254,218), Color.black));
   		tm = grid.getColumnModel().getColumn(12);
      	tm.setCellRenderer(new ColorColumnRenderer(new Color(218,242,254), Color.black));

   		tm = grid1.getColumnModel().getColumn(5);
      	tm.setCellRenderer(new ColorColumnRenderer(new Color(254,233,218), Color.black));
      	tm = grid1.getColumnModel().getColumn(10);
      	tm.setCellRenderer(new ColorColumnRenderer(new Color(253,254,218), Color.black));
   		tm = grid1.getColumnModel().getColumn(11);
      	tm.setCellRenderer(new ColorColumnRenderer(new Color(230,254,218), Color.black));
   		tm = grid1.getColumnModel().getColumn(12);
      	tm.setCellRenderer(new ColorColumnRenderer(new Color(218,242,254), Color.black));
   		/*column=grid.getColumn("Category Name");
   		column.setCellRenderer(CRLeft);
   		column.setPreferredWidth(300);
   		column=grid.getColumn("Item Name");
   		column.setCellRenderer(CRLeft);
   		column.setPreferredWidth(300);
   		column=grid.getColumn("Weight");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(100);
   		column=grid.getColumn("Tounch");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(100);
   		column=grid.getColumn("Pieces");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(100);
   		column=grid.getColumn("Fine Wt.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(100);*/
   		totalPurWtL.setOpaque(true);
   		totalAmountL.setOpaque(true);
   		totalPurFineWtL.setOpaque(true);
   		totalSilverFineWtL.setOpaque(true);
   		totalAmountL1.setOpaque(true);
   		totalSilverFineWtL1.setOpaque(true);
   		totalPurWtL.setBackground(new Color(254,233,218));
		totalAmountL.setBackground(new Color(253,254,218));
		totalPurFineWtL.setBackground(new Color(230,254,218));
		totalSilverFineWtL.setBackground(new Color(218,242,254));
		totalAmountL1.setBackground(new Color(253,254,218));
		totalSilverFineWtL1.setBackground(new Color(218,242,254));
		lastBal1L.setOpaque(true);
   		lastBal2L.setOpaque(true);
   		lastBal3L.setOpaque(true);
   		lastBal4L.setOpaque(true);
   		curBal1L.setOpaque(true);
   		curBal2L.setOpaque(true);
   		curBal3L.setOpaque(true);
   		curBal4L.setOpaque(true);
   		lastBal1L.setBackground(new Color(255,244,192));
		lastBal2L.setBackground(new Color(255,244,192));
		lastBal3L.setBackground(new Color(255,244,192));
		lastBal4L.setBackground(new Color(255,244,192));
		curBal1L.setBackground(new Color(213,229,255));
		curBal2L.setBackground(new Color(213,229,255));
		curBal3L.setBackground(new Color(213,229,255));
		curBal4L.setBackground(new Color(213,229,255));
		/*column=grid1.getColumn("Category Name");
   		column.setCellRenderer(CRLeft);
   		column.setPreferredWidth(300);
   		column=grid1.getColumn("Item Name");
   		column.setCellRenderer(CRLeft);
   		column.setPreferredWidth(300);
   		column=grid1.getColumn("Weight");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(100);
   		column=grid1.getColumn("Tounch");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(100);
   		column=grid1.getColumn("Pieces");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(100);
   		column=grid1.getColumn("Fine Wt.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(100);
		*/
		totalPurWtL1.setOpaque(true);
   		totalPurFineWtL1.setOpaque(true);
   		totalPurWtL1.setBackground(new Color(254,233,218));
		totalPurFineWtL1.setBackground(new Color(230,254,218));
		curRateTf.setHorizontalAlignment(JTextField.CENTER);
		adjustmentWtTf.setHorizontalAlignment(JTextField.CENTER);
		adjustmentAmtTf.setHorizontalAlignment(JTextField.CENTER);
		depositeTf.setHorizontalAlignment(JTextField.CENTER);
		gmOrBhari.addItem("Gram");
		gmOrBhari.addItem("Bhari");
		gmOrBhari.setSelectedIndex(1);
		newPartyBtn.setToolTipText("[F1] : To add new party");
		newCategoryBtn.setToolTipText("[F2] : To add new category");
		newItemBtn.setToolTipText("[F3] : To add new item");
		nextBillBtn.setToolTipText("[F12] : To show next bill");
		preBillBtn.setToolTipText("[F11] : To show previous bill");
		newCategoryBtn1.setToolTipText("[F4] : To add new category");
		newItemBtn1.setToolTipText("[F5] : To add new item");
		addNewBtn.setToolTipText("Click to add entered information.");
		updateBtn.setToolTipText("Click to update selected record");
		addNewBtn1.setToolTipText("Click to add entered information.");
		updateBtn1.setToolTipText("Click to update selected record");
		billNoLb.setBorder(new javax.swing.border.LineBorder(new Color(128,128,255),1));
		
		//adjustTb.setBorderPainted(false);
		//depositeTb.setBorderPainted(false);
		depositeTf.setBackground(Color.yellow);
		/*java.util.Date dt=new java.util.Date();
		String tmp=dt.getDate()+"/"+(dt.getMonth()+1)+"/"+(dt.getYear()+1900);
		dateTf.setText(tmp);
		*/
		java.util.Date dt=new java.util.Date();
        java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("dd/MM/yyyy");
        dateTf.setText(sdf.format(dt));
        
		//depositeTb.setSelected(true);

		/*con.add(lab1);
		con.add(lab2);
		con.add(lab3);
		con.add(lab4);
		con.add(lab5);
		con.add(lab6);
		*/
		con.add(lab7);
		con.add(lab8);
		con.add(lab23);
		/*con.add(lab9);
		con.add(lab10);
		con.add(lab11);
		con.add(lab12);
		con.add(lab13);
		con.add(lab14);
		con.add(lab15);
		con.add(lab16);
		con.add(lab17);
		con.add(lab18);
		con.add(lab19);
		con.add(lab20);
		con.add(lab21);
		con.add(lab22);
		*/
		con.add(partyCb);
		con.add(dateTf);
		con.add(dateBtn);
		//con.add(categoryCb);
		//con.add(itemCb);
		//con.add(openTf);
		//con.add(tounchTf);
		//con.add(fineWtLb);
		//con.add(pieceTf);
		//con.add(addNewBtn);
		//con.add(updateBtn);
		//con.add(categoryCb1);
		//con.add(itemCb1);
		//con.add(openTf1);
		//con.add(tounchTf1);
		//con.add(fineWtLb1);
		//con.add(pieceTf1);
		//con.add(addNewBtn1);
		//con.add(updateBtn1);
		//con.add(lastTounchLb);
		//con.add(lastTounchLb1);
		//con.add(depositeBtn);
		con.add(depositeTf);
		//con.add(drCrLb);
		//con.add(drCrLb1);
		//con.add(drCrCb);

		con.add(addBtn);
		con.add(printBtn);
		con.add(exitBtn);
		con.add(resetBtn);

		con.add(jsp);
		con.add(totalPurWtL);
		con.add(totalAmountL);
		con.add(totalPurFineWtL);
		con.add(totalSilverFineWtL);

		/*
		con.add(lastBal1L);
		con.add(lastBal3L);
		con.add(curBal1L);
		con.add(curBal3L);
		*/
		//con.add(lastBal2L);
		//con.add(lastBal4L);
		//con.add(curBal2L);
		//con.add(curBal4L);
		con.add(jsp1);
		con.add(totalPurWtL1);
		con.add(totalAmountL1);
		con.add(totalPurFineWtL1);
		con.add(totalSilverFineWtL1);
		/*con.add(gmOrBhari);
		con.add(curRateTf);
		con.add(adjustmentWtTf);
		con.add(adjustmentAmtTf);
		con.add(adjustTb);
		con.add(pendingTb);
		*/
		con.add(depositeTb);
		//con.add(newPartyBtn);
		//con.add(newCategoryBtn);
		//con.add(newItemBtn);
		//con.add(preBillBtn);
		//con.add(nextBillBtn);
		//con.add(newCategoryBtn1);
		//con.add(newItemBtn1);
		con.add(billNoLb);




		/*
		grid.setBackground(new Color(255,250,233));
		JPanel p1=new JPanel();
		p1.setBounds(5,45,1120,210);
		p1.setOpaque(true);
		p1.setBackground(new Color(255,250,233));
		p1.setBorder(new javax.swing.border.EtchedBorder());
		con.add(p1);

		grid1.setBackground(new Color(233,255,250));
		JPanel p2=new JPanel();
		p2.setBounds(5,270,1120,225);
		p2.setOpaque(true);
		p2.setBackground(new Color(233,255,250));//233,250,255));
		p2.setBorder(new javax.swing.border.EtchedBorder());
		con.add(p2);
		*/
		billNoLb.setText(""+getCurrentBillNo());

		//depositeTf.setVisible(false);
		depositeBtn.setVisible(false);
		dateTf.setEditable(false);

		newPartyBtn.addActionListener(this);
		newCategoryBtn.addActionListener(this);
		newItemBtn.addActionListener(this);
		preBillBtn.addActionListener(this);
		nextBillBtn.addActionListener(this);
		newCategoryBtn1.addActionListener(this);
		newItemBtn1.addActionListener(this);
		addBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		printBtn.addActionListener(this);
		resetBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		//categoryCb.addActionListener(this);
		//categoryCb1.addActionListener(this);
		itemCb.addActionListener(this);
		itemCb1.addActionListener(this);
		adjustTb.addActionListener(this);
		//depositeTb.addActionListener(this);
		pendingTb.addActionListener(this);
		partyCb.addActionListener(this);
		addNewBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		addNewBtn1.addActionListener(this);
		updateBtn1.addActionListener(this);
		drCrCb.addActionListener(this);
		dateBtn.addActionListener(this);
		//grid.addMouseListener(this);
		//grid1.addMouseListener(this);

		addBtn.addKeyListener(this);
		deleteBtn.addKeyListener(this);
		printBtn.addKeyListener(this);
		resetBtn.addKeyListener(this);
		exitBtn.addKeyListener(this);
		partyCb.addKeyListener(this);
		dateTf.addKeyListener(this);
		categoryCb.addKeyListener(this);
		itemCb.addKeyListener(this);
		openTf.addKeyListener(this);
		tounchTf.addKeyListener(this);
		pieceTf.addKeyListener(this);
		categoryCb1.addKeyListener(this);
		itemCb1.addKeyListener(this);
		openTf1.addKeyListener(this);
		tounchTf1.addKeyListener(this);
		pieceTf1.addKeyListener(this);
		curRateTf.addKeyListener(this);
		adjustmentWtTf.addKeyListener(this);
		adjustmentAmtTf.addKeyListener(this);
		addNewBtn.addKeyListener(this);
		updateBtn.addKeyListener(this);
		addNewBtn1.addKeyListener(this);
		updateBtn1.addKeyListener(this);
		depositeTf.addKeyListener(this);
		dateBtn.addKeyListener(this);
		//grid.addKeyListener(this);
		//grid1.addKeyListener(this);

		dateTf.addFocusListener(this);
		itemCb.addFocusListener(this);
		openTf.addFocusListener(this);
		tounchTf.addFocusListener(this);
		pieceTf.addFocusListener(this);
		openTf1.addFocusListener(this);
		tounchTf1.addFocusListener(this);
		pieceTf1.addFocusListener(this);

		frm.addInternalFrameListener(this);
		getPartyName();

		discounttf=new JTextField();
	 	totalPaybleAmtL=new JLabel("0.00",JLabel.CENTER);
	 	vatAmtL=new JLabel("0.00",JLabel.CENTER);
	 	netPaybleAmtL=new JLabel("0.00",JLabel.CENTER);
		JLabel newl1=new JLabel(" Payble Amt.(In Rs.)");
		JLabel newl2=new JLabel(" VAT Amt.( + 1% )");
		JLabel newl3=new JLabel(" Enter Discount(In Rs.)");
		JLabel newl4=new JLabel(" Net Payble Amt.(In Rs.)");
		discounttf.setHorizontalAlignment(JTextField.CENTER);
		newl1.setOpaque(true);
		newl2.setOpaque(true);
		newl3.setOpaque(true);
		newl4.setOpaque(true);
		totalPaybleAmtL.setOpaque(true);
		vatAmtL.setOpaque(true);
		netPaybleAmtL.setOpaque(true);
		newl1.setBackground(new Color(225,218,254));
		newl2.setBackground(new Color(225,218,254));
		newl3.setBackground(new Color(225,218,254));
		newl4.setBackground(new Color(225,218,254));
		totalPaybleAmtL.setBackground(new Color(243,241,254));
		vatAmtL.setBackground(new Color(243,241,254));
		netPaybleAmtL.setBackground(new Color(243,241,254));
		newl1.setBorder(new javax.swing.border.LineBorder(Color.black,1));
		newl2.setBorder(new javax.swing.border.LineBorder(Color.black,1));
		newl3.setBorder(new javax.swing.border.LineBorder(Color.black,1));
		newl4.setBorder(new javax.swing.border.LineBorder(Color.black,1));
		totalPaybleAmtL.setBorder(new javax.swing.border.LineBorder(Color.black,1));
		vatAmtL.setBorder(new javax.swing.border.LineBorder(Color.black,1));
		netPaybleAmtL.setBorder(new javax.swing.border.LineBorder(Color.black,1));
		newl1.setFont(new Font("Arial",Font.BOLD,11));
		newl2.setFont(new Font("Arial",Font.BOLD,11));
		newl3.setFont(new Font("Arial",Font.BOLD,11));
		newl4.setFont(new Font("Arial",Font.BOLD,11));		
		newl1.setBounds(10,510,110,25);
		totalPaybleAmtL.setBounds(120,510,120,25);		
		newl2.setBounds(290,510,100,25);
		vatAmtL.setBounds(390,510,120,25);		
		newl3.setBounds(560,510,130,25);
		discounttf.setBounds(690,510,120,25);		
		newl4.setBounds(860,510,130,25);
		netPaybleAmtL.setBounds(990,510,120,25);		
		con.add(newl1);
		con.add(newl2);
		con.add(newl3);
		con.add(newl4);
		con.add(totalPaybleAmtL);
		con.add(vatAmtL);
		con.add(discounttf);
		con.add(netPaybleAmtL);
		
		discounttf.addKeyListener(this);


		JLabel l1=new JLabel("SALE DETAILS :::");
		JLabel l2=new JLabel("ADJUSTMENT DETAILS :::");
		l1.setBounds(10,45,1110,25);
		l2.setBounds(10,275,1110,25);
		l1.setOpaque(true);
		l2.setOpaque(true);
		l1.setBackground(new Color(128,209,253));
		l2.setBackground(new Color(128,209,253));
		l1.setFont(new Font("Arial",Font.BOLD,12));
		l2.setFont(new Font("Arial",Font.BOLD,12));
		con.add(l1);
		con.add(l2);
				

		pm=new JPopupMenu();
		deletePM=new JMenuItem("Delete Selected Record");
		pm.add(deletePM);
		deletePM.addActionListener(this);				
		grid.addMouseListener(this);



		pm1=new JPopupMenu();
		deletePM1=new JMenuItem("Delete Selected Record");
		pm1.add(deletePM1);
		deletePM1.addActionListener(this);				
		grid1.addMouseListener(this);
				
		
	/*

		getCategoryName();
		getItemName();
		getItemName1();
		getPartyName();
*/

grid.getModel().addTableModelListener(this);
grid1.getModel().addTableModelListener(this);
//-------------------------------------------
// Key event handler
//-------------------------------------------
grid.addKeyListener(new TableArrowKeyHandler(grid));
grid1.addKeyListener(new TableArrowKeyHandler(grid1));
/*//------------------------------------
//Mouse Listener Registration
//------------------------------------
grid.addMouseListener(new MouseAdapter(){
public void mouseClicked(MouseEvent e) {
System.out.println("mouseClicked---INSIDE-------------->");

int nRow = grid.rowAtPoint(e.getPoint());
int nCol = grid.columnAtPoint(e.getPoint());

//get selected object
Object objSel = grid.getValueAt(nRow, nCol);
System.out.println("mouse clicked:"+objSel+","+nRow+","+nCol);
//----------------------------------------
// Here you can play with selected object
//----------------------------------------
	if(nCol==1)
	{
		objSel = grid.getValueAt(nRow, 0);
		String list1[]=getItemName(""+objSel);
		setComboBoxInCell(grid,1,list1);
	}
	System.out.println("mouseClicked---OUTSIDE-------------->");

}
});
*/




		if(billno>0)
		{
			billNoLb.setText(""+billno);
			//showBill();
		}


		desk.add(frm);
		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (ds.width-1150)/2;
		int y = (ds.height-400)/2;
   		frm.reshape(x,15,1140,665);
   		frm.show();
	}
	/**
* Customized Key event handler Class
*/
public class TableArrowKeyHandler implements KeyListener
{
	private JTable m_table ;

	public TableArrowKeyHandler(JTable p_table)
	{
		m_table = p_table;
	}

	public void keyPressed(final KeyEvent e)
	{

		if (e.getKeyCode() == e.VK_ENTER)
		{
			e.consume();
		}

		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				System.out.println("keyPressed---INSIDE-------------->");

				//get keyCode
				int keyCode = e.getKeyCode();
				int nRow = m_table.getSelectionModel().getAnchorSelectionIndex();
				int nCol =m_table.getColumnModel().getSelectionModel().getAnchorSelectionIndex();

				if (keyCode == e.VK_ENTER)
				{
						if ( (nRow > -1 && nRow < m_table.getRowCount()) && (nCol > -1 && nCol < 10)  && (nCol !=  9))	//(m_table.getColumnCount()-1)))
						{
							Object objSel = m_table.getValueAt(nRow, nCol);
							m_table.setSurrendersFocusOnKeystroke(true);
							m_table.setCellSelectionEnabled(true);
							if(nCol==1 && m_table.getValueAt(nRow, 0).toString().equalsIgnoreCase("Stone")==true)
								m_table.changeSelection(nRow, nCol+2, false, false);
							else if(nCol==3 && m_table.getValueAt(nRow, 0).toString().equalsIgnoreCase("Stone")==false)
								m_table.changeSelection(nRow, nCol+3, false, false);
							else if(nCol==4 && m_table.getValueAt(nRow, 0).toString().equalsIgnoreCase("Stone")==false)
								m_table.changeSelection(nRow, nCol+2, false, false);
							else if(nCol==4 && m_table.getValueAt(nRow, 0).toString().equalsIgnoreCase("Stone")==true)
							{
								//create new row
								newRowFlag=false;
								String blankrow[]=new String[12];
								if(e.getSource()==grid)
								{
									dtm.addRow(blankrow);
								}
								else
								{
									dtm1.addRow(blankrow);
								}
								newRowFlag=true;
								m_table.setSurrendersFocusOnKeystroke(true);
								m_table.setCellSelectionEnabled(true);
								m_table.changeSelection(nRow+1, 0, false, false);
								m_table.requestFocus();
								
							}
							else if(nCol==6)	//pressed ENTER on TOUNCH
							{

								calculateFineWeight(m_table,nRow);
								calculateAmount(m_table,nRow);
								m_table.changeSelection(nRow, nCol+1, false, false);

							}
							else
								m_table.changeSelection(nRow, nCol+1, false, false);
							m_table.requestFocus();

						}
						else if( (nRow == (m_table.getRowCount()-1) && (nCol == 9)) )	//(m_table.getColumnCount()-1))) )
						{
							newRowFlag=false;
							String blankrow[]=new String[12];
							if(e.getSource()==grid)
							{
								dtm.addRow(blankrow);
							}
							else
							{
								dtm1.addRow(blankrow);
							}
							newRowFlag=true;
							m_table.setSurrendersFocusOnKeystroke(true);
							m_table.setCellSelectionEnabled(true);
							m_table.changeSelection(nRow+1, 0, false, false);
							m_table.requestFocus();
						}
				}

		}
	});
	System.out.println("keyPressed---OUTSIDE-------------->");
}
public void keyReleased(KeyEvent e) {}
public void keyTyped(KeyEvent e) {}
}


public void tableChanged(TableModelEvent e)
{
	try
	{

	if(newRowFlag==true)
	{
		JTable table;
		if(e.getSource()==dtm || e.getSource()==grid)
		{
			table=grid;
			System.out.println("grid...");
		}
		else
		{
			table=grid1;
			System.out.println("grid1..."+e.getSource());
		}
		//System.out.println("Table changed---INSIDE-------------->");
		int nRow = e.getFirstRow();
		int nCol = e.getColumn();

		//get selected object
		Object objSel = table.getValueAt(nRow, nCol);
		//System.out.println("tableChanged:"+objSel+","+nRow+","+nCol);
		//----------------------------------------
		// Here you can play with selected object
		//----------------------------------------
		if(nCol==0)
		{
			objSel = table.getValueAt(nRow, 0);
			String list1[]=getItemName(""+objSel);
			setComboBoxInCell(table,1,list1);
		}
		else if(nCol==1)
		{
			//System.out.println("nCol=1");
			objSel = table.getValueAt(nRow, nCol);
			String lasttounch=getLastTounch(partyCb.getSelectedItem().toString(),objSel.toString());
			table.setValueAt(lasttounch,nRow,6);
		}
		if((nCol==2 || nCol==3  || nCol==4 || nCol==6 || nCol==7 || nCol==8 || nCol==9) && errorInTableFlag==false)
		{
			String msg="";
			if(nCol==2)	msg="Error! Invalid character found in GROSS WEIGHT.";
			else if(nCol==3)	msg="Error! Invalid character found in STONE WEIGHT.";
			else if(nCol==4)	msg="Error! Invalid character found in STONE RATE.";
			else if(nCol==6)	msg="Error! Invalid character found in TOUNCH.";
			else if(nCol==7)	msg="Error! Invalid character found in WASTAGE.";
			else if(nCol==8)	msg="Error! Invalid character found in RATE.";
			else if(nCol==9)	msg="Error! Invalid character found in MAKING CHARGE.";

			try
			{
						Double.valueOf(""+objSel);
						System.out.println("ncol="+nCol);
						///////////////////
						//Set net weight
						///////////////////
						if(nCol==2 || nCol==3)
						{
							String temp_grossweight=""+table.getValueAt(nRow, 2);
							String temp_stoneweight=""+table.getValueAt(nRow, 3);
							if(temp_grossweight.equalsIgnoreCase("")==true || temp_grossweight.equalsIgnoreCase("null")==true )
								temp_grossweight="0";
							if(temp_stoneweight.equalsIgnoreCase("")==true || temp_stoneweight.equalsIgnoreCase("null")==true )
								temp_stoneweight="0";

							if(table.getValueAt(nRow, 0).toString().trim().equalsIgnoreCase("gold")==true || table.getValueAt(nRow, 0).toString().trim().equalsIgnoreCase("silver")==true)
							{
								double netweight = Double.valueOf(temp_grossweight)-Double.valueOf(temp_stoneweight);
								table.setValueAt(""+(new BigDecimal(netweight)).setScale(2,5),nRow,5);

							}
							else	//if stone
							{
								double netweight = Double.valueOf(temp_stoneweight);
								table.setValueAt(""+(new BigDecimal(netweight)).setScale(2,5),nRow,5);
							}
							if(table==grid)
							{
								totalPurWtL.setText(""+(new BigDecimal(getTotalInDecimal(table,5))).setScale(2,5));
							}
							else
							{
								totalPurWtL1.setText(""+(new BigDecimal(getTotalInDecimal(table,5))).setScale(2,5));
							}
							calculateFineWeight(table,nRow);
							calculateAmount(table,nRow);
						}
						//////////////////////////////
						//Calculate amount of stone
						//////////////////////////////
						if(nCol==4)
						{
							String temp_stoneweight=(""+table.getValueAt(nRow, 3)).trim();
							if(temp_stoneweight.equalsIgnoreCase("")==true || temp_stoneweight.equalsIgnoreCase("null")==true)
								temp_stoneweight="0";

							String temp_stonerate=(""+table.getValueAt(nRow, 4)).trim();
							if(temp_stonerate.equalsIgnoreCase("")==true || temp_stonerate.equalsIgnoreCase("null")==true)
								temp_stonerate="0";

							double amount=(Double.valueOf(temp_stoneweight)/.2)*Double.valueOf(temp_stonerate);

							table.setValueAt(""+(new BigDecimal(amount)).setScale(2,5), nRow, 10);

							if(table==grid)
							{
								totalAmountL.setText(""+(new BigDecimal(getTotalInDecimal(table,10))).setScale(2,5));
								calculateNetPaybleAmt();
							}
							else
							{
								totalAmountL1.setText(""+(new BigDecimal(getTotalInDecimal(table,10))).setScale(2,5));
								calculateNetPaybleAmt();
							}	
						}
						/////////////////////////////////////////////////////
						//Calculate total amount at the time of TOUNCH input
						/////////////////////////////////////////////////////
						if(nCol==6)
						{
							calculateFineWeight(table,nRow);
							calculateAmount(table,nRow);
						}
						/////////////////////////////////////////////
						//Calculate fine weight of Gold and Silver
						/////////////////////////////////////////////
						if(nCol==7)
						{
							String temptounch=""+table.getValueAt(nRow, 6);
							String tempwastage=""+table.getValueAt(nRow, 7);
							String tempnetweight=""+table.getValueAt(nRow, 5);
							double dbltounch=0,dblwastage=0,dblnetweight=0,fineweight=0;
							//if(temptounch.equals("")==false)
							//	dbltounch=Double.valueOf(temptounch);
							//if(tempwastage.equals("")==false)
							//	dblwastage=Double.valueOf(tempwastage);
							if(temptounch.equals("")==false && temptounch.equalsIgnoreCase("null")==false)
								dbltounch=Double.valueOf(temptounch);
							if(tempwastage.equals("")==false && tempwastage.equalsIgnoreCase("null")==false)
								dblwastage=Double.valueOf(tempwastage);

							double netpercentage=dbltounch+dblwastage;
							if(tempnetweight.equals("")==false)
							{
								dblnetweight=Double.valueOf(tempnetweight);
								fineweight=(dblnetweight*netpercentage)/100;
							}
							String tempfineweight=""+(new BigDecimal(fineweight)).setScale(2,5);
							if(table.getValueAt(nRow, 0).toString().equalsIgnoreCase("gold")==true)
								table.setValueAt(tempfineweight, nRow, 11);
							else if(table.getValueAt(nRow, 0).toString().equalsIgnoreCase("silver")==true)
								table.setValueAt(tempfineweight, nRow, 12);

							//System.out.println("ok reached >>>>>>>>>>>>>>>>>>>>>>");
							if(table==grid)
							{
								totalPurFineWtL.setText(""+(new BigDecimal(getTotalInDecimal(table,11))).setScale(2,5));	//total fine weight of gold
								totalSilverFineWtL.setText(""+(new BigDecimal(getTotalInDecimal(table,12))).setScale(2,5));
							}
							else
							{
								totalPurFineWtL1.setText(""+(new BigDecimal(getTotalInDecimal(table,11))).setScale(2,5));	//total fine weight of gold
								totalSilverFineWtL1.setText(""+(new BigDecimal(getTotalInDecimal(table,12))).setScale(2,5));
							}
							//System.out.println("ok finished >>>>>>>>>>>>>>>>>>>>>>");

						}
						////////////////////
						//Calculate amount
						////////////////////
						if(nCol==8)
						{
							String temprate=(""+table.getValueAt(nRow, 8)).trim();
							if(temprate.equalsIgnoreCase("")==true || temprate.equalsIgnoreCase("null")==true)
								temprate="0";
							double amount=0;
							if(table.getValueAt(nRow, 0).toString().equalsIgnoreCase("gold")==true)
							{
								String tempfineweight=(""+table.getValueAt(nRow, 11)).trim();
								if(tempfineweight.equalsIgnoreCase("")==true || tempfineweight.equalsIgnoreCase("null")==true)
									tempfineweight="0";
								amount=Double.valueOf(tempfineweight)*Double.valueOf(temprate);
							}
							else if(table.getValueAt(nRow, 0).toString().equalsIgnoreCase("silver")==true)
							{
								String tempfineweight=(""+table.getValueAt(nRow, 12)).trim();
								if(tempfineweight.equalsIgnoreCase("")==true || tempfineweight.equalsIgnoreCase("null")==true)
									tempfineweight="0";
								amount=Double.valueOf(tempfineweight)*Double.valueOf(temprate)/1000;
							}
							table.setValueAt(""+(new BigDecimal(amount)).setScale(2,5), nRow, 10);

							if(table==grid)
							{
								totalAmountL.setText(""+(new BigDecimal(getTotalInDecimal(table,10))).setScale(2,5));
								calculateNetPaybleAmt();
							}
							else
							{
								totalAmountL1.setText(""+(new BigDecimal(getTotalInDecimal(table,10))).setScale(2,5));
								calculateNetPaybleAmt();
							}	

						}
						////////////////////
						//Calculate amount with making charge
						////////////////////
						if(nCol==9)
						{
							String temprate=(""+table.getValueAt(nRow, 9)).trim();
							if(temprate.equalsIgnoreCase("")==true || temprate.equalsIgnoreCase("null")==true)
								temprate="0";
							double amount=0;
								String tempgrossweight=(""+table.getValueAt(nRow, 2)).trim();
								if(tempgrossweight.equalsIgnoreCase("")==true || tempgrossweight.equalsIgnoreCase("null")==true)
									tempgrossweight="0";
							if(table.getValueAt(nRow, 0).toString().equalsIgnoreCase("gold")==true)
							{
								amount=Double.valueOf(tempgrossweight)*Double.valueOf(temprate);
							}
							else if(table.getValueAt(nRow, 0).toString().equalsIgnoreCase("silver")==true)
							{
								//first convert weight into Kg. & then calculate
								amount=(Double.valueOf(tempgrossweight)/1000)*Double.valueOf(temprate);
							}

							if(table.getValueAt(nRow, 0).toString().equalsIgnoreCase("")==false)
								amount=amount+Double.valueOf((""+table.getValueAt(nRow, 10)).trim());

							table.setValueAt(""+(new BigDecimal(amount)).setScale(2,5), nRow, 10);

							if(table==grid)
							{
								totalAmountL.setText(""+(new BigDecimal(getTotalInDecimal(table,10))).setScale(2,5));
								calculateNetPaybleAmt();
							}
							else
							{
								totalAmountL1.setText(""+(new BigDecimal(getTotalInDecimal(table,10))).setScale(2,5));
								calculateNetPaybleAmt();
							}	
						}

			}
			catch(NumberFormatException ex)
			{
									errorInTableFlag=true;
									JOptionPane.showMessageDialog(null,msg+ex);
									table.setValueAt("",nRow, nCol);
									table.changeSelection(nRow, nCol, false, false);
									table.requestFocus();
			}
		}
		else if(errorInTableFlag==true)
		{
			errorInTableFlag=false;
		}
		//System.out.println("Table changed---OUTSIDE-------------->");
	}
	}
	catch(Exception ex)
	{
		System.out.println("Error...But no problem.");
	}
}
class ColorColumnRenderer extends DefaultTableCellRenderer 
{
   Color bkgndColor, fgndColor;
 	
   public ColorColumnRenderer(Color bkgnd, Color foregnd) {
      super(); 
      bkgndColor = bkgnd;
      fgndColor = foregnd;
   }
  	
   public Component getTableCellRendererComponent
	    (JTable table, Object value, boolean isSelected,
	     boolean hasFocus, int row, int column) 
   {
      Component cell = super.getTableCellRendererComponent
         (table, value, isSelected, hasFocus, row, column);
 
      cell.setBackground( bkgndColor );
      cell.setForeground( fgndColor );
     
      return cell;
   }
}

	class MyDefaultTableModel extends DefaultTableModel
	{
 		public MyDefaultTableModel(String heading[],int noOfCol)
 		{
			super(heading,noOfCol);
 		}
 		public boolean isCellEditable(int row, int col)
 		{
 			if(col==5 || col==10 || col==11 || col==12)
 			{
 				return false;
 			}
   			return true;
 		}
	}


	private void calculateFineWeight(JTable m_table,int nRow)
	{

							String temptounch=""+m_table.getValueAt(nRow, 6);
							String tempwastage=""+m_table.getValueAt(nRow, 7);
							String tempnetweight=""+m_table.getValueAt(nRow, 5);
							double dbltounch=0,dblwastage=0,dblnetweight=0,fineweight=0;
							if(temptounch.equals("")==false && temptounch.equalsIgnoreCase("null")==false)
								dbltounch=Double.valueOf(temptounch);
							if(tempwastage.equals("")==false && tempwastage.equalsIgnoreCase("null")==false)
								dblwastage=Double.valueOf(tempwastage);

							double netpercentage=dbltounch+dblwastage;
							if(tempnetweight.equals("")==false && tempnetweight.equalsIgnoreCase("null")==false)
							{
								dblnetweight=Double.valueOf(tempnetweight);
								fineweight=(dblnetweight*netpercentage)/100;
							}
						
							String tempfineweight=""+(new BigDecimal(fineweight)).setScale(2,5);
							if(m_table.getValueAt(nRow, 0).toString().equalsIgnoreCase("gold")==true)
								m_table.setValueAt(tempfineweight, nRow, 11);
							else if(m_table.getValueAt(nRow, 0).toString().equalsIgnoreCase("silver")==true)
								m_table.setValueAt(tempfineweight, nRow, 12);

							//System.out.println("ok reached >>>>>>>>>>>>>>>>>>>>>>");
							if(m_table==grid)
							{
								totalPurFineWtL.setText(""+(new BigDecimal(getTotalInDecimal(m_table,11))).setScale(2,5));	//total fine weight of gold
								totalSilverFineWtL.setText(""+(new BigDecimal(getTotalInDecimal(m_table,12))).setScale(2,5));
							}
							else
							{
								totalPurFineWtL1.setText(""+(new BigDecimal(getTotalInDecimal(m_table,11))).setScale(2,5));	//total fine weight of gold
								totalSilverFineWtL1.setText(""+(new BigDecimal(getTotalInDecimal(m_table,12))).setScale(2,5));
							}
							//System.out.println("ok reached ------->>>>>>>>>>>>>>>>>>>>>>");
							
	
	}
	private void calculateAmount(JTable table,int nRow)
	{
		
							String temprate=(""+table.getValueAt(nRow, 8));
							if(temprate.equalsIgnoreCase("")==true || temprate.equalsIgnoreCase("null")==true)
								temprate="0";
							double amount=0;
							if(table.getValueAt(nRow, 0).toString().equalsIgnoreCase("gold")==true)
							{
								String tempfineweight=(""+table.getValueAt(nRow, 11)).trim();
								if(tempfineweight.equalsIgnoreCase("")==true || tempfineweight.equalsIgnoreCase("null")==true)
									tempfineweight="0";
								amount=Double.valueOf(tempfineweight)*Double.valueOf(temprate);
							}
							else if(table.getValueAt(nRow, 0).toString().equalsIgnoreCase("silver")==true)
							{
								String tempfineweight=(""+table.getValueAt(nRow, 12)).trim();
								if(tempfineweight.equalsIgnoreCase("")==true || tempfineweight.equalsIgnoreCase("null")==true)
									tempfineweight="0";
			
								amount=Double.valueOf(tempfineweight)*Double.valueOf(temprate)/1000;
							}
							else if(table.getValueAt(nRow, 0).toString().equalsIgnoreCase("stone")==true)
							{
								temprate=(""+table.getValueAt(nRow, 4));
								if(temprate.equalsIgnoreCase("")==true || temprate.equalsIgnoreCase("null")==true)
									temprate="0";
								String tempfineweight=(""+table.getValueAt(nRow,5 )).trim();
								if(tempfineweight.equalsIgnoreCase("")==true || tempfineweight.equalsIgnoreCase("null")==true)
									tempfineweight="0";
			
								//double amount=(Double.valueOf(temp_stoneweight)/.2)*Double.valueOf(temp_stonerate);
								amount=(Double.valueOf(tempfineweight)/.2)*Double.valueOf(temprate);
							}
							table.setValueAt(""+(new BigDecimal(amount)).setScale(2,5), nRow, 10);
		
							if(table==grid)
							{
								totalAmountL.setText(""+(new BigDecimal(getTotalInDecimal(table,10))).setScale(2,5));
								calculateNetPaybleAmt();
							}
							else
							{
								totalAmountL1.setText(""+(new BigDecimal(getTotalInDecimal(table,10))).setScale(2,5));
								calculateNetPaybleAmt();
							}	
		
	}
	private void calculateNetPaybleAmt()
	{
		double firsttotalamt=Double.valueOf(totalAmountL.getText());
		double secondtotalamt=Double.valueOf(totalAmountL1.getText());
		double totalamt=firsttotalamt-secondtotalamt;
		double vatamt=((totalamt*1)/100);
		double discountamt=0;
		
		if(discounttf.getText().equals("")==false)	discountamt=Double.valueOf(discounttf.getText());
		double netamt=totalamt+vatamt-discountamt;
			
		totalPaybleAmtL.setText(""+(new BigDecimal(totalamt)).setScale(2,5));
		vatAmtL.setText(""+(new BigDecimal(vatamt)).setScale(2,5));
		netPaybleAmtL.setText(""+(new BigDecimal(netamt)).setScale(2,5));				
	}
	
	private double getTotalInDecimal(JTable table,int columnno)
	{
		String temp="";
		double sum=0;
		for(int r=0;r<table.getRowCount();r++)
		{
			System.out.println("column no="+columnno);
			temp=""+table.getValueAt(r,columnno);
			System.out.println("temp="+temp);
			if(temp.equals("")==false && temp.equals("null")==false )
			{
				sum=sum+Double.valueOf(temp);
			}
		}
		return sum;
	}

	public void internalFrameClosing(InternalFrameEvent e)
	{

			flag5=Double.valueOf(totalPurFineWtL.getText());
			flag6=Double.valueOf(totalPurWtL.getText());
			flag7=Double.valueOf(curBal1L.getText());
			flag8=Double.valueOf(curBal3L.getText());
			System.out.println("Pre : "+flag1+","+flag2+","+flag3+","+flag4);
			System.out.println("Current : "+flag5+","+flag6+","+flag7+","+flag8);

				if(flag1==flag5 && flag2==flag6 && flag3==flag7 && flag4==flag8 )
				{
					System.out.println("match ho gaya11...............");
					frm.dispose();
				}
				/*else
				{
					int res=JOptionPane.showConfirmDialog(null,"Do you want to Save?","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE );
					if(res==JOptionPane.YES_OPTION)
					{
						//saveData();
						if(isBillExist()==true)
						{
									int res1=JOptionPane.showConfirmDialog(null,"It is an old bill.\nDo you want to replace?","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE );
									if(res1==JOptionPane.YES_OPTION)
									{
												if(rollBackData()==true)
												{
													updateFlag=true;
													saveData();
												}
												else
													JOptionPane.showMessageDialog(null,"Error!","Message",JOptionPane.ERROR_MESSAGE );
									}
						}
						else
						{
								updateFlag=false;
								saveData();
						}
						reset();
						frm.dispose();
					}
					else
					{
						frm.dispose();
					}

				}
				*/






	}
	public void internalFrameDeactivated(InternalFrameEvent e)
	{
	}
	public void internalFrameActivated(InternalFrameEvent e)
	{
	}
	public void internalFrameDeiconified(InternalFrameEvent e)
	{

	}
	public void internalFrameIconified(InternalFrameEvent e)
	{


	}
	public void internalFrameClosed(InternalFrameEvent e)
	{

	}
	public void internalFrameOpened(InternalFrameEvent e)
	{

	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==dateBtn)
		{
			Cal cl=new Cal();
	        dateTf.setText(cl.getdate());
		}
		else if(e.getSource()==deletePM)
		{
			int res=JOptionPane.showConfirmDialog(null,"Do you want to delete selected row?","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE );
			if(res==JOptionPane.YES_OPTION)
			{
				dtm.removeRow(grid.getSelectedRow());
				totalAmountL.setText(""+(new BigDecimal(getTotalInDecimal(grid,10))).setScale(2,5));
				totalPurFineWtL.setText(""+(new BigDecimal(getTotalInDecimal(grid,11))).setScale(2,5));	//total fine weight of gold
				totalSilverFineWtL.setText(""+(new BigDecimal(getTotalInDecimal(grid,12))).setScale(2,5));
				calculateNetPaybleAmt();
			}	
		}
		else if(e.getSource()==deletePM1)
		{
			int res=JOptionPane.showConfirmDialog(null,"Do you want to delete selected row?","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE );
			if(res==JOptionPane.YES_OPTION)
			{
				dtm1.removeRow(grid1.getSelectedRow());
				totalAmountL1.setText(""+(new BigDecimal(getTotalInDecimal(grid1,10))).setScale(2,5));
				totalPurFineWtL1.setText(""+(new BigDecimal(getTotalInDecimal(grid1,11))).setScale(2,5));	//total fine weight of gold
				totalSilverFineWtL1.setText(""+(new BigDecimal(getTotalInDecimal(grid1,12))).setScale(2,5));
				calculateNetPaybleAmt();
			}	
		}
		else if(e.getSource()==addBtn)
		{
			/*if(isBillExist()==true)
			{
				int res=JOptionPane.showConfirmDialog(null,"It is an old bill.\nDo you want to replace?","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE );
				if(res==JOptionPane.YES_OPTION)
				{
					if(rollBackData()==true)
					{
						updateFlag=true;
						saveData();
					}
					else
						JOptionPane.showMessageDialog(null,"Error!","Message",JOptionPane.ERROR_MESSAGE );
				}
			}
			else*/
			{
				updateFlag=false;
				saveData();
			}
			reset();
		}
		else if(e.getSource()==printBtn)
		{
			saveDataInTempTable();
		//	printchallan pb=new printchallan(desk);
		}
		else if(e.getSource()==deleteBtn)
		{
			deleteData();
		}
		else if(e.getSource()==resetBtn)
		{
			//printchallan pb=new printchallan(desk);
			reset();
		}
		else if(e.getSource()==exitBtn)
		{

			flag5=Double.valueOf(totalPurFineWtL.getText());
			flag6=Double.valueOf(totalPurWtL.getText());
			flag7=Double.valueOf(curBal1L.getText());
			flag8=Double.valueOf(curBal3L.getText());

				if(flag1==flag5 && flag2==flag6 && flag3==flag7 && flag4==flag8 )
				{
					System.out.println("match ho gaya11.4..............");
					frm.dispose();
				}
				/*else
				{
					int res=JOptionPane.showConfirmDialog(null,"Do you want to Save?","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE );
					if(res==JOptionPane.YES_OPTION)
					{
						//saveData();
						if(isBillExist()==true)
						{
									int res1=JOptionPane.showConfirmDialog(null,"It is an old bill.\nDo you want to replace?","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE );
									if(res1==JOptionPane.YES_OPTION)
									{
												if(rollBackData()==true)
												{
													updateFlag=true;
													saveData();
									}
									else
									JOptionPane.showMessageDialog(null,"Error!","Message",JOptionPane.ERROR_MESSAGE );
						}
					}
					else
					{
								updateFlag=false;
								saveData();
					}
						reset();
						frm.dispose();
					}
					else
					{
						frm.dispose();
					}

				}*/




		}
		else if(e.getSource()==partyCb)
		{
			try
			{
				String str=partyCb.getSelectedItem().toString();
				//code to update transaction
				//start
	   	        		   			patch2 pt=new patch2();
        		   					pt.setSize(2,3);
									pt.setVisible(true);
									pt.updatedata(str);
									pt.dispose();

				//end

				reset();
				partyCb.setSelectedItem(str);
				getLastBalance();
				//getLastTounch();
				//getLastTounch1();

				flag1=Double.valueOf(totalPurFineWtL.getText());
				flag2=Double.valueOf(totalPurWtL.getText());
				flag3=Double.valueOf(curBal1L.getText());
				flag4=Double.valueOf(curBal3L.getText());
				System.out.println("Party Selection : "+flag1+","+flag2+","+flag3+","+flag4);
			}
			catch(Exception x)
			{
				System.out.print("error...455..."+x);

			}
		}
		else if(e.getSource()==categoryCb)
		{
			//getItemName();

		}
		else if(e.getSource()==categoryCb1)
		{
			getItemName1();
		}
		else if(e.getSource()==itemCb)
		{
			setCategoryName();
			//getLastTounch();
		}
		else if(e.getSource()==itemCb1)
		{
			setCategoryName1();
			getLastTounch1();
		}
		/*else if(e.getSource()==adjustTb)
		{
			//depositeTb.setSelected(false);
			pendingTb.setSelected(false);
			try
			{
					//curBal3L.setText(""+lastBal3L.getText());
					//curBal4L.setText("0");
					BigDecimal total=new BigDecimal(totalPurWtL1.getText());
					total=(new BigDecimal(""+totalPurFineWtL.getText())).add(new BigDecimal(""+lastBal1L.getText())).subtract(new BigDecimal(""+totalPurFineWtL1.getText()));
					curBal1L.setText(""+total.setScale(3,5));

					//old balance amount
					total=new BigDecimal(lastBal3L.getText());
					double db=Double.valueOf(""+total);
					if(drCrLb1.getText().equals("Dr"))
					{
						db=-db;
					}

					//deposite amount
					double db1=0;
					if(depositeTb.isSelected()==true)
					{
						db1=Double.valueOf(""+depositeTf.getText());
						if(drCrCb.getSelectedItem().toString().equals("Dr"))
						{
							db1=-db1;
						}
					}

					//pending amount
					double db2=0;
					//db2=Double.valueOf(""+adjustmentAmtTf.getText());

					//now calculate total closing amount
					db=db+db1+db2;

					if(db>=0)
					{
						curBal3L.setText(""+(new BigDecimal(""+db)).setScale(2,5));
						drCrLb.setText("Cr");
					}
					else
					{
						db=-db;
						curBal3L.setText(""+(new BigDecimal(""+db)).setScale(2,5));
						drCrLb.setText("Dr");
					}


				if(adjustTb.isSelected()==true)
				{

					total=new BigDecimal(totalPurWtL1.getText());
					total=(new BigDecimal(""+totalPurFineWtL.getText())).add(new BigDecimal(""+lastBal1L.getText())).subtract(new BigDecimal(""+totalPurFineWtL1.getText()));
					total=total.subtract(new BigDecimal(""+adjustmentWtTf.getText()));

					curBal1L.setText(""+total.setScale(3,5));
				}

            }
			catch(Exception x)
			{
				System.out.println("er01..."+x);
			}
		}
		else if(e.getSource()==pendingTb)
		{
			curBal3L.setText("0");
			adjustTb.setSelected(false);
			//depositeTb.setSelected(false);
			try
			{
				if(pendingTb.isSelected()==true)
				{
					curBal3L.setText("0");
					BigDecimal total=new BigDecimal(totalPurWtL1.getText());
					total=(new BigDecimal(""+totalPurFineWtL.getText())).add(new BigDecimal(""+lastBal1L.getText())).subtract(new BigDecimal(""+totalPurFineWtL1.getText())).subtract(new BigDecimal(""+adjustmentWtTf.getText()));
					curBal1L.setText(""+total.setScale(3,5));

					//old balance amount
					total=new BigDecimal(lastBal3L.getText());
					double db=Double.valueOf(""+total);
					if(drCrLb1.getText().equals("Dr"))
					{
						db=-db;
					}

					//deposite amount
					double db1=0;
					if(depositeTb.isSelected()==true)
					{
						db1=Double.valueOf(""+depositeTf.getText());
						if(drCrCb.getSelectedItem().toString().equals("Dr"))
						{
							db1=-db1;
						}
					}

					//pending amount
					double db2=0;
					db2=-Double.valueOf(""+adjustmentAmtTf.getText());


					//now calculate total closing amount
					db=db+db1+db2;

					if(db>=0)
					{
						curBal3L.setText(""+(new BigDecimal(""+db)).setScale(2,5));
						drCrLb.setText("Cr");
					}
					else
					{
						db=-db;
						curBal3L.setText(""+(new BigDecimal(""+db)).setScale(2,5));
						drCrLb.setText("Dr");
					}

				}
				else
				{
					curBal3L.setText("0");
					BigDecimal total=new BigDecimal(totalPurWtL1.getText());
					total=(new BigDecimal(""+totalPurFineWtL.getText())).add(new BigDecimal(""+lastBal1L.getText())).subtract(new BigDecimal(""+totalPurFineWtL1.getText()));
					curBal1L.setText(""+total.setScale(3,5));


					//old balance amount
					total=new BigDecimal(lastBal3L.getText());
					double db=Double.valueOf(""+total);
					if(drCrLb1.getText().equals("Dr"))
					{
						db=-db;
					}

					//deposite amount
					double db1=0;
					if(depositeTb.isSelected()==true)
					{
						db1=Double.valueOf(""+depositeTf.getText());
						if(drCrCb.getSelectedItem().toString().equals("Dr"))
						{
							db1=-db1;
						}
					}

					//pending amount
					double db2=0;
					//db2=Double.valueOf(""+adjustmentAmtTf.getText());

					//now calculate total closing amount
					db=db+db1+db2;

					if(db>=0)
					{
						curBal3L.setText(""+(new BigDecimal(""+db)).setScale(2,5));
						drCrLb.setText("Cr");
					}
					else
					{
						db=-db;
						curBal3L.setText(""+(new BigDecimal(""+db)).setScale(2,5));
						drCrLb.setText("Dr");
					}

				}

            }
			catch(Exception x)
			{
				System.out.println("er01..."+x);
			}

		}
		else if(e.getSource()==depositeTb)
		{
			try
			{
				if(depositeTb.isSelected()==true)
				{
					depositeTf.setText("0");
					depositeTf.setVisible(true);
					drCrCb.setVisible(true);
					drCrCb.setSelectedIndex(0);
					depositeBtn.setVisible(true);
					depositeTf.requestFocus();
					depositeTf.selectAll();
					curBalance=Double.valueOf(curBal3L.getText());
				}
				else
				{
					//curBal3L.setText(""+(new BigDecimal(curBalance)).setScale(2,5));
					depositeTf.setText("0");

					//old balance amount
					BigDecimal total=new BigDecimal(lastBal3L.getText());
					double db=Double.valueOf(""+total);
					if(drCrLb1.getText().equals("Dr"))
					{
						db=-db;
					}

					//deposite amount
					double db1=0;
			
					//pending amount
					double db2=0;
					//db2=Double.valueOf(""+adjustmentAmtTf.getText());
					if(pendingTb.isSelected()==true)
					{
						db2=Double.valueOf(""+adjustmentAmtTf.getText());
						db2=-db2;
					}

					//now calculate total closing amount
					db=db+db1+db2;

					if(db>=0)
					{
						curBal3L.setText(""+(new BigDecimal(""+db)).setScale(2,5));
						drCrLb.setText("Cr");
					}
					else
					{
						db=-db;
						curBal3L.setText(""+(new BigDecimal(""+db)).setScale(2,5));
						drCrLb.setText("Dr");
					}


					depositeTf.setVisible(false);
					drCrCb.setVisible(false);
					depositeBtn.setVisible(false);
					drCrLb.setText(drCrLb1.getText());
					drCrLb.setText(drCrLb1.getText());
				}
            }
			catch(Exception x)
			{
				System.out.println("er01..."+x);
			}

		}*/
		else if(e.getSource()==addNewBtn)
		{
			addNewRecord();
			if(adjustTb.isSelected()==true)
			{
				try
				{
					curBal3L.setText(""+lastBal3L.getText());
					//curBal4L.setText("0");
					BigDecimal total=new BigDecimal(totalPurWtL1.getText());
					total=(new BigDecimal(""+totalPurFineWtL.getText())).add(new BigDecimal(""+lastBal1L.getText())).subtract(new BigDecimal(""+totalPurFineWtL1.getText()));
					curBal1L.setText(""+total.setScale(3,5));


					if(adjustTb.isSelected()==true)
					{

						total=new BigDecimal(totalPurWtL1.getText());
						total=(new BigDecimal(""+totalPurFineWtL.getText())).add(new BigDecimal(""+lastBal1L.getText())).subtract(new BigDecimal(""+totalPurFineWtL1.getText()));
						total=total.subtract(new BigDecimal(""+adjustmentWtTf.getText()));

						curBal1L.setText(""+total.setScale(3,5));
					}

            	}
				catch(Exception x)
				{
					System.out.println("er01..."+x);
				}
			}
			else if(pendingTb.isSelected()==true)
			{
				curBal3L.setText("0");
				try
				{
					//if(pendingTb.isSelected()==true)
					{
						curBal3L.setText("0");
						BigDecimal total=new BigDecimal(totalPurWtL1.getText());
						total=(new BigDecimal(""+totalPurFineWtL.getText())).add(new BigDecimal(""+lastBal1L.getText())).subtract(new BigDecimal(""+totalPurFineWtL1.getText())).subtract(new BigDecimal(""+adjustmentWtTf.getText()));
						curBal1L.setText(""+total.setScale(3,5));
						total=new BigDecimal(lastBal3L.getText());
						total=total.subtract(new BigDecimal(""+adjustmentAmtTf.getText()));
						curBal3L.setText(""+total.setScale(2,5));
					}
            	}
				catch(Exception x)
				{
					System.out.println("er01..."+x);
				}
			}
			/*if(depositeTb.isSelected()==true)
			{
				try
				{
					//if(depositeTb.isSelected()==true)
					{
						depositeTf.setText("0");
						depositeTf.setVisible(true);
						depositeBtn.setVisible(true);
						//depositeTf.requestFocus();
						//depositeTf.selectAll();
						curBalance=Double.valueOf(curBal3L.getText());
					}
            	}
				catch(Exception x)
				{
					System.out.println("er01..."+x);
				}
			}*/
		}
		else if(e.getSource()==addNewBtn1)
		{
			addNewRecord1();
			if(adjustTb.isSelected()==true)
			{
				try
				{
					curBal3L.setText(""+lastBal3L.getText());
					//curBal4L.setText("0");
					BigDecimal total=new BigDecimal(totalPurWtL1.getText());
					total=(new BigDecimal(""+totalPurFineWtL.getText())).add(new BigDecimal(""+lastBal1L.getText())).subtract(new BigDecimal(""+totalPurFineWtL1.getText()));
					curBal1L.setText(""+total.setScale(3,5));


					if(adjustTb.isSelected()==true)
					{

						total=new BigDecimal(totalPurWtL1.getText());
						total=(new BigDecimal(""+totalPurFineWtL.getText())).add(new BigDecimal(""+lastBal1L.getText())).subtract(new BigDecimal(""+totalPurFineWtL1.getText()));
						total=total.subtract(new BigDecimal(""+adjustmentWtTf.getText()));

						curBal1L.setText(""+total.setScale(3,5));
					}

            	}
				catch(Exception x)
				{
					System.out.println("er01..."+x);
				}
			}
			else if(pendingTb.isSelected()==true)
			{
				curBal3L.setText("0");
				try
				{
					//if(pendingTb.isSelected()==true)
					{
						curBal3L.setText("0");
						BigDecimal total=new BigDecimal(totalPurWtL1.getText());
						total=(new BigDecimal(""+totalPurFineWtL.getText())).add(new BigDecimal(""+lastBal1L.getText())).subtract(new BigDecimal(""+totalPurFineWtL1.getText())).subtract(new BigDecimal(""+adjustmentWtTf.getText()));
						curBal1L.setText(""+total.setScale(3,5));
						total=new BigDecimal(lastBal3L.getText());
						total=total.subtract(new BigDecimal(""+adjustmentAmtTf.getText()));
						curBal3L.setText(""+total.setScale(2,5));
					}
            	}
				catch(Exception x)
				{
					System.out.println("er01..."+x);
				}
			}
			/*if(depositeTb.isSelected()==true)
			{
				try
				{
					//if(depositeTb.isSelected()==true)
					{
						depositeTf.setText("0");
						depositeTf.setVisible(true);
						depositeBtn.setVisible(true);
						//depositeTf.requestFocus();
						//depositeTf.selectAll();
						curBalance=Double.valueOf(curBal3L.getText());
					}
            	}
				catch(Exception x)
				{
					System.out.println("er01..."+x);
				}
			}*/
		}
		else if(e.getSource()==newPartyBtn)
		{
			PartyCreationViaScreen pc=new PartyCreationViaScreen(desk);
		}
		else if(e.getSource()==newCategoryBtn || e.getSource()==newCategoryBtn1)
		{
			AddCategoryViaScreen pc=new AddCategoryViaScreen(desk);
		}
		else if(e.getSource()==newItemBtn || e.getSource()==newItemBtn1)
		{
			AddItemViaScreen pc=new AddItemViaScreen(desk);
		}
		else if(e.getSource()==updateBtn)
		{

					String arr[]=new String[6];
					arr[0]=""+categoryCb.getSelectedItem();
					arr[1]=""+itemCb.getSelectedItem();
					arr[2]=openTf.getText();
					arr[3]=tounchTf.getText();
					arr[4]=pieceTf.getText();
					arr[5]=fineWtLb.getText();
					//dtm.addRow(arr);
					int r=grid.getSelectedRow();
					grid.setValueAt(arr[0],r,0);
					grid.setValueAt(arr[1],r,1);
					grid.setValueAt(arr[2],r,2);
					grid.setValueAt(arr[3],r,3);
					grid.setValueAt(arr[4],r,4);
					grid.setValueAt(arr[5],r,5);

					openTf.setText("");
					tounchTf.setText("");
					fineWtLb.setText("");
					pieceTf.setText("");
					getTotalPurFineWt();
					getTotalPurWt();
					categoryCb.requestFocus();

		}
		else if(e.getSource()==updateBtn1)
		{

					String arr[]=new String[6];
					arr[0]=""+categoryCb1.getSelectedItem();
					arr[1]=""+itemCb1.getSelectedItem();
					arr[2]=openTf1.getText();
					arr[3]=tounchTf1.getText();
					arr[4]=pieceTf1.getText();
					arr[5]=fineWtLb1.getText();
					//dtm.addRow(arr);
					int r=grid1.getSelectedRow();
					grid1.setValueAt(arr[0],r,0);
					grid1.setValueAt(arr[1],r,1);
					grid1.setValueAt(arr[2],r,2);
					grid1.setValueAt(arr[3],r,3);
					grid1.setValueAt(arr[4],r,4);
					grid1.setValueAt(arr[5],r,5);

					openTf1.setText("");
					tounchTf1.setText("");
					fineWtLb1.setText("");
					pieceTf1.setText("");
					getTotalPurFineWt1();
					getTotalPurWt1();
					categoryCb1.requestFocus();

		}
		/*else if(e.getSource()==preBillBtn)
		{
			showPreBill();
			flag1=Double.valueOf(totalPurFineWtL.getText());
			flag2=Double.valueOf(totalPurWtL.getText());
			flag3=Double.valueOf(curBal1L.getText());
			flag4=Double.valueOf(curBal3L.getText());

			System.out.println("Party Selection : "+flag1+","+flag2+","+flag3+","+flag4);
		}
		else if(e.getSource()==nextBillBtn)
		{
			showNextBill();
			flag1=Double.valueOf(totalPurFineWtL.getText());
			flag2=Double.valueOf(totalPurWtL.getText());
			flag3=Double.valueOf(curBal1L.getText());
			flag4=Double.valueOf(curBal3L.getText());

			System.out.println("Party Selection : "+flag1+","+flag2+","+flag3+","+flag4);
		}*/
		else if(e.getSource()==drCrCb)
		{
					curBal3L.setText(""+(new BigDecimal(curBalance)).setScale(2,5));
					/*depositeTf.setText("0");
					depositeTf.setVisible(false);
					depositeBtn.setVisible(false);*/
					drCrLb.setText(drCrLb1.getText());


					//old balance amount
					BigDecimal total=new BigDecimal(lastBal3L.getText());
					double db=Double.valueOf(""+total);
					if(drCrLb1.getText().equals("Dr"))
					{
						db=-db;
					}

					//deposite amount
					double db1=0;
					//if(depositeTb.isSelected()==true)
					{
						db1=Double.valueOf(""+depositeTf.getText());
						if(drCrCb.getSelectedItem().toString().equals("Dr"))
						{
							db1=-db1;
						}
						else if(drCrCb.getSelectedItem().toString().equals("Cr"))
						{
							db1=db1;
						}
						else
							db1=0;
					}

					//pending amount
					double db2=0;

					if(pendingTb.isSelected()==true)
					{
						db2=-Double.valueOf(""+adjustmentAmtTf.getText());
					}

					//now calculate total closing amount
					db=db+db1+db2;

					if(db>=0)
					{
						curBal3L.setText(""+(new BigDecimal(""+db)).setScale(2,5));
						drCrLb.setText("Cr");
					}
					else
					{
						db=-db;
						curBal3L.setText(""+(new BigDecimal(""+db)).setScale(2,5));
						drCrLb.setText("Dr");
					}







					/*
					double db=0;
					if(drCrCb.getSelectedItem().toString().equals(drCrLb.getText() ))
						db=curBalance+Double.valueOf(depositeTf.getText());
					else if(drCrLb.getText().equals("Dr") && drCrCb.getSelectedItem().toString().equals("Cr"))
					{
						db=curBalance-Double.valueOf(depositeTf.getText());
						if(db>=0)
							drCrLb.setText("Dr");
						else
							drCrLb.setText("Cr");
					}
					else if(drCrLb.getText().equals("Cr") && drCrCb.getSelectedItem().toString().equals("Dr"))
					{
						db=curBalance-Double.valueOf(depositeTf.getText());
						if(db>=0)
							drCrLb.setText("Cr");
						else
							drCrLb.setText("Dr");
					}
					else
					{
						db=Double.valueOf(curBal3L.getText());
					}
					db=Math.abs(db);
					curBal3L.setText(""+(new BigDecimal(db)).setScale(2,5));
					*/
		}
	}
	public void keyPressed(KeyEvent e)
	{
		if(e.getSource()==dateBtn && e.getKeyCode()==10)
		{
			Cal cl=new Cal();
	        dateTf.setText(cl.getdate());
		}
		else if(e.getSource()==discounttf && e.getKeyCode()==10)
		{
			try
			{
				if(discounttf.getText().trim().equals("")==false)
					Double.valueOf(discounttf.getText());
	
				calculateNetPaybleAmt();
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,"Error! Invalid number found in DISCOUNT");
				discounttf.selectAll();
			}
			
		}
		else if(e.getSource()==addBtn && e.getKeyCode()==10)
		{
			saveData();
		}
		else if(e.getSource()==deleteBtn && e.getKeyCode()==10)
		{
			deleteData();
		}
		else if(e.getSource()==resetBtn && e.getKeyCode()==10)
		{
			reset();
		}
		else if(e.getSource()==exitBtn && e.getKeyCode()==10)
		{

			flag5=Double.valueOf(totalPurFineWtL.getText());
			flag6=Double.valueOf(totalPurWtL.getText());
			flag7=Double.valueOf(curBal1L.getText());
			flag8=Double.valueOf(curBal3L.getText());

				if(flag1==flag5 && flag2==flag6 && flag3==flag7 && flag4==flag8 )
				{
					System.out.println("match ho gaya113...............");
					frm.dispose();
				}
				/*else
				{
					int res=JOptionPane.showConfirmDialog(null,"Do you want to Save?","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE );
					if(res==JOptionPane.YES_OPTION)
					{
						//saveData();
						if(isBillExist()==true)
						{
									int res1=JOptionPane.showConfirmDialog(null,"It is an old bill.\nDo you want to replace?","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE );
									if(res1==JOptionPane.YES_OPTION)
									{
												if(rollBackData()==true)
												{
													updateFlag=true;
													saveData();
									}
									else
									JOptionPane.showMessageDialog(null,"Error!","Message",JOptionPane.ERROR_MESSAGE );
						}
					}
					else
					{
								updateFlag=false;
								saveData();
					}
						reset();
						frm.dispose();
					}
					else
					{
						frm.dispose();
					}

				}*/





		}
		else if(e.getSource()==partyCb && e.getKeyCode()==10)
		{
			dateTf.requestFocus();
		}
		else if(e.getSource()==dateTf && e.getKeyCode()==10)
		{
			categoryCb.requestFocus();
		}
		else if(e.getSource()==categoryCb && e.getKeyCode()==10)
		{
			itemCb.requestFocus();
		}
		else if(e.getSource()==itemCb && e.getKeyCode()==10)
		{
			openTf.requestFocus();
		}
		else if(e.getSource()==openTf && e.getKeyCode()==10)
		{
			if(openTf.getText().trim().length()==0)
			{
				openTf.setText("0");
			}

			tounchTf.requestFocus();
		}
		else if(e.getSource()==tounchTf && e.getKeyCode()==10)
		{
			if(tounchTf.getText().trim().length()==0)
			{
				tounchTf.setText("0");
			}
			BigDecimal gWt=new BigDecimal(openTf.getText());
			BigDecimal tWt=new BigDecimal(tounchTf.getText());
			BigDecimal fWt=new BigDecimal("0");
			fWt=(gWt.multiply(tWt)).divide(new BigDecimal("100"));
			fineWtLb.setText(""+fWt.setScale(3,5));
			pieceTf.requestFocus();
		}
		else if(e.getSource()==pieceTf && e.getKeyCode()==10)
		{
			if(pieceTf.getText().trim().length()==0)
			{
				pieceTf.setText("0");
			}
			//addNewRecord();
			addNewBtn.requestFocus();
		}
		else if(e.getSource()==addNewBtn && e.getKeyCode()==10)
		{
			addNewRecord();
			if(adjustTb.isSelected()==true)
			{
				try
				{
					curBal3L.setText(""+lastBal3L.getText());
					//curBal4L.setText("0");
					BigDecimal total=new BigDecimal(totalPurWtL1.getText());
					total=(new BigDecimal(""+totalPurFineWtL.getText())).add(new BigDecimal(""+lastBal1L.getText())).subtract(new BigDecimal(""+totalPurFineWtL1.getText()));
					curBal1L.setText(""+total.setScale(3,5));


					if(adjustTb.isSelected()==true)
					{

						total=new BigDecimal(totalPurWtL1.getText());
						total=(new BigDecimal(""+totalPurFineWtL.getText())).add(new BigDecimal(""+lastBal1L.getText())).subtract(new BigDecimal(""+totalPurFineWtL1.getText()));
						total=total.subtract(new BigDecimal(""+adjustmentWtTf.getText()));

						curBal1L.setText(""+total.setScale(3,5));
					}

            	}
				catch(Exception x)
				{
					System.out.println("er01..."+x);
				}
			}
			else if(pendingTb.isSelected()==true)
			{
				curBal3L.setText("0");
				try
				{
					//if(pendingTb.isSelected()==true)
					{
						curBal3L.setText("0");
						BigDecimal total=new BigDecimal(totalPurWtL1.getText());
						total=(new BigDecimal(""+totalPurFineWtL.getText())).add(new BigDecimal(""+lastBal1L.getText())).subtract(new BigDecimal(""+totalPurFineWtL1.getText())).subtract(new BigDecimal(""+adjustmentWtTf.getText()));
						curBal1L.setText(""+total.setScale(3,5));
						total=new BigDecimal(lastBal3L.getText());
						total=total.subtract(new BigDecimal(""+adjustmentAmtTf.getText()));
						curBal3L.setText(""+total.setScale(2,5));
					}
            	}
				catch(Exception x)
				{
					System.out.println("er01..."+x);
				}
			}
			/*if(depositeTb.isSelected()==true)
			{
				try
				{
					//if(depositeTb.isSelected()==true)
					{
						depositeTf.setText("0");
						depositeTf.setVisible(true);
						depositeBtn.setVisible(true);
						//depositeTf.requestFocus();
						//depositeTf.selectAll();
						curBalance=Double.valueOf(curBal3L.getText());
					}
            	}
				catch(Exception x)
				{
					System.out.println("er01..."+x);
				}
			}*/
		}
		else if(e.getSource()==categoryCb1 && e.getKeyCode()==10)
		{
			itemCb1.requestFocus();
		}
		else if(e.getSource()==itemCb1 && e.getKeyCode()==10)
		{
			openTf1.requestFocus();
		}
		else if(e.getSource()==openTf1 && e.getKeyCode()==10)
		{
			if(openTf1.getText().trim().length()==0)
			{
				openTf1.setText("0");
			}

			tounchTf1.requestFocus();
		}
		else if(e.getSource()==tounchTf1 && e.getKeyCode()==10)
		{
			if(tounchTf1.getText().trim().length()==0)
			{
				tounchTf1.setText("0");
			}
			BigDecimal gWt=new BigDecimal(openTf1.getText());
			BigDecimal tWt=new BigDecimal(tounchTf1.getText());
			BigDecimal fWt=new BigDecimal("0");
			fWt=(gWt.multiply(tWt)).divide(new BigDecimal("100"));
			fineWtLb1.setText(""+fWt.setScale(3,5));
			pieceTf1.requestFocus();
		}
		else if(e.getSource()==pieceTf1 && e.getKeyCode()==10)
		{

			if(pieceTf1.getText().trim().length()==0)
			{
				pieceTf1.setText("0");
			}
			//addNewRecord1();

			addNewBtn1.requestFocus();
		}
		else if(e.getSource()==addNewBtn1 && e.getKeyCode()==10)
		{
			addNewRecord1();
			if(adjustTb.isSelected()==true)
			{
				try
				{
					curBal3L.setText(""+lastBal3L.getText());
					//curBal4L.setText("0");
					BigDecimal total=new BigDecimal(totalPurWtL1.getText());
					total=(new BigDecimal(""+totalPurFineWtL.getText())).add(new BigDecimal(""+lastBal1L.getText())).subtract(new BigDecimal(""+totalPurFineWtL1.getText()));
					curBal1L.setText(""+total.setScale(3,5));


					if(adjustTb.isSelected()==true)
					{

						total=new BigDecimal(totalPurWtL1.getText());
						total=(new BigDecimal(""+totalPurFineWtL.getText())).add(new BigDecimal(""+lastBal1L.getText())).subtract(new BigDecimal(""+totalPurFineWtL1.getText()));
						total=total.subtract(new BigDecimal(""+adjustmentWtTf.getText()));

						curBal1L.setText(""+total.setScale(3,5));
					}

            	}
				catch(Exception x)
				{
					System.out.println("er01..."+x);
				}
			}
			else if(pendingTb.isSelected()==true)
			{
				curBal3L.setText("0");
				try
				{
					//if(pendingTb.isSelected()==true)
					{
						curBal3L.setText("0");
						BigDecimal total=new BigDecimal(totalPurWtL1.getText());
						total=(new BigDecimal(""+totalPurFineWtL.getText())).add(new BigDecimal(""+lastBal1L.getText())).subtract(new BigDecimal(""+totalPurFineWtL1.getText())).subtract(new BigDecimal(""+adjustmentWtTf.getText()));
						curBal1L.setText(""+total.setScale(3,5));
						total=new BigDecimal(lastBal3L.getText());
						total=total.subtract(new BigDecimal(""+adjustmentAmtTf.getText()));
						curBal3L.setText(""+total.setScale(2,5));
					}
            	}
				catch(Exception x)
				{
					System.out.println("er01..."+x);
				}
			}
			/*if(depositeTb.isSelected()==true)
			{
				try
				{
					//if(depositeTb.isSelected()==true)
					{
						depositeTf.setText("0");
						depositeTf.setVisible(true);
						depositeBtn.setVisible(true);
						//depositeTf.requestFocus();
						//depositeTf.selectAll();
						curBalance=Double.valueOf(curBal3L.getText());
					}
            	}
				catch(Exception x)
				{
					System.out.println("er01..."+x);
				}
			}*/
		}
		else if(e.getSource()==curRateTf && e.getKeyCode()==10)
		{
			adjustmentWtTf.requestFocus();
		}
		else if(e.getSource()==adjustmentWtTf && e.getKeyCode()==10)
		{
			adjustmentAmtTf.requestFocus();
		}
		else if(e.getSource()==adjustmentAmtTf && e.getKeyCode()==10)
		{
			//adjustmentWtTf.requestFocus();
		}
		else if(e.getSource()==grid && e.getKeyCode()==10)
		{
			e.consume();
			int r=grid.getSelectedRow();
			categoryCb.setSelectedItem(""+grid.getValueAt(r,0));
			itemCb.setSelectedItem(""+grid.getValueAt(r,1));
			openTf.setText(""+grid.getValueAt(r,2));
			tounchTf.setText(""+grid.getValueAt(r,3));
			fineWtLb.setText(""+grid.getValueAt(r,5));
			pieceTf.setText(""+grid.getValueAt(r,4));

		}
		else if(e.getSource()==grid1  && e.getKeyCode()==10)
		{
			e.consume();
			int r=grid1.getSelectedRow();
			categoryCb1.setSelectedItem(""+grid1.getValueAt(r,0));
			itemCb1.setSelectedItem(""+grid1.getValueAt(r,1));
			openTf1.setText(""+grid1.getValueAt(r,2));
			tounchTf1.setText(""+grid1.getValueAt(r,3));
			fineWtLb1.setText(""+grid1.getValueAt(r,5));
			pieceTf1.setText(""+grid1.getValueAt(r,4));

		}
		else if(e.getSource()==grid && e.getKeyCode()==e.VK_DELETE)
		{
				e.consume();
				int r=grid.getSelectedRow();
				dtm.removeRow(r);
					getTotalPurFineWt();
					getTotalPurWt();
					categoryCb.requestFocus();
		}
		else if(e.getSource()==grid1 && e.getKeyCode()==e.VK_DELETE)
		{
				e.consume();
				int r=grid1.getSelectedRow();
				dtm1.removeRow(r);
				getTotalPurFineWt1();
				getTotalPurWt1();
				categoryCb1.requestFocus();
		}
		else if(e.getSource()==addNewBtn && e.getKeyCode()==10)
		{
			addNewRecord();
		}
		else if(e.getSource()==addNewBtn1 && e.getKeyCode()==10)
		{
			addNewRecord1();
		}
		else if((e.getSource()==newPartyBtn && e.getKeyCode()==10) || e.getKeyCode()==KeyEvent.VK_F1)
		{
			PartyCreationViaScreen pc=new PartyCreationViaScreen(desk);
		}
		else if(((e.getSource()==newCategoryBtn || e.getSource()==newCategoryBtn1)  && e.getKeyCode()==10) || e.getKeyCode()==KeyEvent.VK_F2 || e.getKeyCode()==KeyEvent.VK_F4)
		{
			AddCategoryViaScreen pc=new AddCategoryViaScreen(desk);
		}
		else if(((e.getSource()==newItemBtn || e.getSource()==newItemBtn1) && e.getKeyCode()==10) || e.getKeyCode()==KeyEvent.VK_F3 || e.getKeyCode()==KeyEvent.VK_F5)
		{
			AddItemViaScreen pc=new AddItemViaScreen(desk);
		}
		else if(e.getSource()==updateBtn && e.getKeyCode()==10)
		{

					String arr[]=new String[6];
					arr[0]=""+categoryCb.getSelectedItem();
					arr[1]=""+itemCb.getSelectedItem();
					arr[2]=openTf.getText();
					arr[3]=tounchTf.getText();
					arr[4]=pieceTf.getText();
					arr[5]=fineWtLb.getText();
					//dtm.addRow(arr);
					int r=grid.getSelectedRow();
					grid.setValueAt(arr[0],r,0);
					grid.setValueAt(arr[1],r,1);
					grid.setValueAt(arr[2],r,2);
					grid.setValueAt(arr[3],r,3);
					grid.setValueAt(arr[4],r,4);
					grid.setValueAt(arr[5],r,5);

					openTf.setText("");
					tounchTf.setText("");
					fineWtLb.setText("");
					pieceTf.setText("");
					getTotalPurFineWt();
					getTotalPurWt();
					categoryCb.requestFocus();

		}
		else if(e.getSource()==updateBtn1 && e.getKeyCode()==10)
		{

					String arr[]=new String[6];
					arr[0]=""+categoryCb1.getSelectedItem();
					arr[1]=""+itemCb1.getSelectedItem();
					arr[2]=openTf1.getText();
					arr[3]=tounchTf1.getText();
					arr[4]=pieceTf1.getText();
					arr[5]=fineWtLb1.getText();
					//dtm.addRow(arr);
					int r=grid1.getSelectedRow();
					grid1.setValueAt(arr[0],r,0);
					grid1.setValueAt(arr[1],r,1);
					grid1.setValueAt(arr[2],r,2);
					grid1.setValueAt(arr[3],r,3);
					grid1.setValueAt(arr[4],r,4);
					grid1.setValueAt(arr[5],r,5);

					openTf1.setText("");
					tounchTf1.setText("");
					fineWtLb1.setText("");
					pieceTf1.setText("");
					getTotalPurFineWt1();
					getTotalPurWt1();
					categoryCb1.requestFocus();

		}
		/*if(e.getKeyCode()==KeyEvent.VK_F11)
		{
			showPreBill();
			flag1=Double.valueOf(totalPurFineWtL.getText());
			flag2=Double.valueOf(totalPurWtL.getText());
			flag3=Double.valueOf(curBal1L.getText());
			flag4=Double.valueOf(curBal3L.getText());
		}
		if(e.getKeyCode()==KeyEvent.VK_F12)
		{
			showNextBill();
			flag1=Double.valueOf(totalPurFineWtL.getText());
			flag2=Double.valueOf(totalPurWtL.getText());
			flag3=Double.valueOf(curBal1L.getText());
			flag4=Double.valueOf(curBal3L.getText());
		}*/
	}
	public void keyReleased(KeyEvent e)
	{
		if(e.getSource()==adjustmentWtTf)
		{
			try
			{
				if(adjustmentWtTf.getText().length()==1 && (adjustmentWtTf.getText().equals("-") || adjustmentWtTf.getText().equals(".")))
				{
				}
				else if(adjustmentWtTf.getText().length()==2 && (adjustmentWtTf.getText().equals("-.")))
				{
				}
				else if((e.getKeyCode()>=48 && e.getKeyCode()<=57) || e.getKeyCode()==46 || e.getKeyCode()==8 || e.getKeyCode()==45)
				{
					double gWt=Double.valueOf(curRateTf.getText());
					double tWt=Double.valueOf(adjustmentWtTf.getText());
					double fWt=0;

					if(gmOrBhari.getSelectedIndex()==1)
					{
						gWt=gWt/11.664;
					}
					else
					{
						gWt=gWt/10.00;
					}
					System.out.println("gwt:"+gWt);
					//fWt=gWt.multiply(tWt);
					fWt=gWt*tWt;
					try
					{
						String t=""+fWt;
						String t1=t.substring(0,t.indexOf('.'));
						String t2=t.substring(t.indexOf('.'),t.length());

						if(Double.valueOf(t2).doubleValue()>=0.5)
							t1=""+(Integer.parseInt(t1)+1);
						else
							t1=""+(Integer.parseInt(t1));
						System.out.println("t2="+t2);
						System.out.println(t1+".00");
						adjustmentAmtTf.setText(""+t1+".00");
					}
					catch(Exception x)
					{
						System.out.println(""+x);
					}
				}
				else
				{
					String s=adjustmentAmtTf.getText();
					adjustmentAmtTf.setText(s.substring(0,s.length()-1));
				}
			}
			catch(Exception x)
			{
				adjustmentWtTf.setText("");
				adjustmentAmtTf.setText("");
				System.out.println("wt:"+x);
			}
		}
		else if(e.getSource()==adjustmentAmtTf)
		{
			try
			{
				double gWt=Double.valueOf(curRateTf.getText());
				double tWt=Double.valueOf(adjustmentAmtTf.getText());
				if(gmOrBhari.getSelectedIndex()==1)
				{
					gWt=gWt/11.664;	//.divide(new BigDecimal("11.664"));
				}
				else
				{
					gWt=gWt/10.00;
				}

				double fWt=tWt/gWt;
				adjustmentWtTf.setText(""+(new BigDecimal(fWt)).setScale(3,5));
			}
			catch(ArithmeticException x)
			{
				System.out.println("erro..."+x);
			}
			catch(Exception x)
			{
				System.out.println("erro..."+x);
				adjustmentWtTf.setText("");
				adjustmentAmtTf.setText("");
			}
		}
		else if(e.getSource()==curRateTf)
		{
			try
			{
				BigDecimal gWt=new BigDecimal(curRateTf.getText());
				BigDecimal tWt=new BigDecimal(adjustmentWtTf.getText());
				BigDecimal fWt=new BigDecimal("0");
				if(gmOrBhari.getSelectedIndex()==1)
				{
					gWt=gWt.divide(new BigDecimal("11.664"));
				}
				else
				{
					gWt=gWt.divide(new BigDecimal("10.000"));
				}

				fWt=gWt.multiply(tWt);
				adjustmentAmtTf.setText(""+fWt.setScale(2,5));
			}
			catch(Exception x)
			{
				System.out.println("erro..."+x);
				//adjustmentWtTf.setText("");
				adjustmentAmtTf.setText("");
			}
		}
		else if(e.getSource()==openTf)
		{
			if((e.getKeyCode()>=48 && e.getKeyCode()<=57) || e.getKeyCode()==46 || e.getKeyCode()==8 || e.getKeyCode()==10){}
			else
			{
				String s=openTf.getText();
				openTf.setText(s.substring(0,s.length()-1));
			}
		}
		else if(e.getSource()==tounchTf)
		{
			if((e.getKeyCode()>=48 && e.getKeyCode()<=57) || e.getKeyCode()==46 || e.getKeyCode()==8 || e.getKeyCode()==10){}
			else
			{
				System.out.println("key found:"+e.getKeyCode());

				String s=tounchTf.getText();
				tounchTf.setText(s.substring(0,s.length()-1));
			}
		}
		else if(e.getSource()==pieceTf)
		{
			if((e.getKeyCode()>=48 && e.getKeyCode()<=57) || e.getKeyCode()==46 || e.getKeyCode()==8 || e.getKeyCode()==10){}
			else
			{
				String s=pieceTf.getText();
				pieceTf.setText(s.substring(0,s.length()-1));
			}
		}
		else if(e.getSource()==openTf1)
		{
			if((e.getKeyCode()>=48 && e.getKeyCode()<=57) || e.getKeyCode()==46 || e.getKeyCode()==8 || e.getKeyCode()==10){}
			else
			{
				String s=openTf1.getText();
				openTf1.setText(s.substring(0,s.length()-1));
			}
		}
		else if(e.getSource()==tounchTf1)
		{
			if((e.getKeyCode()>=48 && e.getKeyCode()<=57) || e.getKeyCode()==46 || e.getKeyCode()==8 || e.getKeyCode()==10){}
			else
			{
				String s=tounchTf1.getText();
				tounchTf1.setText(s.substring(0,s.length()-1));
			}
		}
		else if(e.getSource()==pieceTf1)
		{
			if((e.getKeyCode()>=48 && e.getKeyCode()<=57) || e.getKeyCode()==46 || e.getKeyCode()==8 || e.getKeyCode()==10){}
			else
			{
				String s=pieceTf1.getText();
				pieceTf1.setText(s.substring(0,s.length()-1));
			}
		}
		else if(e.getSource()==curRateTf)
		{
			if((e.getKeyCode()>=48 && e.getKeyCode()<=57) || e.getKeyCode()==46 || e.getKeyCode()==8 || e.getKeyCode()==10){}
			else
			{
				String s=curRateTf.getText();
				curRateTf.setText(s.substring(0,s.length()-1));
			}
		}
		else if(e.getSource()==adjustmentAmtTf)
		{
			if((e.getKeyCode()>=48 && e.getKeyCode()<=57) || e.getKeyCode()==46 || e.getKeyCode()==8 || e.getKeyCode()==10){}
			else
			{
				String s=adjustmentAmtTf.getText();
				adjustmentAmtTf.setText(s.substring(0,s.length()-1));
			}
		}
		else if(e.getSource()==adjustmentWtTf)
		{
			if((e.getKeyCode()>=48 && e.getKeyCode()<=57) || e.getKeyCode()==46 || e.getKeyCode()==8 || e.getKeyCode()==10){}
			else
			{
				String s=adjustmentWtTf.getText();
				adjustmentWtTf.setText(s.substring(0,s.length()-1));
			}
		}
		else if(e.getSource()==depositeTf)
		{
			try
			{
				System.out.println("Ascii code:"+e.getKeyCode());
				if((e.getKeyCode()>=48 && e.getKeyCode()<=57) || e.getKeyCode()==46 || e.getKeyCode()==8 || e.getKeyCode()==45 || e.getKeyCode()==10)
				{
					/*
					double db=0;
					if(drCrCb.getSelectedItem().toString().equals(drCrLb.getText() ))
						db=curBalance+Double.valueOf(depositeTf.getText());
					else if(drCrLb.getText().equals("Dr") && drCrCb.getSelectedItem().toString().equals("Cr"))
					{
						db=curBalance-Double.valueOf(depositeTf.getText());
						if(db>=0)
							drCrLb.setText("Dr");
						else
							drCrLb.setText("Cr");
					}
					else if(drCrLb.getText().equals("Cr") && drCrCb.getSelectedItem().toString().equals("Dr"))
					{
						db=curBalance-Double.valueOf(depositeTf.getText());
						if(db>=0)
							drCrLb.setText("Cr");
						else
							drCrLb.setText("Dr");
					}
					db=Math.abs(db);
					curBal3L.setText(""+(new BigDecimal(db)).setScale(2,5));
					*/
				}
				else
				{
					String s=depositeTf.getText();
					depositeTf.setText(s.substring(0,s.length()-1));

				}
			}
			catch(Exception x)
			{
				curBal3L.setText(""+(new BigDecimal(curBalance)).setScale(2,5));
			}
		}
	}
	public void keyTyped(KeyEvent e)
	{

	}

	public void focusGained(FocusEvent e)
	{
		if(e.getSource()==openTf)
		{
			openTf.selectAll();
		}
		else if(e.getSource()==tounchTf)
		{
			tounchTf.selectAll();
		}
		else if(e.getSource()==dateTf)
		{
			dateTf.selectAll();
		}
		else if(e.getSource()==pieceTf)
		{
			pieceTf.selectAll();
		}
		else if(e.getSource()==openTf1)
		{
			openTf1.selectAll();
		}
		else if(e.getSource()==tounchTf1)
		{
			tounchTf1.selectAll();
		}
		else if(e.getSource()==pieceTf1)
		{
			pieceTf1.selectAll();
		}
	}
	public void focusLost(FocusEvent fe){}
	/*private boolean isBillExist()
	{
		try
		{
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	   		Connection cn=Utility.makeConnection();//DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed");
	   		Statement st=cn.createStatement();
	   		ResultSet rs;
	   		rs=st.executeQuery("select * from salechallan where s_s_no="+Integer.parseInt(billNoLb.getText()));
	   		if(rs.next())
	   		{
	   			return true;
	   		}
	   		else
	   		{
	   			rs=st.executeQuery("select * from sale_xChallan where s_s_no="+Integer.parseInt(billNoLb.getText()));
	   			{
	   				if(rs.next())
	   				{
	   					return true;
	   				}
	   			}
	   		}
	   		return false;
		}
		catch(Exception x)
		{
			System.out.println("error 198 ..."+x);
		}
		return false;
	}
	*/
	/*
	private boolean rollBackData()
	{
		try
		{
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	   		Connection cn=Utility.makeConnection();//DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed");
	   		Statement st=cn.createStatement();
	   		Statement stTemp=cn.createStatement();
	   		ResultSet rs,rsTemp;
	   		System.out.println("ok1 ...");
	   		rs=st.executeQuery("select * from salechallan where s_s_no="+Integer.parseInt(billNoLb.getText())+" and t_type='s'");
	   		while(rs.next())
	   		{
	   			String v2=rs.getString("i_name");
	   			String v6=rs.getString("f_wt");
	   			String v5=rs.getString("pcs");
	   			rsTemp=stTemp.executeQuery("select * from itemList where itemName='"+v2+"'");
				if(rsTemp.next())
				{
					BigDecimal bd1=rsTemp.getBigDecimal("weight");
					BigDecimal bd2=rsTemp.getBigDecimal("piece");
					bd1=bd1.add(new BigDecimal(v6));
					bd2=bd2.add(new BigDecimal(v5));
					stTemp.executeUpdate("update itemList set weight="+bd1+",piece="+bd2+" where itemName='"+v2+"'");
				}
			}
			System.out.println("ok2 ...");
			rs=st.executeQuery("select * from salechallan where s_s_no="+Integer.parseInt(billNoLb.getText())+" and t_type='a'");
	   		while(rs.next())
	   		{
	   			String v2=rs.getString("i_name");
	   			String v6=rs.getString("f_wt");
	   			String v5=rs.getString("pcs");
				rsTemp=stTemp.executeQuery("select * from itemList where itemName='"+v2+"'");
				if(rsTemp.next())
				{
					BigDecimal bd1=rsTemp.getBigDecimal("weight");
					BigDecimal bd2=rsTemp.getBigDecimal("piece");
					bd1=bd1.subtract(new BigDecimal(v6));
					bd2=bd2.subtract(new BigDecimal(v5));
					stTemp.executeUpdate("update itemList set weight="+bd1+",piece="+bd2+" where itemName='"+v2+"'");
				}
			}
				System.out.println("ok3 ...");
				rs=st.executeQuery("select * from sale_xChallan where s_s_no="+Integer.parseInt(billNoLb.getText())+"");
        		if(rs.next())
        		{
        			double s1rs=(rs.getDouble("field6")-rs.getDouble("field4"));
        			double s2gm=(rs.getDouble("field5")-rs.getDouble("field3"));
        			System.out.println("rs="+s1rs+"      gm="+s2gm);
        			//rollback current balance
        			rs=st.executeQuery("select * from partyDetails where partyName='"+partyCb.getSelectedItem().toString()+"'");
        			if(rs.next())
        			{
        				double rs1=rs.getDouble("currentAmt")-s1rs;
        				double gm1=rs.getDouble("currentWt")-s2gm;
        				System.out.println("update partyDetails set currentAmt='"+(""+rs1)+"',currentWt='"+(""+gm1)+"' where partyName='"+partyCb.getSelectedItem().toString()+"'");
        				st.executeUpdate("update partyDetails set currentAmt='"+(""+rs1)+"',currentWt='"+(""+gm1)+"' where partyName='"+partyCb.getSelectedItem().toString()+"'");
        			}

        			//now update to next all transaction
        			rs=st.executeQuery("select * from sale_xChallan where s_s_no="+Integer.parseInt(billNoLb.getText())+"");
        			if(rs.next())
        			{
        				if(drCrLb.getText().equals("Dr"))
        					curBal3L.setText("-"+curBal3L.getText());
        				s1rs=(Double.valueOf(curBal3L.getText())-rs.getDouble("field6"));
        				if(drCrLb.getText().equals("Dr"))
        					curBal3L.setText(""+(-Double.valueOf(curBal3L.getText())));

        				s2gm=(Double.valueOf(curBal1L.getText())-rs.getDouble("field5"));
        				System.out.println("Actual Difference :");
        				System.out.println("rs="+s1rs+"      gm="+s2gm);
        				rs=st.executeQuery("select slx.field3,slx.field4,slx.field5,slx.field6,slx.s_s_no from sale_xChallan slx,salechallan sl where sl.p_Name='"+partyCb.getSelectedItem().toString()+"' and sl.s_s_no=slx.s_s_no and slx.s_s_no>"+Integer.parseInt(billNoLb.getText()));
        				while(rs.next())
        				{
        					double gm1=rs.getDouble(1)+s2gm;
        					double rs1=rs.getDouble(2)+s1rs;
        					double gm2=rs.getDouble(3)+s2gm;
        					double rs2=rs.getDouble(4)+s1rs;
        					int id=rs.getInt(5);
        					System.out.println("update sale_xChallan set field3='"+(""+gm1)+"',field4='"+(""+rs1)+"',field5='"+(""+gm2)+"',field6='"+(""+rs2)+"' where s_s_no='"+id);
        					stTemp.executeUpdate("update sale_xChallan set field3='"+(""+gm1)+"',field4='"+(""+rs1)+"',field5='"+(""+gm2)+"',field6='"+(""+rs2)+"' where s_s_no="+id);
        				}
        			}
        		}
			//}
			System.out.println("ok4 ...");
			st.executeUpdate("delete from salechallan where s_s_no="+Integer.parseInt(billNoLb.getText()));
			System.out.println("ok5 ...");
			st.executeUpdate("delete from sale_xChallan where s_s_no="+Integer.parseInt(billNoLb.getText()));
			System.out.println("ok6 ...");
			return true;
		}
		catch(Exception x)
		{
			System.out.println("error 198 ..."+x);
		}
		return false;
	}
	*/

	private void saveData()
	{

				//System.out.println("inside save data ()");
									



		try
		{
			if(dateTf.getText().trim().length()>0)
			{
				//if(grid.getRowCount()>0 || grid1.getRowCount()>0)
				{
								//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	   							Connection cn=Utility.makeConnection();//DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed");
		  	          			Statement st=cn.createStatement();
		  	          			Statement st1=cn.createStatement();
		  	          			Statement stTemp=cn.createStatement();

		  	          			int psno=0;
        			    		int psno1=0;
        			    		ResultSet rs,rsTemp,rs1,rs2;

        			    		rs2=st.executeQuery("select max(s_s_no) from LastTounch");
		    	    		    if(rs2.next())
		    	    		    {
		    	    		    		psno1=rs2.getInt(1)+1;
		    	    		    }
        			    		/*if(updateFlag==false)
		    	    		    {
		    	    		    	rs=st.executeQuery("select max(s_s_no) from salechallan");
		    	    		    	if(rs.next())
		    	    		    	{
		    	    		    		psno=rs.getInt(1)+1;
		    	    		    	}
		    	    		    	rs=st.executeQuery("select max(s_s_no) from sale_xChallan");
			    	    		    if(rs.next())
			    	    		    {
			    	    		    	int n=rs.getInt(1)+1;
		    		    		    	if(n>psno)
		    		    		    		psno=n;
		    	    			    }
		    	    		    }
		    	    		    else*/
		    	    		    	psno=Integer.parseInt(billNoLb.getText());

		    	    		    String partynm=""+partyCb.getSelectedItem();

		    	    		    if(partynm.equals("-Select Party-"))
		    	    		    {
		    	    		    		JOptionPane.showMessageDialog(null,"Please Select The Corect Party Name");
		    	    		    		partyCb.requestFocus();
		    	    		    }
		    	    		    else
		    	    		    {

									
		    	    		    String dt="";
		    	    		    String tmp=dateTf.getText();
		    	    		    dt=tmp.substring(0,tmp.indexOf('/'));
		    	    		    tmp=tmp.substring(tmp.indexOf('/')+1,tmp.length());
		    	    		    dt=tmp.substring(0,tmp.indexOf('/'))+"/"+dt;
		    	    		    tmp=tmp.substring(tmp.indexOf('/')+1,tmp.length());
		    	    		    dt=tmp+"/"+dt;
		    	    		    int contFlag=0;
		    	    		    String qry="";
		    	   		    for(int i=0;i<grid.getRowCount();i++)
		    	    	    {
								String v1=""+grid.getValueAt(i,10);//amount
								if(v1.equals("null")==false && v1.equals("")==false)
								{
									
		    	    		    	contFlag=1;
		    	    		    	String v2=""+grid.getValueAt(i,1);//item name
									int serialno=0;
									int itemcode=Integer.parseInt(Utility.getSingleData("select itemcode from itemlist where itemname='"+v2+"'"));
									qry="insert into salechallan values("+psno+",'"+partynm+"','"+dt+"',"+itemcode;
									for(int col=2;col<=12;col++)
									{
										if((""+grid.getValueAt(i,col)).equals("null")==true)
											qry=qry+",0";
										else	
											qry=qry+","+Double.valueOf(""+grid.getValueAt(i,col));
									}
									qry=qry+",'s','s')";
									System.out.println("qry="+qry);
									st.executeUpdate(qry);
									
									/////////////////////
									//update item stock
									/////////////////////
									rsTemp=stTemp.executeQuery("select weight from itemList where itemcode="+itemcode);
									if(rsTemp.next())
									{
										double qty=rsTemp.getDouble(1);
										qty=qty-Double.valueOf(""+grid.getValueAt(i,5));
										stTemp.executeUpdate("update itemList set weight="+qty+" where itemcode="+itemcode);
									}
									
									/*st.executeUpdate("insert into LastTounch values("+psno1+",'"+partynm+"','"+v4+"','"+v2+"','"+v7+"')");
									rsTemp=stTemp.executeQuery("select * from itemList where categoryName='"+v1+"' and itemName='"+v2+"'");
									if(rsTemp.next())
									{
										BigDecimal bd1=rsTemp.getBigDecimal("weight");
										BigDecimal bd2=rsTemp.getBigDecimal("piece");
										bd1=bd1.subtract(new BigDecimal(v6));
										bd2=bd2.subtract(new BigDecimal(v5));
										stTemp.executeUpdate("update itemList set weight="+bd1+",piece="+bd2+" where categoryName='"+v1+"' and itemName='"+v2+"'");
									}*/
		    	    		    }
		    	    		}
		    	    		for(int i=0;i<grid1.getRowCount();i++)
		    	        	{
								String v1=""+grid1.getValueAt(i,10);//amount
								if(v1.equals("null")==false && v1.equals("")==false)
								{
									//System.out.println("a3");
										
		    	    		    	contFlag=1;
		    	    		    	String v2=""+grid1.getValueAt(i,1);//item name
									//System.out.println("a4");
									int serialno=0;
									int itemcode=Integer.parseInt(Utility.getSingleData("select itemcode from itemlist where itemname='"+v2+"'"));
									qry="insert into salechallan values("+psno+",'"+partynm+"','"+dt+"',"+itemcode;
									for(int col=2;col<=12;col++)
									{
										if((""+grid1.getValueAt(i,col)).equals("null")==true)
											qry=qry+",0";
										else	
											qry=qry+","+Double.valueOf(""+grid1.getValueAt(i,col));
									}
									qry=qry+",'a','s')";
									System.out.println("qry="+qry);
									st.executeUpdate(qry);

									
									/////////////////////
									//update item stock
									/////////////////////
									rsTemp=stTemp.executeQuery("select weight from itemList where itemcode="+itemcode);
									if(rsTemp.next())
									{
										double qty=rsTemp.getDouble(1);
										qty=qty+Double.valueOf(""+grid1.getValueAt(i,5));
										stTemp.executeUpdate("update itemList set weight="+qty+" where itemcode="+itemcode);
									}
		    	    		    }
							}
							
							String disamtvar=discounttf.getText().trim();
							if(disamtvar.equals(""))	disamtvar="0";		
							String qry1="insert into saleChallanAmtDetails values("+psno+","+Double.valueOf(totalPurWtL.getText())+","+Double.valueOf(totalAmountL.getText())+","+Double.valueOf(totalPurFineWtL.getText())+","+Double.valueOf(totalSilverFineWtL.getText())+","+Double.valueOf(totalPurWtL1.getText())+","+Double.valueOf(totalAmountL1.getText())+","+Double.valueOf(totalPurFineWtL1.getText())+","+Double.valueOf(totalSilverFineWtL1.getText())+","+Double.valueOf(totalPaybleAmtL.getText())+","+Double.valueOf(vatAmtL.getText())+","+Double.valueOf(disamtvar)+","+Double.valueOf(netPaybleAmtL.getText())+","+Double.valueOf(depositeTf.getText())+")";
							System.out.println(qry1);
							stTemp.executeUpdate(qry1);
							
            					/*for(int i=0;i<grid1.getRowCount();i++)
		    	    		    {
		    	    		    	contFlag=1;
		    	    		    	String v1=""+grid1.getValueAt(i,0);
		    	    		    	String v2=""+grid1.getValueAt(i,1);
		    	    		    	String v3=""+grid1.getValueAt(i,2);
		    	    		    	String v4=""+grid1.getValueAt(i,3);
		    	    		    	String v5=""+grid1.getValueAt(i,4);
		    	    		    	String v6=""+grid1.getValueAt(i,5);
									String v7="a";
									st.executeUpdate("insert into salechallan values("+psno+",'"+partynm+"','"+dt+"','"+v1+"','"+v2+"','"+v3+"','"+v4+"','"+v5+"','"+v6+"','"+v7+"')");
									//
									st.executeUpdate("insert into LastTounch values("+psno1+",'"+partynm+"','"+v4+"','"+v2+"','"+v7+"')");
									rsTemp=stTemp.executeQuery("select * from itemList where categoryName='"+v1+"' and itemName='"+v2+"'");
									if(rsTemp.next())
									{
										BigDecimal bd1=rsTemp.getBigDecimal("weight");
										BigDecimal bd2=rsTemp.getBigDecimal("piece");
										bd1=bd1.add(new BigDecimal(v6));
										bd2=bd2.add(new BigDecimal(v5));
										stTemp.executeUpdate("update itemList set weight="+bd1+",piece="+bd2+" where categoryName='"+v1+"' and itemName='"+v2+"'");
									}
		    	    		    }*/
								/*
		    	    		    if(contFlag==0)
		    	    		    {
		    	    		    	st.executeUpdate("insert into salechallan values("+psno+",'"+partynm+"','"+dt+"','','',0,0,0,0,'')");
		    	    		    }
		    	    		    double d1=Double.valueOf(totalPurWtL.getText());
		    	    		    double d2=Double.valueOf(totalPurFineWtL.getText());
		    	    		    double d3=Double.valueOf(lastBal1L.getText());
		    	    		    //double d4=Double.valueOf(lastBal2L.getText());
		    	    		    double d5=Double.valueOf(lastBal3L.getText());
		    	    		    if(drCrLb1.getText().equals("Dr"))
		    	    		    	d5=-d5;
		    	    		    //double d6=Double.valueOf(lastBal4L.getText());
		    	    		    double d7=Double.valueOf(curBal1L.getText());
		    	    		    //double d8=Double.valueOf(curBal2L.getText());
		    	    		    double d9=Double.valueOf(curBal3L.getText());
		    	    		    if(drCrLb.getText().equals("Dr"))
		    	    		    	d9=-d9;
		    	    		    //double d10=Double.valueOf(curBal4L.getText());
		    	    		    double d11=Double.valueOf(totalPurWtL1.getText());
		    	    		    double d12=Double.valueOf(totalPurFineWtL1.getText());
		    	    		    double d13=0;
		    	    		    double d14=0;
		    	    		    double d15=0;
		    	    		    int d16=0;
		    	    		    int d17=0;
		    	    		    int d18=0;
		    	    		    double d19=0;
		    	    		    if(curRateTf.getText().trim().length()>0)
		    	    		    	d13=Double.valueOf(curRateTf.getText());
		    	    		    if(adjustmentWtTf.getText().trim().length()>0)
		    	    		    	d14=Double.valueOf(adjustmentWtTf.getText());
		    	    		    if(adjustmentAmtTf.getText().trim().length()>0)
		    	    		    	d15=Double.valueOf(adjustmentAmtTf.getText());
		    	    		    if(depositeTf.getText().trim().length()>0)
		    	    		    {
									d19=0;
									if(drCrCb.getSelectedIndex()>0)
		    	    		    	{
		    	    		    		d19=Double.valueOf(depositeTf.getText());
		    	    		    		d19=Math.abs(d19);
		    	    		    		if(drCrCb.getSelectedItem().toString().equals("Dr"))
		    	    		    			d19=-d19;
		    	    		    	}
		    	    		    }
		    	    		    if(adjustTb.isSelected()==true)
		    	    		    	d16=1;
            					if(depositeTb.isSelected()==true)
		    	    		    	d17=1;
		    	    		    if(pendingTb.isSelected()==true)
		    	    		    	d18=1;
		    	    		    	String rateType=""+gmOrBhari.getSelectedItem();
		    	    		    	st.executeUpdate("insert into sale_xChallan values("+psno+","+d1+","+d2+","+d3+","+d5+","+d7+","+d9+","+d11+","+d12+","+d13+","+d14+","+d15+","+d16+","+d17+","+d18+",'"+rateType+"',"+d19+")");
		    	    		    	*/

									//update stock-->'partyDetails' table
		    	    		    	/*rs=st.executeQuery("select max(s_s_no) from salechallan where p_name='"+partyCb.getSelectedItem()+"'");
		    	    		    	if(rs.next())
		    	    		    	{
		    	    		    		psno=rs.getInt(1);
		    	    		    	}*/

	            					JOptionPane.showMessageDialog(null,"Process completed.");
									/*rs=st.executeQuery("select * from sale_xChallan where s_s_no="+psno);
									if(rs.next())
									{
										stTemp.executeUpdate("update partyDetails set currentAmt='"+rs.getString("field6")+"',currentWt='"+rs.getString("field5")+"' where 	partyName='"+partyCb.getSelectedItem()+"' and p_type='s'");
									}
									*/
            						cn.close();
            						}
            						//JOptionPane.showMessageDialog(null,"Process completed.");
            	}
            }
            else
            {
            	JOptionPane.showMessageDialog(null,"Enter date, please.");
            	dateTf.requestFocus();
            }
		}
		catch(Exception x)
		{
			System.out.println("error 98 ..."+x);
		}


	}

	private void saveDataInTempTable()
	{

		try
		{
			if(dateTf.getText().trim().length()>0)
			{
				//if(grid.getRowCount()>0 || grid1.getRowCount()>0)
				{
					//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		Connection cn=Utility.makeConnection();//DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed");
		  	          			Statement st=cn.createStatement();
		  	          			Statement stTemp=cn.createStatement();
		  	          			int psno=Integer.parseInt(billNoLb.getText());

        			    		ResultSet rs,rsTemp;
        			    		st.executeUpdate("delete from sale_temp");
        			    		st.executeUpdate("delete from sale_x_temp");

		    	    		    String partynm=""+partyCb.getSelectedItem();
		    	    		    if(partynm.equals("-Select Party-"))
		    	    		    	{
		    	    		    		JOptionPane.showMessageDialog(null,"Please Select The Correct Party Name");
		    	    		    		partyCb.requestFocus();
		    	    		    	}
		    	    		    else
		    	    		    {
		    	    		    String dt="";
		    	    		    String tmp=dateTf.getText();
		    	    		    dt=tmp.substring(0,tmp.indexOf('/'));
		    	    		    tmp=tmp.substring(tmp.indexOf('/')+1,tmp.length());
		    	    		    dt=tmp.substring(0,tmp.indexOf('/'))+"/"+dt;
		    	    		    tmp=tmp.substring(tmp.indexOf('/')+1,tmp.length());
		    	    		    dt=dt+"/"+tmp;

		    	    		    for(int i=0;i<grid.getRowCount();i++)
		    	    		    {
		    	    		    	String v1=""+grid.getValueAt(i,0);
		    	    		    	String v2=""+grid.getValueAt(i,1);
		    	    		    	String v3=""+grid.getValueAt(i,2);
		    	    		    	String v4=""+grid.getValueAt(i,3);
		    	    		    	String v5=""+grid.getValueAt(i,4);
		    	    		    	String v6=""+grid.getValueAt(i,5);
									String v7="s";
									st.executeUpdate("insert into Sale_temp values("+psno+",'"+partynm+"','"+dt+"','"+v1+"','"+v2+"','"+v3+"','"+v4+"','"+v5+"','"+v6+"','"+v7+"')");

		    	    		    }
            					for(int i=0;i<grid1.getRowCount();i++)
		    	    		    {
		    	    		    	String v1=""+grid1.getValueAt(i,0);
		    	    		    	String v2=""+grid1.getValueAt(i,1);
		    	    		    	String v3=""+grid1.getValueAt(i,2);
		    	    		    	String v4=""+grid1.getValueAt(i,3);
		    	    		    	String v5=""+grid1.getValueAt(i,4);
		    	    		    	String v6=""+grid1.getValueAt(i,5);
									String v7="a";
									st.executeUpdate("insert into Sale_temp values("+psno+",'"+partynm+"','"+dt+"','"+v1+"','"+v2+"','"+v3+"','"+v4+"','"+v5+"','"+v6+"','"+v7+"')");

		    	    		    }

		    	    		    double d1=Double.valueOf(totalPurWtL.getText());
		    	    		    double d2=Double.valueOf(totalPurFineWtL.getText());
		    	    		    double d3=Double.valueOf(lastBal1L.getText());
		    	    		    //double d4=Double.valueOf(lastBal2L.getText());
		    	    		    double d5=Double.valueOf(lastBal3L.getText());
		    	    		    //double d6=Double.valueOf(lastBal4L.getText());
		    	    		    double d7=Double.valueOf(curBal1L.getText());
		    	    		    //double d8=Double.valueOf(curBal2L.getText());
		    	    		    double d9=Double.valueOf(curBal3L.getText());
		    	    		    //double d10=Double.valueOf(curBal4L.getText());
		    	    		    double d11=Double.valueOf(totalPurWtL1.getText());
		    	    		    double d12=Double.valueOf(totalPurFineWtL1.getText());
		    	    		    double d13=0;
		    	    		    double d14=0;
		    	    		    double d15=0;
		    	    		    boolean d16=false;
		    	    		    boolean d17=false;
		    	    		    boolean d18=false;
		    	    		    double d19=0;
		    	    		    if(curRateTf.getText().trim().length()>0)
		    	    		    	d13=Double.valueOf(curRateTf.getText());
		    	    		    if(adjustmentWtTf.getText().trim().length()>0)
		    	    		    	d14=Double.valueOf(adjustmentWtTf.getText());
		    	    		    if(adjustmentAmtTf.getText().trim().length()>0)
		    	    		    	d15=Double.valueOf(adjustmentAmtTf.getText());
		    	    		    if(depositeTf.getText().trim().length()>0)
		    	    		    	d19=Double.valueOf(depositeTf.getText());
		    	    		    if(adjustTb.isSelected()==true)
		    	    		    	d16=true;
            					//if(depositeTb.isSelected()==true)
		    	    		    //	d17=true;
		    	    		    if(pendingTb.isSelected()==true)
		    	    		    	d18=true;
		    	    		    String rateType=""+gmOrBhari.getSelectedItem();
		    	    		    st.executeUpdate("insert into Sale_x_temp values("+psno+","+d1+","+d2+","+d3+","+d5+","+d7+","+d9+","+d11+","+d12+","+d13+","+d14+","+d15+","+d16+","+d17+","+d18+",'"+rateType+"',"+d19+")");

								cn.close();
								printchallan pb=new printchallan(desk);
								}

            	}
            }
            else
            {
            	JOptionPane.showMessageDialog(null,"Enter date, please.");
            	dateTf.requestFocus();
            }
		}
		catch(Exception x)
		{
			System.out.println("error 98 ..."+x);
		}


	}

	private void reset()
	{
		System.out.println("reset in");
		//itemTf.setText("");
        /*openTf.setText("");
        tounchTf.setText("");
        fineWtLb.setText("");
        pieceTf.setText("");

        openTf1.setText("");
        tounchTf1.setText("");
        fineWtLb1.setText("");
        pieceTf1.setText("");
		*/
		
        while(grid.getRowCount()>0)		dtm.removeRow(0);
        while(grid1.getRowCount()>0)	dtm1.removeRow(0);
		String blankrow[]=new String[12];
		dtm.addRow(blankrow);
		dtm1.addRow(blankrow);
		//adjustmentWtTf.setText("");
		//adjustmentAmtTf.setText("");
		
		totalPurWtL.setText("0");
		totalAmountL.setText("0");
		totalPurFineWtL.setText("0");
		totalSilverFineWtL.setText("0");
		
		totalPurWtL1.setText("0");
		totalAmountL1.setText("0");
		totalPurFineWtL1.setText("0");
		totalSilverFineWtL1.setText("0");
		
		lastBal1L.setText("0");
		lastBal3L.setText("0");
		curBal1L.setText("0");
		curBal3L.setText("0");

		netPaybleAmtL.setText("0.00");
		discounttf.setText("");
		vatAmtL.setText("0.00");
		totalPaybleAmtL.setText("0.00");
		//adjustTb.setSelected(false);
		//pendingTb.setSelected(false);
		//depositeTb.setSelected(true);

		depositeTf.setText("0");
		depositeTf.setVisible(true);
		drCrCb.setVisible(true);

		partyCb.setSelectedIndex(0);

        partyCb.requestFocus();

		billNoLb.setText(""+getCurrentBillNo());
        //getItemName();
		System.out.println("reset end");
	}
	private void deleteData()
	{
		/*int res=JOptionPane.showConfirmDialog(null,"Are you sure?","Confirm dialog box",JOptionPane.YES_NO_OPTION);
		if(res==JOptionPane.YES_OPTION)
		{
			try
			{
				if(itemTf.getText().trim().length()>0)
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	        	Connection cn=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed");
	            	Statement st=cn.createStatement();
        		    ResultSet rs;
        		    rs=st.executeQuery("select * from itemList where categoryName='"+categoryCb.getSelectedItem()+"' and itemName='"+itemTf.getText().trim()+"'");
        		    if(rs.next())
        		    {
        		    	st.executeUpdate("delete from itemList where categoryName='"+categoryCb.getSelectedItem()+"' and itemName='"+itemTf.getText().trim()+"'");
        		    	JOptionPane.showMessageDialog(null,"Item name has been deleted successfully.");
	            		itemTf.setText("");
	            		getItemName();
            			itemTf.requestFocus();
        		    }
        		    else
            		{
            			//st.executeUpdate("insert into categoryList values('"+categoryLb.getText().trim().toUpperCase()+"')");
    	        		JOptionPane.showMessageDialog(null,"Oh! Invalid item name found.");
	            		itemTf.setText("");
            			itemTf.requestFocus();
            		}
            		cn.close();
            	}
            	else
            	{
            		JOptionPane.showMessageDialog(null,"Enter item name, please.");
            		itemTf.requestFocus();
            	}
            }
			catch(Exception x)
			{
				System.out.println("er01..."+x);
			}
		}*/
	}
	private String[] getCategoryName()
	{
			String arraylist[]=null;
			try
			{
					//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		Connection cn=Utility.makeConnection();//DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed");
	            	Statement st=cn.createStatement();
        		    ResultSet rs;
        		    //while(grid.getRowCount()>0)	dtm.removeRow(0);

        		    String categoryName="";
        		    rs=st.executeQuery("select * from categoryList order by categoryName");
        		    while(rs.next())
        		    {

        		    	categoryName=categoryName+rs.getString("categoryName")+",";
        		    	//categoryCb.addItem(str);
        		    	//categoryCb1.addItem(str);

        		    }
        		    String list[]=categoryName.split(",");
		           	cn.close();
		           	return list;
            }
			catch(Exception x)
			{
				System.out.println("er01..."+x);
			}
			return arraylist;

	}
	private String[] getItemName(String categoryName)
	{
		String temparr[]=null;
			try
			{
					//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		Connection cn=Utility.makeConnection();//DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed");
	            	Statement st=cn.createStatement();
        		    ResultSet rs;
        		    //itemCb.removeAllItems();
        		    String itemName="";
        		    System.out.println("select * from itemList  where categoryName='"+categoryName+"'  order by itemName");
        		    rs=st.executeQuery("select * from itemList  where categoryName='"+categoryName+"'  order by itemName");
        		    while(rs.next())
        		    {
        		    	itemName=itemName+rs.getString("itemName")+",";
        		    }
        		    String itemlist[]=itemName.split(",");
		           	cn.close();
		           	return itemlist;
            }
			catch(Exception x)
			{
				System.out.println("er01..."+x);
			}
		return temparr;
	}
	private void getItemName1()
	{
			try
			{
					//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		Connection cn=Utility.makeConnection();//DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed");
	            	Statement st=cn.createStatement();
        		    ResultSet rs;
        		    itemCb1.removeAllItems();
        		    rs=st.executeQuery("select * from itemList order by itemName");//where categoryName='"+categoryCb1.getSelectedItem()+"'
        		    while(rs.next())
        		    {
        		    	itemCb1.addItem(rs.getString("itemName"));
        		    }
		           	cn.close();
            }
			catch(Exception x)
			{
				System.out.println("er01..."+x);
			}

	}
	private void setCategoryName()
	{
			try
			{
					//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		Connection cn=Utility.makeConnection();//DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed");
	            	Statement st=cn.createStatement();
        		    ResultSet rs;
        		    rs=st.executeQuery("select * from itemList  where itemName='"+itemCb.getSelectedItem()+"'");
        		    if(rs.next())
        		    {
        		    	categoryCb.setSelectedItem(rs.getString("categoryName"));
        		    }
		           	cn.close();
            }
			catch(Exception x)
			{
				System.out.println("er01..."+x);
			}

	}

	private void setCategoryName1()
	{
			try
			{
					//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		Connection cn=Utility.makeConnection();//DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed");
	            	Statement st=cn.createStatement();
        		    ResultSet rs;
        		    rs=st.executeQuery("select * from itemList  where itemName='"+itemCb1.getSelectedItem()+"'");
        		    if(rs.next())
        		    {
        		    	categoryCb1.setSelectedItem(rs.getString("categoryName"));
        		    }
		           	cn.close();
            }
			catch(Exception x)
			{
				System.out.println("er01..."+x);
			}

	}

	private void getPartyName()
	{
			try
			{
					//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		Connection cn=Utility.makeConnection();//DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed");
	            	Statement st=cn.createStatement();
        		    ResultSet rs;
        		    while(grid.getRowCount()>0)	dtm.removeRow(0);
        		    partyCb.addItem("-Select Party-");
        		    rs=st.executeQuery("select * from partyDetails where p_type='s' order by partyName ");
        		    while(rs.next())
        		    {

        		    	partyCb.addItem(rs.getString("partyName"));

        		    }
		           	cn.close();
            }
			catch(Exception x)
			{
				System.out.println("er01..."+x);
			}

	}
	private int getCurrentBillNo()
	{
			try
			{
					int psno=0;
					//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		Connection cn=Utility.makeConnection();//DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed");
	            	Statement st=cn.createStatement();
        		    ResultSet rs;
		    	    		    rs=st.executeQuery("select max(s_s_no) from Salechallan");
		    	    		    if(rs.next())
		    	    		    {
		    	    		    	psno=rs.getInt(1)+1;
		    	    		    }
		    	    		    rs=st.executeQuery("select max(s_s_no) from SALERETAILCHALLAN");
		    	    		    if(rs.next())
		    	    		    {
		    	    		    	int n=rs.getInt(1)+1;
		    	    		    	if(n>psno)
		    	    		    		psno=n;
		    	    		    }
		           	cn.close();
		           	return psno;
            }
			catch(Exception x)
			{
				System.out.println("er01..."+x);
			}
			return 0;

	}
	private String getLastTounch(String partyname,String itemname)
	{
			String lasttounch="0";
			try
			{
					//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		Connection cn=Utility.makeConnection();//DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed");
	            	Statement st=cn.createStatement();
	            	//String pname=""+partyCb.getSelectedItem();
	            	//String iname=""+itemCb.getSelectedItem();
	            	//int bno=Integer.parseInt(billNoLb.getText());

					int itemcode=0;
        		    ResultSet rs=st.executeQuery("select itemcode from itemlist where itemname='"+itemname+"'");//and s_s_no<"+bno+"
        		    if(rs.next())
        		    {
        		    	itemcode=rs.getInt(1);
        		    }
        		    System.out.println("select tnh from LastTounch where i_code='"+itemcode+"' and p_name='"+partyname+"'  and t_type='s' order by s_s_no desc");
        		    rs=st.executeQuery("select tnh from LastTounch where i_code="+itemcode+" and p_name='"+partyname+"'  and t_type='s' order by s_s_no desc");//and s_s_no<"+bno+"
        		    if(rs.next())
        		    {
        		    	//lastTounchLb.setText(""+rs.getBigDecimal("tnh").setScale(2,5));
        		    	lasttounch=""+rs.getBigDecimal("tnh").setScale(2,5);
        		    }
        		    /*else
        		    {
        		    	lasttounch="NA";
        		    }*/
  					cn.close();
            }
			catch(Exception x)
			{
				System.out.println("er015..."+x);
			}
			return lasttounch;
	}
	private void getLastTounch1()
	{
			try
			{
					//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		Connection cn=Utility.makeConnection();//DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed");
	            	Statement st=cn.createStatement();
	            	String pname=""+partyCb.getSelectedItem();
	            	String iname=""+itemCb1.getSelectedItem();
	            	int bno=Integer.parseInt(billNoLb.getText());
        		    ResultSet rs=st.executeQuery("select tnh from LastTounch where i_name='"+iname+"' and p_name='"+pname+"'   and t_type='a' order by s_s_no desc");//and s_s_no<"+bno+"
        		    if(rs.next())
        		    {
        		    	lastTounchLb1.setText(""+rs.getBigDecimal("tnh").setScale(2,5));
        		    }
        		    else
        		    {
        		    	lastTounchLb1.setText("NA");
        		    }
  					cn.close();
            }
			catch(Exception x)
			{
				System.out.println("er01..."+x);
			}
	}
	private void addNewRecord()
	{
			try
			{
					String arr[]=new String[6];
					arr[0]=""+categoryCb.getSelectedItem();
					arr[1]=""+itemCb.getSelectedItem();
					arr[2]=openTf.getText();
					arr[3]=tounchTf.getText();
					arr[4]=pieceTf.getText();
					arr[5]=fineWtLb.getText();
					dtm.addRow(arr);
					openTf.setText("");
					tounchTf.setText("");
					fineWtLb.setText("");
					pieceTf.setText("");
					getTotalPurFineWt();
					getTotalPurWt();
					categoryCb.requestFocus();
            }
			catch(Exception x)
			{
				System.out.println("er01..."+x);
			}

	}
	private void getTotalPurWt()
	{
			try
			{

					BigDecimal total=new BigDecimal("0");
					for(int i=0;i<dtm.getRowCount();i++)
					{
						total=total.add(new BigDecimal(""+dtm.getValueAt(i,2)));
					}
					totalPurWtL.setText(""+total.setScale(3,5));
					/*
					total=total.add(new BigDecimal(""+lastBal1L.getText())).subtract(new BigDecimal(""+totalPurWtL1.getText()));
					//curBal1L.setText(""+total.setScale(3,5));

					if(total.compareTo(new BigDecimal("0"))==1)
					{
						curBal1L.setText(""+total.setScale(3,5));
						curBal2L.setText("0");
					}
					else if(total.compareTo(new BigDecimal("0"))==-1)
					{
						curBal2L.setText(""+total.setScale(3,5));
						curBal1L.setText("0");
					}
					else
					{
						curBal1L.setText("0");
						curBal2L.setText("0");
					}*/
            }
			catch(Exception x)
			{
				System.out.println("er01..."+x);
			}

	}
	private void getTotalPurFineWt()
	{
			try
			{
					curBal1L.setText("0");
					BigDecimal total=new BigDecimal("0");
					for(int i=0;i<dtm.getRowCount();i++)
					{
						total=total.add(new BigDecimal(""+dtm.getValueAt(i,5)));
					}
					totalPurFineWtL.setText(""+total.setScale(3,5));

					total=total.add(new BigDecimal(""+lastBal1L.getText())).subtract(new BigDecimal(""+totalPurFineWtL1.getText()));
					curBal1L.setText(""+total.setScale(3,5));

					/*if(total.compareTo(new BigDecimal("0"))==1)
					{
						curBal1L.setText(""+total.setScale(3,5));
						curBal2L.setText("0");
					}
					else if(total.compareTo(new BigDecimal("0"))==-1)
					{
						curBal2L.setText(""+total.setScale(3,5));
						curBal1L.setText("0");
					}
					else
					{
						curBal1L.setText("0");
						curBal2L.setText("0");
					}*/
            }
			catch(Exception x)
			{
				System.out.println("er01..."+x);
			}

	}
	private void addNewRecord1()
	{
			try
			{
					String arr[]=new String[6];
					arr[0]=""+categoryCb1.getSelectedItem();
					arr[1]=""+itemCb1.getSelectedItem();
					arr[2]=openTf1.getText();
					arr[3]=tounchTf1.getText();
					arr[4]=pieceTf1.getText();
					arr[5]=fineWtLb1.getText();
					dtm1.addRow(arr);
					openTf1.setText("");
					tounchTf1.setText("");
					fineWtLb1.setText("");
					pieceTf1.setText("");
					getTotalPurFineWt1();
					getTotalPurWt1();
					categoryCb1.requestFocus();
            }
			catch(Exception x)
			{
				System.out.println("er01..."+x);
			}

	}
	private void getTotalPurWt1()
	{
			try
			{
					BigDecimal total=new BigDecimal("0");
					for(int i=0;i<dtm1.getRowCount();i++)
					{
						total=total.add(new BigDecimal(""+dtm1.getValueAt(i,2)));
					}
					totalPurWtL1.setText(""+total.setScale(3,5));
					/*total=(new BigDecimal(""+totalPurWtL.getText())).add(new BigDecimal(""+lastBal1L.getText())).subtract(new BigDecimal(""+totalPurWtL1.getText()));
					//curBal1L.setText(""+total.setScale(3,5));
					if(total.compareTo(new BigDecimal("0"))==1)
					{
						curBal1L.setText(""+total.setScale(3,5));
						curBal2L.setText("0");
					}
					else if(total.compareTo(new BigDecimal("0"))==-1)
					{
						curBal2L.setText(""+total.setScale(3,5));
						curBal1L.setText("0");
					}
					else
					{
						curBal1L.setText("0");
						curBal2L.setText("0");
					}*/
            }
			catch(Exception x)
			{
				System.out.println("er01..."+x);
			}

	}
	private void getTotalPurFineWt1()
	{
			try
			{
					BigDecimal total=new BigDecimal("0");
					for(int i=0;i<dtm1.getRowCount();i++)
					{
						total=total.add(new BigDecimal(""+dtm1.getValueAt(i,5)));
					}
					totalPurFineWtL1.setText(""+total.setScale(3,5));

					total=(new BigDecimal(""+totalPurFineWtL.getText())).add(new BigDecimal(""+lastBal1L.getText())).subtract(new BigDecimal(""+totalPurFineWtL1.getText()));
					curBal1L.setText(""+total.setScale(3,5));

					/*if(total.compareTo(new BigDecimal("0"))==1)
					{
						curBal1L.setText(""+total.setScale(3,5));
						curBal2L.setText("0");
					}
					else if(total.compareTo(new BigDecimal("0"))==-1)
					{
						curBal2L.setText(""+total.setScale(3,5));
						curBal1L.setText("0");
					}
					else
					{
						curBal1L.setText("0");
						curBal2L.setText("0");
					}*/
            }
			catch(Exception x)
			{
				System.out.println("er01..."+x);
			}

	}
	private void getLastBalance()
	{
			try
			{
					//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		Connection cn=Utility.makeConnection();//DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed");
	            	Statement st=cn.createStatement();
        		    ResultSet rs;
        		    lastBal1L.setText("0");
        		    lastBal2L.setText("0");
        		    lastBal3L.setText("0");
        		    lastBal4L.setText("0");
        		    //System.out.println("select purx.field7 from Sale_x purx,Sale pur where pur.p_name='"+partyCb.getSelectedItem()+"'  order by purx.p_date desc");
        		    //rs=st.executeQuery("select purx.field5,purx.field6 from Sale_x purx,Sale pur where pur.p_name='"+partyCb.getSelectedItem()+"' and purx.s_s_no=pur.s_s_no order by pur.p_date desc,pur.s_s_no desc");
        		    rs=st.executeQuery("select currentWt,currentAmt from partyDetails where partyName='"+partyCb.getSelectedItem()+"'");
        		    if(rs.next())
        		    {

        		    	lastBal1L.setText(""+rs.getBigDecimal(1).setScale(3,5));
        		    	curBal1L.setText(lastBal1L.getText());
        		    	//lastBal2L.setText(""+rs.getBigDecimal(2).setScale(3,5));
        		    	String temp=""+rs.getBigDecimal(2).setScale(2,5);
        		    	System.out.println("last closing balance="+temp);
        		    	if(Double.valueOf(temp)>=0)
        		    	{
        		    		drCrLb.setText("Cr");
        		    		drCrLb1.setText("Cr");
        		    	}
        		    	else
        		    	{
        		    		drCrLb.setText("Dr");
        		    		drCrLb1.setText("Dr");
        		    	}
        		    	temp=""+Math.abs(Double.valueOf(temp));
        		    	lastBal3L.setText(""+(new BigDecimal(temp)).setScale(2,5));
        		    	curBal3L.setText(lastBal3L.getText());
        		    	//lastBal4L.setText(""+rs.getBigDecimal(4).setScale(2,5));

        		    }
		           	cn.close();
            }
			catch(Exception x)
			{
				System.out.println("er01..."+x);
			}

	}
	/*
	private void showPreBill()
	{
		String openedBillNo=billNoLb.getText();
		try
		{
					//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		Connection cn=Utility.makeConnection();//DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed");
	            	Statement st=cn.createStatement();
        		    ResultSet rs;
					String partynm=""+partyCb.getSelectedItem();
        		    rs=st.executeQuery("select * from salechallan where p_Name='"+partynm+"' and s_s_no<"+Integer.parseInt(billNoLb.getText())+" order by s_s_no desc");
        		    if(rs.next())
        		    {
        		    	reset();
        		    	partyCb.setSelectedItem(partynm);
        		    	billNoLb.setText(rs.getString("s_s_no"));

						String temp=""+rs.getDate("s_date");
						temp=temp.substring(8,10)+"/"+temp.substring(5,7)+"/"+temp.substring(0,4);
        		    	dateTf.setText(temp);

        		    	rs=st.executeQuery("select * from salechallan where s_s_no="+Integer.parseInt(billNoLb.getText())+" and t_type='s'");
        		    	while(rs.next())
        		    	{
        		    		String arr[]=new String[6];
        		    		arr[0]=rs.getString("c_name");
        		    		arr[1]=rs.getString("i_name");
        		    		arr[2]=rs.getString("wt");
        		    		arr[3]=rs.getString("tnh");
        		    		arr[4]=rs.getString("pcs");
        		    		arr[5]=rs.getString("f_wt");
        		    		dtm.addRow(arr);
        		    	}
        		    	rs=st.executeQuery("select * from salechallan where s_s_no="+Integer.parseInt(billNoLb.getText())+" and t_type='a'");
        		    	while(rs.next())
        		    	{
        		    		String arr[]=new String[6];
	        		    		arr[0]=rs.getString("c_name");
        		    		arr[1]=rs.getString("i_name");
        		    		arr[2]=rs.getString("wt");
        		    		arr[3]=rs.getString("tnh");
        		    		arr[4]=rs.getString("pcs");
        		    		arr[5]=rs.getString("f_wt");
        		    		dtm1.addRow(arr);
        		    	}

        		    	rs=st.executeQuery("select * from sale_xChallan where s_s_no="+Integer.parseInt(billNoLb.getText())+"");
        		    	if(rs.next())
        		    	{
        		    		totalPurWtL.setText(rs.getString("field1"));
        		    		totalPurFineWtL.setText(rs.getString("field2"));
        		    		lastBal1L.setText(rs.getString("field3"));
        		    		double db=rs.getDouble("field4");
        		    		if(db>0)
        		    			drCrLb1.setText("Cr");
        		    		else
        		    			drCrLb1.setText("Dr");
        		    		db=Math.abs(db);
        		    		lastBal3L.setText(""+(new BigDecimal(db)).setScale(2,5) );

        		    		curBal1L.setText(rs.getString("field5"));

        		    		totalPurWtL1.setText(rs.getString("field7"));
        		    		totalPurFineWtL1.setText(rs.getString("field8"));

        		    		gmOrBhari.setSelectedItem(rs.getString("rate_type"));
        		    		curRateTf.setText(rs.getString("field9"));
        		    		adjustmentWtTf.setText(rs.getString("field10"));
        		    		adjustmentAmtTf.setText(rs.getString("field11"));

        		    		adjustTb.setSelected(rs.getBoolean("btn1"));
        		    		pendingTb.setSelected(rs.getBoolean("btn3"));
        		    		//depositeTb.setSelected(rs.getBoolean("btn2"));
        		    		//if(depositeTb.isSelected())
        		    		{
        		    			depositeTf.setVisible(true);
        		    			drCrCb.setVisible(true);

        		    			db=rs.getDouble("jama");
        		    			if(db>0)
        			    			drCrCb.setSelectedItem("Cr");
        			    		else if(db<0)
        			    			drCrCb.setSelectedItem("Dr");
        			    		else
        			    			drCrCb.setSelectedIndex(0);

    	    		    		db=Math.abs(db);
	        		    		depositeTf.setText(""+(new BigDecimal(db)).setScale(2,5));
        		    		}

        		    		db=rs.getDouble("field6");
        		    		if(db>0)
        		    			drCrLb.setText("Cr");
        		    		else
        		    			drCrLb.setText("Dr");
        		    		db=Math.abs(db);
        		    		curBal3L.setText(""+(new BigDecimal(db)).setScale(2,5));

        		    	}

	  		    }
		           	cn.close();

		}
		catch(Exception x)
		{
			System.out.println("Error...829..."+x);
		}
	}
	*/

	/*
	private void showNextBill()
	{
		String openedBillNo=billNoLb.getText();
		try
		{
					//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		Connection cn=Utility.makeConnection();//DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed");
	            	Statement st=cn.createStatement();
        		    ResultSet rs;
					String partynm=""+partyCb.getSelectedItem();
        		    rs=st.executeQuery("select * from salechallan where p_Name='"+partynm+"' and s_s_no>"+Integer.parseInt(billNoLb.getText())+" order by s_s_no");
        		    if(rs.next())
        		    {
        		    	reset();
        		    	partyCb.setSelectedItem(partynm);
        		    	billNoLb.setText(rs.getString("s_s_no"));

        		    	String temp=""+rs.getDate("s_date");
						temp=temp.substring(8,10)+"/"+temp.substring(5,7)+"/"+temp.substring(0,4);
        		    	dateTf.setText(temp);

        		    	rs=st.executeQuery("select * from salechallan where s_s_no="+Integer.parseInt(billNoLb.getText())+" and t_type='s'");
        		    	while(rs.next())
        		    	{
        		    		String arr[]=new String[6];
        		    		arr[0]=rs.getString("c_name");
        		    		arr[1]=rs.getString("i_name");
        		    		arr[2]=rs.getString("wt");
        		    		arr[3]=rs.getString("tnh");
        		    		arr[4]=rs.getString("pcs");
        		    		arr[5]=rs.getString("f_wt");
        		    		dtm.addRow(arr);
        		    	}
        		    	rs=st.executeQuery("select * from salechallan where s_s_no="+Integer.parseInt(billNoLb.getText())+" and t_type='a'");
        		    	while(rs.next())
        		    	{
        		    		String arr[]=new String[6];
        		    		arr[0]=rs.getString("c_name");
        		    		arr[1]=rs.getString("i_name");
        		    		arr[2]=rs.getString("wt");
        		    		arr[3]=rs.getString("tnh");
        		    		arr[4]=rs.getString("pcs");
        		    		arr[5]=rs.getString("f_wt");
        		    		dtm1.addRow(arr);
        		    	}

        		    	rs=st.executeQuery("select * from sale_xChallan where s_s_no="+Integer.parseInt(billNoLb.getText())+"");
        		    	if(rs.next())
        		    	{
        		    		totalPurWtL.setText(rs.getString("field1"));
        		    		totalPurFineWtL.setText(rs.getString("field2"));
        		    		lastBal1L.setText(rs.getString("field3"));
        		    		//lastBal3L.setText(rs.getString("field4"));
        		    		double db=rs.getDouble("field4");
        		    		if(db>0)
        		    			drCrLb1.setText("Cr");
        		    		else
        		    			drCrLb1.setText("Dr");
        		    		db=Math.abs(db);
        		    		lastBal3L.setText(""+(new BigDecimal(db)).setScale(2,5) );

        		    		curBal1L.setText(rs.getString("field5"));


        		    		totalPurWtL1.setText(rs.getString("field7"));
        		    		totalPurFineWtL1.setText(rs.getString("field8"));

        		    		gmOrBhari.setSelectedItem(rs.getString("rate_type"));
        		    		curRateTf.setText(rs.getString("field9"));
        		    		adjustmentWtTf.setText(rs.getString("field10"));
        		    		adjustmentAmtTf.setText(rs.getString("field11"));

        		    		adjustTb.setSelected(rs.getBoolean("btn1"));
        		    		pendingTb.setSelected(rs.getBoolean("btn3"));
        		    		//depositeTb.setSelected(rs.getBoolean("btn2"));
        		    		//if(depositeTb.isSelected())
        		    		{
        		    			depositeTf.setVisible(true);
        		    			drCrCb.setVisible(true);
        		    			//depositeTf.setText(rs.getString("jama"));
        		    			db=rs.getDouble("jama");
        		    			if(db>0)
        			    			drCrCb.setSelectedItem("Cr");
        			    		else if(db<0)
        			    			drCrCb.setSelectedItem("Dr");
        			    		else
        			    			drCrCb.setSelectedIndex(0);

    	    		    		db=Math.abs(db);
	        		    		depositeTf.setText(""+(new BigDecimal(db)).setScale(2,5));
        		    		}

        		    		db=rs.getDouble("field6");
        		    		if(db>0)
        		    			drCrLb.setText("Cr");
        		    		else
        		    			drCrLb.setText("Dr");
        		    		db=Math.abs(db);
        		    		curBal3L.setText(""+(new BigDecimal(db)).setScale(2,5));

        		    	}

	  		    }
		           	cn.close();

		}
		catch(Exception x)
		{
			System.out.println("Error...829..."+x);
		}

	}
	*/

	/*
	private void showBill()
	{
		try
		{
					//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		Connection cn=Utility.makeConnection();//DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed");
	            	Statement st=cn.createStatement();
        		    ResultSet rs;
					String partynm=""+partyCb.getSelectedItem();
        		    rs=st.executeQuery("select * from salechallan where s_s_no="+Integer.parseInt(billNoLb.getText())+" order by s_s_no");
        		    if(rs.next())
        		    {
        		    	reset();
        		    	partyCb.setSelectedItem(rs.getString("p_name"));
        		    	billNoLb.setText(rs.getString("s_s_no"));

        		    	String temp=""+rs.getDate("s_date");
						temp=temp.substring(8,10)+"/"+temp.substring(5,7)+"/"+temp.substring(0,4);
        		    	dateTf.setText(temp);

        		    	rs=st.executeQuery("select * from salechallan where s_s_no="+Integer.parseInt(billNoLb.getText())+" and t_type='s'");
        		    	while(rs.next())
        		    	{
        		    		String arr[]=new String[6];
        		    		arr[0]=rs.getString("c_name");
        		    		arr[1]=rs.getString("i_name");
        		    		arr[2]=rs.getString("wt");
        		    		arr[3]=rs.getString("tnh");
        		    		arr[4]=rs.getString("pcs");
        		    		arr[5]=rs.getString("f_wt");
        		    		dtm.addRow(arr);
        		    	}
        		    	rs=st.executeQuery("select * from salechallan where s_s_no="+Integer.parseInt(billNoLb.getText())+" and t_type='a'");
        		    	while(rs.next())
        		    	{
        		    		String arr[]=new String[6];
        		    		arr[0]=rs.getString("c_name");
        		    		arr[1]=rs.getString("i_name");
        		    		arr[2]=rs.getString("wt");
        		    		arr[3]=rs.getString("tnh");
        		    		arr[4]=rs.getString("pcs");
        		    		arr[5]=rs.getString("f_wt");
        		    		dtm1.addRow(arr);
        		    	}

        		    	rs=st.executeQuery("select * from sale_xChallan where s_s_no="+Integer.parseInt(billNoLb.getText())+"");
        		    	if(rs.next())
        		    	{
        		    		totalPurWtL.setText(rs.getString("field1"));
        		    		totalPurFineWtL.setText(rs.getString("field2"));
        		    		lastBal1L.setText(rs.getString("field3"));
        		    		//lastBal3L.setText(rs.getString("field4"));
        		    		double db=rs.getDouble("field4");
        		    		if(db>0)
        		    			drCrLb1.setText("Cr");
        		    		else
        		    			drCrLb1.setText("Dr");
        		    		db=Math.abs(db);
        		    		lastBal3L.setText(""+(new BigDecimal(db)).setScale(2,5) );

        		    		curBal1L.setText(rs.getString("field5"));


        		    		totalPurWtL1.setText(rs.getString("field7"));
        		    		totalPurFineWtL1.setText(rs.getString("field8"));

        		    		gmOrBhari.setSelectedItem(rs.getString("rate_type"));
        		    		curRateTf.setText(rs.getString("field9"));
        		    		adjustmentWtTf.setText(rs.getString("field10"));
        		    		adjustmentAmtTf.setText(rs.getString("field11"));

        		    		adjustTb.setSelected(rs.getBoolean("btn1"));
        		    		pendingTb.setSelected(rs.getBoolean("btn3"));
        		    		//depositeTb.setSelected(rs.getBoolean("btn2"));
        		    		//if(depositeTb.isSelected())
        		    		{
        		    			depositeTf.setVisible(true);
        		    			drCrCb.setVisible(true);
        		    			//depositeTf.setText(rs.getString("jama"));
        		    			db=rs.getDouble("jama");
        		    			if(db>0)
        			    			drCrCb.setSelectedItem("Cr");
        			    		else if(db<0)
        			    			drCrCb.setSelectedItem("Dr");
        			    		else
        			    			drCrCb.setSelectedIndex(0);

    	    		    		db=Math.abs(db);
	        		    		depositeTf.setText(""+(new BigDecimal(db)).setScale(2,5));
        		    		}

        		    		db=rs.getDouble("field6");
        		    		if(db>0)
        		    			drCrLb.setText("Cr");
        		    		else
        		    			drCrLb.setText("Dr");
        		    		db=Math.abs(db);
        		    		curBal3L.setText(""+(new BigDecimal(db)).setScale(2,5));

        		    	}

        		    }
		           	cn.close();

		}
		catch(Exception x)
		{
			System.out.println("Error...829..."+x);
		}

	}
	*/
	public void mousePressed(MouseEvent e)
	{
		if(e.getSource()==grid && e.getModifiers()==4)
		{
			pm.show(grid,e.getX(),e.getY());
		}
		else if(e.getSource()==grid1 && e.getModifiers()==4)
		{
			pm1.show(grid1,e.getX(),e.getY());
		}
	}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseClicked(MouseEvent e)
	{
		if(e.getSource()==grid)
		{
			int r=grid.getSelectedRow();
			categoryCb.setSelectedItem(""+grid.getValueAt(r,0));
			itemCb.setSelectedItem(""+grid.getValueAt(r,1));
			openTf.setText(""+grid.getValueAt(r,2));
			tounchTf.setText(""+grid.getValueAt(r,3));
			fineWtLb.setText(""+grid.getValueAt(r,5));
			pieceTf.setText(""+grid.getValueAt(r,4));
		}
		else if(e.getSource()==grid1)
		{
			int r=grid1.getSelectedRow();
			categoryCb1.setSelectedItem(""+grid1.getValueAt(r,0));
			itemCb1.setSelectedItem(""+grid1.getValueAt(r,1));
			openTf1.setText(""+grid1.getValueAt(r,2));
			tounchTf1.setText(""+grid1.getValueAt(r,3));
			fineWtLb1.setText(""+grid1.getValueAt(r,5));
			pieceTf1.setText(""+grid1.getValueAt(r,4));

		}
	}
	public void mouseExited(MouseEvent e){}


	private void setComboBoxInCell(JTable table,int columnNo,String list[])
	{
		TableColumnModel cm = table.getColumnModel();
		cm.getColumn(columnNo).setCellEditor(new DefaultCellEditor(
    new JComboBox(new DefaultComboBoxModel(list))));

		/*
		TableColumnModel cm = grid.getColumnModel();
		cm.getColumn(0).setCellEditor(new DefaultCellEditor(
    new JComboBox(new DefaultComboBoxModel(new String[] {
      "Yes",
      "No",
      "Maybe"
    }))));
		cm.getColumn(1).setCellEditor(new DefaultCellEditor(
    new JComboBox(new DefaultComboBoxModel(new String[] {
      "Yes",
      "No",
      "Maybe"
    }))));
    	//String blankrow[]=new String[12];
		dtm.addRow(blankrow);
		*/
	}






//PRINTING
	class printbill extends JFrame
    {
                public printbill()
                {
                        try
                        {
                                String space="";
                                String temp="";
                                int rep=0;
                                System.out.println("Start printing");
                                FileOutputStream fos=new FileOutputStream("LPT1");	//files\\purchase"+".in");//
                                PrintWriter pw=new PrintWriter(fos);
                                System.out.println("Start1 ");

                                int countLine=1;
								//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						   		Connection cn=Utility.makeConnection();//DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed");
		  	          			Statement st=cn.createStatement();
                            	ResultSet rs;

			        		    String firmname=""+partyCb.getSelectedItem();;
        					    String billno="";
								String date=""+dateTf.getText();
		    	    		    rs=st.executeQuery("select max(s_s_no) from salechallan");
		    	    		    if(rs.next())
		    	    		    {
		    	    		    	billno=""+(rs.getInt(1));
		    	    		    }
		    	    		    billno=billNoLb.getText();
								temp="ROUGH ESTIMATE";
        					    int l=temp.length();
        					    space="";
        					    for(int i=1;i<=(42-l)/2;i++)	{space=space+" ";}
                                pw.println(space+temp);

                                l=firmname.length();
        					    space="";
        					    for(int i=1;i<=(42-l)/2;i++)	{space=space+" ";}
                                pw.println(space+firmname);

                                temp="Bill No.:"+billno;
        					    l=temp.length();
        					    space="";
        					    pw.print(temp);

								l=temp.length();
								temp="Date:"+date;
        					    l=l+temp.length();
        					    space="";
        					    for(int i=1;i<=42-l;i++)	{space=space+" ";}
        					    pw.println(space+temp);

								//draw line
        					    space="";
        					    for(int i=1;i<=42;i++)	{space=space+"-";}
        					    pw.println(space);

								//draw heading
        					    space="Item                 Weight  Tounch  Gold";
        					    pw.println(space);

								//draw line
        					    space="";
        					    for(int i=1;i<=42;i++)	{space=space+"-";}
        					    pw.println(space);

								int totalpcs;
								BigDecimal wttotal=new BigDecimal("0.000");
								BigDecimal fwttotal=new BigDecimal("0.000");

								rs=st.executeQuery("select * from salechallan where s_s_no="+Integer.parseInt(billno)+" and t_type='s'");
		    	    		    while(rs.next())
		    	    		    {
		    	    		    	temp=rs.getString("i_name").trim()	;
		    	    		    	pw.print(temp);

		    	    		    	totalpcs=temp.length();
		    	    		    	temp=""+rs.getBigDecimal("wt").setScale(3,5);
		    	    		    	wttotal=wttotal.add(new BigDecimal(temp));
		    	    		    	totalpcs+=temp.length();
									l=totalpcs;
	        					    space="";
    	    					    for(int i=1;i<=(26-l);i++)	{space=space+" ";}
									pw.print(space+temp);		//9 char



									temp=""+rs.getBigDecimal("tnh").setScale(2,5);
		    	    		    	l=temp.length();
	        					    space="";
    	    					    for(int i=1;i<=(8-l);i++)	{space=space+" ";}
									pw.print(space+temp);		//9 char

									temp=""+rs.getBigDecimal("f_wt").setScale(3,5);
									fwttotal=fwttotal.add(new BigDecimal(temp));
		    	    		    	l=temp.length();
	        					    space="";
    	    					    for(int i=1;i<=(8-l);i++)	{space=space+" ";}
									pw.println(space+temp);		//9 char

		    	    		    }

		    	    		    //draw line
        					    space="";
        					    for(int i=1;i<=42;i++)	{space=space+"-";}
        					    pw.println(space);

        					    temp="New Total";
		    	    		    pw.print(temp);

		    	    		    temp=""+(new BigDecimal(""+wttotal)).setScale(3,5);
		    	    		    l=temp.length();
								space="";
    	    				    for(int i=1;i<=(17-l);i++)	{space=space+" ";}
								pw.print(space+temp);		//9 char

								temp=""+(new BigDecimal(""+fwttotal)).setScale(3,5);
		    	    		    l=temp.length();
	        				    space="";
    	    				    for(int i=1;i<=(16-l);i++)	{space=space+" ";}
								pw.println(space+temp);		//9 char

		    	    		    //draw line
        					    space="";
        					    for(int i=1;i<=42;i++)	{space=space+"-";}
        					    pw.println(space);

								temp="Old Balance";
		    	    		    pw.print(temp);

		    	    		    /*rs=st.executeQuery("select slx.field3,sl.s_date from sale_xChallan slx,salechallan sl where slx.s_s_no="+Integer.parseInt(billno)+" and sl.s_s_no=slx.s_s_no");
		    	    		    if(rs.next())
		    	    		    {
		    	    		    	temp=""+rs.getDate(2);
		    	    		    	l=temp.length();
									space="";
    	    					    for(int i=1;i<=5;i++)	{space=space+" ";}
									pw.print(space+temp);

		    	    		    	temp=""+rs.getBigDecimal(1).setScale(3,5);
		    	    		    	fwttotal=fwttotal.add(new BigDecimal(temp));
		    	    		    	l=temp.length();
									space="";
    	    					    for(int i=1;i<=(16-l);i++)	{space=space+" ";}
									pw.println(space+temp);		//9 char


		    	    		    }*/

			        		    //draw line
        					    space="";
        					    for(int i=1;i<=42;i++)	{space=space+"-";}
        					    pw.println(space);

        					    temp="Total";
		    	    		    pw.print(temp);


								temp=""+(new BigDecimal(""+fwttotal)).setScale(3,5);
		    	    		    l=temp.length();
	        				    space="";
    	    				    for(int i=1;i<=(37-l);i++)	{space=space+" ";}
								pw.println(space+temp);		//9 char

		    	    		    //draw line
        					    space="";
        					    for(int i=1;i<=42;i++)	{space=space+"_";}
        					    pw.println(space);

								temp="Jama Details";
		    	    		    pw.println(temp);

			        		    BigDecimal wttotal1=new BigDecimal("0.000");
								BigDecimal fwttotal1=new BigDecimal("0.000");

								rs=st.executeQuery("select * from salechallan where s_s_no="+Integer.parseInt(billno)+" and t_type='a'");
		    	    		    while(rs.next())
		    	    		    {
		    	    		    	temp=rs.getString("i_name").trim()	;
		    	    		    	pw.print(temp);

		    	    		    	totalpcs=temp.length();
		    	    		    	temp=""+rs.getBigDecimal("wt").setScale(3,5);
		    	    		    	wttotal1=wttotal1.add(new BigDecimal(temp));
		    	    		    	totalpcs+=temp.length();
									l=totalpcs;
	        					    space="";
    	    					    for(int i=1;i<=(26-l);i++)	{space=space+" ";}
									pw.print(space+temp);		//9 char



									temp=""+rs.getBigDecimal("tnh").setScale(2,5);
		    	    		    	l=temp.length();
	        					    space="";
    	    					    for(int i=1;i<=(8-l);i++)	{space=space+" ";}
									pw.print(space+temp);		//9 char

									temp=""+rs.getBigDecimal("f_wt").setScale(3,5);
									fwttotal1=fwttotal1.add(new BigDecimal(temp));
		    	    		    	l=temp.length();
	        					    space="";
    	    					    for(int i=1;i<=(8-l);i++)	{space=space+" ";}
									pw.println(space+temp);		//9 char

		    	    		    }

		    	    		    //draw line
        					    space="";
        					    for(int i=1;i<=42;i++)	{space=space+"-";}
        					    pw.println(space);

			        		    temp="Jama Total";
		    	    		    pw.print(temp);

		    	    		    temp=""+(new BigDecimal(""+wttotal1)).setScale(3,5);
		    	    		    l=temp.length();
								space="";
    	    				    for(int i=1;i<=(16-l);i++)	{space=space+" ";}
								pw.print(space+temp);		//9 char

								temp=""+(new BigDecimal(""+fwttotal1)).setScale(3,5);
		    	    		    l=temp.length();
	        				    space="";
    	    				    for(int i=1;i<=(16-l);i++)	{space=space+" ";}
								pw.println(space+temp);		//9 char

		    	    		    //draw line
        					    space="";
        					    for(int i=1;i<=42;i++)	{space=space+"_";}
        					    pw.println(space);

								temp="Bill Uptodate";
		    	    		    pw.print(temp);


								temp=""+(fwttotal.subtract(fwttotal1)).setScale(3,5);
		    	    		    l=temp.length();
	        				    space="";
    	    				    for(int i=1;i<=(29-l);i++)	{space=space+" ";}
								pw.println(space+temp);		//9 char
								fwttotal=fwttotal.subtract(fwttotal1);

		    	    		    //draw line
        					    space="";
        					    for(int i=1;i<=42;i++)	{space=space+"_";}
        					    pw.println(space);

        					    temp="Bhawkata";
		    	    		    pw.println(temp);

		    	    		    /*rs=st.executeQuery("select slx.field9,slx.field10,slx.field11,slx.rate_type from sale_xChallan slx where slx.s_s_no="+Integer.parseInt(billno)+"");
		    	    		    if(rs.next())
		    	    		    {
		    	    		    	temp=""+rs.getBigDecimal(1).setScale(2,5)+" per "+rs.getString(4);
		    	    		    	l=temp.length();
									pw.print(temp);


		    	    		    	temp=""+rs.getBigDecimal(3).setScale(2,5);
		    	    		    	l=l+temp.length();
									space="";
    	    					    for(int i=1;i<=(30-l);i++)	{space=space+" ";}
									pw.print(space+temp);		//9 char

									temp=""+rs.getBigDecimal(2).setScale(3,5);
		    	    		    	fwttotal=fwttotal.subtract(new BigDecimal(temp));
		    	    		    	l=temp.length();
									space="";
    	    					    for(int i=1;i<=(12-l);i++)	{space=space+" ";}
									pw.println(space+temp);		//9 char


		    	    		    }*/

		    	    		    //draw line
        					    space="";
        					    for(int i=1;i<=42;i++)	{space=space+"_";}
        					    pw.println(space);

        					    temp="Final Total Balance";
		    	    		    pw.print(temp);

		    	    		    l=temp.length();
		    	    		    temp=""+fwttotal.setScale(3,5);
		    	    		    l+=temp.length();
	        				    space="";
    	    				    for(int i=1;i<=(42-l);i++)	{space=space+" ";}
								pw.println(space+temp);		//9 char

								//draw line
        					    space="";
        					    for(int i=1;i<=42;i++)	{space=space+"_";}
        					    pw.println(space);

        					    temp="Pending Cash Details";
		    	    		    pw.println(temp);

		    	    		    space="  Old Jama   New Jama  Bhawkata    Pending ";
        					    pw.println(space);

								//space="    0.00       0.00";
        					    //pw.print(space);
		    	    		    /*
		    	    		     rs=st.executeQuery("select field4,field6,jama,field11 from sale_xChallan where s_s_no="+Integer.parseInt(billno)+"");
		    	    		    if(rs.next())
								{
									temp=""+rs.getBigDecimal(1).setScale(2,5);
									l=temp.length();
			    	    		    space="";
    		    				    for(int i=1;i<=(10-l);i++)	{space=space+" ";}
									pw.print(space+temp);

									temp=""+rs.getBigDecimal(3).setScale(2,5);
									l=temp.length();
			    	    		    space="";
    		    				    for(int i=1;i<=(11-l);i++)	{space=space+" ";}
									pw.print(space+temp);

									temp=""+rs.getBigDecimal(4).setScale(2,5);
									l=temp.length();
			    	    		    space="";
    		    				    for(int i=1;i<=(10-l);i++)	{space=space+" ";}
									pw.print(space+temp);


									temp=""+rs.getBigDecimal(2).setScale(2,5);
									l=temp.length();
			    	    		    space="";
    		    				    for(int i=1;i<=(11-l);i++)	{space=space+" ";}
									pw.println(space+temp);
								}*/


								//draw line
        					    space="";
        					    for(int i=1;i<=42;i++)	{space=space+"_";}
        					    pw.println(space);

                                pw.close();
                                fos.close();
                                //con.close();
                                System.out.println("End printing");
                        }
                        catch(Exception x)
                        {
                                System.out.println("Error 929393...."+x);
                        }

                }
        }



	int currentpg,totalpg;
	boolean firsttime=false;
	boolean complete=false;

	class printchallan extends JFrame
	{
        	JInternalFrame pchallanf;
	        Container contentPane;
        	GridBagLayout gbl;
	        GridBagConstraints gbc;
        	JButton printButton;
	        JButton pageSetupButton,exitButton;

			PrintPanel canvas;
	        PageFormat pageFormat;

        	public printchallan(JDesktopPane desk)
        	{
                pchallanf=new JInternalFrame("Printing of Invoice",false,true,true,true);
                contentPane=pchallanf.getContentPane();
				gbl=new GridBagLayout();
				gbc=new GridBagConstraints();
                contentPane.setLayout(new BorderLayout());

                addWindowListener(new WindowAdapter()
                {
                        public void windowClosing(WindowEvent e)
                        {
                                System.exit(0);
                        }
                }
                );

                canvas=new PrintPanel();
                contentPane.add(canvas,"Center");
                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new GridLayout(2,1));

                //pageSetupButton.addActionListener(this);

                contentPane.add(buttonPanel,"East");

                                PrinterJob printJob=PrinterJob.getPrinterJob();
                                //double width=4.27 * 72;
                                double width=4.40 * 72;
                                double height=(4.5 * 72);
                                Paper paper=new Paper();
                                paper.setSize(width,height);

                                PageFormat page=new PageFormat();
                                paper.setImageableArea(30,10,paper.getWidth(),paper.getHeight());
                                //page.setOrientation(PageFormat.LANDSCAPE);
                                page.setPaper(paper);
                                pageFormat=printJob.defaultPage(page);
                                pageFormat.setPaper(paper);
                                printJob.setPrintable(canvas,pageFormat);

                                try
                                {
										printJob.print();
	                            }
                                catch(Exception exception)
                                {
                                        JOptionPane.showMessageDialog(this,exception);
                                }
        		 }
	}

	class PrintPanel extends JPanel implements Printable
	{
        int page=100;
		TextLayout layout;
		//Font f,f1,f2,f3,f4,f5,f6;
		Graphics2D g2;
		int row=0;
		FontRenderContext context;


        public PrintPanel()
        {
                //ChallanNo=JOptionPane.showInputDialog(null,"Enter Challan Number:");
        }
        public void paintComponent(Graphics g)
        {
                super.paintComponent(g);
                Graphics2D g2=(Graphics2D)g;
                drawPage(g2);
        }

        public int print(Graphics g,PageFormat pf,int page) throws PrinterException
        {
                if(page>=1)
                        return Printable.NO_SUCH_PAGE;
                Graphics2D g2=(Graphics2D)g;
                g2.setPaint(Color.black);
                g2.translate(pf.getImageableX(),pf.getImageableY());
                //g2.draw(new Rectangle2D.Double(0,0,pf.getImageableWidth(),pf.getImageableHeight()));
                System.out.println("W1="+pf.getImageableWidth()+"H1="+pf.getImageableHeight());
                drawPage(g2);
                return Printable.PAGE_EXISTS;
        }
        public void drawPage(Graphics2D g2)
        {
			this.g2=g2;

            context=g2.getFontRenderContext();
            Font fb11,fp11,fb10,fp10,fb9,fp9,fb8,fp8,fp7;

            fb11=new Font("Times New Roman",Font.BOLD,11);
            fp11=new Font("Times New Roman",Font.PLAIN,11);
            fb10=new Font("Arial",Font.BOLD,10	);
            fp10=new Font("Arial",Font.PLAIN,10);
            fb9=new Font("Arial",Font.BOLD,9);
            fp9=new Font("Arial",Font.PLAIN,9);
            fb8=new Font("Arial",Font.BOLD,8);
            fp8=new Font("Arial",Font.PLAIN,8);
            fp7=new Font("Arial",Font.PLAIN,7);

            FontMetrics fm;
            GeneralPath clipShape=new GeneralPath();

            String str=" fdfg dfg dfg";
            String str1="d fgf dgdfg df";
            layout=new TextLayout(str,fp11,context);
            AffineTransform transform=AffineTransform.getTranslateInstance(10,20);

			if(firsttime==false)
			{
				firsttime=true;
			}
			else
			{
		        try
        		{
					//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		Connection cn=Utility.makeConnection();//DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed");
		  	          			Statement st=cn.createStatement();
                            	ResultSet rs;

			        		    String firmname=""+partyCb.getSelectedItem();;
        					    String billno="";
								String date=""+dateTf.getText();

		    	    		    billno=billNoLb.getText();
					int top=10;
        			int left=10;
        			int flag=0;
        			g2.setFont(fp8);
		            fm=g2.getFontMetrics();
		            String temp="ROUGH ESTIMATE";
		            g2.drawString(temp,(300-fm.stringWidth(temp))/2,top);


					top+=10;
					g2.setFont(fb10);
		            fm=g2.getFontMetrics();
		            temp=firmname;
		            g2.drawString(temp,(300-fm.stringWidth(temp))/2,top);

		        	top+=10;
					g2.setFont(fp9);
		            fm=g2.getFontMetrics();
		            temp="Date : "+date;
		            //layout=new TextLayout(temp,fp10,context);
        		    g2.drawString(temp,10,top);

        		    top+=5;
        		    g2.setFont(fb11);
					g2.drawLine(left,top,285,top);

					top+=10;
					g2.setFont(fb8);
		            temp=" ITEM                            WEIGHT    TOUNCH    GOLD";
					layout=new TextLayout(temp,fb9,context);
					g2.drawString(temp,10,top);

        		    top+=5;
        		    g2.setFont(fb11);
					g2.drawLine(left,top,285,top);

        		    BigDecimal wttotal=new BigDecimal("0.000");
					BigDecimal fwttotal=new BigDecimal("0.000");

					rs=st.executeQuery("select * from Sale_temp where s_s_no="+Integer.parseInt(billno)+" and t_type='s'");
		    	    while(rs.next())
		    	    {
		    	    	top+=13;
						g2.setFont(fp8);
						fm=g2.getFontMetrics();
		            	temp=rs.getString("i_name").trim();
		            	System.out.println("Item Name - length:"+fm.stringWidth(temp));
		            	g2.drawString(temp,10,top);

		    	    	g2.setFont(fp9);
		    	    	fm=g2.getFontMetrics();
						temp=""+rs.getBigDecimal("wt").setScale(3,5);
		    	    	wttotal=wttotal.add(new BigDecimal(temp));
		    	    	g2.drawString(temp,(180-fm.stringWidth(temp)),top);

		    	    	temp=""+rs.getBigDecimal("tnh").setScale(2,5);
		    	    	g2.drawString(temp,(225-fm.stringWidth(temp)),top);

		    	    	temp=""+rs.getBigDecimal("f_wt").setScale(3,5);
		    	    	fwttotal=fwttotal.add(new BigDecimal(temp));
		    	    	g2.drawString(temp,(275-fm.stringWidth(temp)),top);

		    	   	}

        		    top+=7;
        		    g2.setFont(fp9);
        		    g2.drawString("-------------------------------------------------------------------------------------------------",left,top);
					//g2.drawLine(left,top,300,top);

						top+=13;
						g2.setFont(fb9);
						fm=g2.getFontMetrics();
		            	temp="New Total";
		            	g2.drawString(temp,10,top);

		    	    	g2.setFont(fb10);
		    	    	fm=g2.getFontMetrics();
		    	    	temp=""+wttotal.setScale(3,5);
		    	    	g2.drawString(temp,(180-fm.stringWidth(temp)),top);


		    	    	temp=""+fwttotal.setScale(3,5);
		    	    	g2.drawString(temp,(275-fm.stringWidth(temp)),top);

		    	   	top+=7;
        		    g2.setFont(fp9);
					g2.drawString("-------------------------------------------------------------------------------------------------",left,top);
					//g2.drawLine(left,top,300,top);

					System.out.println("select slx.field3,sl.s_date from Sale_x_temp slx,Sale_temp sl where slx.s_s_no="+Integer.parseInt(billno)+" and sl.s_s_no=slx.s_s_no");
   	    		    rs=st.executeQuery("select slx.field3 from Sale_x_temp slx where slx.s_s_no="+Integer.parseInt(billno)+"");
   	    		    if(rs.next())
   	    		    {
   	    		    	System.out.println("1");
						top+=13;
						g2.setFont(fb9);
						fm=g2.getFontMetrics();
		            	temp="Old Balance";
		            	g2.drawString(temp,10,top);
						System.out.println("2");
		    	    	/*g2.setFont(fp9);
		    	    	fm=g2.getFontMetrics();
						temp=""+rs.getDate(2);
						temp=temp.substring(8,10)+"/"+temp.substring(5,7)+"/"+temp.substring(0,4);
		    	    	g2.drawString(temp,100,top);*/
						System.out.println("3");
		    	    	g2.setFont(fb10);
		    	    	fm=g2.getFontMetrics();
						temp=""+rs.getBigDecimal(1).setScale(3,5);
		    	    	fwttotal=fwttotal.add(new BigDecimal(temp));
		    	    	g2.drawString(temp,(275-fm.stringWidth(temp)),top);
		    	    	System.out.println("4");

		    	    	rs=st.executeQuery("select * from salechallan where s_s_no<"+Integer.parseInt(billno)+" and p_name='"+partyCb.getSelectedItem()+"' order by s_date desc");
		    	    	if(rs.next())
		    	    	{
		    	    		g2.setFont(fp9);
		    		    	fm=g2.getFontMetrics();
							temp=""+rs.getDate("s_date");
							System.out.println("5:"+temp);
							temp=temp.substring(8,10)+"/"+temp.substring(5,7)+"/"+temp.substring(0,4);
			    	    	g2.drawString(temp,100,top);
		    	    	}
   	    		    }

        		    top+=7;
        		    g2.setFont(fp9);
					g2.drawString("-------------------------------------------------------------------------------------------------",left,top);

						top+=13;
						g2.setFont(fb9);
						fm=g2.getFontMetrics();
		            	temp="Net Total";
		            	g2.drawString(temp,10,top);

		    	    	g2.setFont(fb10);
		    	    	fm=g2.getFontMetrics();
						temp=""+fwttotal.setScale(3,5);
		    	    	g2.drawString(temp,(275-fm.stringWidth(temp)),top);

					top+=7;//7
        		    g2.setFont(fb11);
					g2.drawLine(left,top,285,top++);
					g2.drawLine(left,top,285,top);

						top+=13;
						g2.setFont(fb9);
						fm=g2.getFontMetrics();
		            	temp="Jama Details";
		            	g2.drawString(temp,10,top);


        		    BigDecimal wttotal1=new BigDecimal("0.000");
					BigDecimal fwttotal1=new BigDecimal("0.000");

					g2.setFont(fp9);
					rs=st.executeQuery("select * from Sale_temp where s_s_no="+Integer.parseInt(billno)+" and t_type='a'");
		    	    while(rs.next())
		    	    {
		    	    	top+=13;
						g2.setFont(fp8);
						//g2.setFont(fp10);
						fm=g2.getFontMetrics();
		            	temp=rs.getString("i_name").trim();
		            	g2.drawString(temp,10,top);

		    	    	g2.setFont(fp9);
		    	    	fm=g2.getFontMetrics();
						temp=""+rs.getBigDecimal("wt").setScale(3,5);
		    	    	wttotal1=wttotal1.add(new BigDecimal(temp));
		    	    	g2.drawString(temp,(180-fm.stringWidth(temp)),top);

		    	    	temp=""+rs.getBigDecimal("tnh").setScale(2,5);
		    	    	g2.drawString(temp,(225-fm.stringWidth(temp)),top);

		    	    	temp=""+rs.getBigDecimal("f_wt").setScale(3,5);
		    	    	fwttotal1=fwttotal1.add(new BigDecimal(temp));
		    	    	g2.drawString(temp,(275-fm.stringWidth(temp)),top);
		    	   	}

					top+=7;
        		    g2.setFont(fp9);
					g2.drawString("-------------------------------------------------------------------------------------------------",left,top);
					//g2.drawLine(left,top,300,top);

						top+=13;
						g2.setFont(fb9);
						fm=g2.getFontMetrics();
		            	temp="Jama Total";
		            	g2.drawString(temp,10,top);

		    	    	temp=""+wttotal1.setScale(3,5);
		    	    	g2.drawString(temp,(180-fm.stringWidth(temp)),top);


		    	    	temp=""+fwttotal1.setScale(3,5);
		    	    	g2.drawString(temp,(275-fm.stringWidth(temp)),top);

		    	   	top+=7;
        		    g2.setFont(fb11);
					g2.drawLine(left,top,285,top++);
		    	    g2.drawLine(left,top,285,top);

					top+=13;
					g2.setFont(fb9);
					fm=g2.getFontMetrics();
		            temp="Bill Uptodate";
		            g2.drawString(temp,10,top);

		    	    temp=""+fwttotal.subtract(fwttotal1).setScale(3,5);
		    	    fwttotal=fwttotal.subtract(fwttotal1);
		    	    g2.drawString(temp,(275-fm.stringWidth(temp)),top);

        			top+=7;
        		    g2.setFont(fp9);
					g2.drawString("-------------------------------------------------------------------------------------------------",left,top);



		    	    top+=13;
					g2.setFont(fb9);
					fm=g2.getFontMetrics();
		            temp="Bhawkata   ";
		            g2.drawString(temp,10,top);


					rs=st.executeQuery("select slx.field9,slx.field10,slx.field11,slx.rate_type from Sale_x_temp slx where slx.s_s_no="+Integer.parseInt(billno)+"");
		    	    if(rs.next())
		    	    {
		    	    	//top+=13;
		    	    	int i=fm.stringWidth(temp);
		    	    	g2.setFont(fp8);
		    	    	fm=g2.getFontMetrics();
		    	      	temp=""+rs.getBigDecimal(1).setScale(2,5)+" per "+rs.getString(4)+"   "+"Rs. "+rs.getBigDecimal(3).setScale(2,5);
		    	       	g2.drawString(temp,30+i,top);

		    	    	/*temp="Rs. "+rs.getBigDecimal(3).setScale(2,5);
		    	    	g2.drawString(temp,(190-fm.stringWidth(temp)),top);
		    	    	*/
		    	    	g2.setFont(fb10);
		    	    	fm=g2.getFontMetrics();
		    	    	temp=""+rs.getBigDecimal(2).setScale(3,5);
		    	    	fwttotal=fwttotal.subtract(new BigDecimal(temp));
		    	    	g2.drawString(temp,(275-fm.stringWidth(temp)),top);
		    	    }

		    	    top+=7;
        		    g2.setFont(fb11);
					g2.drawLine(left,top,285,top);

		    	    top+=13;
					g2.setFont(fb9);
					fm=g2.getFontMetrics();
		            temp="Final Total Balance";
		            g2.drawString(temp,10,top);

					g2.setFont(new Font("Times New Roman",Font.BOLD|Font.ITALIC,11));
		    	    temp=""+(fwttotal).setScale(3,5);
		    	    g2.drawString(temp,(275-fm.stringWidth(temp)),top);

					top+=7;
        		    g2.setFont(fb11);
					g2.drawLine(left,top,285,top);


		    	    top+=13;
					g2.setFont(fb9);
					fm=g2.getFontMetrics();
				    temp="Pending Cash Details";
		            g2.drawString(temp,10,top);

   	    		    top+=13;
					g2.setFont(fb8);
					fm=g2.getFontMetrics();
				    temp="      Bhawkata      Old Jama       New Jama         Pending ";
		            g2.drawString(temp,10,top);

   	    		    g2.setFont(fp8);
   	    		    fm=g2.getFontMetrics();
					rs=st.executeQuery("select field4,field6,jama,field11 from Sale_x_temp where s_s_no="+Integer.parseInt(billno)+"");
   	    		    if(rs.next())
					{
						top+=13;
			    	    temp=""+rs.getBigDecimal(4).setScale(2,5);
			    	    g2.drawString(temp,(70-fm.stringWidth(temp)),top);

			    	    temp=""+rs.getBigDecimal(1).setScale(2,5);
			    	    g2.drawString(temp,(135-fm.stringWidth(temp)),top);

			    	    temp=""+rs.getBigDecimal(3).setScale(2,5);
			    	    g2.drawString(temp,(210-fm.stringWidth(temp)),top);

			    	    g2.setFont(new Font("Times New Roman",Font.BOLD|Font.ITALIC,11));
		    	    	temp=""+rs.getBigDecimal(2).setScale(2,5);
			    	    g2.drawString(temp,(275-fm.stringWidth(temp)),top);

					}

		    	    top+=7;
        		    g2.setFont(fb11);
					g2.drawLine(left,top,285,top);


         		}
         		catch(Exception x)
         		{
	        		System.out.println("BPError2193821..."+x);
         		}
         	}
      	}
	}



}