package LibraryManager;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;  

public class MainWindow extends JFrame{
	//data base
	public DataBaseConnector connector;
	
	//this frame
	public int height = 1080;
	public int width = 1920;
	
	//button
	public int buttonHeight = 100;
	public int buttonWidth = 200;
	public int buttonStartY = 100;
	public int buttonStartX = 200;
	public int buttonIncreaseY = 100;
	public int buttonIncreaseX = 200;
	
	public JButton addUserOperationButton = new JButton("Add User");
	public JButton addBookOperationButton = new JButton("Add Book");
	public JButton deleteUserOperationButton = new JButton("Delete User");
	public JButton deleteBookOperationButton = new JButton("Delete Book");
	
	public JButton rentBookOperationButton = new JButton("Rent Book");
	public JButton returnBookOperationButton = new JButton("Return Book");
	
	public JButton historyListShowButton = new JButton("Show Change History");
	public JButton userListShowButton = new JButton("Show Users");	
	public JButton bookListShowButton = new JButton("Show Books");	
	public JButton rentListShowButton = new JButton("Show Rentals");	
	
	//operation window frames
	public JFrame addUserOperationWindow;
	public JFrame addBookOperationWindow;
	public JFrame deleteUserOperationWindow;
	public JFrame deleteBookOperationWindow;
	
	public JFrame rentBookOperationWindow;
	public JFrame returnBookOperationWindow;
	
	//list
	public int listHeight = 1000;
	public int listWidth = 1000;
	public int listY = 10;
	public int listX = 800;
	
	public JTable tableToShow = new JTable();
	public JScrollPane listScroller = new JScrollPane(tableToShow);
	public String[] testUserList = {"Adam Nowak", "Dawid Nowak", "Norbert Nowak"};
	public String[] testBookList = {"Lord of the rings", "Hobbit", "Simimarilion"};
	public String[] testHistoryList = {"User added", "User deleted", "Book added"};
	public String[] testRentList = {"1 1", "2 3", "3 2"};
	
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
	
	private Action showRentBookOperationWindow = new AbstractAction("Rent Book") {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	rentBookOperationWindow.setVisible(true);
	    }
	};
	
	private Action showReturnBookOperationWindow = new AbstractAction("Return Book") {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	returnBookOperationWindow.setVisible(true);
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
	    }
	};
	
	private Action loadBookList = new AbstractAction("Load Books") {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	DefaultTableModel resultModel = connector.showBooksQuery();
	    	tableToShow.setModel(resultModel);
	    	tableToShow.repaint();
	    }
	};
	
	private Action loadUserList = new AbstractAction("Load Users") {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	DefaultTableModel resultModel = connector.showUsersQuery();
	    	tableToShow.setModel(resultModel);
	    	tableToShow.repaint();
	    }
	};
	
	private Action loadRentList = new AbstractAction("Show Rentals") {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	DefaultTableModel resultModel = connector.showRentalsQuery();
	    	tableToShow.setModel(resultModel);
	    	tableToShow.repaint();
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
		addBookOperationButton.setBounds(buttonX(1), buttonY(0), buttonWidth, buttonHeight);
		deleteBookOperationButton.setBounds(buttonX(1), buttonY(1), buttonWidth, buttonHeight);
		
		rentBookOperationButton.setBounds(buttonX(0), buttonY(2), buttonWidth, buttonHeight);
		returnBookOperationButton.setBounds(buttonX(1), buttonY(2), buttonWidth, buttonHeight);
		
		historyListShowButton.setBounds(buttonX(0), buttonY(5), buttonWidth, buttonHeight);
		userListShowButton.setBounds(buttonX(1), buttonY(5), buttonWidth, buttonHeight);
		bookListShowButton.setBounds(buttonX(1), buttonY(6), buttonWidth, buttonHeight);
		rentListShowButton.setBounds(buttonX(0), buttonY(6), buttonWidth, buttonHeight);
		
		//set their actions
		addUserOperationButton.addActionListener(showAddUserOperationWindow);
		deleteUserOperationButton.addActionListener(showDeleteUserOperationWindow);
		addBookOperationButton.addActionListener(showAddBookOperationWindow);
		deleteBookOperationButton.addActionListener(showDeleteBookOperationWindow);
		
		rentBookOperationButton.addActionListener(showRentBookOperationWindow);
		returnBookOperationButton.addActionListener(showReturnBookOperationWindow);
		
		historyListShowButton.addActionListener(loadChangeHistoryList);
		userListShowButton.addActionListener(loadUserList);
		bookListShowButton.addActionListener(loadBookList);
		rentListShowButton.addActionListener(loadRentList);
	}
	
	public void initializeList() {
		tableToShow.setBounds(listX, listY, listWidth, listHeight);
		listScroller.setBounds(listX, listY, listWidth, listHeight);
	}
	
	public void addAllToFrame() {
		this.add(addUserOperationButton);
		this.add(deleteUserOperationButton);
		this.add(addBookOperationButton);
		this.add(deleteBookOperationButton);
		
		this.add(rentBookOperationButton);
		this.add(returnBookOperationButton);
		
		this.add(historyListShowButton);
		this.add(userListShowButton);
		this.add(bookListShowButton);
		this.add(rentListShowButton);
		
		//this.add(tableToShow);
		this.add(listScroller);
	}
	
	public MainWindow(DataBaseConnector connector) {
		this.connector = connector;
		addUserOperationWindow = new AddUserOperationWindow(connector);
		addBookOperationWindow = new AddBookOperationWindow(connector);
		deleteUserOperationWindow = new DeleteUserOperationWindow(connector);
		deleteBookOperationWindow = new DeleteBookOperationWindow(connector);
		
		rentBookOperationWindow = new RentBookOperationWindow(connector);
		returnBookOperationWindow = new ReturnBookOperationWindow(connector);
		
		initializeButtons();
		initializeList();
		addAllToFrame();
		this.setLayout(null);
		this.setSize(width, height); 
		this.setVisible(true);
	}
}  

