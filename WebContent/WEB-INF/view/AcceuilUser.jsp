<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c"%>



<html>
<head>
<title>Acceuil</title>
</head>

<body>
<%@include file="/WEB-INF/view/header.jsp" %>


<h1> Bienvenue</h1>
<p>
Bienvenue sur l'appication de commande en ligne Eboutique<br/>
</p>


<p> pour acceder au catalogue dès maintenant, veuillez cliquer sur : <a href="<c:url value="/CatalogueServlet" />"> catalogue</a>  <br/> </p>
<%@include file="/WEB-INF/view/footer.jsp" %>
</body>

</html>