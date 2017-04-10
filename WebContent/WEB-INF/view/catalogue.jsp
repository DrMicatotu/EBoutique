<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Catalogue Eboutique</title>
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/shop-homepage.css" rel="stylesheet">

<!-- Footer -->
<link href="css/CSSFooter.css" rel="stylesheet">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"	rel="stylesheet">
</head>

<body>

	<%@include file="/WEB-INF/view/header.jsp"%>


	<div class="jumbotron container-fluid col-xs-offset-11"
		style="padding-top: 0px; padding-bottom: 0px;">
		<h4>
			&nbsp;&nbsp;&nbsp;<a href="DeconnectServlet" class="text-xs-left">Deconnection</a>
		</h4>

	</div>


	<div class="container">
		<div class="jumbotron">
			<h1 class="col-lg-offset-2">Notre selection de produits</h1>

			<c:choose>
				<c:when test="${empty cataList}">
	Il n'y a pas de produit dans ce catalogue
	</c:when>
				<c:otherwise>


					<br />
					<br />
					<div class="row">
						<c:forEach var="catalogue" items="${cataList}">

							<div class="col-sm-6 col-lg-4 col-md-4">
								<div class="thumbnail">
									<img src="http://placehold.it/320x150" alt="">
									<div class="caption">

										<h4>
											<a href="#">${catalogue.name}</a>
										</h4>
										<br />
										<h4 class="pull-right prixCatalogue" >${catalogue.sellingPrice}&euro;</h4>
										<p>
											ref : ${catalogue.id} <br />
										</p>
									</div>
									<div class="ratings">
										<c:set var="rand"><%=java.lang.Math.round(java.lang.Math.random() * 50 + 1)%></c:set>
										<p class="pull-right">${rand}&nbsp;reviews</p>
										<p>
											<span class="glyphicon glyphicon-star"></span> <span
												class="glyphicon glyphicon-star"></span> <span
												class="glyphicon glyphicon-star"></span>

											<c:set var="randStar"><%=java.lang.Math.round(java.lang.Math.random() * 2)%></c:set>

											<c:if test="${randStar == 0}">
												<span class="glyphicon glyphicon-star-empty"></span>
												<span class="glyphicon glyphicon-star-empty"></span>

											</c:if>

											<c:if test="${randStar == 1}">
												<span class="glyphicon glyphicon-star"></span>
												<span class="glyphicon glyphicon-star-empty"></span>

											</c:if>

											<c:if test="${randStar == 2}">
												<span class="glyphicon glyphicon-star"></span>
												<span class="glyphicon glyphicon-star"></span>

											</c:if>


										</p>
									</div>
									<div class="row">
										
													<form action="DetailServlet" method="post">
														<input class="btn btn-info btn-lg col-xs-offset-1 col-xs-3" type="submit"
															value="Details" /> <input type="hidden" name="id"
															value="${catalogue.id}" />
													
												
													
														<a href="#" class="btn btn-success btn-lg quickCart col-xs-7" data-price="${catalogue.sellingPrice}" data-idProd="${catalogue.id}"
														data-nameProd="${catalogue.name}">
          													<span class="glyphicon glyphicon-shopping-cart"></span> Ajouter au panier
       													</a>
       												</form>
        

												
									</div>
								</div>
							</div>


							
						</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
	</div>



	<%@include file="/WEB-INF/view/footer.jsp"%>

<script>


$(".quickCart").click(function() {
	
	$.cookie.json=true;
	var quantity = 1;
	var prix = parseFloat ($(this).attr("data-price"));
	var idProd = parseInt ($(this).attr("data-idProd"));
	var nameProd = ($(this).attr("data-nameProd"));
	
	var cart = $.cookie("Cart") || {};
	
	if (cart[idProd]) {
		quantity += cart[idProd].quantityCart;
	}
	
	var product = {"nameCart" : nameProd, "prixCart" : prix, "quantityCart" : quantity};
	cart[idProd] = product;
	
	$.cookie("Cart",cart,{expires:2});
	
	window.location.href="http://localhost:7560/EBoutiquePrototype/PanierServlet";
	
	
	
});
</script>
</body>
</html>

