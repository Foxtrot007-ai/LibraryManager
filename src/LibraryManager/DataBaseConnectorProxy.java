package LibraryManager;

import java.sql.DriverManager;

public class DataBaseConnectorProxy extends DataBaseConnector {
	
	public void updateChangeHistory(String operationName, String data) {
		String query = "INSERT INTO history (actionName, actionVariables, dateOfChange) VALUES ('"
				+ operationName + "', '" 
				+ data + "', '"
				+ java.time.LocalDate.now().toString() + "');";
		try{  
			stmt.executeUpdate(query);  
		}catch(Exception e){ 
			new ErrorSqlWindow(e);
		} 
	}
	
	@Override
	public void addUserQuery(String FirstName, String LastName, String Pesel){
		try {
			super.addUserQuery(FirstName, LastName, Pesel);
			String data = "FirstName=" + FirstName + ",LastName=" + LastName + ",Pesel=" + Pesel;
			this.updateChangeHistory("addUserQuery", data);
		}catch(Exception e) {System.out.println(e);}
	}
	
	@Override
	public void deleteUserQuery(String UserId){ 
		try {
			super.deleteUserQuery(UserId);
			String data = "UserId=" + UserId;
			this.updateChangeHistory("deleteUserQuery", data);
		}catch(Exception e) {System.out.println(e);}
	}
	
	@Override
	public void addBookQuery(String BookTitle){
		try {
			super.addBookQuery(BookTitle);
			String data = "BookTitle=" + BookTitle;
			this.updateChangeHistory("addBookQuery", data);
		}catch(Exception e) {System.out.println(e);}
	}
	
	@Override
	public void deleteBookQuery(String BookId){ 
		try {
			super.deleteBookQuery(BookId);
			String data = "BookId=" + BookId;
			this.updateChangeHistory("deleteBookQuery", data);
		}catch(Exception e) {System.out.println(e);}
	}
	
	@Override
	public void addRentalQuery(String UserId ,String BookId, String Limit){
		try {
			super.addRentalQuery(UserId, BookId, Limit);
			String data = "UserId=" + UserId + ",BookId=" + BookId + ",Limit=" + Limit;
			this.updateChangeHistory("addRentalQuery", data);
		}catch(Exception e) {System.out.println(e);}
	}
	
	@Override
	public void deleteRentalQuery(String BookId){
		try {
			super.deleteRentalQuery(BookId);
			String data = "BookId=" + BookId;
			this.updateChangeHistory("deleteRentalQuery", data);
		}catch(Exception e) {System.out.println(e);}
	}
	
	
	
	public DataBaseConnectorProxy(String dataBaseName) {
		super(dataBaseName);
	}

}
