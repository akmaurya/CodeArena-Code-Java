/*
 * FirmList.java
 *
 * Created on May 19, 2010, 6:09 PM
 */

//package medretail;

/**
 *
 * @author  Deep Pal
 */
public class FirmList extends javax.swing.JFrame {
    
    /** Creates new form FirmList */
    public FirmList() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        getContentPane().setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Book Antiqua", 1, 14));
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Select Firm Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 20, 200, 20);

        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 50, 230, 230);

        jPanel1.setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)), "Information Of New Firm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 204)));
        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabel2.setText("Enter new firm name");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 30, 150, 20);

        jPanel1.add(jTextField1);
        jTextField1.setBounds(160, 30, 260, 19);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(260, 50, 440, 80);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow.gif")));
        jButton1.setText("Select");
        getContentPane().add(jButton1);
        jButton1.setBounds(260, 180, 140, 100);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.gif")));
        jButton2.setText("Create Firm");
        getContentPane().add(jButton2);
        jButton2.setBounds(410, 180, 140, 100);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exit.gif")));
        jButton3.setText("Exit");
        getContentPane().add(jButton3);
        jButton3.setBounds(560, 180, 140, 100);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
// TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowActivated
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FirmList().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
    
}