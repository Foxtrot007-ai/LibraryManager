package LibraryManager;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class AddBookOperationWindow extends JFrame {
	public DataBaseConnectorProxy connection;
	//add book UI
	public JTextField bookTitleTextField = new JTextField();
	public JTextField bookIdTextField = new JTextField();
	public JLabel bookTitleLabel = new JLabel("Title:");
	public JLabel bookIdLabel = new JLabel("Book Id:");
	public JButton addButton = new JButton("Add Book");
	
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
	
	private Action addBookAction = new AbstractAction("Add book") {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	connection.addBookQuery(bookTitleTextField.getText());
	    }
	};
	
	public void initializeAddBookComponents() {
		bookTitleLabel.setBounds(100, 50, 200, 50);
		bookTitleTextField.setBounds(100, 100, 200, 50);
		
		addButton.setBounds(100, 350, 200, 50);
		addButton.addActionListener(addBookAction);
		
		this.add(bookTitleLabel);
		this.add(bookTitleTextField);
		
		this.add(bookIdLabel);
		this.add(bookIdTextField);
		
		this.add(addButton);
	}
	
	public AddBookOperationWindow(DataBaseConnectorProxy connector) {
		this.connection = connector; 
		initializeThisFrame();
		initializeAddBookComponents();
	}
}
