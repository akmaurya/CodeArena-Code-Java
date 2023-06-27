/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package atm;

/**
 *
 * @author DEEP PAL
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel ML=new com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel();
        //com.sun.java.swing.plaf.motif.MotifLookAndFeel ML=new com.sun.java.swing.plaf.motif.MotifLookAndFeel();
        Desktop_atm frm=new Desktop_atm();
        frm.setExtendedState(frm.MAXIMIZED_BOTH);
        frm.setDefaultLookAndFeelDecorated(true);
        try
        {
            javax.swing.UIManager.setLookAndFeel(ML);
            javax.swing.SwingUtilities.updateComponentTreeUI(frm);
            frm.setVisible(true);
        }
        catch(Exception e)
        {
            System.out.println("Error ! In Main Method"+e);
        }
    }

}
