package Présentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import DAO.ProduitDAO;
import DAO.ProduitDAOImp;
import Metier.ProduitMetier;
import Model.Produit;

/**
 * Servlet implementation class ProduitServlet
 */
@WebServlet("/ProduitServlet")
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProduitDAO pDAO;
    public ProduitServlet() {
        super();
    }
	public void init() throws ServletException{
		pDAO = new ProduitDAOImp();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
//		
		/*
		ProduitMetier pMetier = new ProduitMetier();
		HttpSession session=request.getSession();
		Long id =(Long)session.getAttribute("client");
		String mcID = (String) session.getAttribute("id");
		String mcNOM =(String) session.getAttribute("nom");
		String mcPRIX =(String) session.getAttribute("prix");
		List<Produit> prodList = pDAO.findByMc(mcID, mcNOM, mcPRIX, id);
		pMetier.setProds(prodList);
		request.setAttribute("metier", pMetier);
		
		request.getRequestDispatcher("/pages/ProduitView.jsp").forward(request, response);
		*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mcID = request.getParameter("mcID");
		String mcNOM = request.getParameter("mcNOM");
		String mcPRIX = request.getParameter("mcPRIX");
		
		ProduitMetier pMetier = new ProduitMetier();
		HttpSession session=request.getSession();
		Long id =(Long)session.getAttribute("client");
		/*HttpSession sessionR=request.getSession();
		sessionR.setAttribute("id", mcID);
		sessionR.setAttribute("nom", mcNOM);
		sessionR.setAttribute("prix", mcPRIX);*/
		List<Produit> prodList = pDAO.findByMc(mcID, mcNOM, mcPRIX, id);
		pMetier.setProds(prodList);
		request.setAttribute("metier", pMetier);
		
		request.getRequestDispatcher("/pages/ProduitView.jsp").forward(request, response);
	}

}
