/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * KGSG_UBI_Report.java
 *
 * Created on Jul 22, 2013, 2:33:27 PM
 */

package atm;

/**
 *
 * @author welcome
 */
public class KGSG_UBI_Report extends javax.swing.JInternalFrame {
javax.swing.table.DefaultTableModel dtm,dtm1,dtm2;
    /** Creates new form KGSG_UBI_Report */
    public KGSG_UBI_Report(String paymentno) {
        initComponents();
        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
        javax.swing.table.DefaultTableCellRenderer CRLeft=new javax.swing.table.DefaultTableCellRenderer();
        javax.swing.table.DefaultTableCellRenderer CRRight=new javax.swing.table.DefaultTableCellRenderer();
        javax.swing.table.DefaultTableCellRenderer CRCenter=new javax.swing.table.DefaultTableCellRenderer();

        CRLeft.setHorizontalAlignment(javax.swing.JLabel.LEFT);
        CRRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
        CRCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);

        String heading[]={"Sr.No","Date","Txn ID","Card No/Record No","Debit","Credit","Balance"," ","KGSG Date","K Txn ID","KGSG Card No/Record No","KGSG Debit","KGSG Credit","KGSG Balance","Traced(Y/N)","Comment","Date","Reversed to A/c","Txn ID"};
        dtm=new javax.swing.table.DefaultTableModel(heading,0);

        jTable1.setModel(dtm);
        jTable1.setRowHeight(25);
        javax.swing.table.TableColumn column;

//jTable1.getTableHeader().setFont(new Font("Vardana", Font.BOLD, 12));
        column=jTable1.getColumn("Sr.No");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(45);
        column=jTable1.getColumn("Txn ID");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(60);
        column=jTable1.getColumn("Date");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(70);
        column=jTable1.getColumn("Card No/Record No");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(200);
        column=jTable1.getColumn("Debit");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(80);
        column=jTable1.getColumn("Credit");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(80);
        column=jTable1.getColumn("Balance");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(90);
        column=jTable1.getColumn("Traced(Y/N)");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(60);
        column=jTable1.getColumn("Comment");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(80);
        column=jTable1.getColumn("Reversed to A/c");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(50);
        column=jTable1.getColumn("Txn ID");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(60);
        column=jTable1.getColumn(" ");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(2);
        column=jTable1.getColumn("K Txn ID");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(60);
        column=jTable1.getColumn("KGSG Date");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(70);
        column=jTable1.getColumn("KGSG Card No/Record No");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(200);
        column=jTable1.getColumn("KGSG Debit");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(80);
        column=jTable1.getColumn("KGSG Credit");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(80);
        column=jTable1.getColumn("KGSG Balance");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(90);
        //jTable2.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
        CRLeft.setHorizontalAlignment(javax.swing.JLabel.LEFT);
        CRRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
        CRCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);

        String heading1[]={"",""};
        dtm1=new javax.swing.table.DefaultTableModel(heading1,0);

        jTable2.setModel(dtm1);
        jTable2.setRowHeight(25);

        String heading2[]={"",""};
        dtm2=new javax.swing.table.DefaultTableModel(heading1,0);

        jTable3.setModel(dtm2);
        jTable3.setRowHeight(25);

//jTable1.getTableHeader().setFont(new Font("Vardana", Font.BOLD, 12));
        

        table(paymentno);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("UBI And KGSG Matching Report");
        getContentPane().setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 20, 1000, 440);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 500, 370, 80);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(600, 480, 350, 130);

        jLabel1.setBackground(new java.awt.Color(153, 255, 204));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel1.setText("Opening of UBI Balance =");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(270, 0, 190, 20);

        jLabel2.setBackground(new java.awt.Color(153, 255, 204));
        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(460, 0, 150, 20);

        jLabel3.setBackground(new java.awt.Color(153, 255, 204));
        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel3.setText("Opening of KGSG Balance =");
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(670, 0, 200, 20);

        jLabel4.setBackground(new java.awt.Color(153, 255, 204));
        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(870, 0, 140, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables


    public void table(String paymentno)
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
            double udebit=0,ucredit=0,ubalance=0,kdebit=0,kcredit=0,kbalance=0;
            String qry="select tran_date,tran_id,particular,tran_debit_amt,tran_credit_amt,balanceamt from ubi_bill_of_kgsg_cards where ubi_payment_no="+Integer.parseInt(paymentno)+" order by entry_no asc";
            System.out.println(qry);
            String load[][]=object1.getInformationDD(qry, 6);
            System.out.println(load.length);

            String upart[]=load[0][2].split("/");
            String uparticular=upart[0]+"/"+upart[1].substring(3, upart[1].length())+"/";
            qry="select ubi_payment_no from kgsg_n_ubi where ubi_payment_no="+(Integer.parseInt(paymentno)-1)+"";
            String pay=object1.getSingleValue(qry);
            System.out.println("pay = "+pay);
            String start=null;
            if(pay==null || pay.equals(""))
            {
                qry="select max(ubi_payment_no) from kgsg_n_ubi where ubi_payment_no<"+(Integer.parseInt(paymentno))+"";
                pay=object1.getSingleValue(qry);
                System.out.println("pay ====== "+pay);
                
            }
            if(Integer.parseInt(pay)<=0)
            {
                qry="select min(entry_no) from kgsg_n_ubi where ubi_payment_no="+(Integer.parseInt(paymentno))+"";
                System.out.println(qry);
                start=""+(Integer.parseInt(object1.getSingleValue(qry))-1);
            }
            else
            {
                qry="select max(entry_no) from kgsg_n_ubi where ubi_payment_no="+(Integer.parseInt(pay))+"";
                System.out.println(qry);
                start=object1.getSingleValue(qry);
            }
            System.out.println(qry);
            
            System.out.println("START = "+start);
            if(start==null)
            {
                start="0";
            }
            upart=load[load.length-1][2].split("/");
            uparticular=upart[0]+"/"+upart[1].substring(3, upart[1].length())+"/";
            qry="select max(entry_no) from kgsg_n_ubi where ubi_payment_no="+Integer.parseInt(paymentno)+" ";
            System.out.println(qry);
            String last=object1.getSingleValue(qry);
            System.out.println("Start="+start+"   last="+last);
            if(last==null && start==null)
            {
                last=start="0";
            }
            if(last==null)
            {
                last="0";
            }

            System.out.println("Start="+start+"   last="+last);
            qry="select tran_date,tran_id,particular,tran_debit_amt,tran_credit_amt,balance_amt from kgsg_n_ubi where entry_no<="+Integer.parseInt(last)+" and entry_no>"+Integer.parseInt(start)+" ";
            System.out.println(qry);
            String load1[][]=object1.getInformationDD(qry, 6);
            System.out.println("load1.length == "+load1.length);
            
            String arr[]=null;
            //int total=0;
            int flag=0;
            dtm.setRowCount(0);
            String  dt[]=null;

            if(load.length>0 && load1.length==0)
            {
                 System.out.println("load.length>0 && load1.length==0 load.length ="+load.length);
                 arr=new String[15];
                for(int i=0;i<load.length;i++)
                {
                    System.out.println("in load part start ");
                                arr[0]=""+(dtm.getRowCount()+1);
                                dt=load[i][0].split("-");
                                arr[1]=dt[2]+"-"+dt[1]+"-"+dt[0];
                                arr[2]=load[i][1];
                                arr[3]=load[i][2];
                                arr[4]=load[i][3];
                                arr[5]=load[i][4];
                                arr[6]=load[i][5];
                                udebit=udebit+Double.valueOf(arr[4]);
                                ucredit=ucredit+Double.valueOf(arr[5]);
                                System.out.println("load part completed ");

                                arr[8]="";
                                arr[9]="";
                                arr[10]="";
                                arr[11]="";
                                arr[12]="";
                                arr[13]="";
                                arr[14]="N";
                                dtm.addRow(arr);
                }
                System.out.println("records are inserted ");
            }

            if(load.length > 0 && load1.length > 0)
            {
                //System.out.println("hello111111111111111111111111111");
                arr=new String[15];
                System.out.println("load.length="+load.length);
                System.out.println("load1.length="+load1.length);
                String uparticular1="";

                for(int i=0,j=0;i<load.length && j<load1.length;i++,j++)
                {
                    arr[0]=""+(dtm.getRowCount()+1);
                    dt=load[i][0].split("-");
                    arr[1]=dt[2]+"-"+dt[1]+"-"+dt[0];
                    arr[2]=load[i][1];
                    arr[3]=load[i][2];
                    arr[4]=load[i][3];
                    arr[5]=load[i][4];
                    arr[6]=load[i][5];
                    udebit=udebit+Double.valueOf(arr[4]);
                    ucredit=ucredit+Double.valueOf(arr[5]);

                    dt=load1[j][0].split("-");
                    arr[8]=dt[2]+"-"+dt[1]+"-"+dt[0];
                    arr[9]=load1[j][1];
                    arr[10]=load1[j][2];
                    arr[11]=load1[j][3];
                    arr[12]=load1[j][4];
                    arr[13]=load1[j][5];
                    arr[14]="Y";
                    kdebit=udebit+Double.valueOf(arr[11]);
                    kcredit=kcredit+Double.valueOf(arr[12]);

                    arr[13]=load1[j][5];
                    upart=load[i][2].split("/");
                    uparticular=upart[0]+"/"+upart[1].substring(3, upart[1].length())+"/";
                    upart=load1[j][2].split("/");
                    uparticular1=upart[0]+"/"+upart[1]+"/";
                    System.out.println(uparticular+"     uparticular1 = "+uparticular1);
                    //if(uparticular.equalsIgnoreCase(uparticular1) && arr[4].equals(arr[12]) && arr[5].equals(arr[11]))
                    {
                        dtm.addRow(arr);
                        /*upart=load[i+1][2].split("/");
                        uparticular=upart[0]+"/"+upart[1].substring(3, upart[1].length())+"/";
                        upart=load1[j+1][2].split("/");
                        uparticular1=upart[0]+"/"+upart[1]+"/";
                        if(!uparticular1.equalsIgnoreCase(uparticular))
                        {
                            flag=1;
                        }*/
                    }
                   if(!(uparticular.equalsIgnoreCase(uparticular1)) )
                    {
                        System.out.println("uparticular = "+uparticular);
                        qry="select tran_date,tran_id,particular,tran_debit_amt,tran_credit_amt,balance_amt from kgsg_n_ubi where (particular like '"+uparticular+"%' ) and entry_no<="+Integer.parseInt(last)+" and entry_no>"+Integer.parseInt(start)+" and tran_credit_amt="+Double.valueOf(arr[4])+" and tran_debit_amt="+Double.valueOf(arr[5])+" ";
                        String lo[][]=object1.getInformationDD(qry, 6);
                        System.out.println("lo.length = "+lo.length);
                        if(lo.length>0)
                        {
                            for(int k=0;k<1;k++)
                            {
                                arr[0]=""+(dtm.getRowCount()+1);
                                dt=load[i][0].split("-");
                                arr[1]=dt[2]+"-"+dt[1]+"-"+dt[0];
                                arr[2]=load[i][1];
                                arr[3]=load[i][2];
                                arr[4]=load[i][3];
                                arr[5]=load[i][4];
                                arr[6]=load[i][5];
                                udebit=udebit+Double.valueOf(arr[4]);
                                ucredit=ucredit+Double.valueOf(arr[5]);

                                dt=lo[k][0].split("-");
                                arr[8]=dt[2]+"-"+dt[1]+"-"+dt[0];
                                arr[9]=lo[k][1];
                                arr[10]=lo[k][2];
                                arr[11]=lo[k][3];
                                arr[12]=lo[k][4];
                                arr[13]=lo[k][5];
                                kdebit=udebit+Double.valueOf(arr[11]);
                                kcredit=kcredit+Double.valueOf(arr[12]);
                                arr[14]="Y";
                                dtm.addRow(arr);
                            }
                        }
                        else
                        {
                            arr[0]=""+(dtm.getRowCount()+1);
                                dt=load[i][0].split("-");
                                arr[1]=dt[2]+"-"+dt[1]+"-"+dt[0];
                                arr[2]=load[i][1];
                                arr[3]=load[i][2];
                                arr[4]=load[i][3];
                                arr[5]=load[i][4];
                                arr[6]=load[i][5];
                                udebit=udebit+Double.valueOf(arr[4]);
                                ucredit=ucredit+Double.valueOf(arr[5]);
                                arr[8]="";
                                arr[9]="";
                                arr[10]="";
                                arr[11]="";
                                arr[12]="";
                                arr[13]="";
                                arr[14]="N";
                                dtm.addRow(arr);
                        }
                        
                    }
                    /*else if(!(uparticular1.equalsIgnoreCase(uparticular)) )
                    {
                        arr[0]=""+(dtm.getRowCount()+1);
                        arr[1]="";
                        arr[2]="";
                        arr[3]="";
                        arr[4]="";
                        arr[5]="";
                        arr[6]="";
                        dt=load1[j][0].split("-");
                        arr[8]=dt[2]+"-"+dt[1]+"-"+dt[0];
                        arr[9]=load1[j][1];
                        arr[10]=load1[j][2];
                        arr[11]=load1[j][3];
                        arr[12]=load1[j][4];
                        arr[13]=load1[j][5];
                    }*/
                        
                    
                    //dtm.addRow(arr);
                    System.out.println("hello   "+i);
                }
                flag=1;
            }
            //else
            //{
                System.out.println("in else load.length="+load.length+"   load1.length="+load1.length);
            if (load1.length > load.length)
            {
                System.out.println("load1.length > load.length");
                qry="select tran_date,tran_id,particular,tran_debit_amt,tran_credit_amt,balance_amt,recon_status from kgsg_n_ubi where entry_no<="+Integer.parseInt(last)+" and entry_no>"+Integer.parseInt(start)+" and (recon_status="+0+" or recon_status="+10+" or recon_status="+20+" or ubi_payment_no<>"+Integer.parseInt(paymentno)+") ";
                System.out.println(qry);
                String lo[][]=object1.getInformationDD(qry, 7);
                System.out.println("lo.length ===== "+lo.length);
                
                for(int i=0;i<lo.length;i++)
                {
                    arr[0]=""+(dtm.getRowCount()+1);
                        arr[1]="";
                        arr[2]="";
                        arr[3]="";
                        arr[4]="";
                        arr[5]="";
                        arr[6]="";
                        dt=lo[i][0].split("-");
                        arr[8]=dt[2]+"-"+dt[1]+"-"+dt[0];
                        arr[9]=lo[i][1];
                        arr[10]=lo[i][2];
                        arr[11]=lo[i][3];
                        arr[12]=lo[i][4];
                        arr[13]=lo[i][5];
                        kdebit=udebit+Double.valueOf(arr[11]);
                        
                        if(lo[i][6].equals("2"))
                        {
                            arr[14]="PT";
                        }
                        else
                        {
                            arr[14]="N";
                            kcredit=kcredit+Double.valueOf(arr[12]);
                        }
                        
                        dtm.addRow(arr);
                        
                }
            }
                System.out.println("load.length="+load.length+"   load1.length="+load1.length);
            if (load.length > jTable1.getRowCount() && flag==0)
            {
                System.out.println("load.length > load1.length");
                qry="select entry_no from ubi_bill_of_kgsg_cards where particular='"+jTable1.getValueAt(jTable1.getRowCount()-1, 3).toString()+"'";
                System.out.println(qry);

                String eno=object1.getSingleValue(qry);
                System.out.println("eno = "+eno);
                qry="select tran_date,tran_id,particular,tran_debit_amt,tran_credit_amt,balanceamt from ubi_bill_of_kgsg_cards where entry_no>"+Integer.parseInt(eno)+"";
                System.out.println(qry);
                String lo[][]=object1.getInformationDD(qry, 6);
                System.out.println("lo.length ===== "+lo.length);

                for(int i=0;i<(load.length-load1.length);i++)
                {
                    arr[0]=""+(dtm.getRowCount()+1);
                                dt=lo[i][0].split("-");
                                arr[1]=dt[2]+"-"+dt[1]+"-"+dt[0];
                                arr[2]=lo[i][1];
                                arr[3]=lo[i][2];
                                arr[4]=lo[i][3];
                                arr[5]=lo[i][4];
                                arr[6]=lo[i][5];
                                System.out.println("load part completed ");
                                udebit=udebit+Double.valueOf(arr[4]);
                                ucredit=ucredit+Double.valueOf(arr[5]);
                                

                                arr[8]="";
                                arr[9]="";
                                arr[10]="";
                                arr[11]="";
                                arr[12]="";
                                arr[13]="";
                                arr[14]="N";
                                dtm.addRow(arr);
                }
            }
            //}
            
            String UDebit=""+(new java.math.BigDecimal(udebit)).setScale(2,5);
            String KDebit=""+(new java.math.BigDecimal(kdebit)).setScale(2,5);
            String arr1[]=new String[14];

            dtm.addRow(arr1);

            
            System.out.println("Udebit = "+UDebit);
            String UCredit=""+(new java.math.BigDecimal(ucredit)).setScale(2,5);
            String KCredit=""+(new java.math.BigDecimal(kcredit)).setScale(2,5);
            System.out.println("UCredit = "+UCredit);
            String UBalance=""+(new java.math.BigDecimal(ubalance)).setScale(2,5);
            String KBalance=""+(new java.math.BigDecimal(kbalance)).setScale(2,5);
            System.out.println("UBalance = "+UBalance);





            jTable1.setValueAt("Summation =", jTable1.getRowCount()-1, 3);
            jTable1.setValueAt(UDebit, jTable1.getRowCount()-1, 4);
            jTable1.setValueAt(UCredit, jTable1.getRowCount()-1, 5);
            //jTable1.setValueAt(UBalance, jTable1.getRowCount()-1, 6);

            
            //jTable1.setValueAt(KBalance, jTable1.getRowCount()-1, 13);
            int n=dtm.getRowCount();
            jTable1.setRowSelectionInterval(n-1, n-1);//
            int starten=Integer.parseInt(start);
            String startbal=null;
            String ubal;
            if(load1.length>0)
            {
                jTable1.setValueAt(KDebit, jTable1.getRowCount()-1, 11);
                jTable1.setValueAt(KCredit, jTable1.getRowCount()-1, 12);
                if(starten==0)
                {
                    starten=1;
                    qry="select balance_amt from kgsg_n_ubi where entry_no="+starten+"";
                    System.out.println(qry);
                    startbal=object1.getSingleValue(qry);
                }
                else
                {
                    qry="select balance_amt from kgsg_n_ubi where entry_no>"+starten+"";
                    System.out.println(qry);
                    startbal=object1.getSingleValue(qry);
                }

            if(!load1[0][4].equals("0"))
            {
                System.out.println("load1[0][3].equals(0)"+load1[0][4]);
                double tot=Double.valueOf(startbal)-Double.valueOf(load1[0][4]);
                jLabel4.setText(""+(new java.math.BigDecimal(tot)).setScale(2,5));
            }
            else if(!load1[0][3].equals("0") )
            {
                System.out.println("load1[0][4].equals(0)"+load1[0][3]);
                double tot=Double.valueOf(startbal)+Double.valueOf(load1[0][3]);
                jLabel4.setText(""+(new java.math.BigDecimal(tot)).setScale(2,5));
            }
            
                
            }
            else
            {
                startbal="0";
                jTable1.setValueAt("0", jTable1.getRowCount()-1, 11);
                jTable1.setValueAt("0", jTable1.getRowCount()-1, 12);
                jLabel4.setText("0");
            }
                
             
            //System.out.println("load1[0][3]="+load1[0][3]+"   load1[0][4]="+load1[0][4]+"   startbal="+startbal);
            
            if(Integer.parseInt(pay)<=0)
            {
                qry="select min(entry_no) from ubi_bill_of_kgsg_cards where ubi_payment_no="+1+"";
                System.out.println(qry);
                String uen=object1.getSingleValue(qry);
                qry="select balanceamt from ubi_bill_of_kgsg_cards where entry_no="+Integer.parseInt(uen)+"";
                ubal=object1.getSingleValue(qry);
            }
            else
            {
                qry="select max(entry_no) from ubi_bill_of_kgsg_cards where ubi_payment_no="+Integer.parseInt(pay)+"";
                System.out.println(qry);
                String uen=object1.getSingleValue(qry);
                qry="select balanceamt from ubi_bill_of_kgsg_cards where entry_no>"+Integer.parseInt(uen)+"";
                ubal=object1.getSingleValue(qry);
            }

            
            System.out.println("load[0][3]="+load[0][3]+"   load[0][4]="+load[0][4]+"   bal="+ubal);
            if(Double.valueOf(load[0][4])!=0)
            {
                System.out.println("load[0][4].equals(0)"+load[0][4]);
                double tot=Double.valueOf(ubal)+Double.valueOf(load[0][4]);
                jLabel2.setText(""+(new java.math.BigDecimal(tot)).setScale(2,5));
            }
            else if(Double.valueOf(load[0][3])!=0 )
            {
                System.out.println("load1[0][3].equals(0)"+load[0][3]);
                double tot=Double.valueOf(ubal)-Double.valueOf(load[0][3]);
                jLabel2.setText(""+(new java.math.BigDecimal(tot)).setScale(2,5));
            }

            //jTable1.getSelectionModel().setSelectionInterval(jTable1.getRowCount()-1, jTable1.getColumnCount()-1);
        jTable1.scrollRectToVisible(new java.awt.Rectangle(jTable1.getCellRect(dtm.getRowCount()-1, 0, true)));

        String arr2[]=new String[2];
        arr2[0]="Total Card Debit";
        arr2[1]=jTable1.getValueAt(dtm.getRowCount()-1, 4).toString();
        dtm1.addRow(arr2);
        String arr3[]=new String[2];
        arr3[0]="Total Card Use";
        arr3[1]=jTable1.getValueAt(dtm.getRowCount()-1, 12).toString();
        dtm2.addRow(arr3);
        double total=0;
        for(int a=0;a<dtm.getRowCount()-2;a++)
        {
            //System.out.println(jTable1.getValueAt(a, 5));
            if(!(jTable1.getValueAt(a, 5).equals("")))
            if(Double.valueOf(jTable1.getValueAt(a, 5).toString())!=0 && (jTable1.getValueAt(a, 5).equals(""))==false)
            {
                String part=jTable1.getValueAt(a, 3).toString();
                System.out.println("part = "+part);
                for(int b=a-1;b>=0;b--)
                {
                    if(!(jTable1.getValueAt(b, 4).equals("")))
                    {
                    //System.out.println(jTable1.getValueAt(b, 3)+"                part="+part+"         "+Double.valueOf(jTable1.getValueAt(a, 5).toString())+"        "+Double.valueOf(jTable1.getValueAt(b, 4).toString()));
                    //boolean bn=jTable1.getValueAt(b, 3).equals(part) && (Double.valueOf(jTable1.getValueAt(a, 5).toString())==Double.valueOf(jTable1.getValueAt(b, 4).toString()));
                        if(jTable1.getValueAt(b, 3).equals(part) && jTable1.getValueAt(b, 4).equals(jTable1.getValueAt(a, 5)) )
                        {
                            System.out.println("total auto reversal =");
                            total=total+Double.valueOf(jTable1.getValueAt(b, 4).toString());
                            System.out.println("total auto reversal ="+total);
                            break;
                        }
                    }
                }
            }
        }

        
        arr2[0]="Total Auto Reversal ";
        arr2[1]=""+(new java.math.BigDecimal(total)).setScale(2,5);
        dtm1.addRow(arr2);


            arr2[0]="Net Reversed by UBI";
            String temp1=""+(Double.valueOf(jTable2.getValueAt(0, 1).toString())-Double.valueOf(jTable2.getValueAt(1, 1).toString()));
            arr2[1]=""+(new java.math.BigDecimal(temp1)).setScale(2,5);
            dtm1.addRow(arr2);
            System.out.println("third Table Calculating Start");
            total=0;

            for(int a=0;a<dtm.getRowCount()-2;a++)
            {
                boolean bn=jTable1.getValueAt(a, 11).equals("");
                System.out.println(bn);
                if(!(jTable1.getValueAt(a, 11).equals("")))
                {
                if(Double.valueOf(jTable1.getValueAt(a, 11).toString())!=0 && (jTable1.getValueAt(a, 11).equals(""))==false)
                {
                    String part=jTable1.getValueAt(a, 10).toString();
                    System.out.println("part = "+part);
                    for(int b=a-1;b>=0;b--)
                    {
                        bn=jTable1.getValueAt(b, 12).equals("");
                        System.out.println("              "+bn);
                        if(!(jTable1.getValueAt(b, 12).equals("")) && (jTable1.getValueAt(b, 12)!=null) )
                        {
                            System.out.println("I If Statement when jTable1.getValueAt(b, 11)!=null)");
                        //System.out.println(jTable1.getValueAt(b, 3)+"                part="+part+"         "+Double.valueOf(jTable1.getValueAt(a, 5).toString())+"        "+Double.valueOf(jTable1.getValueAt(b, 4).toString()));
                        //boolean bn=jTable1.getValueAt(b, 3).equals(part) && (Double.valueOf(jTable1.getValueAt(a, 5).toString())==Double.valueOf(jTable1.getValueAt(b, 4).toString()));
                            if(jTable1.getValueAt(b, 10).equals(part) && jTable1.getValueAt(a, 11).equals(jTable1.getValueAt(b, 12)) )
                            {
                                System.out.println("total auto reversal =");
                                total=total+Double.valueOf(jTable1.getValueAt(b, 12).toString());
                                System.out.println("total auto reversal ="+total);
                                break;
                            }
                        }
                    }
                }
                }
            }
            arr3[0]="Total Auto Reversal ";
            arr3[1]=""+(new java.math.BigDecimal(total)).setScale(2,5);
            dtm2.addRow(arr3);


            arr3[0]="Net Card Use ";
            temp1=""+(Double.valueOf(jTable3.getValueAt(0, 1).toString())-Double.valueOf(jTable3.getValueAt(1, 1).toString()));
            arr3[1]=""+(new java.math.BigDecimal(temp1)).setScale(2,5);
            dtm2.addRow(arr3);

            arr3[0]="CD A/C Debited ";
            arr3[1]=jTable2.getValueAt(jTable2.getRowCount()-1, 1).toString();
            dtm2.addRow(arr3);

            arr3[0]="Net Difference ";
            temp1=""+(Double.valueOf(jTable3.getValueAt(2, 1).toString())-Double.valueOf(jTable3.getValueAt(3, 1).toString()));
            arr3[1]=""+(new java.math.BigDecimal(temp1)).setScale(2,5);
            dtm2.addRow(arr3);
            System.out.println("Third Table difference Calculating Start");
            total=0;
            if(jTable3.getValueAt(4, 1).equals("0")==false)
            for(int a=0;a<dtm.getRowCount()-2;a++)
            {
            System.out.println("looping start");
                if(!(jTable1.getValueAt(a, 11)!=null))
                if(Double.valueOf(jTable1.getValueAt(a, 11).toString())!=0 && (jTable1.getValueAt(a, 11).equals(""))==false)
                {
                    String part=jTable1.getValueAt(a, 10).toString();
                    System.out.println("part = "+part);
                    for(int b=a-1;b>=0;b--)
                    {
                        if((jTable1.getValueAt(b, 11)!=null))
                        {
                            System.out.println("I If Statement when jTable1.getValueAt(b, 11)!=null)");
                        //System.out.println(jTable1.getValueAt(b, 3)+"                part="+part+"         "+Double.valueOf(jTable1.getValueAt(a, 5).toString())+"        "+Double.valueOf(jTable1.getValueAt(b, 4).toString()));
                        //boolean bn=jTable1.getValueAt(b, 3).equals(part) && (Double.valueOf(jTable1.getValueAt(a, 5).toString())==Double.valueOf(jTable1.getValueAt(b, 4).toString()));
                            if(jTable1.getValueAt(b, 10).equals(part) && jTable1.getValueAt(b, 12).equals(jTable1.getValueAt(a, 11))==false )
                            {
                                arr3[0]="Break Up Of Net Difference";
                                arr3[1]=""+Double.valueOf(jTable1.getValueAt(b, 12).toString());
                                dtm2.addRow(arr3);
                                arr3[0]="New Total Auto Reversal ";
                                double temp3=total+Double.valueOf(jTable3.getValueAt(1, 1).toString());
                                arr3[1]=""+(new java.math.BigDecimal(temp3)).setScale(2,5);
                                dtm2.addRow(arr3);
                                total=Double.valueOf(arr3[1])+total;
                                arr3[0]="Net Card Use ";
                                temp1=""+(Double.valueOf(jTable3.getValueAt(0, 1).toString())-temp3);
                                String totu=temp1;
                                arr3[1]=""+(new java.math.BigDecimal(temp1)).setScale(2,5);
                                dtm2.addRow(arr3);
                                arr3[0]="CD A/C Debited ";
                                arr3[1]=jTable2.getValueAt(jTable2.getRowCount()-1, 1).toString();
                                dtm2.addRow(arr3);
                                arr3[0]="Net Difference ";
                                temp1=""+(Double.valueOf(totu)-Double.valueOf(jTable2.getValueAt(jTable2.getRowCount()-1, 1).toString()));
                                arr3[1]=""+(new java.math.BigDecimal(temp1)).setScale(2,5);
                                dtm2.addRow(arr3);
                                System.out.println("Net Difference "+arr3[1]);
                                break;
                            }
                        }
                    }
                }
            }

        }
        catch(Exception ae)
        {
            System.out.println("Eror in table method"+ae);
        }
    }
    java.math.BigDecimal bd=null;
}