<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Order page</title>
</head>
<body>
	<h1>Order a product</h1>
	<form:form method="POST" modelAttribute="prodOrd"
		action="${pageContext.request.contextPath}/products/edit/${prodOrd.productId}">
		<table>
			<tbody>
				<tr>
					<td>Product:</td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>Order value:</td>
					<td><form:input path="unitsInOrder" /></td>
				</tr>
				<tr>
					<td><form:label path="unitsInStock">
                      In Stock</form:label></td>
                      <td><form:input path="unitsInStock"/></td>
				</tr>
				<tr>
					<td><form:label path="productId">
                      Product ID</form:label></td>
                      <td><form:input path="productId"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="Order" /></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</form:form>

	<p>
		<a href="${pageContext.request.contextPath}/products">Home page</a>
	</p>
</body>
</html>


