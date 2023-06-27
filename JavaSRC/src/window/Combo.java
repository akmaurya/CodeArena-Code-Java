package window;

import javax.swing.*;

/**
 * Created by jarvis on 27/6/17.
 */
public class Combo {
    public JComboBox emptyCombo(JComboBox comboBox)
    {
        int size = comboBox.getItemCount();
        System.out.println("Total Items = "+size);
        comboBox.setEditable(true);
        for (int i = 1; i < size; i++) {
            comboBox.remove(i);
        }
        comboBox.setEditable(false);
        return comboBox;
    }
}
