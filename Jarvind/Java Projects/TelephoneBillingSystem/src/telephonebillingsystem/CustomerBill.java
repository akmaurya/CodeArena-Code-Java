/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CustomerBill.java
 *
 * Created on May 29, 2013, 3:46:54 PM
 */

package telephonebillingsystem;

/**
 *
 * @author user2
 */
public class CustomerBill extends javax.swing.JInternalFrame {

    /** Creates new form CustomerBill */
    public CustomerBill() {
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

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(telephonebillingsystem.TelephoneBillingSystemApp.class).getContext().getResourceMap(CustomerBill.class);
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        getContentPane().setLayout(null);

        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 10, 190, 30);

        jTextField1.setText(resourceMap.getString("jTextField1.text")); // NOI18N
        jTextField1.setName("jTextField1"); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(220, 10, 160, 30);

        jLabel2.setFont(resourceMap.getFont("jLabel2.font")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 160, 200, 20);

        jTextField2.setText(resourceMap.getString("jTextField2.text")); // NOI18N
        jTextField2.setName("jTextField2"); // NOI18N
        getContentPane().add(jTextField2);
        jTextField2.setBounds(220, 160, 160, 30);

        jLabel3.setFont(resourceMap.getFont("jLabel3.font")); // NOI18N
        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 190, 170, 30);

        jTextField3.setText(resourceMap.getString("jTextField3.text")); // NOI18N
        jTextField3.setName("jTextField3"); // NOI18N
        getContentPane().add(jTextField3);
        jTextField3.setBounds(220, 200, 160, 30);

        jButton1.setIcon(resourceMap.getIcon("jButton1.icon")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 90, 180, 30);

        jButton2.setIcon(resourceMap.getIcon("jButton2.icon")); // NOI18N
        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N
        getContentPane().add(jButton2);
        jButton2.setBounds(210, 90, 170, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jButton1.requestFocus();
        }
    }//GEN-LAST:event_jTextField1KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

    private void done()
    {
        try
        {
            String qry="Select PreviousAmount from MasterBillCreation where CustomerAccountNo="+Integer.parseInt(jTextField1.getText())+"";
            String pre=Utility.getSingleValue(qry);
            qry="Select UsageCharge from MasterBillCreation where CustomerAccountNo="+Integer.parseInt(jTextField1.getText())+"";
            String usage=Utility.getSingleValue(qry);
            qry="Select Curent_Amount from MasterBillCreation where CustomerAccountNo="+Integer.parseInt(jTextField1.getText())+"";
            String cur=Utility.getSingleValue(qry);
            double tot=Double.valueOf(pre)+Double.valueOf(usage)+Double.valueOf(cur);
            jTextField2.setText(""+tot);
            qry="Select DueDate from MasterBillCreation where CustomerAccountNo="+Integer.parseInt(jTextField1.getText())+"";
            String D[]=Utility.getSingleValue(qry).split("-");
                    String dd[]=D[2].split(" ");//+"-"+D[1]+"-"+D[0];
                    String setDate=dd[0]+"-"+D[1]+"-"+D[0];
                    jTextField3.setText(setDate);
        }
        catch(Exception ae)
        {
            System.out.println("Error in done method"+ae);
        }
    }
}
