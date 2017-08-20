import java.sql.*;

class Evoting{
	static final String JDBC_DRIVER
	static final String DB_URL
	static Connection conn;
	static Statement stmt;

	public static void main(String args[]){
		try{
			Class.forName();
			conn = DriverManager.openConnection();
			
			stmt
			String sql
			int r_affected = stmt.updateQuery(sql);
		}
	}

	public static void add_candidate(String name){
		try{
			stmt.executeQuery("");
		}
		catch(SQLException se){
			System.out.println("Error. Can't add candidates.");
		}

	}


//added a new comment just to see a few changes in the git collaboration, by parash
}