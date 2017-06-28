<%@ taglib prefix="security"
           uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/PageStyle.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/AllElementsTableStyle.css"/>


    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<header>
    <h1>Perfume Fair</h1>
    <ul class="hr">
        <li><a href="/WEB-INF/views/homepage.jsp">
            <button class="menuButton">Home</button>
        </a></li>
        <li><a href="/brands">
            <button class="menuButton">All Brands</button>
        </a></li>
        <li><a href="/offers">
            <button class="menuButton">All Offers</button>
        </a></li>
        <li>
            <security:authorize access="">
                <a href="/sales"><button class="menuButton">Login</button></a>
            </security:authorize>
        </li>
        <li>
            <security:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
                <a href="/sales"><button class="menuButton">Cart</button></a>
            </security:authorize>
        </li>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    </ul>
</header>
</body>
</html>

