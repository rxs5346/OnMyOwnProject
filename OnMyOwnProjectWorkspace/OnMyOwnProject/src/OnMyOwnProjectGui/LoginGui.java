package OnMyOwnProjectGui;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Core.ProblemInfo;

public class LoginGui
{
	public LoginGui()
	{
		final JFrame theFrame = new JFrame();
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int widthOfScreen = gd.getDisplayMode().getWidth();
		int heightOfScreen = gd.getDisplayMode().getHeight();
		theFrame.setTitle("Login to the database");
		theFrame.setSize(widthOfScreen-50,heightOfScreen-50);
		theFrame.setLocation(550, 400);
		
		final JPanel panel = new JPanel(new GridLayout(3,2));
		final JLabel usernameLabel = new JLabel("Enter your username");
		final JLabel passwordLabel = new JLabel("Enter your password");
		final JLabel space1 = new JLabel("");
		final JTextField userNameField = new JTextField(50);
		final JTextField passwordField = new JTextField(50);
		final JButton submitPasswordButton = new JButton("Submit");
		
		panel.add(usernameLabel);
		panel.add(userNameField);
		panel.add(passwordLabel);
		panel.add(passwordField);
		panel.add(space1);
		panel.add(submitPasswordButton);
		submitPasswordButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				String userName = userNameField.getText();
				String password = passwordField.getText();
				boolean loggedInFlag = false;
				//check connection with username and password
				Connection createDBconnection = null;
				try 
				{
					createDBconnection = DriverManager
							.getConnection("jdbc:mysql://localhost:3306/",userName, password); //root! at sru test! at home
					loggedInFlag = true;
				} 
				catch (SQLException q) 
				{
					System.out.println("Connection Failed! Check output console");
					loggedInFlag = false;
					q.printStackTrace();
					return;
				}
				finally
				{
					try
					{
						createDBconnection.close();
					}
					catch (SQLException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(loggedInFlag)
				{
					System.out.println("You were logged in");
					ProblemInfo.username = userName;
					ProblemInfo.password = password;
					ProblemInfo.logInSuccessful = true;
					//close login window
				}
				else
				{
					System.out.println("You need to supply the correct credentials");
					ProblemInfo.logInSuccessful = false;
				}
			}
		});
		
		theFrame.getContentPane().add(panel);
		theFrame.pack();
		theFrame.setVisible(true);
		
		theFrame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}
}
