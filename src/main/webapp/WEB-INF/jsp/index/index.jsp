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
			<h4>Qual você gosta mais?</h4>
		</div>
	</div>
	
	<div class="row options centered">
		<div class="col-md-10 centered">
			<div class="row">
				<div id="box1" onclick="vote()" class="col-md-5 jumbotron option-box text-center">
					<div id="option1"></div>
				</div>
				<div class="col-md-2 text-center boxOu">OU</div>
				<div id="box2" onclick="vote()" class="col-md-5 jumbotron option-box text-center">
					<div id="option2"></div>
				</div>
			</div>
		</div>
	</div>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src='<c:url value="/js/main.js"/>'></script>  
<jsp:include page="../template/footer.jsp"/>