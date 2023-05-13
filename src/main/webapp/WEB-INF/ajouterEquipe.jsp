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
<title>L'ajout d'un equipe</title>
</head>
<body>

<div align="center">
Bonjour <%=nom %><br>
<a href="Logout">Deconnexion</a>
</div>
<h1>Ajouter un equipe</h1>


<table boreder="1">
<form action="ajouterEquipe" method="post">
<tr>
<td>Nom:</td><td><input type="text" name="nom"required ></td>
</tr>

<tr>
<td>pays:</td><td><input type="text"   name="pays"required ></td>
<tr>
<td><input type="submit" value="Ajouter"></td>
<td><input type="reset" value="Etablir"></td>
</tr>
</form>
</table>

<a href="ajouterJoueur">Ajouter un joueur</a>
</body>
</html>