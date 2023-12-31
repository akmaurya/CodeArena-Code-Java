/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UserPaymentWindow.java
 *
 * Created on May 28, 2013, 5:28:24 PM
 */

package telephonebillingsystem;

/**
 *
 * @author user2
 */
public class UserPaymentWindow extends javax.swing.JInternalFrame {
public javax.swing.table.DefaultTableModel dtm;
    /** Creates new form UserPaymentWindow */
    public UserPaymentWindow() {
        initComponents();
        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
        javax.swing.table.DefaultTableCellRenderer CRLeft = new javax.swing.table.DefaultTableCellRenderer();
        javax.swing.table.DefaultTableCellRenderer CRRight = new javax.swing.table.DefaultTableCellRenderer();
        javax.swing.table.DefaultTableCellRenderer CRCenter = new javax.swing.table.DefaultTableCellRenderer();
        CRCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        CRLeft.setHorizontalAlignment(javax.swing.JLabel.LEFT);
        CRRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);

        String heading[]={"S.No","Customer Name","Cu Account No","Customer id","Act Ballance","Payble Amount"};
        dtm=new javax.swing.table.DefaultTableModel(heading,0);
        jTable1.setModel(dtm);
        javax.swing.table.TableColumn column;

        column=jTable1.getColumn("S.No");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(40);
        column=jTable1.getColumn("Cu Account No");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(90);
        column=jTable1.getColumn("Customer id");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(70);
        column=jTable1.getColumn("Customer Name");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(160);
        column=jTable1.getColumn("Act Ballance");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(70);
        column=jTable1.getColumn("Payble Amount");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(85);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(telephonebillingsystem.TelephoneBillingSystemApp.class).getContext().getResourceMap(UserPaymentWindow.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        getContentPane().setLayout(null);

        jButton1.setFont(resourceMap.getFont("jButton1.font")); // NOI18N
        jButton1.setIcon(resourceMap.getIcon("jButton1.icon")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(70, 10, 410, 30);

        jScrollPane1.setName("jScrollPane1"); // NOI18N

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
        jTable1.setName("jTable1"); // NOI18N
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 60, 520, 580);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Show();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void Show()
    {
        try
        {
            String qry="Select * from MasterBillCreation where status=1";
            String load[][]=Utility.getInformationDD(qry,9);
            String arr[]=null;
            if(load.length>0)
            {
                arr=new String[10];
                for(int i=0;i<load.length;i++)
                {
                    arr[0]=""+(dtm.getRowCount()+1);
                    String actno=load[i][0];
                    qry="select Cu_Name from master_user where Account_No="+Integer.parseInt(actno)+"";
                    String cunm=Utility.getSingleValue(qry);
                    arr[1]=cunm;
                    arr[2]=actno;
                    arr[3]=load[i][1];
                    qry="select Account_Balance from BillPayment where Cu_Acc_No="+Integer.parseInt(actno)+"";
                    String acb=Utility.getSingleValue(qry);
                    arr[4]=acb;
                    qry="select Amount_Payable from BillPayment where Cu_Acc_No="+Integer.parseInt(actno)+"";
                    String pab=Utility.getSingleValue(qry);
                    arr[5]=pab;
                    dtm.addRow(arr);
                }
            }
        }
        catch(Exception ae)
        {
            System.out.println("Error in Show method.........."+ae);
        }
    }
}
