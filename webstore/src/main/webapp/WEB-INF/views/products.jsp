<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib	prefix="c"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib	prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib  prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Porducts</title>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
	<section>
	<div class="jumbotron">
		<div class="container">
				<h1>Products</h1>
				<p>All the available products in our store</p>
				<c:url var="logoutUrl" value="/logout"/>
				<form:form action="${logoutUrl}" method="post">
					<input type="submit" value="Log out" class="btn btn-danger btn-mini pull-right"/>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form:form>
		</div>
	</div>
	</section>
	
	<section class="container">
		<div class="row">
		<c:forEach items="${products}" var="product">
			<div class="col-sm-6 col-md-3" style="padding-bottom:15px">
				<div class="thumbnail">
					<div class="caption">
						<h3>${product.name}</h3>
						<div class="col-md-5">
							<img src="<c:url value="/images/bat.jpg"></c:url>"alt="image" style ="width:100%"/>
						</div>
						<p>${product.description}</p>
						<p>${product.unitPrice}	USD</p>
						<p>Available ${product.unitsInStock} units in stock</p>
						<p>
							<a href="<spring:url value= "/products/product?id=${product.productId}"/>"	class="btn	btn-primary"> 
								<span class="glyphicon-info-sign glyphicon"></span> Details
							</a>
						</p>
					</div>
				</div>
			</div>
		</c:forEach>
		</div>
		</section>

</body>
</html>