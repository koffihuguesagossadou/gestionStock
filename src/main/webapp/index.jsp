<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Gestion de stock</title>
	<link rel="stylesheet" type="text/css" href="styles/index.css">
	<link rel="stylesheet" type="text/css" href="bootstrap/bootstrap.min.css">
	<script type="text/javascript" src="js/ajax.js"></script>
</head>
<body onload="getData()">
	<%@ include file="layouts/navbar.jsp" %>
	<div>
		
		<div class="table-container">
		  <table class="modern-table" id="dataTable">
		    <thead>
		      <tr>
		        <th>id</th>
		        <th>désignation</th>
		        <th>prix</th>
		        <th>quantité</th>
		      </tr>
		    </thead>
		    <tbody>
		      
		    </tbody>
		  </table>
		</div>
	</div>
</body>
</html>