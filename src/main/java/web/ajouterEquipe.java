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
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class ajouterEquipe
 */
@WebServlet("/ajouterEquipe")
public class ajouterEquipe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajouterEquipe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		
		//if( session.getAttribute("nom")!= null){
			String nom = request.getParameter("nom");
			
			String pays = request.getParameter("pays");
			
			String url = "jdbc:mysql://localhost:3306/dynamique" ;
			String u = "root";
			String p = "";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,u,p);
				
				PreparedStatement pst = con.prepareStatement("insert into equipe (nom,pays) values(?,?)");
				
				pst.setString(1, nom);
				pst.setString(2, pays);
				
				System.out.println("Bonjour " + pst.toString());
				ResultSet r = pst.executeQuery(); 
				
				if(r.next()) {
				//	session.setAttribute("nom", nom);
					response.sendRedirect("WEB-INF/index.jsp");
				}
				else {
					response.sendRedirect("WEB-INF/auth.jsp");
				}
				
				r.close();
				pst.close();
				con.close();
				
					
				
			}
			catch(Exception e) {
				System.out.print(e);
			}
			
			
			
		}
		//else{
		//	response.sendRedirect("auth.jsp");
	//	}
	//}

}
