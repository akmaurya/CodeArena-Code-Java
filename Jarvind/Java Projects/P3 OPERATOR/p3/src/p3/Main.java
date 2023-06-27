/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package p3;

import p3.LoadFinancialYear;

/**
 *
 * @author welcome
 */
public class Main {
static public String year;
static public String cname;
static String userID;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LoadFinancialYear LF=new LoadFinancialYear();
        java.awt.Dimension sd=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        LF.reshape((sd.width-660)/2,((sd.height-300)/2),640, 340);
        try
        {
            com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel ML=new com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel();
            javax.swing.UIManager.setLookAndFeel(ML);
            javax.swing.SwingUtilities.updateComponentTreeUI(LF);
            LF.setVisible(true);
        }
        catch(Exception e)
        {
            System.out.println("Error ! In Main Method"+e);
        }
    }
}