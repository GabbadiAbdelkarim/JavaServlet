package Présentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Metier.ProduitMetier;
import Model.Client;
import Model.Produit;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddProductServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Client c = new Client();
		Double price = Double.parseDouble(request.getParameter("prix"));
		System.out.println(price);
		c.setId((Long)session.getAttribute("client"));
		Produit p = new Produit(request.getParameter("designation"),
								request.getParameter("description"),
								price,
								c);
		ProduitMetier pMetier = new ProduitMetier();
		pMetier.addProduct(p);
		System.out.println(p.toString());
		response.sendRedirect("/Devoir/pages/ProduitView.jsp");
	}

}
