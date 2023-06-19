package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import Model.Client;

public class ClientDAOImp implements ClientDAO {

	//@Resource(name="jdbc/dbmy")
	//private DataSource ds;
	@Override
	public void add(Client c) {

	}

	@Override
	public Client edit(Client c) {

		return null;
	}

	@Override
	public void delete(Long id) {

	}

	@Override
	public List<Client> findAll() {
		  
		
		return null;
	}
	public Client LoginClient(Client c){
		Client client = new Client();
		try{
			System.out.println("3.1");
		     Connection conn = BaseDAO.getCon();
		     java.sql.Statement s=conn.createStatement();

		 	 ResultSet rs =s.executeQuery("select * from client where email='"+c.getEmail()+"' and password='"+c.getPassword()+"'");
		     rs.next();
		     System.out.println("3");
		     if(rs.getString("email")!=null){
		    	 client= new Client(rs.getLong("id"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"));		     	
		    	 System.out.println("4");
		    	 return client;
		     }
		     else
		    	 return null;
		}
		 catch(SQLException e)
		 {
		    e.printStackTrace(); 
			return null;      
		 }
		
	}
	@Override
	public Client findById(Long id) {

		return null;
	}

	@Override
	public Client seConnecter(String email, String password) {
		Client client;
		try {
			Connection conn = BaseDAO.getCon();
			Statement s=conn.createStatement();

		 	 ResultSet rs =s.executeQuery("select * from client where email='"+email+"' and password='"+password+"'");
		     rs.next();
		     
			return new Client(rs.getLong("id"), rs.getString("prenom"), rs.getString("nom"), rs.getString("email"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
