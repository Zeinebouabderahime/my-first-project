<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>connexion</title>
<link type="text/css" rel="stylesheet" href="form.css" />
</head>
<body>
<form action="connexion" method="post">
<fieldset>
<legend>Connexion</legend>
<label for="nom">Adresse email <span class="requis">*</span></label>
<input type="email" id="email" name="email" value="<c:out value ="/${utilisateur.email }"/>" size="20" maxlength="60" />
<span class ="erreur">${form.erreurs['email']}</span>
<br>
<label for="motdepasse">Mot de passe class="requis">*</span></label>
<input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20">
<span class="erreur">${form.erreurs['motdepasse']}</span>
<br>
<input type="submit" value="connexion" class="sanslabel">
<br>
<p class="${empty form.erreurs ? 'succes' : 'erreur'}" >${form.resultat}</p>

</fieldset>
</form>

</body>
</html>