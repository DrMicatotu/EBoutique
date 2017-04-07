<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Votre Panier Eboutique</title>
</head>

<body>
	<%@include file="/WEB-INF/view/header.jsp"%>

	<div class="container">
		<div class="jumbotron">

			<h1>Panier</h1>

			<c:choose>
				<c:when test="${empty prdPanier}">
	Il n'y a pas de produit dans votre panier
	</c:when>
				<c:otherwise>vous avez demandé l'article suivant:
<br />
					<br />
					<table>

						<tr>

							<td>${prdPanier.name}</td>
							<td>&nbsp;&nbsp;|&nbsp;&nbsp;prix à l'unité : <a id="prix">${prdPanier.sellingPrice}</a>
								&euro;
							</td>
							<td><label> | quantité </label></td>
							<td id="quantity"><p>1</p></td>
							<td border="1px" bordercolor="white">&nbsp;</td>
							<td><input type="submit" class="btn btn-default" value="+"
								id="plus" /></td>
							<td><input type="submit" class="btn btn-default" value="-"
								id="minus" /></td>
							<td border="1px" bordercolor="white">&nbsp;</td>
						</tr>
						<tr>
							<td border="1px" bordercolor="white">&nbsp;</td>
						</tr>
						<tr>
							<td border="1px" bordercolor="white">&nbsp;</td>
							<td border="1px" bordercolor="white">&nbsp;</td>
							<td border="1px" bordercolor="white">prix total :</td>
							<td border="1px" bordercolor="white" id="prixQuantity"></td>
						</tr>
						<tr>
							<td border="1px" bordercolor="white">&nbsp;</td>
						</tr>
						<tr>
							<td border="1px" bordercolor="white">&nbsp;</td>
							<td border="1px" bordercolor="white">&nbsp;</td>

							<td><form action="CommandeServlet" method="post">
									<input type="submit" class="btn btn-default"
										value="Valider achat" />
								</form></td>

						</tr>


					</table>

				</c:otherwise>
			</c:choose>

		</div>
	</div>

	<%@include file="/WEB-INF/view/footer.jsp"%>

</body>

<script type="text/javascript">
	var quantity = 1;
	var prix = document.getElementById('prix').innerHTML;
	document.getElementById('prixQuantity').innerHTML = prix + " &euro;";

	var myMinus = document.getElementById('minus');
	myMinus.addEventListener("click", function(event) {
		if (quantity >= 1)
			quantity -= 1;
		else
			quantity = 0;
		document.getElementById('quantity').innerHTML = quantity;
		document.getElementById('prixQuantity').innerHTML = quantity * prix;
	});

	var myPlus = document.getElementById('plus');
	myPlus.addEventListener("click", function(event) {
		if (quantity == 15)
			quantity = 15;
		else
			quantity += 1;
		document.getElementById('quantity').innerHTML = quantity;
		document.getElementById('prixQuantity').innerHTML = quantity * prix
				+ " &euro;";
	});
</script>
</html>