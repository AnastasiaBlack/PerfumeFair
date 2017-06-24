<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Анастасія
  Date: 22.06.2017
  Time: 1:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Submitted Order</title>
</head>
<body>
<p>...User ${userNickname} has submitted an order...</p>
<p> ${pageMessage}</p>


<c:forEach items="${allOrders}" var="order" varStatus="status">
    <table><c:forEach items="${order.sales}" var="sale" varStatus="status">
        <tr style="text-align:center">
            <td>${sale.offer.perfume.name}</td>
            <td>${sale.offer.perfume.brand.name}</td>
            <td>${sale.volumeOrdered}</td>
            <td>${sale.singleSalePrice}</td>
        </tr>
    </c:forEach>
        <tr>
            Total price: ${order.totalPrice} UAH
        </tr>
        <hr>
    </table>
</c:forEach>
<div>Total price</div>

</body>
</html>
