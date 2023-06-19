package Metier;


import DAO.ClientDAO;
import DAO.ClientDAOImp;
import Model.Client;

public class ClientMetier {
	private ClientDAO clientdao = new ClientDAOImp();

	public Client seConnecter(String email, String password){	
			return clientdao.seConnecter(email, password);
	}

}
