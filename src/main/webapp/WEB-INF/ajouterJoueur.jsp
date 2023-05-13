<%@ page language="java" %>
<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%

if( session.getAttribute("nom")!= null){
	String nom = session.getAttribute("nom").toString();
	
}
else{
	response.sendRedirect("auth.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter un joueur</title>

</head>
<body>


<div align="center">
<a href="Logout">Deconnexion</a>
</div>
<h1 align="center"><i>Ajouter un joueur</i></h1>

<h3 color="red" >Attention !n' attribuer un joueur qu à un équipe dèja existe ! </h3>
<h4 color="red">sinon il faut dabord créer l'équipe que vous voulez lui attribuez  </h4>

<form action="ajouterJoueur" methode="post">
<table boreder="1">

<tr>
<td>Numero</td><td><input type="number" name="numero"required ></td>
</tr>

<tr>
<td>Nom</td><td><input type="text"   name="nom"required ></td>
<tr>
<tr>
<td>Post</td><td><input type="text" name="post"required ></td>
</tr>
<tr>
<td>Nationnalite</td><td><input type="text" name="nationnalite"required ></td>
</tr><tr>
<td>Salire</td><td><input type="text" name="salaire"required ></td>
</tr>
<tr>
<td>IdEquipe</td><td><input type="text" name="idequipe"required ></td>
</tr>


<td><input type="submit" value="Ajouter"></td>
<td><input type="reset" value="Etablir"></td>
</tr>
</table>
</form>
<a href="ajouterJoueur">Ajouter un equipe</a>


</body>
</html>