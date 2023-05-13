<%@ page language="java" %>
<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String nom = "";
if( session.getAttribute("nom")!= null){
	nom = session.getAttribute("nom").toString();
}
else{
	response.sendRedirect("auth.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>index</title>
<style type="text/css">

</head>
<body>
<div align = "right">
Bomjour <%=nom %><br>
<a href="Logout">Logout</a>
<h1>listes des équipes </h1>

<table border="1" width="50%" align="center">

<tr>
<th>ID de l'équipe</th>
<th>Nom</th>
<th>Pays</th>
<th colspan="2">action</th>
</tr>
<%

String url = "jdbc:mysql://localhost:3306/dynamique" ;
String u = "root";
String p = "";
int num = 0;
try {
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection(url,u,p);
	
PreparedStatement pst = con.prepareStatement("SELECT * From equipe ");
	
	
	

	
ResultSet r = pst.executeQuery(); 
	
while(r.next()){
%>
		
<tr>
		
<td><%= r.getString(1) %></td>
<td><%= r.getString(2) %></td>
<td><%= r.getString(3) %></td>
			
			
<td><a href="deleteEquipe?id<%=r.getString(1)%>">Supprimerr</a></td>
<td><a href="updateEquipe?id<%=r.getString(1)%>">Modifier</a></td>
		
</tr>
		
<% 
}
	
	
pst = con.prepareStatement("SELECT count(*) From equipe ");
r = pst.executeQuery(); 
r.next();
num = r.getInt(1);
r.close();
pst.close();
con.close();
	
		
	
}
catch(Exception e) {
System.out.print(e);
}


%>


</table>
</div>
Nomber des equipes : <%= num %><br><br><br><br>
<a href="direction?id=1">Ajouter un equipe</a><br>
<a href="direction?id=2">Ajouter un joueur</a>

<div align="center">
Bonjour <%=nom %><br>
<a href="Logout">Deconnexion</a>
</div>

</body>
</html>