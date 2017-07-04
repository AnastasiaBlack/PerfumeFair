<%--
  Created by IntelliJ IDEA.
  User: Анастасія
  Date: 04.07.2017
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Filter Offers By Brand</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/AllElementsTableStyle.css"/>


</head>
<body>
<%@ include file="menu.jsp" %>

<p style="text-align: center">Усі пропозиції ${searchName}</p>

<table class="center">
    <tr style="margin-bottom: 10px; text-align: left">
        <th>Perfume</th>
        <th>Brand</th>
        <th>Volume Available</th>
        <th>Price per Ml</th>
    </tr>
    <c:forEach items="${sortedOffers}" var="offer" varStatus="status">
        <tr style="margin-left: auto">
            <td>${offer.perfume.name}</td>
            <td>${offer.perfume.brand.name}</td>
            <td>${offer.volumeForSale}</td>
            <td>${offer.pricePerMl}</td>
            <security:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')"><td><form action="${pageContext.request.contextPath}/seeDetails?id=${offer.id}" method="post">
                <button class="menuButton"><input type='hidden' value='${_csrf.token}' name='${_csrf.parameterName}'/>
                    Деталі</button></form></td></security:authorize>
        </tr>
    </c:forEach>
</table>
<p>
<div style="text-align: end;"><a href="/homepage">
    <button class="new"><b>Homepage:)</b></button>
</a></div>
</p>

</body>
</html>