package edu.easylearning.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	
	public static Connection connect(){
		
		Connection con = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost/education","root","root");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return con;
	}

}

		
	


