<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Анастасія
  Date: 20.06.2017
  Time: 23:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">

    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/AllElementsTableStyle.css"/>

</head>
<body>
<%@ include file="menu.jsp" %>
<table style="margin-top: 40px" class="center">
    <title>Brands</title>
    <div style="margin-top: 20px">${offer.perfume.name} by ${offer.perfume.brand.name}</div>
    <tr>
        <td>Назва</td>
        <td>${offer.perfume.name} by ${offer.perfume.brand.name}</td>
    </tr>
    <tr>
        <td>Всього до продажу</td>
        <td>${offer.volumeForSale} мл</td>
    </tr>
    <tr>
        <td>Ціна за мл</td>
        <td>${offer.pricePerMl}</td>
    </tr>
    <tr>
            <%--<form:form>--%>
            <%--Замовити:--%>
            <%--<input type="text" name="volumeOrdered" placeholder="введіть кількість мілілітрів для замовлення"/>--%>
            <%--<br/>--%>
                <%--<button class="menuButton">Покласти до кошика</button>--%>
        <%--</form:form>--%>
        <form:form action="/addToCart" method="post">
            Замовити:
            <input type="text" name="volumeOrdered" placeholder="введіть кількість мілілітрів для замовлення"/>
            <br/>
            <input type="hidden" name="id" value="${offer.id}"/>
            <button class="menuButton">Покласти до кошика</button>
        </form:form>
    </tr>

</table>
</body>
</html>
