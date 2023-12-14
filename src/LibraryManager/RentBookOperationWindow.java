package LibraryManager;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class RentBookOperationWindow extends JFrame {
	public DataBaseConnectorProxy connection;
	//rental UI
	public JTextField userIdTextField = new JTextField();
	public JLabel userIdLabel = new JLabel("User Id:");
	public JTextField bookIdTextField = new JTextField();
	public JLabel bookIdLabel = new JLabel("Book Id:");
	public JTextField limitTextField = new JTextField();
	public JLabel limitLabel = new JLabel("For how many days?:");
	public JButton rentButton = new JButton("Rent Book");
	
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
		this.setSize(400,500);
		this.setVisible(false);
	}
	
	private Action rentAction = new AbstractAction("rent book") {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	connection.addRentalQuery(userIdTextField.getText(), bookIdTextField.getText(), limitTextField.getText());
	    }
	};
	
	public void initializeRentBookComponents() {
		userIdLabel.setBounds(100, 50, 200, 50);
		userIdTextField.setBounds(100, 100, 200, 50);
		bookIdLabel.setBounds(100, 150, 200, 50);
		bookIdTextField.setBounds(100, 200, 200, 50);
		limitLabel.setBounds(100, 250, 200, 50);
		limitTextField.setBounds(100, 300, 200, 50);
		rentButton.setBounds(100, 350, 200, 70);
		rentButton.addActionListener(rentAction);
		this.add(userIdLabel);
		this.add(userIdTextField);
		this.add(bookIdLabel);
		this.add(bookIdTextField);
		this.add(limitLabel);
		this.add(limitTextField);
		this.add(rentButton);
	}
	
	public RentBookOperationWindow(DataBaseConnectorProxy connector) {
		this.connection = connector; 
		initializeThisFrame();
		initializeRentBookComponents();
	}
}
