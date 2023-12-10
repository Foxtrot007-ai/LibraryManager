package LibraryManager;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class ReturnBookOperationWindow extends JFrame {
	public DataBaseConnector connection;
	//Return book UI
	public JTextField idTextField = new JTextField();
	public JLabel idLabel = new JLabel("Book Id:");
	public JButton returnButton = new JButton("Return Book");
	
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
		this.setSize(400,300);
		this.setVisible(false);
	}
	
	private Action returnAction = new AbstractAction("return book") {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	connection.deleteRentalQuery(idTextField.getText());
	    }
	};
	
	public void initializeReturnBookComponents() {
		idLabel.setBounds(100, 50, 200, 50);
		idTextField.setBounds(100, 100, 200, 50);
		returnButton.setBounds(100, 150, 200, 70);
		returnButton.addActionListener(returnAction);
		this.add(idLabel);
		this.add(idTextField);
		this.add(returnButton);
	}
	
	public ReturnBookOperationWindow(DataBaseConnector connector) {
		this.connection = connector; 
		initializeThisFrame();
		initializeReturnBookComponents();
	}
}
