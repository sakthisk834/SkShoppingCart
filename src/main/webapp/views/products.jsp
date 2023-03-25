<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table cellpadding="2" cellspacing ="2" border="1">
<tr>
<th>id</th>
<th>name</th>
<th>color</th>
<th>price</th>
</tr>
<c:forEach var="product" items="${products}">
<tr>
<td>${product.productid}</td>
<td>${product.productname}</td>
<td>${product.productcolor}</td>
<td>${product.productprice}</td>
<td><a href="${pageContext.request.contextPath}/cart? & action=add & product_id=${product.productid}">Add to Cart</a></td>
</tr>
</c:forEach>
</table><br>
<a href="${pageContext.request.contextPath}/cart">Go to cart</a>
<br/>
<br>
<a href="${pageContext.request.contextPath}/views/home.jsp">Home</a>
<br/>

</body>
</html>