package LibraryManager;

public class LibraryApplication {
	MainWindow mainWindow;
	LoginWindow loginWindow;
	DataBaseConnector dataBase;
	public LibraryApplication(){
		dataBase = new DataBaseConnector("librarydatabase");
		loginWindow = new LoginWindow(dataBase);
		mainWindow = new MainWindow(dataBase);
	}
}
