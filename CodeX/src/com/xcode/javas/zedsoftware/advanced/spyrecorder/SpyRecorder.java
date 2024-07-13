package com.xcode.javas.zedsoftware.advanced.spyrecorder;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File; 
import javax.imageio.ImageIO;
import javax.swing.*;  

class SpyRecorder extends JFrame
{
	public SpyRecorder() 
	{    	
		
    		try 
        	{
	            Thread.sleep(1000);
            	Toolkit tk = Toolkit.getDefaultToolkit(); 
            	Dimension d = tk.getScreenSize();
            	Rectangle rec = new Rectangle(0, 0, d.width, d.height);  
            	Robot ro = new Robot();
            	int i=1;
				while(i>0)
		    	{
	            	BufferedImage img = ro.createScreenCapture(rec);
            		File f = new File("image/myimage"+i+".jpg");//set appropriate path
        	    	ImageIO.write(img, "jpg", f);
        	    		i++;
        		}
        	}
        	catch(Exception ex)
        	{
            	System.out.println(ex.getMessage());
        	}
        
    	
	}
	
	public static void main(String[] args)
	{
    	SpyRecorder sr =new SpyRecorder();
	}
}