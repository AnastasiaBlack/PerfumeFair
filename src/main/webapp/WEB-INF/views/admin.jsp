<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<%--<head>--%>
    <%--<meta charset="utf-8">--%>
    <%--<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <%--<meta name="description" content="">--%>
    <%--<meta name="author" content="">--%>

    <%--<title>Admin</title>--%>

    <%--<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">--%>
<%--</head>--%>

<%--<body>--%>
<%--<div class="container">--%>
    <%--<c:if test="${pageContext.request.userPrincipal.name != null}">--%>
        <%--<form id="logoutForm" method="post" action="${contextPath}/logout">--%>
            <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
        <%--</form>--%>
        <%--<h2>Admin Page ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a>--%>
        <%--</h2>--%>
    <%--</c:if>--%>
<%--</div>--%>

<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>--%>
<%--<script src="${contextPath}/resources/js/bootstrap.min.js"></script>--%>

<%--</body>--%>
<head>
    <meta charset="utf-8">

    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/AllElementsTableStyle.css"/>

</head>
<body>
<%@ include file="menu.jsp" %>
<form:form action="/editOffer" method="post">
Замовити:
<input type="text" name="perfumeName" placeholder="Perfume name"/>
<br/>
<input type="text" name="brandName" placeholder="Brand name"/>
<br/>
<input type="text" name="price" placeholder="Price per Ml"/>
<br/>
<input type="text" name="volumeForSale" placeholder="Volume for sale"/>
<br/>
<input type="hidden" name="id" value="${offer.id}"/>
<button class="menuButton">Submit</button>
</form:form>


</html>