import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.awt.Image;
import javax.swing.*;

public class runClient extends Thread implements KeyListener,MouseListener
{
        JLabel imageViewer;
        Window window;
        Frame frame;
        static runClient gvw; 
        public runClient()
        {
                this.gvw=gvw;
        }
        //public static railway showGifFile(String gifFile,int imageHeight, int imageWidth)
        public runClient showGifFile(String gifFile,int imageHeight, int imageWidth)
        {
                gvw = new runClient(gifFile);
                gvw.centerAndSetVisible(imageHeight, imageWidth);
                return gvw;
        }

        public static runClient showGifFile(Image gifImage, int imageHeight, int imageWidth)
        {
                runClient gvw = new runClient(gifImage);
                gvw.centerAndSetVisible(imageHeight, imageWidth);
                return gvw;
        }
        public static void hideGifFile(runClient gvw)
        {
                gvw.removeNotify();
        }

        public runClient(Image  gifImage)
        {
                initialize(gifImage);
        }

        public runClient(Applet applet, String gifFileName)
        {
                Image gifImage = applet.getImage(applet.getCodeBase(),gifFileName);
                initialize(gifImage);
        }

        public runClient(String gifFileName)
        {
                Image gifImage=Toolkit.getDefaultToolkit().getImage(gifFileName);
                initialize(gifImage);
        }

        public void centerAndSetVisible(int imageHeight,int imageWidth)
        {
                Dimension sd=Toolkit.getDefaultToolkit().getScreenSize();
                int x=(sd.width-imageWidth)/2;
                int y=(sd.height-imageHeight)/2;
                setLocation(x,y);
                setSize(new Dimension(imageWidth,imageHeight));
                setVisible(true);
        }
        public void setSize(Dimension d)
        {
                window.setSize(d);
                if (imageViewer !=null)
                        imageViewer.setSize(d);
        }
        public void setLocation(int x, int y)
        {
                window.setLocation(x,y);
        }

        public void setVisible(boolean newValue)
        {
                window.setBackground(Color.white);
                window.setVisible(newValue);
        }
        public void toFront()
        {
                window.toFront();
        }
        private void initialize(Image gifImage)
        {
                frame= new Frame();
                frame.addNotify();
                window=new Window(frame);
                window.addNotify();
                imageViewer=new JLabel(new ImageIcon(gifImage,"TermBuilder splash image"));
                window.add(imageViewer);
                window.addKeyListener(this);
                window.addMouseListener(this);
        }
        public Frame getParent()
        {
                return frame;
        } 

        public void removeNotify()
        {
                window.removeNotify();
                frame.removeNotify();
        }
        public void finalize()
        {
                removeNotify();
        }
        public static void main(String args[])
        {
                runClient object=new runClient();
                object.showGifFile("logo.gif",378,569);
                object.start();
        }

                public void run()
                {
                        try
                        {
                         						   	
        						collegevc.college LF=new collegevc.college(null ,null ,null);
	        					java.awt.Dimension sd=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        						LF.reshape((sd.width-360)/2,((sd.height-200)/2)-50,400,170);
	        					LF.setVisible(true);
        						
						gvw.setVisible(false);
                                gvw.showGifFile("logo.gif",378,569);
                                window.requestFocus();
                                Thread.sleep(3000);

                                gvw.setVisible(false);
                        }
                        catch(Exception x){}
                }
        public void keyPressed(KeyEvent ke)
        {
                if(ke.getKeyCode()==10)
                {
                        System.out.println("Pressed...");
                                gvw.setVisible(false);
                }
        }
        public void keyReleased(KeyEvent ke){}
        public void keyTyped(KeyEvent ke){}
        public void mousePressed(MouseEvent me)
        {
                        System.out.println("Mouse Pressed...");
                                gvw.setVisible(false);
        }
        public void mouseReleased(MouseEvent me){}
        public void mouseClicked(MouseEvent me){}
        public void mouseEntered(MouseEvent me){}
        public void mouseExited(MouseEvent me){}

}
