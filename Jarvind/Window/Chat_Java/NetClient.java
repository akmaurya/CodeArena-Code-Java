import java.util.*;
import java.awt.*;
import java.net.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class NetClient extends JFrame{
	private JTextField userText;
	private JTextArea chatWindow;
	private JTextArea chatWindow1;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private String message="";
	private String serverIP;
	String str;
	private Socket connection;
	private JScrollPane pane;
		private JScrollPane pane1;
	//Graphics g;
	public NetClient(String host)
	{
		super("client side");
		Container cn=getContentPane();
		//g=cn.getGraphics();
		cn.setLayout(null);
		serverIP=host;
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
		chatWindow=new JTextArea();
		str=JOptionPane.showInputDialog("enter your name:");
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
			connectToServer();
			setupStreams();
			whileChatting();	
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			closeConn();
		}
	}
	private void connectToServer()throws IOException{
		showMessage("\n Attempting Connection...\n");
		connection=new Socket(InetAddress.getByName(serverIP),6789);
		showMessage("connected to:"+ connection.getInetAddress().getHostName());
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
		ableToType(true);
		do
		{
			try{
				message=(String) input.readObject();
				System.out.println(message);
				showMessageTo("\n"+message);

			}
			catch(ClassNotFoundException ce){
				showMessage("not know the object type");
			}
		}while(!message.equals("mihir:: END"));
	}
	private void closeConn(){
		showMessage("\n closing connection...!\n");
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
			chatWindow.append("\n ERROR in Connection:");
		}
	}
	private void showMessage(final String text){
		SwingUtilities.invokeLater(
			new Runnable(){
				public void run(){
						chatWindow.setForeground(Color.RED);
						chatWindow.append(text);
				}
			}
			);
	}
	private void showMessageTo(final String text){
		SwingUtilities.invokeLater(
			new Runnable(){
				public void run(){
						chatWindow1.setForeground( Color.BLUE);
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