<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Update Product</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/shop-homepage.css" rel="stylesheet">

<!-- Footer -->
<link href="css/CSSFooter.css" rel="stylesheet">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>

<body>
	<%@include file="/WEB-INF/view/header.jsp"%>

	<div class="jumbotron container-fluid col-xs-offset-11"
		style="padding-top: 0px; padding-bottom: 0px;">
		<h4>
			&nbsp;&nbsp;&nbsp;<a href="DeconnectServlet" class="text-xs-left">Deconnection</a>
		</h4>

	</div>
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
				<tr />
				<tr />
				<tr>
					<td><input type="submit" value="Valider" /></td>
				</tr>
			</table>
	</div>
	<%@include file="/WEB-INF/view/footer.jsp"%>
</body>
</html>