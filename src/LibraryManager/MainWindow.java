package LibraryManager;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.swing.*;  

public class MainWindow {

	
	public JFrame mainFrame = new JFrame();
	public int height = 1000;
	public int width = 1000;
	
	public JMenuBar menuBar = new JMenuBar();
	
	public JMenu viewMenu = new JMenu("View");
	public JMenuItem userMenu = new JMenuItem();
	public JMenuItem bookMenu = new JMenuItem();
	public JMenuItem historyMenu = new JMenuItem();
	
	
	enum ViewTypes{
		user,
		book,
		history
	}
	
	public ViewTypes currentView = ViewTypes.user;
	
	public JPanel views = new JPanel(new CardLayout());
	
	public JPanel userPanel = new JPanel();
	public JPanel bookPanel = new JPanel();
	public JPanel historyPanel = new JPanel();
	
	
	private void UpdatePanels() {
		bookPanel.setVisible(false);
		historyPanel.setVisible(false);
		userPanel.setVisible(false);
		
		switch (currentView) {
		case user:
				userPanel.setVisible(true);
			break;
		case book:
				bookPanel.setVisible(true);
			break;
		case history:
				historyPanel.setVisible(true);
			break;
		default:
			break;
		}
	}
	
	private Action selectUserView = new AbstractAction("Manage users") {
	    @Override
	    public void actionPerformed(ActionEvent e) {
			currentView = ViewTypes.user;
			UpdatePanels();
	    }
	};
	
	private Action selectBookView = new AbstractAction("Manage books") {
	    @Override
	    public void actionPerformed(ActionEvent e) {
			currentView = ViewTypes.book;
			UpdatePanels();
	    }
	};
	
	private Action selectHistoryView = new AbstractAction("Show history") {
	    @Override
	    public void actionPerformed(ActionEvent e) {
			currentView = ViewTypes.history;
			UpdatePanels();
	    }
	};
	
	public MainWindow() {
		userMenu.setAction(selectUserView);
		viewMenu.add(userMenu);
		bookMenu.setAction(selectBookView);
		viewMenu.add(bookMenu);
		historyMenu.setAction(selectHistoryView);
		viewMenu.add(historyMenu);
		
		menuBar.add(viewMenu);
		mainFrame.setJMenuBar(menuBar);
	
		userPanel.setBackground(Color.BLUE);
		bookPanel.setBackground(Color.RED);
		historyPanel.setBackground(Color.GREEN);
		
		views.add(userPanel, "Panel 1");
		views.add(bookPanel, "Panel 2");
		views.add(historyPanel, "Panel 3");
		
		Container pane = mainFrame.getContentPane();
		pane.add(views, BorderLayout.CENTER);
		
		bookPanel.setVisible(false);
		historyPanel.setVisible(false);
		userPanel.setVisible(false);

		mainFrame.setSize(width, height); 
		mainFrame.setVisible(true);
	}
}  

