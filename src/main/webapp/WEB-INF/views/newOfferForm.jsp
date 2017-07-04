<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/AllElementsTableStyle.css"/>

</head>
<body>
<%@ include file="menu.jsp" %>
<form:form action="/submitNewOffer" method="post" modelAttribute="tempOffer">
<p>Додайте свій парфум на продаж</p>
<spring:bind path="perfumeName">
<div class="form-group ${status.error ? 'has-error' : ''}" style="width: auto">
    <form:input type="text" path="perfumeName" class="form-control" placeholder="Назва аромату"
                autofocus="true"/>
    <form:errors path="perfumeName"/>
</div>
</spring:bind>

<spring:bind path="brandName">
<div class="form-group ${status.error ? 'has-error' : ''}">
    <form:input type="text" path="brandName" class="form-control" placeholder="Бренд"/>
    <form:errors path="brandName"/>
</div>
</spring:bind>
<spring:bind path="price">
<div class="form-group ${status.error ? 'has-error' : ''}">
    <form:input type="text" path="price" class="form-control" placeholder="Ціна"/>
    <form:errors path="price"/>
</div>
</spring:bind>

<spring:bind path="volumeForSale">
<div class="form-group ${status.error ? 'has-error' : ''}">
    <form:input type="text" path="volumeForSale" class="form-control"
                placeholder="Об'єм до продажу"/>
    <form:errors path="volumeForSale"/>
</div>
</spring:bind>
<%--<input type="text" name="perfumeName" placeholder="Perfume name"/>--%>
<%--<br/>--%>
<%--<input type="text" name="brandName" placeholder="Brand name"/>--%>
<%--<br/>--%>
<%--<input type="number" name="price" placeholder="Price per Ml"/>--%>
<%--<br/>--%>
<%--<input type="number" name="volumeForSale" placeholder="Volume for sale"/>--%>
<%--<br/>--%>
<%--<input type="hidden" name="id" value="${offer.id}"/>--%>
<button class="menuButton">Submit</button>
</form:form>


</html>