/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package riperealtorspltd;

/**
 *
 * @author welcome
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DesktopWindow dw=new DesktopWindow();
        dw.setExtendedState(dw.MAXIMIZED_BOTH);
        dw.setTitle("Welcome in Ripe Realtors (P) Ltd.");
        dw.setVisible(true);
    }

}
