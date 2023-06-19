package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BaseDAO {
	@Resource(name = "jdbc/commerce")
	private static DataSource dataSource;
	/*static{
	    try {
	    	Context initContext = new InitialContext();
	    	Context envContext = (Context)initContext.lookup("java:comp/env");
	        dataSource = (DataSource) envContext.lookup("jdbc/commerce");
	    } catch (NamingException e) {
	        throw new IllegalStateException("missing in JNDI!  ", e);
	    }
	}*/

	private static Connection con;
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/commerce","root","");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getCon() {
		return con;
	}
	/*
	
	public static Connection getCon() {
		//return con;
	   try {
			return con =dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}*/
}
