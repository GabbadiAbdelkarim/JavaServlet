package DAO;

import java.util.List;


import Model.Client;

public interface ClientDAO {

	public void add(Client c);
	
	public Client edit(Client c);
	
	public void delete(Long id);
	
	public List<Client> findAll();
	
	public Client findById(Long id);
	
	public Client seConnecter(String email, String password);
	
}
