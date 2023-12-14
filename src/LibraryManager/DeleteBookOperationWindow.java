package LibraryManager;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class DeleteBookOperationWindow extends JFrame{
	public DataBaseConnectorProxy connection;
	//delete book UI
	public JTextField idTextField = new JTextField();
	public JLabel idLabel = new JLabel("Book Id:");
	public JButton deleteButton = new JButton("Delete Book");
	
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
	private Action deleteBookAction = new AbstractAction("delete book") {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	connection.deleteBookQuery(idTextField.getText());
	    }
	};
	public void initializeDeleteBookComponents() {
		idLabel.setBounds(100, 50, 200, 50);
		idTextField.setBounds(100, 100, 200, 50);
		deleteButton.setBounds(100, 150, 200, 70);
		deleteButton.addActionListener(deleteBookAction);
		this.add(idLabel);
		this.add(idTextField);
		this.add(deleteButton);
	}
	
	public DeleteBookOperationWindow(DataBaseConnectorProxy connector) {
		this.connection = connector; 
		initializeThisFrame();
		initializeDeleteBookComponents();
	}
}