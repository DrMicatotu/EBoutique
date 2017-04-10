<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Index</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/shop-homepage.css" rel="stylesheet">

<!-- Footer -->
<link href="css/CSSFooter.css" rel="stylesheet">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">

<style>
.error {
	background-color: #FFCCCC;
	color: red;
}
</style>


</head>


<!-- Custom CSS -->


<body background="img/Computer-engineering01_Web.jpg">
	<%@ include file="/WEB-INF/view/header.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<div class="row carousel-holder">

					<div class="col-xs-12">
						<div id="carousel-example-generic" class="carousel slide"
							data-ride="carousel">
							<ol class="carousel-indicators">
								<li data-target="#carousel-example-generic" data-slide-to="0"
									class="active"></li>
								<li data-target="#carousel-example-generic" data-slide-to="1"></li>
								<li data-target="#carousel-example-generic" data-slide-to="2"></li>
							</ol>
							<div class="carousel-inner">
								<div class="item active">
									<img class="slide-image" src="http://placehold.it/800x300"
										alt="">
								</div>
								<div class="item">
									<img class="slide-image" src="http://placehold.it/800x300"
										alt="">
								</div>
								<div class="item">
									<img class="slide-image" src="http://placehold.it/800x300"
										alt="">
								</div>
							</div>
							<a class="left carousel-control" href="#carousel-example-generic"
								data-slide="prev"> <span
								class="glyphicon glyphicon-chevron-left"></span>
							</a> <a class="right carousel-control"
								href="#carousel-example-generic" data-slide="next"> <span
								class="glyphicon glyphicon-chevron-right"></span>
							</a>
						</div>
					</div>

				</div>

				<div class="col-xs-12">
					<div class="jumbotron">
						<br />
						<h1>Bienvenue sur Eboutique</h1>
						<br />
						<p>
							Bienvenue sur l'appication de commande en ligne Eboutique<br />
							pour continuer veuillez vous identifier <br />
						</p>

						<c:if test="${error}">
							<div class="row col-xs-10">
								<p class="error">Erreur sur le login et/ou le mot de passe</p>
							</div>
						</c:if>
						<br />

						<div class="row">
							<form action="LoginServlet" method="post">


								<div class="form-group row col-xs-offset-1 col-xs-6">
									<label for="usr">login :</label> 
									<input type="text" class="form-control row col-xs-offset-1 col-xs-6" name="login">
								</div>


								<div class="form-group row col-xs-offset-1 col-xs-6">
									<label for="pwd">mot de passe :</label>
									<input class="form-control col-xs-offset-1 col-xs-6" name="password" type="password" id="pwd" />


									<input type="submit" class="btn btn-default row col-xs-offset-12"
										value="Valider" />
								</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="/WEB-INF/view/footer.jsp"%>
</body>

</html>