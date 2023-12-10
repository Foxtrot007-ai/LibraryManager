package LibraryManager;

public class LibraryApplication {
	MainWindow mainWindow;
	DataBaseConnector dataBase;
	public LibraryApplication(){
		dataBase = new DataBaseConnector("librarydatabase","root","root");
		mainWindow = new MainWindow(dataBase);
	}
}
