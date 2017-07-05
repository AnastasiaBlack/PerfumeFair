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
<p><center>${title}:</center></p>
<input type="text" name="perfumeName" placeholder="${offer.perfume.name}"/>
<br/>
<input type="text" name="brandName" placeholder="${offer.perfume.brand.name}"/>
<br/>
<input type="number" name="price" placeholder="${offer.pricePerMl}"/>
<br/>
<input type="number" name="volumeForSale" placeholder="${offer.volumeForSale}"/>
<br/>
<input type="hidden" name="id" value="${offer.id}"/>
<button class="menuButton">Submit</button>
</form:form>


</html>