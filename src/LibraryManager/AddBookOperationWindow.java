package LibraryManager;

import java.awt.*;
import javax.swing.*;

public class AddBookOperationWindow extends JFrame {
	//add user UI
	public JTextField bookTitleTextField = new JTextField();
	public JTextField bookReleaseTextField = new JTextField();
	public JTextField bookIdTextField = new JTextField();
	public JLabel bookTitleLabel = new JLabel("Title:");
	public JLabel bookReleaseLabel = new JLabel("Release:");
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
	
	public void initializeAddBookComponents() {
		bookTitleLabel.setBounds(100, 50, 200, 50);
		bookTitleTextField.setBounds(100, 100, 200, 50);
		
		bookReleaseLabel.setBounds(100, 150, 200, 50);
		bookReleaseTextField.setBounds(100, 200, 200, 50);
		
		bookIdLabel.setBounds(100, 250, 200, 50);
		bookIdTextField.setBounds(100, 300, 200, 50);
		
		addButton.setBounds(100, 350, 200, 50);
		
		this.add(bookTitleLabel);
		this.add(bookTitleTextField);
		
		this.add(bookReleaseLabel);
		this.add(bookReleaseTextField);
		
		this.add(bookIdLabel);
		this.add(bookIdTextField);
		
		this.add(addButton);
	}
	
	public AddBookOperationWindow() {
		initializeThisFrame();
		initializeAddBookComponents();
	}
}
