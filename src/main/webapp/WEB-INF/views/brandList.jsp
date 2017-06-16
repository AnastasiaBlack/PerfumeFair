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
    <title>Brands</title>
</head>
<body>

<table>
    <c:forEach items="${brands}" var="brand">
        <tr>
            <td>
                    ${brand.name}
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
