<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order</title>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Order page</title>
</head>
<body>
	<section>
	<div class="jumbotron">
		<div class="container">
				<h1>Order a product</h1>
		</div>
	</div>
	</section>
	<section class="container">
	<form:form method="POST" modelAttribute="prodOrd"
		action="${pageContext.request.contextPath}/products/edit/${prodOrd.productId}">
		<table>
			<tbody>
				<tr>
					<td>Product:</td>
					<td>${prodOrd.name}</td>
				</tr>
				<tr>
					<td>Order value:</td>
					<td><form:input path="unitsInOrder" /></td>
				</tr>
				<tr>
					<td>Units On Stock</td>
					<td>${prodOrd.unitsInStock}</td>
				</tr>
				<tr>
                      <td><form:hidden path="productId"></form:hidden></td> 
                      <td><form:hidden path="unitsInStock"></form:hidden></td>
				</tr>
				<tr>
					<td>
					<input type="submit" class="btn btn-warning btn-large glyphicon-shopping-cart glyphicon"/>
						<span class="glyphicon-shopping-cart glyphicon"></span> Order Now
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</form:form>
    	<br>
	<p>
		<a href="${pageContext.request.contextPath}/products" class="btn btn-primary">
			<span class="glyphicon-info-sign glyphicon"></span> Home page
		</a>
	</p>
	</section>
</body>
</html>


