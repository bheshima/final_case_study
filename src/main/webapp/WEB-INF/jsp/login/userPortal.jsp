<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recipe Share</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
	integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
	crossorigin="anonymous"></script>
</head>
<!--  navbar   -->
<body>

<div class="header text-center">
	<h1>Recipe Share</h1>
	<p>Share your favorite recipes with the world.</p>
</div>

	<nav class="navbar fixed-navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Recipe Share</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="/home">Home</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="/search">Search</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="/createRecipe">Create
							Recipe</a></li>
					<li class="nav-item"><a class="nav-link" href="/recipesDisplayAll">All Recepies</a></li>
					<li class="nav-item"><a class="nav-link" href="/categoryDisplay">Categories</a></li>
					<li class="nav-item"><a class="nav-link" href="/logout">Logout</a>
				</ul>
			</div>
		</div>
	</nav>
	<!-- navbar -->
	<div class="container">
	<h1>Welcome ${user.fullName }</h1>



	<table border="1" cellpadding="3">

		<tr>

			<td><b>Recipe Name</b></td>
			<td><b>Servings</b></td>
			<td><b>Cook time</b></td>
			<td><b>Prep Time</b></td>
			<td><b>Directions</b></td>
			<td><b>Results</b></td>
		</tr>

		<c:forEach items="${recipe}" var="recipe">
			<tr>
				<%-- <td><a href="/recipeDisplay" >${recipe.id }</td> --%>

				<td>${recipe.recipeDescription }</td>
				<td>${recipe.servings }</td>
				<td>${recipe.cookTime }</td>
				<td>${recipe.prepTime }</td>
				<td>${recipe.directions }</td>
					<td><a href="<c:url value="/recipeDisplay/${recipe.id}" />" >Recipe Result</a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>

</html>