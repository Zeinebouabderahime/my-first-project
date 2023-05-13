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
 * Servlet implementation class deleteEquipe
 */
@WebServlet("/deleteEquipe")
public class deleteEquipe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteEquipe() {
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
		String url = "jdbc:mysql://localhost:3306/dynamique" ;
		String u = "root";
		String p = "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,u,p);
			
			PreparedStatement pst = con.prepareStatement("SELECT * From equipe ");
			
			
			

			
			ResultSet r = pst.executeQuery(); 
		
		
		
		pst = con.prepareStatement("SELECT count(*) From equipe ");
		r = pst.executeQuery(); 
		r.next();
		
		r.close();
		pst.close();
		con.close();
		
			
		
	}
	catch(Exception e) {
		System.out.print(e);
	}

	
	}
}


