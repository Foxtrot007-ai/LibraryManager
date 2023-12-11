package LibraryManager;

import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  
import java.sql.*;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel; 

class DataBaseConnector{
	Connection con;
	Statement stmt;
	String dataBaseName;
	public DataBaseConnector(String dataBaseName) {
		this.dataBaseName = dataBaseName;
	}
	
	public void startConnection(String login, String password) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dataBaseName, login, password);  
			stmt = con.createStatement();  
			System.out.println("Connected :)");
		}catch(Exception e){ System.out.println(e);}  
	}
	
	public void addUserQuery(String FirstName, String LastName, String Pesel) {
		String query = "INSERT INTO users (FirstName, LastName, Pesel) VALUES ('"
					+ FirstName + "', '" 
					+ LastName + "', '"
					+ Pesel + "');";
		try{  
			stmt.executeUpdate(query);  
		}catch(Exception e){ System.out.println(e);}  
	}
	
	public void deleteUserQuery(String UserId) {
		String query = "DELETE FROM users WHERE PersonID='" + UserId + "'";
		try{  
			stmt.executeUpdate(query);   
		}catch(Exception e){ System.out.println(e);} 
	}
	
	public void addBookQuery(String BookTitle) {
		String query = "INSERT INTO books (BookTitle) VALUES ('"+ BookTitle +"')";
		try{  
			stmt.executeUpdate(query);   
		}catch(Exception e){ System.out.println(e);}  
	}
	
	public void deleteBookQuery(String BookId) {
		String query = "DELETE FROM books WHERE BookID='" + BookId + "'";
		try{  
			stmt.executeUpdate(query);   
		}catch(Exception e){ System.out.println(e);} 
	}
	
	public void addRentalQuery(String UserId ,String BookId, String Limit) {
		String query = "INSERT INTO rentals (UserID, BookID, RentDate, DayLimit) VALUES ('"
					 + UserId +"', '"
					 + BookId +"', '"
					 + java.time.LocalDate.now().toString() +"', '"
					 + Limit + "')";
		try{  
			stmt.executeUpdate(query);    
		}catch(Exception e){ System.out.println(e);}  
	}
	
	public void deleteRentalQuery(String BookId) {
		String query = "DELETE FROM rentals WHERE BookID='" + BookId + "'";
		try{  
			stmt.executeUpdate(query);    
		}catch(Exception e){ System.out.println(e);} 
	}
	
	public DefaultTableModel showRentalsQuery() {
		String query = "Select * from rentals"; 
		Vector<Vector<String>> resultVector = new Vector<Vector<String>>();
		try{ 
			ResultSet rs = stmt.executeQuery(query);  
			while(rs.next()) {
				Vector<String> temp = new Vector<String>();
				temp.add(rs.getString(1));
				temp.add(rs.getString(2));
				temp.add(rs.getString(3));
				temp.add(rs.getString(4));
				resultVector.add(temp);
			}
		}catch(Exception e){ System.out.println(e);}
		
		DefaultTableModel resultModel = new DefaultTableModel();
		Vector<String> colNames = new Vector<String>();
		colNames.add("UserId");
		colNames.add("BookId");
		colNames.add("Rent Date");
		colNames.add("Limit");
		resultModel.setDataVector(resultVector, colNames);
		return resultModel;
	}
	
	public DefaultTableModel showUsersQuery() {
		String query = "Select * from users";
		Vector<Vector<String>> resultVector = new Vector<Vector<String>>();
		try{ 
			ResultSet rs = stmt.executeQuery(query);  
			while(rs.next()) {
				Vector<String> temp = new Vector<String>();
				temp.add(rs.getString(1));
				temp.add(rs.getString(2));
				temp.add(rs.getString(3));
				temp.add(rs.getString(4));
				resultVector.add(temp);
			}
		}catch(Exception e){ System.out.println(e);}
		
		DefaultTableModel resultModel = new DefaultTableModel();
		Vector<String> colNames = new Vector<String>();
		colNames.add("UserId");
		colNames.add("FirstName");
		colNames.add("LastName");
		colNames.add("Pesel");
		resultModel.setDataVector(resultVector, colNames);
		return resultModel;
	}
	
	public DefaultTableModel showBooksQuery() {
		String query = "Select * from books";
		Vector<Vector<String>> resultVector = new Vector<Vector<String>>();
		try{ 
			ResultSet rs = stmt.executeQuery(query);  
			while(rs.next()) {
				Vector<String> temp = new Vector<String>();
				temp.add(rs.getString(1));
				temp.add(rs.getString(2));
				resultVector.add(temp);
			}
		}catch(Exception e){ System.out.println(e);}
		
		DefaultTableModel resultModel = new DefaultTableModel();
		Vector<String> colNames = new Vector<String>();
		colNames.add("BookId");
		colNames.add("BookTitle");
		resultModel.setDataVector(resultVector, colNames);
		return resultModel;
	}
}  
