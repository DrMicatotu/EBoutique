<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Update Product</title>
</head>

<body>
<%@include file="/WEB-INF/view/header.jsp" %>
	<div>

		<form action="UpdateProductServlet" method="post">
			<table>
				<tr>
					<td><label>id du produit :</label></td>
					<td><input name="id" type="text" /></td>
				</tr>
				
				<tr>
					<td><label> nouveau prix : </label></td>
					<td><input name="price" type="text" /></td>
				</tr>
				<tr/>
				<tr/>
				<tr>
				<td><input type="submit" value="Valider"/></td>
				</tr>
			</table>
	</div>
	<%@include file="/WEB-INF/view/footer.jsp" %>
</body>
</html>