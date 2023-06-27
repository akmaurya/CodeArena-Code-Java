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
        Login frm=new Login(null,true);
        frm.setBounds(100, 100, 530, 380);
        frm.setTitle("WELCOME IN USER LOGIN WINDOW");
        frm.setDefaultLookAndFeelDecorated(true);
                                                  //  AL.setCurrentTheme(MT);
        try
        {
            com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel ML=new com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel();
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
