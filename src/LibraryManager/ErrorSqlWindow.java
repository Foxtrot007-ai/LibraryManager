package LibraryManager;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class ErrorSqlWindow extends JFrame {
	public JLabel idLabel = new JLabel();
	public JButton exitButton = new JButton("OK");
	public Exception exceptionInfo;
	
	public void initializeThisFrame() {
		this.setLayout(null);
		this.setSize(400, 400);
		this.setVisible(true);
	}
	
	public void exitThisWindow() {
		this.dispose();
	}
	
	private Action exitAction = new AbstractAction("exit window") {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	exitThisWindow();
	    }
	};
	
	public void initializeComponents() {
		idLabel.setBounds(100, 50, 200, 200);
		idLabel.setText("<html>"+ exceptionInfo.getMessage() +"</html>");
		exitButton.setBounds(100, 250, 200, 70);
		exitButton.addActionListener(exitAction);
		this.add(idLabel);
		this.add(exitButton);
	}
	
	public ErrorSqlWindow(Exception e) { 
		exceptionInfo = e;
		initializeThisFrame();
		initializeComponents();
	}
}

