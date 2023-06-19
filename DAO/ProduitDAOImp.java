package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Client;
import Model.Produit;

public class ProduitDAOImp implements ProduitDAO {

	@Override
	public void add(Produit p) {
		System.out.println("DAO produit : "+ p.toString());
		System.out.println("DAO id : "+p.getClient().getId());
		try {
			Connection con = BaseDAO.getCon();
			Statement st = con.createStatement();
			st.executeUpdate("insert into produit (nom,description, prix, client) values ('"+p.getNom()+"','"+p.getDescription()+"','"+p.getPrix()+"','"+p.getClient().getId()+"')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(Produit p) {
		System.out.println(p.toString());
		Connection co = BaseDAO.getCon();
        try {
            PreparedStatement preparedStatement = co
                    .prepareStatement("update produit set nom=?, description=?, prix=?, client=?" +
                            "where code=?");
            preparedStatement.setString(1, p.getNom());
            preparedStatement.setString(2, p.getDescription());
            preparedStatement.setDouble(3, p.getPrix());
            preparedStatement.setString(4, String.valueOf(p.getClient().getId()));
            preparedStatement.setLong(5, p.getCode());
            preparedStatement.executeUpdate();
            System.out.println(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	@Override
	public void delete(Long code) {
		Connection co = BaseDAO.getCon();
        try {
            PreparedStatement preparedStatement = co
                    .prepareStatement("delete from produit where code=?");
            preparedStatement.setLong(1, code);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public List<Produit> findAll() {
		
		return null;
	}

	@Override
	public Produit findById(Long id) {
		Connection con = BaseDAO.getCon();
	        Produit prod = new Produit();
	        Client c = new Client();
	        try {
	            PreparedStatement preparedStatement = con.
	                    prepareStatement("select * from produit where code=?");
	            preparedStatement.setLong(1, id);
	            ResultSet rs = preparedStatement.executeQuery();

	            if (rs.next()) {
	            	prod.setCode(rs.getLong("code"));
	            	prod.setNom(rs.getString("nom"));
	            	prod.setDescription(rs.getString("description"));
	            	prod.setPrix(rs.getDouble("prix"));
	            	c.setId(rs.getLong("client"));
	            	prod.setClient(c);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return prod;
	    }

	@Override
	public List<Produit> findByMc(String mcID, String mcNOM, String mcPRIX, Long id) {
		List<Produit> pds = new ArrayList<Produit>();
		Connection co = BaseDAO.getCon();
		System.out.println(id);
		System.out.println(mcID);
		System.out.println(mcNOM);
		System.out.println(mcPRIX);
		try {
			PreparedStatement ps = co.prepareStatement("select * from produit where code like ? and nom like ? and prix like ? and client = ?");
			ps.setString(1, "%"+mcID+"%");
			ps.setString(2, "%"+mcNOM+"%");
			ps.setString(3, "%"+mcPRIX+"%");
			ps.setLong(4, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Produit p = new Produit();
				p.setCode(rs.getLong("code"));
				p.setNom(rs.getString("nom"));
				p.setDescription(rs.getString("description"));
				p.setPrix(rs.getDouble("prix"));
				pds.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return pds;
	}

}
