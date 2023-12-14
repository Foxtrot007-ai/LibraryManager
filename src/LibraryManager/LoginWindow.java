package LibraryManager;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class LoginWindow extends JFrame{
	public DataBaseConnectorProxy connection;
	//login UI
	public JTextField loginTextField = new JTextField();
	public JTextField passwordTextField = new JTextField();
	public JLabel loginLabel = new JLabel("Login:");
	public JLabel passwordLabel = new JLabel("Password:");
	public JButton connectButton = new JButton("Connect");
	
	public void initializeThisFrame() {
		//I don't want to close this frame just turn it visibility off
		JFrame thisFrame = this;
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				thisFrame.setVisible(false);
		    }
		});
		this.setLayout(null);
		this.setSize(400, 500);
		this.setVisible(true);
	}
	
	private Action addBookAction = new AbstractAction("Add book") {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	connection.startConnection(loginTextField.getText(), passwordTextField.getText());
	    }
	};
	
	public void initializeComponents() {
		loginLabel.setBounds(100, 50, 200, 50);
		loginTextField.setBounds(100, 100, 200, 50);
		
		passwordLabel.setBounds(100, 150, 200, 50);
		passwordTextField.setBounds(100, 200, 200, 50);
		
		connectButton.setBounds(100, 350, 200, 50);
		connectButton.addActionListener(addBookAction);
		
		this.add(loginLabel);
		this.add(loginTextField);
		
		this.add(passwordLabel);
		this.add(passwordTextField);
		
		this.add(connectButton);
	}
	
	public LoginWindow(DataBaseConnectorProxy connector) {
		this.connection = connector; 
		initializeThisFrame();
		initializeComponents();
	}
}

