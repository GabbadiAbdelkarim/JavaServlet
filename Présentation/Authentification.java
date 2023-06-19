package Présentation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import DAO.ClientDAO;
import DAO.ClientDAOImp;
import Metier.ClientMetier;
import Model.Client;

/**
 * Servlet implementation class Authentification
 */
@WebServlet("/Authentification")
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ClientDAO cDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authentification() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(){
    	cDAO = new ClientDAOImp();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ClientMetier clMetier = new ClientMetier();	
		
		HttpSession session = request.getSession();
			
		if(clMetier.seConnecter(request.getParameter("email"), request.getParameter("mdp")) != null){
			Client c = clMetier.seConnecter(request.getParameter("email"), request.getParameter("mdp"));
			session.setAttribute("client", c.getId());
			response.sendRedirect("ProduitView.jsp");
		} else {
			System.out.print("Echec de connexion");
			response.sendRedirect("LoginView.jsp");
			response.setContentType("text/html");
			session.setAttribute("msg", "Login ou mot de passe incorrecte !");
		}
		
	}
	
}
