<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
    <style>
    h2 {
background-color:#FEFFED;
text-align:center;
border-radius:10px 10px 0 0;
margin:-10px -40px;
padding:15px
}
hr {
border:0;
border-bottom:1px solid #ccc;
margin:10px -40px;
margin-bottom:30px
}
#login {
width:300px;
float:left;
border-radius:10px;
font-family:raleway;
border:2px solid #ccc;
padding:10px 40px 25px;
margin-top:70px
}
input[type=text],input[type=password] {
width:99.5%;
padding:10px;
margin-top:8px;
border:1px solid #ccc;
padding-left:5px;
font-size:16px;
font-family:raleway
}
input[type=submit] {
width:100%;
background-color:#FFBC00;
color:#fff;
border:2px solid #FFCB00;
padding:10px;
font-size:20px;
cursor:pointer;
border-radius:5px;
margin-bottom:15px
}
#profile {
padding:50px;
border:1px dashed grey;
font-size:20px;
background-color:#DCE6F7
}
#logout {
float:right;
padding:5px;
border:dashed 1px gray
}</style>
</head>
<body>
	<form action="Login" method="post" >
	<table>
		
		<tr>
			<td>
				Nom
			</td>
			<td>
				<input type="text" name="nom" required>
			</td>
		</tr>
		<tr>
			<td>
				password
			</td>
			<td>
				<input type="password" name="pass" required>
			</td>
		</tr>
		<tr>
			<td colspan="2" >
				<input type="submit" value="login" backgroundcolor="green">
		</tr>
		
	</table>
	</form>
	<form action="Enregistrement" methode="post" >
	<table>
		<tr>
		<td>Vous n'avez pas compte</td>
			<td colspan="2" >
				<input type="submit" value="nuoveau compte" backgroundcolor="green"></td>
		</tr>
		</table>
	</form>

</body>
</html>