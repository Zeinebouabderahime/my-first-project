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
 * Servlet implementation class updateEquipe
 */
@WebServlet("/updateEquipe")
public class updateEquipe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateEquipe() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		if( session.getAttribute("nom")!= null){
			
			String id = request.getParameter("id");
			
			String url = "jdbc:mysql://localhost:3306/dynamique" ;
			String u = "root";
			String p = "";
			
			
			String nom = request.getParameter("nom");
			String pays = request.getParameter("pays");
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,u,p);
				
				
			
			
			
				PreparedStatement pst = con.prepareStatement("update from equipe where id=? ");
				pst.setString(1, nom);
				pst.setString(2, pays);
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


