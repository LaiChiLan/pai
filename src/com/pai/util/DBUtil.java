package com.pai.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {

  public static Connection getConnection() throws Exception{	
	  Connection conn = null;
	   	String url="jdbc:mysql://219.137.165.219:3306/paimai";
	   	String userName = "dio";
	   	String userPass = "lizhinan163";
	    	try {
	    	Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,userName,userPass); 
			System.out.println("	���ӳɹ�	"); 
	    	} catch (Exception e) {
	    		e.printStackTrace(); 
	    		throw e;
	    	}      	 
	    	return conn;
		  
  }
  
  public static void close(Connection conn) throws Exception {
	  if(conn!= null){
		  try{
			  conn.close();	
			  System.out.println("	�ر�����	"); 
		  }catch(SQLException e){
			  e.printStackTrace(); 
			  throw e;
		  }
		  
	  }  
  }
}
