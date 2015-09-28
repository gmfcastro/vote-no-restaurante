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
			<h4>ranking</h4>
		</div>
	</div>
	<div class="row jumbotron">
		<c:set var="index" value="${1}"/>
		<c:forEach items="${ranking}" var="restaurant">
			<div class="col-md-3 centered">
				<div class="row">
					<div class="col-md-12 text-left">
						<p>#<c:out value="${index}"></c:out> - ${restaurant.name}</p>
						<c:set var="index" value="${index + 1}"/>
					</div>
				</div>
			</div>
		</c:forEach>
		</div>
	
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<jsp:include page="../template/footer.jsp"/>