package com.xcode.javas.other.javatricks;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

class vborder extends JPanel

{

Border border;

JButton butn;

public vborder()

{

setLayout(new GridLayout(2,3,5,5));

butn=new JButton("Empty Border");

//create a button with empty border

border=new EmptyBorder(1,1,1,1);//top=1,left=1,bottom=1,right=1

butn.setBorder(border);

add(butn);//add button to the panel

//create a button with raised and etched border

butn=new JButton("Etched and Raised Border");

border=new EtchedBorder(EtchedBorder.RAISED);//set the border(raised&etched)

butn.setBorder(border);

add(butn);

//create a button with colour and etched border

butn=new JButton("Etched and Color Border");

butn.setOpaque(true);

border=new BevelBorder(EtchedBorder.RAISED,Color.red,Color.blue);//highlight and shadow

butn.setBorder(border);

add(butn);//add button to the panel

//create a button with bevel border raised

butn=new JButton("Bevel Lowered");

border=new BevelBorder(BevelBorder.LOWERED);//set the border(bevel)

butn.setBorder(border);

add(butn);

//create a button with bevelborder lowered

butn=new JButton("Etched and Lowered Border");

Icon icon=new ImageIcon("aa.gif");

//create a button with a specified inset

border=new MatteBorder(50,20,50,20,icon);//top,left,bottom,right

butn.setBorder(border);

add(butn);

//create a button with matte border

butn=new JButton("Matte Border");

//highlight and shadow

border=new BevelBorder(EtchedBorder.LOWERED,Color.gray,Color.yellow);

butn.setBorder(border);

add(butn);

}

public static void main(String aa[])

{

//calls the vborder constructor

vborder varBrds=new vborder();

JFrame frame=new JFrame("Different Borders Layout in Swing");//set the text on the frame

frame.setContentPane(varBrds);

//pack()is used to compress the pane with respect to the components placed

frame.pack();

//display the frame

frame.setVisible(true);

}

} 