package Jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.DriverManager;

public class DbConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplilearm", "root", "root");
		
		Statement stmt = con.createStatement();
		
		// for insert, update, delete user executeUpdate
		stmt.executeUpdate("Insert into Customer (name,email,phone) values ( 'Vasu ','vasu@example.c','8880985888')");
		
		// for select/read use executeQuery
		ResultSet result = stmt.executeQuery("select * from customer;");
	
		
		while(result.next()) {
			//System.out.println("Customer Id " + result.getInt("cid"));
			System.out.println("Customer name " + result.getString("name"));
			
		}
		
		//C = Create
		//R = Read
		//U = Update
		//D = Delete


	}
}
