package LibraryManager;

public class LibraryApplication {
	MainWindow mainWindow;
	LoginWindow loginWindow;
	DataBaseConnectorProxy dataBase;
	public LibraryApplication(){
		dataBase = new DataBaseConnectorProxy("librarydatabase");
		loginWindow = new LoginWindow(dataBase);
		mainWindow = new MainWindow(dataBase);
	}
}
