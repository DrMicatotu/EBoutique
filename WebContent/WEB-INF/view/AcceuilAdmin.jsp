<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
<head>
<title>Acceuil Admin</title>
</head>

<body>
<%@include file="/WEB-INF/view/header.jsp" %>

<div class="jumbotron text-xs-center parallax">
<h1> Bienvenue Admin</h1>



<p> pour acceder au catalogue : <br/> </p>

<a href="<c:url value="/CatalogueServlet" />"> catalogue</a> 

<p> modification du catalogue : <br/><br/>

<a href="<c:url value="/CreateProduct" />"> Creer un Produit</a> <br/> 

<a href="<c:url value="/DeleteProduct" />"> Supprimer un produit</a> <br/> 

<a href="<c:url value="/UpdateProduct" />"> modifier un produit</a> <br/> 
</p>

</div>


<%@include file="/WEB-INF/view/footer.jsp" %>

</body>

</html>