<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="gestionStock.entities.Article" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier</title>
<link rel="stylesheet" type="text/css" href="/gestionStock/styles/modif.css">
</head>
<body>
	<%
		Article article = (Article) request.getAttribute("article");
	%>
	<div class="form-container">
	  <form class="form-modify-article" action="/gestionStock/article" method="POST">
	    <label for="designation">Désignation</label>
	    <input type="text" id="designation" name="designation" value='<%= article.getDesignation()==null ? "" : article.getDesignation() %>' required>
	    <label for="price">Prix</label>
	    <input type="text" id="price" name="prix" value='<%= article.getPrix()==null? "": article.getPrix() %>' required>
	    <label for="quantity">Quantité</label>
	    <input type="number" id="quantity" name="quantite" value='<%= article.getQuantite()==0 ? "" : article.getQuantite() %>' required>
	    <input type="hidden" value='<%= article.getId()==0? "" : article.getId() %>' name="id">
	    <input type="hidden" value="upd" name="status">
	    <button type="submit">Modifier</button>
	  </form>
	</div>
	
</body>
</html>