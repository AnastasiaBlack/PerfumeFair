<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
    <%--<meta charset="utf-8">--%>
    <%--<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <%--<meta name="description" content="">--%>
    <%--<meta name="author" content="">--%>

    <%--<title>Welcome</title>--%>

    <%--<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">--%>
<%--</head>--%>
<%--<body>--%>

<%--<div class="container">--%>

    <%--<c:if test="${pageContext.request.userPrincipal.name != null}">--%>
        <%--<form id="logoutForm" method="POST" action="${contextPath}/logout">--%>
            <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
        <%--</form>--%>

        <%--<h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a>--%>
        <%--</h2>--%>

    <%--</c:if>--%>

<%--</div>--%>
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>--%>
<%--<script src="${contextPath}/resources/js/bootstrap.min.js"></script>--%>
<%--</body>--%>
<%--</html>--%>
<%--
  Created by IntelliJ IDEA.
  User: Анастасія
  Date: 09.06.2017
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page language="java" contentType="text/html;charset=UTF-8"--%>
<%--pageEncoding="UTF-8" %>--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/AllElementsTableStyle.css"/>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/PageStyle.css"/>

</head>
<body>
<%@ include file="/WEB-INF/views/menu.jsp" %>
<h2>
    <center><strong>Платформа для продажу та купівлі парфуму по мілілітрах.</strong></center>
</h2>


<div>
    <center><img src="https://i.ytimg.com/vi/V16hd5icmrw/hqdefault.jpg"></center>
</div>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi rhoncus blandit mi ultricies scelerisque. Donec
    fermentum feugiat diam. Integer a neque neque. Nam sit amet sagittis sapien. Curabitur a justo imperdiet, vestibulum
    dolor egestas, scelerisque ex. In facilisis mollis libero ac fringilla. Mauris quis tempus nibh. Fusce at odio
    euismod, iaculis eros eget, dictum lacus. Duis pretium dolor quis tortor semper, ut rhoncus lectus viverra. Nunc
    pulvinar tincidunt dictum. Nam lobortis quis turpis eu condimentum. Vestibulum laoreet cursus efficitur. Aliquam id
    porta leo, a auctor ex. Nullam a mi id ex mollis condimentum nec quis neque. Nam varius, velit sit amet bibendum
    aliquet, tortor lorem eleifend lectus, ac pulvinar lacus tortor in nunc. Vestibulum id sapien in quam pellentesque
    hendrerit.</p>

<center>
    <button class="register">Duis pretium dolor quis!</button>
</center>
<p>Phasellus diam felis, varius volutpat sollicitudin non, vulputate cursus erat. Integer eu justo sapien. Etiam
    pretium, mauris sit amet suscipit accumsan, purus turpis fermentum nibh, at fermentum odio velit semper tellus.
    Etiam eget lobortis risus pretium, mauris sit amet suscipit accumsam. Donec dui ex, ultricies lacinia odio ac,
    volutpat mattis tellus. Integer tempus lacus ac lacus varius laoreet. Quisque fermentum risus ac tortor hendrerit,
    non sollicitudin ligula fringilla.</p>

<div class="gallery">
    <img src="http://dummyimage.com/350x150/9d96a1/111111.jpg">
    <img src="http://dummyimage.com/350x150/9d96a1/111111.jpg">
    <img src="http://dummyimage.com/350x150/9d96a1/111111.jpg">
    <img src="http://dummyimage.com/350x150/9d96a1/111111.jpg">
</div>
<hr>
<footer><i>Integer tempus lacus ac lacus varius laoreet. </i></footer>
</body>
</html>