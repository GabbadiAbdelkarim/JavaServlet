package DAO;

import java.util.List;

import Model.Produit;


public interface ProduitDAO {

	public void add(Produit p);
	
	public void edit(Produit p);
	
	public void delete(Long code);
	
	public List<Produit> findAll();
	
	public List<Produit> findByMc(String mcID, String mcNOM, String mcPRIX, Long id);
	
	public Produit findById(Long id);
}
