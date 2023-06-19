package Présentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Metier.ProduitMetier;
import Model.Client;
import Model.Produit;


@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProduitMetier pMetier;
    public EditProductServlet() {
        super();
        pMetier = new ProduitMetier();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long code = Long.parseLong(request.getParameter("code"));
		ProduitMetier pMetier = new ProduitMetier();
		HttpSession session = request.getSession();
		session.setAttribute("code", code);
        request.setAttribute("produit", pMetier.findByCode(code));
        RequestDispatcher view = request.getRequestDispatcher("/pages/editProductView.jsp");
        view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Produit p = new Produit();

		HttpSession session = request.getSession();
		Client c = new Client();
		Double price = Double.parseDouble(request.getParameter("prix"));
		p.setNom(request.getParameter("designation"));
        p.setDescription(request.getParameter("description"));
        p.setPrix(Double.parseDouble(request.getParameter("prix")));
        c.setId((Long)session.getAttribute("client"));
        p.setClient(c);
        p.setCode((Long)session.getAttribute("code"));

        request.setAttribute("prods", pMetier.getProds());
        
		pMetier.editProduit(p);
        RequestDispatcher view = request.getRequestDispatcher("/pages/ProduitView.jsp");
        view.forward(request, response);
    }
	

}
