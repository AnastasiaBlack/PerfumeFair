<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Анастасія
  Date: 22.06.2017
  Time: 1:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<c:forEach items="${cart.sales}" var="sale" varStatus="status">
    <tr style="text-align:center">
        <td>${sale.offer.perfume.name}</td>
        <td>${sale.offer.perfume.brand.name}</td>
        <td>${sale.volumeOrdered}</td>
        <td>${sale.singleSalePrice}</td>
    </tr>
</c:forEach>
<form:form action="/submitOrder" method="post">
    <input type="text" name="nickname" placeholder="введіть ваше повне ім'я:"/>
    <br/>
    <input type="text" name="phone" placeholder="Тел.:"/>
    <br/>
    <input type="text" name="email" placeholder="E-mail:"/>
    <button class="menuButton">Оформити замовлення</button>
</form:form>
</body>
</html>
