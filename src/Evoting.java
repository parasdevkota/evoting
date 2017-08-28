package evoting;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Evoting{
	static Connection conn = null;
	static Statement stmt = null;
	static JFrame window;
	public static void main(String args[]){
		JLabel user_label;
	  	JTextField user;
	  	JLabel pass_label;
	  	JPasswordField pass;
	  	JButton btn;
	  	ResultSet rs;
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		final String DB_URL = "jdbc:mysql://localhost:3306/?useSSL=false";
		final String USER = "root";
		final String PASS = "";
		

		user_label = new JLabel("Username:");
	    pass_label = new JLabel("Password:");
	    user = new JTextField(25);
	    pass = new JPasswordField(25);
	    btn = new JButton("Login");
		window = new JFrame("Evoting");
		window.setVisible(true);
		window.setLayout(new FlowLayout());
		window.setSize(400,250);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(user_label);
	    window.add(user);
	    window.add(pass_label);
	    window.add(pass);
	    window.add(btn);

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
			stmt.execute("CREATE TABLE IF NOT EXISTS admin(id smallint AUTO_INCREMENT, username varchar(40), password varchar(20), PRIMARY KEY (id))");
		}catch(Exception e){
			System.out.println("ERROR: Error while loading from database.");
			e.printStackTrace();
		}
	    btn.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent ae){
	    		try{

	    			ResultSet rs = stmt.executeQuery("SELECT * from admin");
	    			boolean sucess = false;
		    		while(rs.next()){
		    			if(rs.getString("username").equals(user.getText()) && rs.getString("password").equals(pass.getText())){
		    				JOptionPane.showMessageDialog(window, "Login Sucessful", "Success", JOptionPane.INFORMATION_MESSAGE);
		    				sucess = true;

		    			}
		    		}
		    		if(!sucess){
		    			JOptionPane.showMessageDialog(window, "Username and password do not match", "Login Failed", JOptionPane.ERROR_MESSAGE);

		    		}
	    		}
	    		catch(Exception e){

	    		}
	    	}
	    });
	}
	
}