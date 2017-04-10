<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Votre Panier Eboutique</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/shop-homepage.css" rel="stylesheet">

<!-- Footer -->
<link href="css/CSSFooter.css" rel="stylesheet">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"	rel="stylesheet">

<style>
.modelTitre {
text-align: center;
}


</style>
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

			<h1>Panier</h1>
			
			<div class="modelTitre row">
				
				
				<div class='col-xs-6 col-xs-offset-1 nameProduct'>nom du produit</div>
				<div class='col-xs-1 prixUnit'>prix unitaire</div>
				<div class="col-xs-1 col-xs-offset-1">Quantitity</div>
				<div class='col-xs-1 prixQuant col-xs-offset-1'  >sous-totaux</div>
				
			</div>
			<br/><br/>
			<div id="cartList"></div>
			<br/><br/>
			<div class =" row col-xs-offset-9" id= "prixTotal" data-total = "" style="font-size:200%; font-weight: 900;"> </div>
			
			<div class=" row col-xs-offset-9 col-xs-6">
				<a href="#" class="btn btn-success btn-lg col-xs-7" id="cartOrder">
					<span class="glyphicon glyphicon-shopping-cart"></span> Commander
       			</a>
			</div>
			
			
			
			
			
		</div>
	</div>
	
	<div id="template" class="hide">
			<div class="model row">
				
				<div class="col-xs-1"><input type="submit" class="btn btn-danger removeProduct" value="X" /></div>
				<div class='col-xs-6 nameProduct'></div>
				<div class='col-xs-1 prixUnit'></div>
				<div class="col-xs-1"><input type="submit" class="btn btn-default  btnPlusMinus  " value="-" data-op="minus" /></div>
				<div class="col-xs-1"><input type="text" value="0" class=" form-control quantityProduct"/></div>
				<div class="col-xs-1"><input type="submit" class="btn btn-default  btnPlusMinus  " value="+" data-op="plus" /></div>
				<div class='col-xs-1 prixQuant' ></div>
				
			</div>
	</div>

	<%@include file="/WEB-INF/view/footer.jsp"%>



<script type="text/javascript">

	$.cookie.json=true;
		
	var cart = $.cookie("Cart");
	
	if (cart == null) {
		$("#cartPage").text("Le contenu de votre panier est actuellement vide")
	} else {
		
		var total = 0;
		var subtotal = 0;
		var rowNumb = 0;
		
		for (idProd in cart) {
			
			var nameCart = cart[idProd].nameCart;
			var prixCart = cart[idProd].prixCart;
			var quantityCart = cart[idProd].quantityCart;
			
			subtotal = prixCart * quantityCart;
			total += subtotal;
			
			
			$("#template").find(".model").clone().appendTo("#cartList");
			
			var ligne = $("#cartList").find(".model").eq(rowNumb);
			ligne.find(".nameProduct").text(nameCart);
			ligne.find(".quantityProduct").val(quantityCart);
			ligne.find(".prixUnit").text(prixCart + ' \u20AC');
			ligne.find(".prixUnit").attr("data-price",prixCart);
			ligne.find(".prixQuant").text(subtotal + ' \u20AC');
			ligne.find(".removeProduct").attr("data-id",idProd);
			rowNumb++;
						
		}
		
		$("#prixTotal").attr("data-total",total);
		$("#prixTotal").text("total : " + total + " \u20AC" );
	}
	
	$(".btnPlusMinus").click(function(){
		
		quantity = parseInt ( $(this).parents(".model").find(".quantityProduct").val());
		prix = parseFloat( $(this).parents(".model").find(".prixUnit").data("price"));
		var total = parseFloat( $("#prixTotal").attr("data-total") );
		
		var operator = 1;
		if ($(this).data("op") == "minus") {
			operator = (quantity - 1 < 1) ? 0 : -1;
			}
		
		quantity += operator;
		total += (100*Math.round(operator*prix))/100;
		
		$(this).parents(".model").find(".quantityProduct").val(quantity);
		$(this).parents(".model").find(".prixQuant").text((100*Math.round(quantity*prix))/100 +  ' \u20AC');
		
		$("#prixTotal").attr("data-total",total);
		$("#prixTotal").text("total : " + total + " \u20AC" );
		
		var cart = $.cookie("Cart");
		var idCart = $(this).parents(".model").find(".removeProduct").attr("data-id");
		
		cart[idCart].quantityCart = quantity;
		
		$.cookie("Cart",cart);
			
		
	});

	$(".quantityProduct").change(function() {
		
		quantity = parseInt ( $(this).parents(".model").find(".quantityProduct").val());
		prix = parseFloat( $(this).parents(".model").find(".prixUnit").data("price"));
		
		if (quantity < 1 || isNaN(quantity) ) {
				quantity = 1;
				alert("veuillez saisir une quantité supérieure à 1 SVP");
				$(this).parents(".model").find(".quantityProduct").val(parseInt(quantity));
			}
		
		
		
		$(this).parents(".model").find(".prixQuant").text(quantity*prix +  ' \u20AC');
		
		var total = 0;
		
		var cart = $.cookie("Cart");
		var idCart = $(this).parents(".model").find(".removeProduct").attr("data-id");
		
		cart[idCart].quantityCart = quantity;
		
		$.cookie("Cart",cart);
		
		
			for (idProd in cart) {
			
				var prixCart = cart[idProd].prixCart;
				var quantityCart = cart[idProd].quantityCart;
			
				total +=  (100*Math.round(prixCart * quantityCart))/100;
			}
		
			$("#prixTotal").attr("data-total",total);
			$("#prixTotal").text("total : " + total + " \u20AC" );
		
		});
	
	$(".removeProduct").click(function(){
		var cart = $.cookie("Cart");
		var idProd = $(this).attr("data-id");
		
		
		
		var total = parseFloat( 100*Math.round($("#prixTotal").attr("data-total"))/100 );
		var subtotal = cart[idProd].prixCart*cart[idProd].quantityCart;
		
		total -= subtotal;
		
		
		
		
		
		delete cart[idProd];
		if (cart == undefined) {
			total = 0;
		}
		$.cookie("Cart",cart)
			
		$(this).parents(".model").remove()
		
		console.log($.cookie("Cart"))
		
		
		$("#prixTotal").attr("data-total", total).text("Total : " + total + "\u20AC" );
		
		
		
	});
	
	$(".quantityProduct").keypress(function(e) {
		
		if(!(47 < e.which && e.which < 58)) {
			return false;
		} 
	});
	
	$("#cartOrder").click(function(){
		
		var cart = $.cookie("Cart");
		console.log(JSON.stringify(cart));
		
		$.post("/EBoutiquePrototype/orderServlet",{"cart" : JSON.stringify(cart)},function(response){
			
			if(response == "ok") {
				
			} else {
				
			}
			
		});
		
	});
	
</script>
</body>
</html>