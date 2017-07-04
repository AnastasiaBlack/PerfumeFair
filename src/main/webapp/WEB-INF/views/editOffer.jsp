<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">

    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/AllElementsTableStyle.css"/>

</head>
<body>
<%@ include file="menu.jsp" %>
<form:form action="/submitEditedOrder" method="post">
<p>${title}:</p>
<input type="text" name="perfumeName" placeholder="Perfume name"/>
<br/>
<input type="text" name="brandName" placeholder="Brand name"/>
<br/>
<input type="number" name="price" placeholder="Price per Ml"/>
<br/>
<input type="number" name="volumeForSale" placeholder="Volume for sale"/>
<br/>
<input type="hidden" name="id" value="${offer.id}"/>
<button class="menuButton">Submit</button>
</form:form>


</html>