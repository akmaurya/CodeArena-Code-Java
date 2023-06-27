/*
 * TelephoneBillingSystemApp.java
 */

package telephonebillingsystem;

import java.awt.*;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class TelephoneBillingSystemApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {

        LoginDialog ld=new LoginDialog(new Frame(),true);

        ld.setBounds(100, 200, 400, 250);
        //ld.setSize(339, 172);
        ld.setVisible(true);
        //TelephoneBillingSystemView frm=new TelephoneBillingSystemView(this);
        //show(frm);
        show(new TelephoneBillingSystemView(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of TelephoneBillingSystemApp
     */
    public static TelephoneBillingSystemApp getApplication() {
        return Application.getInstance(TelephoneBillingSystemApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(TelephoneBillingSystemApp.class, args);
    }
}
