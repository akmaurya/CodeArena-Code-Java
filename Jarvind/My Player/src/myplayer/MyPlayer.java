/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myplayer;

/**
 *
 * @author Sanjay
 */
public class MyPlayer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        MainWindow mwindow=new MainWindow();
        try
        {
            com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel NLF=new com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel();
            javax.swing.UIManager.setLookAndFeel(NLF);
            javax.swing.SwingUtilities.updateComponentTreeUI(mwindow);
            mwindow.setVisible(true);
        }
        catch(Exception ex)
        {
            System.out.println("Error | About Java Look & Feel"+ex);
        }

        mwindow.setExtendedState(mwindow.MAXIMIZED_BOTH);
        mwindow.setTitle("My Player | Simple Player");
        mwindow.setVisible(true);
    }
}
