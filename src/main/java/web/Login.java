package web;

import java.io.IOException;
import java.io.PrintWriter;
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

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
	PrintWriter out;
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		//String email = request.getParameter("email");
		String nom = request.getParameter("nom");
		String password = request.getParameter("pass");
		System.out.println("Nom : " + nom + "Password : "+ password);
		String url = "jdbc:mysql://localhost:3306/dynamique" ;
		String u = "root";
		String p = "";
		
		try {
			System.out.println("Bonjour");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,u,p);
			if(con!=null) {
				System.out.println("Connecte");
			}
			PreparedStatement pst = con.prepareStatement("SELECT id From user WHERE nom=? and password=?");
			
			pst.setString(1,nom);
			pst.setString(2,password);
			

			
			ResultSet r = pst.executeQuery(); 
		//	System.out.println(r.getString(1));
			
			
			if(r.next()) {
			//	session.setAttribute("nom", nom);
				request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
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
