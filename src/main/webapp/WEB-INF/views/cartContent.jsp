<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Анастасія
  Date: 19.06.2017
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart Content</title>
    <meta charset="UTF-8">

    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/AllElementsTableStyle.css"/>
</head>

<body>
<%@ include file="menu.jsp" %>
<h3>Your Cart</h3>
<table class="center">
    <tr>
        <th>Perfume</th>
        <th>Brand</th>
        <th>Ml</th>
        <th>Price for the perfume</th>
    </tr>
    <c:forEach items="${sales}" var="sale" varStatus="status">
        <tr style="text-align:center">
            <td>${sale.offer.perfume.name}</td>
            <td>${sale.offer.perfume.brand.name}</td>
            <td>${sale.volumeOrdered}</td>
            <td>${sale.singleSalePrice}</td>
            <td>
                <form action="${pageContext.request.contextPath}/deleteSaleFromCart?id=${sale.id}" method="post">
                    <input type="submit" value="Delete"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>