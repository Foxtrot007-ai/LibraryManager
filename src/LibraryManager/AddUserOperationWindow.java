package LibraryManager;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class AddUserOperationWindow extends JFrame {
	public DataBaseConnector connection;
	//add user UI
	public JTextField firstNameTextField = new JTextField();
	public JTextField lastNameTextField = new JTextField();
	public JTextField peselTextField = new JTextField();
	public JLabel firstNameLabel = new JLabel("First Name:");
	public JLabel lastNameLabel = new JLabel("Last Name:");
	public JLabel peselLabel = new JLabel("Pesel:");
	public JButton addButton = new JButton("Add User");
	
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
		this.setVisible(false);
	}
	
	private Action addUserAction = new AbstractAction("Add user") {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	connection.addUserQuery(firstNameTextField.getText(), lastNameTextField.getText(), peselTextField.getText());
	    }
	};
	
	public void initializeAddUserComponents() {
		firstNameLabel.setBounds(100, 50, 200, 50);
		firstNameTextField.setBounds(100, 100, 200, 50);
		
		lastNameLabel.setBounds(100, 150, 200, 50);
		lastNameTextField.setBounds(100, 200, 200, 50);
		
		peselLabel.setBounds(100, 250, 200, 50);
		peselTextField.setBounds(100, 300, 200, 50);
		
		addButton.setBounds(100, 350, 200, 50);
		addButton.addActionListener(addUserAction);
		
		this.add(firstNameLabel);
		this.add(firstNameTextField);
		
		this.add(lastNameLabel);
		this.add(lastNameTextField);
		
		this.add(peselLabel);
		this.add(peselTextField);
		
		this.add(addButton);
	}
	
	public AddUserOperationWindow(DataBaseConnector connector) {
		this.connection = connector; 
		initializeThisFrame();
		initializeAddUserComponents();
	}
}
