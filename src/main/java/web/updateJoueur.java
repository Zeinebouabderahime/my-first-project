package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class updateJoueur
 */
@WebServlet("/updateJoueur")
public class updateJoueur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateJoueur() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		if( session.getAttribute("nom")!= null){
			
			String id = request.getParameter("id");
			
			String url = "jdbc:mysql://localhost:3306/projet_dynamique" ;
			String u = "root";
			String p = "";
			
			
			
			String numero = request.getParameter("numer");
			String nom = request.getParameter("nom");
			String post = request.getParameter("post");
			String nationnalite = request.getParameter("nationnalite");
			String salaire = request.getParameter("salaire");
			String idequipe = request.getParameter("idequipe");
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,u,p);
				
				
			
			
			
				PreparedStatement pst = con.prepareStatement("update joueur set numero=? , nom=? , post=? , nationnalite=? , salaire=? , idequipe=? where idequipe=?  ");
				pst.setString(1, numero);
				pst.setString(2, nom);
				pst.setString(3, post);
				pst.setString(4, nationnalite);
				pst.setString(5, salaire);
				pst.setString(6, idequipe);
				pst.executeUpdate(); 
				
				response.sendRedirect("indexe.jsp");
				
				pst.close();
				con.close();
			
				
			
			}
			catch(Exception e) {
				System.out.print(e);
			}
	
	
				
			}
			else{
				response.sendRedirect("auth.jsp");
			}
				
	}
		
}


