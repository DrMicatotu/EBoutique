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

	<style>
.quantityProduct {
	
	text-align: center;
}
</style>

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
			<h1 class="col-lg-offset-1" id="nameProd" data-id="${info[0]}">${info[1]} </h1>
			
			<div class="row">

				<div class="col-xs-8">
					<br /> <br /> <br /> <br /> <br /> <br />
					<c:set var="count" value="3" scope="page" />
					<c:forEach var="info" items="${info}" begin="3">
						<c:if test="${count == 2}">
							<table>
								<th colspan="2"><br /> <br />
									<h4>
										<br /> <br />${info}<br /> <br /> <br /> <br /> Le
										produit est constitué des composants suivants : <br />
									</h4></th>
								</c:if>
								<c:if test="${count > 2 && count%2 != 0}">
									<tr>
										<td>
											<h3>${info}</h3>
										</td>
								</c:if>
								<c:if test="${count > 2 && count%2 == 0}">
									<td>
										<h3>${info}</h3>
									</td>
									</tr>
								</c:if>



								<c:set var="count" value="${count + 1}" scope="page" />
								</c:forEach>
							</table>
							<p>&nbsp;</p>
				</div>
				<div class="col-xs-4">
					<div class="row">

						<h2 class="col-xs-offset-8">${info[2]}&euro;</h2>

					</div>
					<div class="row">

						<img src="http://placehold.it/320x150" alt="">
					</div>
					<div class="row">
						<img src="http://placehold.it/320x150" alt="">
					</div>
					<div class="row">
						<img src="http://placehold.it/320x150" alt="">
					</div>

					<div class="row">
						<h2 class="col-xs-offset-3 prixQuant">Total :
							${info[2]}&euro;</h2>
					</div>

					<div class="row model btn-group col-xs-offset-4">

						<input type="submit" class="btn btn-default col-xs-2 col-xs-offset-3 btnPlusMinus" value="-" data-op="minus" />
						<input type="text"  value="1" class="col-xs-2 form-control quantityProduct" style="width: 55px"/>
						<input type="submit" class="btn btn-default col-xs-2 btnPlusMinus" value="+" data-id="plus" />

					</div>

					
						

							<input class="btn btn-success col-xs-8 col-xs-offset-2" action="/PanierServlet"
								type="submit" id="addToCart" value="ajouter au panier" />

						
					</div>

				</div>
			</div>
		</div>
	</div>
	<input type="hidden" name="price" id="prix" value="${info[2]}" />
	<input type="hidden" name="idProd" id="idProd" value="${info[0]}" />




	<%@include file="/WEB-INF/view/footer.jsp"%>

	<script type="text/javascript">
		
		var quantity = parseInt ( $(".quantityProduct").val() );
		var prix = parseFloat ($("#prix").val() );
		var idProd = $("h1").data("id");
		var nameProd = $("#nameProd").text();
		
		$.cookie.json=true;
	
		$(".btnPlusMinus").click(function(){
			var operator = 1;
			if ($(this).data("op") == "minus") {
				operator = (quantity - 1 < 1) ? 0 : -1;
				}
			quantity = parseInt ( $(this).parents(".model").find(".quantityProduct").val());
			quantity += operator;
			$(this).parents(".model").find(".quantityProduct").val(quantity);
			$(".prixQuant").text("Total : " + quantity*prix +  ' \u20AC');
			
		});

		$(".quantityProduct").change(function() {
			
			quantity = parseInt ( $(".quantityProduct").val() );
			
			if (quantity < 1) {
					quantity = 1;
					alert("veuillez saisir une quantité supérieure à 1 SVP");
					$(".quantityProduct").val(1);
				}
			
			$(".prixQuant").text("Total : " + quantity*prix +  ' \u20AC');
			
			
			
			});
		
		$(".quantityProduct").keypress(function(e) {
			
			if(!(47 < e.which && e.which < 58)) {
				return false;
			} 
		});
		
		$("#addToCart").click(function() {
			
			var quantity = parseInt ( $(".quantityProduct").val() );
			var prix = parseFloat ($("#prix").val() );
			var idProd = $("h1").data("id");
			var nameProd = $("#nameProd").text();							
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

