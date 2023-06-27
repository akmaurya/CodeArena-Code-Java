/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package golden_shoap;

/**
 *
 * @author user1
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                // TODO code application logic here
        Master_Screen ms=new  Master_Screen();
       // ms.setSize(400,300);
        ms.setExtendedState(ms.MAXIMIZED_BOTH);
        ms.setDefaultLookAndFeelDecorated(true);
        try
        {
            com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel ML=new com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel();
            javax.swing.UIManager.setLookAndFeel(ML);
            javax.swing.SwingUtilities.updateComponentTreeUI(ms);
            ms.setVisible(true);
        }
        catch(Exception e)
        {
            System.out.println("Error ! In Main Method"+e);
        }
        
    }

}
