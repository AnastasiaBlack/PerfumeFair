<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Анастасія
  Date: 16.06.2017
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/AllElementsTableStyle.css"/>

</head>
<body>

<table class="center">
    <title>Brands</title>
    <div>BRANDS</div>
    <c:forEach items="${brands}" var="brand" varStatus="count">
        <tr>
            <td>
                    ${brand.name}
            </td>
        </tr>
    </c:forEach>
</table>
<p>
<div style="text-align: end;"><a href="/hello">
    <button class="new"><b>Homepage:)</b></button>
</a></div>
</p>
</body>
</html>
