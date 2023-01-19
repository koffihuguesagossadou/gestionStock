<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajout</title>
<link rel="stylesheet" type="text/css" href="../styles/ajout.css">
</head>
<body>
	<div class="form-container">
	  <form class="form-register-article" action="/gestionStock/article" method="POST">
	    <label for="designation">Désignation</label>
	    <input type="text" id="designation" name="designation" required>
	    <label for="price">Prix</label>
	    <input type="text" id="price" name="prix" required>
	    <label for="quantity">Quantité</label>
	    <input type="text" id="quantity" name="quantite" required>
	    <input type="hidden" name="status" value="add">
	    <button type="submit">Enregistrer</button>
	  </form>
	</div>
	
</body>
</html>