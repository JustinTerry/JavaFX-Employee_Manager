package employee_Manager;
import java.sql.*;

public class Database {

	Connection dBConn;

	public void openDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			dBConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/store?autoReconnect=true&useSSL=false",
					"root", "password");
			System.out.println("DB is open");
		} catch (Exception exc) {
			exc.printStackTrace();
		}

	} 

	public boolean insertEmp(String first, String last, String street, String city, String state, String zip, String email,
			String social, String pin, String phone, String dob, boolean admin) {
		int nextID;
		
		try {
			openDB();
			PreparedStatement myStmt = dBConn.prepareStatement(
					" INSERT INTO employees(employeeID, employeeFirstName, employeeLastName, employeeStreetAddress, employeeCity, employeeState, employeeZipCode, employeeEmail, employeeSocial, employeePin, employeePhone, employeeDOB, employeeIsAdmin)"
							+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			ResultSet myRs = myStmt.executeQuery(" SELECT MAX(employeeID) AS highestID FROM store.employees;");
			if(myRs.next()) {
				nextID = myRs.getInt(1)+1;
				}else {
					nextID = 1;
				}

			myStmt.setInt(1, nextID);
			myStmt.setString(2, first);
			myStmt.setString(3, last);
			myStmt.setString(4, street);
			myStmt.setString(5, city);
			myStmt.setString(6, state);
			myStmt.setString(7, zip);
			myStmt.setString(8, email);
			myStmt.setString(9, social);
			myStmt.setString(10, pin);
			myStmt.setString(11, phone);
			myStmt.setString(12, dob);
			myStmt.setBoolean(13, admin);
			

			try {
				myStmt.execute();
				System.out.println("Added to DB");
				return true;
			} catch (SQLException e) {
				if (e.getErrorCode() == 1062) {
					System.out.println("ID already in use");
					return false;
				} else {
					e.printStackTrace();
					return false;
				}
			}

		} catch (Exception exc) {
			exc.printStackTrace();
			return false;
		}
	}
}
