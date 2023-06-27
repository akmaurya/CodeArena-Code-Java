/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package railwaycashoffice;
import com.sun.java.swing.plaf.motif.*;
import com.sun.java.swing.plaf.windows.*;
import com.sun.java.swing.plaf.nimbus.*;
import javax.swing.plaf.metal.*;
import javax.swing.plaf.metal.MetalTheme;

/**
 *
 * @author pratiksha
 */
public class Main {
static public String year;
static String userID;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LoadFinancialYear LF=new LoadFinancialYear();
        java.awt.Dimension sd=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        LF.reshape((sd.width-360)/2,((sd.height-200)/2)-50,400,170);
        LF.setVisible(true);
    }

}
