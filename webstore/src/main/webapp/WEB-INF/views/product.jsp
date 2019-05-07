<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib	prefix="spring"	uri="http://www.springframework.org/tags"%>
	
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
		</div>
	</div>
	</section>
	
	<section class="container">
		<div class="row">
			<div class="col-md-5"">
					<div class="caption">
						<h3>${products.name}</h3>
						<p>${products.description}</p>
						<p>
							<strong>Item Code :</strong>
							<span class="label label-warning"> ${products.productId} </span>
						</p>
						<p>
							<strong>category</strong> : ${products.category}
						</p>
						<p>
							<strong>Availble units in stock</strong> : ${products.unitsInStock} 
						</p>
						<h4>${products.unitPrice}	USD</h4>
						<p>
							<a href="${pageContext.request.contextPath}/products/edit/${products.productId}" class="btn btn-warning btn-large">
								<span class="glyphicon-shopping-cart glyphicon"></span> Order Now
							</a>
							<a	href="<spring:url value="/products" />" class="btn btn-default">
								<span class="glyphicon-hand-left glyphicon"></span> back
							</a>
						</p>
					</div>
			</div>
		</div>
		</section>
</body>
</html>