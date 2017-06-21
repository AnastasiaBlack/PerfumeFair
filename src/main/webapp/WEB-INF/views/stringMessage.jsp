<%--@elvariable id="pageMessage" type="java"--%>
<%--
  Created by IntelliJ IDEA.
  User: adminaccount
  Date: 6/19/2017
  Time: 6:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/AllElementsTableStyle.css"/>

</head>
<body>
<%@ include file="menu.jsp" %>
<h3>${pageMessage}</h3>
</body>
</html>
