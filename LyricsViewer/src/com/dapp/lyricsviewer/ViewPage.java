package com.dapp.lyricsviewer;

import javax.swing.*;
import java.awt.*;

public class ViewPage extends JFrame{
    JTextArea viewArea;
    public static void main(String[] args) {
        ViewPage front = new ViewPage();
        front.setSize(800,600);
        front.setVisible(true);
    }


    public ViewPage()
    {
        Container cn = getContentPane();
        cn.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        viewArea = new JTextArea();
        scrollPane = new JScrollPane(viewArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(200,50,550,500);
        cn.add(scrollPane);
    }

}
