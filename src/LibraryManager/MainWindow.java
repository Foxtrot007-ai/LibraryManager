package LibraryManager;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;  

public class MainWindow extends JFrame{
	//this frame
	public int height = 1080;
	public int width = 1920;
	
	//button
	public int buttonHeight = 100;
	public int buttonWidth = 200;
	public int buttonStartY = 100;
	public int buttonStartX = 300;
	public int buttonIncreaseY = 100;
	public int buttonIncreaseX = 0;
	
	public JButton addUserOperationButton = new JButton("Add User");
	public JButton addBookOperationButton = new JButton("Add Book");
	public JButton deleteUserOperationButton = new JButton("Delete User");
	public JButton deleteBookOperationButton = new JButton("Delete Book");
	
	public JButton historyListShowButton = new JButton("Show Change History");
	public JButton userListShowButton = new JButton("Show Users");	
	public JButton bookListShowButton = new JButton("Show Books");	
	
	//operation window frames
	public JFrame addUserOperationWindow = new AddUserOperationWindow();
	public JFrame addBookOperationWindow = new AddBookOperationWindow();
	public JFrame deleteUserOperationWindow = new DeleteUserOperationWindow();
	public JFrame deleteBookOperationWindow = new DeleteBookOperationWindow();
	
	//list
	public int listHeight = 1080;
	public int listWidth = 800;
	public int listY = 10;
	public int listX = 800;
	
	public JList listToShow = new JList();
	public JScrollPane listScroller = new JScrollPane(listToShow);
	public String[] testUserList = {"Adam Nowak", "Dawid Nowak", "Norbert Nowak"};
	public String[] testBookList = {"Lord of the rings", "Hobbit", "Simimarilion"};
	public String[] testHistoryList = {"User added", "User deleted", "Book added"};
	
	//action for buttons
	private Action showAddUserOperationWindow = new AbstractAction("Add User") {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	addUserOperationWindow.setVisible(true);
	    }
	};
	
	private Action showAddBookOperationWindow = new AbstractAction("Add Book") {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	addBookOperationWindow.setVisible(true);
	    }
	};
	
	private Action showDeleteUserOperationWindow = new AbstractAction("Delete User") {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	deleteUserOperationWindow.setVisible(true);
	    }
	};
	
	private Action showDeleteBookOperationWindow = new AbstractAction("Delete Book") {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	deleteBookOperationWindow.setVisible(true);
	    }
	};
	
	private Action buttonSomething = new AbstractAction("Do something") {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	System.out.println("do something pls");
	    }
	};
	
	private Action loadChangeHistoryList = new AbstractAction("Load Change History") {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	listToShow.setListData(testHistoryList);
	    }
	};
	
	private Action loadBookList = new AbstractAction("Load Books") {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	listToShow.setListData(testBookList);
	    }
	};
	
	private Action loadUserList = new AbstractAction("Load Users") {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	listToShow.setListData(testUserList);
	    }
	};
	
	//functions
	public int buttonY(int position) {
		return buttonStartY + buttonIncreaseY * position;
	}
	
	public int buttonX(int position) {
		return buttonStartX + buttonIncreaseX * position;
	}
	
	public void initializeButtons() {
		//set their positions
		addUserOperationButton.setBounds(buttonX(0), buttonY(0), buttonWidth, buttonHeight);
		deleteUserOperationButton.setBounds(buttonX(0), buttonY(1), buttonWidth, buttonHeight);
		addBookOperationButton.setBounds(buttonX(0), buttonY(2), buttonWidth, buttonHeight);
		deleteBookOperationButton.setBounds(buttonX(0), buttonY(3), buttonWidth, buttonHeight);
		
		historyListShowButton.setBounds(buttonX(0), buttonY(5), buttonWidth, buttonHeight);
		userListShowButton.setBounds(buttonX(0), buttonY(6), buttonWidth, buttonHeight);
		bookListShowButton.setBounds(buttonX(0), buttonY(7), buttonWidth, buttonHeight);
		//set their actions
		addUserOperationButton.addActionListener(showAddUserOperationWindow);
		deleteUserOperationButton.addActionListener(showDeleteUserOperationWindow);
		addBookOperationButton.addActionListener(showAddBookOperationWindow);
		deleteBookOperationButton.addActionListener(showDeleteBookOperationWindow);
		
		historyListShowButton.addActionListener(loadChangeHistoryList);
		userListShowButton.addActionListener(loadUserList);
		bookListShowButton.addActionListener(loadBookList);
	}
	
	public void initializeList() {
		listToShow.setBounds(listX, listY, listWidth, listHeight);
		listScroller.setBounds(listX, listY, listWidth, listHeight);
		listToShow.setListData(testUserList);
	}
	
	public void addAllToFrame() {
		this.add(addUserOperationButton);
		this.add(deleteUserOperationButton);
		this.add(addBookOperationButton);
		this.add(deleteBookOperationButton);
		
		this.add(historyListShowButton);
		this.add(userListShowButton);
		this.add(bookListShowButton);
		
		this.add(listToShow);
		this.add(listScroller);
	}
	
	public MainWindow() {
		initializeButtons();
		initializeList();
		addAllToFrame();
		this.setLayout(null);
		this.setSize(width, height); 
		this.setVisible(true);
	}
}  

