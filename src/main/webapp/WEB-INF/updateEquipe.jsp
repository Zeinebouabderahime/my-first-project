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
<title>Modifier un équipe</title>
</head>
<body>

<div align = "right">
Bomjour <%=nom %><br>
<div align="center">
Bonjour <%=nom %><br>
<a href="Logout">Deconnexion</a>
</div>
<h1 align="center"><i>Modifier l'équipe</i> </h1>
<form action = "UpdateEquipe" methode="post">
<table border="1" width="50%" align="center">

<tr>
	<th>Nom de l'équipe</th><td><input type="text" name="nom"></td>

</tr>
<tr>
	<th>Pays de l'équipe</th>
	<td><input type="text" name="pays"></td>

</tr>
<tr>
	<td><input type="submit" value="Modifier"></td>
	<td><input type="submit" value="Modifier"></td>
</tr>

</table>
</form>


</body>
</html>