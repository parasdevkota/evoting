package evoting;
import java.sql.*;
import javax.swing.*;
import java.awt.*;

public class Evoting{
	


	public static void main(String args[]){
	JFrame window = new JFrame("Evoting");
	window.setVisible(true);
	window.setSize(400,400);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	LoginDialog ld = new LoginDialog(window);


	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	final String DB_URL = "jdbc:mysql://localhost:3306/?useSSL=false";
	final String USER = "root";
	final String PASS = "";
	Connection conn = null;
	Statement stmt = null;
		try{
			System.out.println("Connecting to database server...");

			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Connection has been made to database.");

			stmt = conn.createStatement();
			//create database and tables if not exists
			stmt.execute("CREATE DATABASE IF NOT EXISTS evoting_db");
			stmt.execute("USE evoting_db");
			stmt.execute("CREATE TABLE IF NOT EXISTS voter(id smallint AUTO_INCREMENT, dob date, name varchar(40), address varchar(50), securityKey char(10), hasVoted boolean, PRIMARY KEY (id))");
			stmt.execute("CREATE TABLE IF NOT EXISTS candidate(id smallint AUTO_INCREMENT, name varchar(40), noOfVotes smallint, symbolPath varchar(50), PRIMARY KEY (id))");
			// stmt.execute("CREATE TABLE IF NOT EXISTS borrows(id smallint(6) AUTO_INCREMENT, borrower_id smallint(6), book_id smallint(6), borrowed_date timestamp, PRIMARY KEY (id))");
			// stmt.execute("CREATE TABLE IF NOT EXISTS settings(id smallint(6) AUTO_INCREMENT, password varchar(20), threshold tinyint(4), overdue_duration tinyint(4), PRIMARY KEY (id))");
		}catch(Exception e){
			System.out.println("ERROR: Error while loading from database.");
			e.printStackTrace();

		}
	}
}