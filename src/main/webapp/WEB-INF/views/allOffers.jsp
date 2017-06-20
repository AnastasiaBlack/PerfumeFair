<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Анастасія
  Date: 16.06.2017
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Offers</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/AllElementsTableStyle.css"/>


</head>
<body>
<%@ include file="menu.jsp" %>

<p>ALL OFFERS</p>


<table class="center">
    <tr>
        <th>Perfume</th>
        <th>Brand</th>
        <th>Volume Available</th>
        <th>Price per Ml</th>
    </tr>
    <c:forEach items="${offers}" var="offer" varStatus="status">
        <tr>
            <td>${offer.perfume.name}</td>
            <td>${offer.perfume.brand.name}</td>
            <td>${offer.volumeForSale}</td>
            <td>${offer.pricePerMl}</td>
        </tr>
    </c:forEach>
</table>
<p>
<div style="text-align: end;"><a href="/index.jsp">
    <button class="new"><b>Homepage:)</b></button>
</a></div>
</p>

</body>
</html>