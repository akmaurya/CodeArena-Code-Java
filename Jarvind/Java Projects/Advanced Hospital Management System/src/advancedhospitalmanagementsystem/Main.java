/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package advancedhospitalmanagementsystem;

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
        DeskTop ob =new DeskTop();
        ob.setExtendedState(ob.MAXIMIZED_BOTH);
        ob.setTitle("H O S P I T A L   M A N A G E M E N T   S Y S T E M   V e r  1 . 1");
        ob.setVisible(true);
    }

}
