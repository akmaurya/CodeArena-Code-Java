package com.xcode.javas.rough.oracle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jarvis on 1/1/17.
 */
class LambdaExample_3 {
      public static void main(String[] args) {

             JButton testButton = new JButton("Test Button");
             testButton.addActionListener(new ActionListener(){
     @Override public void actionPerformed(ActionEvent ae){
                         System.out.println("Click Detected by Anon Class");
                       }
     });

             testButton.addActionListener(e -> System.out.println("Click Detected by Lambda Listner"));

             // Swing stuff
             JFrame frame = new JFrame("Listener Test");
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame.add(testButton, BorderLayout.CENTER);
             frame.pack();
             frame.setVisible(true);

           }
 }