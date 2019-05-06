<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib	prefix="c"	uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customers</title>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
	<section>
	<div class="jumbotron">
		<div class="container">
				<h1>Customers</h1>
				<p>All mine Customers in Store </p>
		</div>
	</div>
	</section>
	
	<section class="container">
		<div class="row">
		<c:forEach items="${lsitCust}" var="cust">
			<div class="col-sm-6 col-md-3" style="padding-bottom:15px">
				<div class="thumbnail">
					<div class="caption">
						<h3>${cust.customerId}</h3>
						<p>${cust.name}</p>
						<p>${cust.address}</p>
						<p>Orderd ${cust.noOfOrdersMade} units in stock</p>
					</div>
				</div>
			</div>
		</c:forEach>
		</div>
		</section>

</body>
</html>