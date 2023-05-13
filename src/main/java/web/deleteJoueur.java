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
 * Servlet implementation class deleteJoueur
 */
@WebServlet("/deleteJoueur")
public class deleteJoueur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteJoueur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if( session.getAttribute("nom")!= null){
			
			String id = request.getParameter("id");
			
			String url = "jdbc:mysql://localhost:3306/dynamique" ;
			String u = "root";
			String p = "";
			int num = 0;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,u,p);
				
				
			
			
			
				PreparedStatement pst = con.prepareStatement("delete from joueur where id=? ");
				pst.setString(1, id);
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
