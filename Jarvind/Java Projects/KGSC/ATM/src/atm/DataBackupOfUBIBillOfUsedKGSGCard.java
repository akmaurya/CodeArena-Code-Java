/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DataBackupOfUBIBillOfUsedKGSGCard.java
 *
 * Created on May 2, 2013, 5:35:52 PM
 */

package atm;

/**
 *
 * @author DEEP PAL
 */
public class DataBackupOfUBIBillOfUsedKGSGCard extends javax.swing.JInternalFrame {

    /** Creates new form DataBackupOfUBIBillOfUsedKGSGCard */
    public DataBackupOfUBIBillOfUsedKGSGCard() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(null);

        jButton1.setText("Select File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(40, 20, 310, 23);

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(60, 150, 73, 23);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(180, 150, 120, 30);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(180, 110, 130, 20);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(180, 200, 120, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        javax.swing.JFileChooser jfc=new javax.swing.JFileChooser();
        jfc.showOpenDialog(this);
        System.out.println(jfc.getSelectedFile().getAbsoluteFile());
        readfile(jfc.getSelectedFile().getAbsoluteFile().toString());
}//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        add();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

    private boolean readfile(String filename)
    {
        try
        {
            //connect with server
            //-----------------------
            interfaceATM object1=null;
            try
            {
		object1=(interfaceATM)java.rmi.Naming.lookup(getIPaddress.IP());
            }
            catch(Exception e)
            {
		System.out.println("Error at the time of connection with server "+getIPaddress.IP()+"..."+e);
                getIPaddress.changeIP();
		try
		{
			object1=(interfaceATM)java.rmi.Naming.lookup(getIPaddress.IP());
		}
		catch(Exception ex)
		{
			System.out.println("Error at the time of connection with server ip-rmi//127.0.0.1/railwayMethods  ..."+ex);
		}
            }
            //First find last record
            //----------------------
            int position=-1;
            String query="select tran_date from ubi_bill_of_kgsg_cards order by entry_no desc";
            String last_tran_date=object1.getSingleValue(query);
            //query="select tran_id from ubi_bill_of_kgsg_cards order by entry_no desc";
            //String last_tran_id=object1.getSingleValue(query);
            System.out.println("last dt="+last_tran_date);
            //System.out.println("last id="+last_tran_id);
            String check_string="";
            

            if(last_tran_date.equals("")==false)
            {
                last_tran_date=last_tran_date.substring(8,10)+"-"+last_tran_date.substring(5,7)+"-"+last_tran_date.substring(0,4);
                check_string =" "+last_tran_date+"  ";
                position=find(filename, check_string);
                System.out.println("position find="+position);
            }

            String wholedata="";
            String line=null;
            String dashline=" --------------------------------------------------------------------------------------------------------------------------------------------------------------";
            String blankline="";
            boolean flag=false;
            int countline=0;
            String trandate="",tranid="";

            java.io.RandomAccessFile raf=new java.io.RandomAccessFile(filename, "r");
            //System.out.println("raf="+raf);
            if(position>=0)
                if(raf!=null)
                    raf.seek(position);
            System.out.println("raf.length="+raf.length()+"raf.getFilePointer"+raf.getFilePointer());
            System.out.println("position:"+position);
            while(raf.length()>raf.getFilePointer())
            {

                line=raf.readLine();
                //System.out.println("\t"+line.substring(11, 12));
                if((line.length()>=58))
                {



                    if((line.equals(blankline)==true) || line.equals(dashline) || line.substring(52, 57).trim().equals("70000") )
                    {
                        
                        line=raf.readLine();
                    }
                else
                    {
                        if(line.substring(53, 57).equals("4000")==false )
                        {

                        }
                        else
                        {
                            System.out.println(line.substring(53, 57));
                            wholedata=wholedata+line+"\n";
                            //System.out.println(line);

                            countline++;
                            System.out.println(countline);
                        }
                       // System.out.println(line.substring(53, 57));

                    }
                
                }
                
                /*if(line.substring(11, 12).equals("|")&&)
                    {
                    
                    }
                */

                /*int i=line.indexOf("     Summary");
                System.out.println(i+" :f: "+line);
                if(line.indexOf("     Summary")==0)
                {
                    System.out.println("ok....");
                    line=raf.readLine();
                    if(line.equals(dashline))
                    {
                        line=raf.readLine();
                        flag=true;
                    }
                    System.out.println(flag);
                }*/
                /*
                if (line.equals(dashline))
                {
                    line=raf.readLine();
                    if(line.equals("    Summary for the Account :- "))
                    {
                        line = raf.readLine();

                        if (line.equals(dashline))
                        {
                            line = raf.readLine();
                            if (line.equals(blankline))
                            {
                                line = raf.readLine();
                                if (line.equals("T"))
                                {
                                    flag=false;
                                }
                            }
                        }
                    }
                        
                }

                if (flag)
                {
                    if(line.substring(0,10).trim().length()!=0)
                    {
                    wholedata=wholedata+line+"\n";
                    System.out.println(line);
                    countline++;
                    }
                }
                 * 
                 */
            }
            System.out.println("total line read="+countline);
            //if(last_tran_id.equals("")==false && last_tran_date.equals("")==false)
            if(position>=0)
            {
                //last_tran_date=last_tran_date.substring(8,10)+"-"+last_tran_date.substring(5,7)+"-"+last_tran_date.substring(0,4);
                //String check_string =" "+last_tran_date+"   "+last_tran_id;
                System.out.println("check_string="+check_string);
                System.out.println(wholedata.indexOf(check_string));
                if(wholedata.indexOf(check_string)>=0)
                {
                    System.out.println("ok");
                    wholedata=wholedata.substring(wholedata.indexOf(check_string),wholedata.length());
                    wholedata=wholedata.substring(wholedata.indexOf("\n")+1,wholedata.length());
                    System.out.println("data="+wholedata);
                }
            }
            //String qry="select max(entry_no) from ubi_bill_of_kgsg_cards";
            //String max=object1.getSingleValue(qry);
            //if(max==null)
              //  max="0";
            //int maxentry=Integer.parseInt(max);
            //if(maxentry<countline)
            {
                boolean response=object1.updateUBIBillOfKGSGCards(wholedata);

                if(response==true)
                {
                    javax.swing.JOptionPane.showMessageDialog(this, "Congratulation! Information updated successfully.","Information",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    javax.swing.JOptionPane.showMessageDialog(this, "Sorry! Updation process terminated due to any reason.\nSo please try again.","Error Information",javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
               // else
                 //   javax.swing.JOptionPane.showMessageDialog(this, "Sorry! Updation process terminated due to any reason. May data already exists \nSo please try again! ","Error Information",javax.swing.JOptionPane.ERROR_MESSAGE);

        }
        catch(Exception ex)
        {
            System.out.println("error no. 1..."+ex);
        }
        return true;
    }

    public int find(String f, String searchString) {
        int result = -1;
        int pos=-1;
        String str="";
        java.util.Scanner in = null;
        try {
            in = new java.util.Scanner(new java.io.FileReader(f));
            while(in.hasNextLine() && result<0)//&& !result)
            {
                str=in.nextLine();
                result = str.indexOf(searchString);
                //result = in.nextLine().indexOf(searchString) >= 0;
                if(result<0)
                {
                    pos=pos+str.length();
                }
            }
            if(result>=0)
                result=pos;
        }
        catch(java.io.IOException e) {
            e.printStackTrace();
        }
        finally {
            try { in.close() ; } catch(Exception e) { /* ignore */ }
        }
        return result;
    }

    private void add()
    {
        try
        {
            interfaceATM object1=null;
            try
            {
		object1=(interfaceATM)java.rmi.Naming.lookup(getIPaddress.IP());
            }
            catch(Exception e)
            {
		System.out.println("Error at the time of connection with server "+getIPaddress.IP()+"..."+e);
                getIPaddress.changeIP();
		try
		{
			object1=(interfaceATM)java.rmi.Naming.lookup(getIPaddress.IP());
		}
		catch(Exception ex)
		{
			System.out.println("Error at the time of connection with server ip-rmi//127.0.0.1/railwayMethods  ..."+ex);
		}
            }
            String qry="select sum(tran_debit_amt) from ubi_bill_of_kgsg_cards order by entry_no asc";
            System.out.println(qry);
            String debit=object1.getSingleValue(qry);
            qry="select sum(tran_credit_amt) from ubi_bill_of_kgsg_cards order by entry_no asc";
            System.out.println(qry);
            String credit=object1.getSingleValue(qry);
            if(credit==null)
            {
                credit="0";
            }
            if(debit!=null)
            {
                jTextField2.setText(debit);
                jTextField3.setText(credit);
                jTextField1.setText(""+(Double.valueOf(debit)-Double.valueOf(credit)));
                System.out.println(Double.valueOf(debit)-Double.valueOf(credit));
            }
        }
        catch(Exception ae)
        {
            System.out.println("error in add method"+ae);
        }
    }
}
