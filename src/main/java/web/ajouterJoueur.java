package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ajouterJoueur
 */
@WebServlet("/ajouterJoueur")
public class ajouterJoueur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajouterJoueur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String Numero = request.getParameter("Numero");
		String Nom = request.getParameter("Nom");
		String Post = request.getParameter("Post");
		String Nationnalite = request.getParameter("Nationnalite");
		String Salire = request.getParameter("Salire");
		String IdEquipe = request.getParameter("IdEquipe");
		
		String url = "jdbc:mysql://localhost:3306/dynamique" ;
		String u = "root";
		String p = "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,u,p);
			
			PreparedStatement pst = con.prepareStatement("insert into joueur (numero,Nom,Post,Nationnalite,Salire,IdEquipe) values(?,?,?,?,?,?)");
			
			pst.setString(1, Numero);
			pst.setString(2, Nom);
			pst.setString(3, Post);
			pst.setString(4, Nationnalite);
			pst.setString(5, Salire);
			pst.setString(6, IdEquipe);
			ResultSet r = pst.executeQuery(); 
			
			if(r.next()) {
				request.getRequestDispatcher("index.jsp");
			}
			else {
				request.getRequestDispatcher("auth.jsp");
			}
			
			r.close();
			pst.close();
			con.close();
			
				
			
		}
		catch(Exception e) {
			System.out.print(e);
		}
		

		}
		}

