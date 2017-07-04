<%--
  Created by IntelliJ IDEA.
  User: Анастасія
  Date: 04.07.2017
  Time: 0:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Filter Offers By Brand</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/AllElementsTableStyle.css"/>


</head>
<body>
<%@ include file="menu.jsp" %>

<p style="text-align: center">Усі пропозиції ${searchName}</p>

<%--<form action="${pageContext.request.contextPath}/sortByPrice" method="post">--%>
    <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
    <%--<input type="hidden" name="searchName" value="${searchName}">--%>
    <%--<input type="hidden" name="offers" value="${offers}">--%>
    <%--<input type="submit" value="Сортувати за ціною">--%>
<%----%>
<%--</form>--%>


<table class="center">
    <tr style="margin-bottom: 10px; text-align: left">
        <th>Perfume</th>
        <th>Brand</th>
        <th>Volume Available</th>
        <th>Price per Ml</th>
    </tr>
    <c:forEach items="${offers}" var="offer" varStatus="status">
        <tr style="margin-left: auto">
            <td>${offer.perfume.name}</td>
            <td>${offer.perfume.brand.name}</td>
            <td>${offer.volumeForSale}</td>
            <td>${offer.pricePerMl}</td>
            <security:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
                <td>
                    <form action="${pageContext.request.contextPath}/seeDetails?id=${offer.id}" method="post">
                        <button class="menuButton"><input type='hidden' value='${_csrf.token}'
                                                          name='${_csrf.parameterName}'/>
                            Деталі
                        </button>
                    </form>
                </td>
            </security:authorize>
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