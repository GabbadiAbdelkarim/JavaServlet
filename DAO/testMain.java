package DAO;


public class testMain {

	public static void main(String[] args) {
		ClientDAO cDAO = new ClientDAOImp();
				
		
		
		System.out.println(cDAO.findById(1L));
		
		
	}

}
