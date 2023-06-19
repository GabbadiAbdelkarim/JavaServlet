package Metier;
import java.util.ArrayList;
import java.util.List;

import DAO.ProduitDAO;
import DAO.ProduitDAOImp;
import Model.Produit;
public class ProduitMetier {

	private List<Produit> prods = new ArrayList<Produit>();
	public String message="";

	
	public List<Produit> getProds() {
		return prods;
	}
	public void setProds(List<Produit> prods) {
		this.prods = prods;
	}
	
	public void addProduct(Produit p){
		System.out.println("Metier produit : "+p.toString());
		ProduitDAO pDAO = new ProduitDAOImp();
		if(p.getNom()!="" && p.getDescription()!="" && String.valueOf(p.getPrix())!="")
		{
			if(p.getPrix()<=10000.0){
				if(p.getPrix()>=8000.0)
					p.setPrix(p.getPrix()*0.75);
				
				pDAO.add(p);
			}
			else if(p.getNom().length()<=3 )
			{
				message="Veuillez saisir une désignation correcte!";
				System.out.println(message);
				}
			else
			{
				message="Le prix est trop élevé !";
				System.out.println(message);
			}
		}
		else
		{
			message="Veuillez remplir tous les champs!";
			System.out.println(message);
		}
			
	}
	
	public void deleteProduit(Long code){
		ProduitDAO pDAO = new ProduitDAOImp();
		if(String.valueOf(code)!="")
			pDAO.delete(code);
	}
	public Produit findByCode(Long code){
		Produit p = new Produit();
		ProduitDAO pDAO = new ProduitDAOImp();
		if(String.valueOf(code)!="")
			p =  pDAO.findById(code);
		return p;
	}
	
	public void editProduit(Produit p){
		ProduitDAO pDAO = new ProduitDAOImp();
		if(p.getNom()!="" && p.getDescription()!="" && String.valueOf(p.getPrix())!="")
		{
			if(p.getPrix()<=10000.0){
				if(p.getPrix()>=8000.0)
					p.setPrix(p.getPrix()*0.75);
				
				pDAO.edit(p);
			}
			else if(p.getNom().length()<=3 )
			{
				message="Veuillez saisir une désignation correcte!";
				System.out.println(message);
				}
			else
			{
				message="Le prix est trop élevé !";
				System.out.println(message);
			}
		}
		else
		{
			message="Veuillez remplir tous les champs!";
			System.out.println(message);
		}
		
	}
}
