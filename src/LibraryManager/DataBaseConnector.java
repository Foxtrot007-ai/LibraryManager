package LibraryManager;

import java.sql.*;
import java.util.List;
import java.util.Vector; 

class DataBaseConnector{
	Connection con;
	Statement stmt;
	public DataBaseConnector(String dataBaseName, String login, String password) {
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
			ResultSet rs = stmt.executeQuery(query);  
		}catch(Exception e){ System.out.println(e);}  
	}
	
	public void deleteUserQuery(String UserId) {
		String query = "DELETE FROM users WHERE PersonID='" + UserId + "'";
		try{  
			ResultSet rs = stmt.executeQuery(query);  
		}catch(Exception e){ System.out.println(e);} 
	}
	
	public void addBookQuery(String BookTitle) {
		String query = "INSERT INTO books (BookTitle) VALUES ('"+ BookTitle +"')";
		try{  
			ResultSet rs = stmt.executeQuery(query);  
		}catch(Exception e){ System.out.println(e);}  
	}
	
	public void deleteBookQuery(String BookId) {
		String query = "DELETE FROM books WHERE BookID='" + BookId + "'";
		try{  
			ResultSet rs = stmt.executeQuery(query);  
		}catch(Exception e){ System.out.println(e);} 
	}
	
	public void addRentalQuery(String UserId ,String BookId) {
		String query = "INSERT INTO rentals (UserID, BookID, RentDate, DayLimit) VALUES ('"
					 + UserId +"'"
					 + BookId +"'2001-07-14', '14')";
		try{  
			ResultSet rs = stmt.executeQuery(query);  
		}catch(Exception e){ System.out.println(e);}  
	}
	
	public void deleteRentalQuery(String BookId) {
		String query = "DELETE FROM rentals WHERE BookID='" + BookId + "'";
		try{  
			ResultSet rs = stmt.executeQuery(query);  
		}catch(Exception e){ System.out.println(e);} 
	}
	
	public Vector<Vector<String>> showRentalsQuery() {
		String query = "Select * from rentals";
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		try{ 
			ResultSet rs = stmt.executeQuery(query);  
			while(rs.next()) {
				Vector<String> temp = new Vector<String>();
				temp.add(rs.getString(1));
				temp.add(rs.getString(2));
				temp.add(rs.getString(3));
				temp.add(rs.getString(4));
				result.add(temp);
			}
		}catch(Exception e){ System.out.println(e);}
		return result;
	}
	
	public Vector<Vector<String>> showUsersQuery() {
		String query = "Select * from users";
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		try{ 
			ResultSet rs = stmt.executeQuery(query);  
			while(rs.next()) {
				Vector<String> temp = new Vector<String>();
				temp.add(rs.getString(1));
				temp.add(rs.getString(2));
				temp.add(rs.getString(3));
				temp.add(rs.getString(4));
				result.add(temp);
			}
		}catch(Exception e){ System.out.println(e);}
		return result;
	}
	
	public Vector<Vector<String>> showBooksQuery() {
		String query = "Select * from books";
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		try{ 
			ResultSet rs = stmt.executeQuery(query);  
			while(rs.next()) {
				Vector<String> temp = new Vector<String>();
				temp.add(rs.getString(1));
				temp.add(rs.getString(2));
				result.add(temp);
			}
		}catch(Exception e){ System.out.println(e);}
		return result;
	}
}  
