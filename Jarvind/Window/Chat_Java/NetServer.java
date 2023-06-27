import java.util.*;
import java.awt.*;
import java.net.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class NetServer extends JFrame{
	private JTextField userText;
	private JTextArea chatWindow;
	private JTextArea chatWindow1;
	String str;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection;
	private JScrollPane pane;
	private JScrollPane pane1;
	public NetServer()
	{
		super("server side");
		Container cn=getContentPane();
		cn.setLayout(null);
		userText=new JTextField();
		userText.setBackground(Color.YELLOW);
		userText.setForeground(Color.RED);
		//Dimension d=new Dimension(500,50);
		//userText.setPreferredSize(d);
		userText.setBounds(0,0,500,50);
		userText.setEditable(false);
		userText.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ae)
				{

					sendMessage(ae.getActionCommand());
					userText.setText("");
				}
			}
			);
		cn.add(userText);
		str=JOptionPane.showInputDialog("enter your name:");
		chatWindow=new JTextArea();
		//chatWindow.setBackground(Color.GRAY);
		chatWindow.setForeground(Color.BLUE);
		pane=new JScrollPane(chatWindow);
		pane.setBounds(0,50,250,450);
		cn.add(pane);
		chatWindow1=new JTextArea();
		//chatWindow1.setBackground(new Color(0,64,0));
		chatWindow1.setForeground(Color.BLUE);
		pane1=new JScrollPane(chatWindow1);
		pane1.setBounds(250,50,250,450);
		cn.add(pane1);
		setSize(500,500);
		setVisible(true);
	}
	public void startRunning(){
		 
		try{
			server=new ServerSocket(6789,100);
			while(true)
			{
				try{
					waitForConnection();
					setupStreams();
					whileChatting();
				}
				catch(EOFException eof){
					showMessage("\n server ended the connection");
				}
				finally{
					closeConn();
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void waitForConnection()throws IOException{
		showMessage("waiting for someone to connection\n");
		connection =server.accept();
		showMessage("nw connected to"+connection.getInetAddress().getHostName());
	}
	private void setupStreams() throws IOException{
		output=new ObjectOutputStream(connection.getOutputStream());
		//System.out.println(output+"");
		output.flush();
		input=new ObjectInputStream(connection.getInputStream());
		//System.out.println(input+"");
		showMessage("\n stream are now setup\n");
	}
	private void whileChatting()throws IOException{
		chatWindow.setForeground(Color.BLACK);
		String message="you are now conneccted";
		sendMessage(message);
		ableToType(true);
		do
		{
			try{
				message=(String) input.readObject();
				
				System.out.println(message);
				showMessageTo("\n"+message);

			}
			catch(ClassNotFoundException ce){
				showMessage("what user send");
			}
		}while(!message.equals("vishal:: END"));
	}
	private void closeConn(){
		showMessage("\nclosing connection...!\n");
		ableToType(false);
		try{
			output.close();
			input.close();
			connection.close();
		}
		catch(IOException a){
			a.printStackTrace();
		}
	}
	private void sendMessage(String message){
		try{
			output.writeObject(""+str+":: "+message+"");
			output.flush();
			showMessage("\n"+str+":: "+message);
		}
		catch(IOException a)
		{
			chatWindow.append("\n ERROR:");
		}
	}
	private void showMessage(final String text){
		SwingUtilities.invokeLater(
			new Runnable(){
				public void run(){
						chatWindow.setForeground(Color.BLUE);
						chatWindow.append(text);
				}
			}
			);
	}
	private void showMessageTo(final String text){
		SwingUtilities.invokeLater(
			new Runnable(){
				public void run(){
						chatWindow1.setForeground(Color.RED);
						chatWindow1.append(text);
				}
			}
			);
	}
	private void ableToType(final boolean tof){
		SwingUtilities.invokeLater(
			new Runnable(){
				public void run(){
					userText.setEditable(tof);
				}
			}
			);
	}
 }