<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../template/header.jsp"/>

<nav class="navbar navbar-inverse">

		<div class="row">
			<div class="col-md-12 text-center my-header">
				<h2>Vote no Restaurante</h2>
			</div>
		</div>
	
</nav>

<div class="container">
	<div class="row text-center">
		<div class="col-md-12 question">
			<h4>Quem é você?</h4>
		</div>
	</div>
	<div class="row jumbotron">
		<div class="col-md-6 centered">
			<form class="center-block" action="user/create" method="post">
			  <div class="form-group">
			    <input type="text" class="form-control my-input" name="user.name" id="userName" placeholder="Nome">
			  </div>
			  <div class="form-group">
			    <input type="email" class="form-control my-input" name="user.email" id="userEmail" placeholder="Email">
			  </div>
			  <button type="submit" class="btn btn-primary my-btn-submit" style="width:100%">Enviar</button>
			</form>
		</div>
	</div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<jsp:include page="../template/footer.jsp"/>