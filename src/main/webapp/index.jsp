<%--
  Created by IntelliJ IDEA.
  User: Анастасія
  Date: 28.06.2017
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="security"
           uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">

    <link rel="stylesheet" type="text/css" href="resources/PageStyle.css"/>
    <link rel="stylesheet" type="text/css"
          href="resources/AllElementsTableStyle.css"/>


    <%--<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">--%>
</head>
<body>

<header>
    <h1>Perfume Fair</h1>
    <ul class="hr">
        <li><a href="/brands">
            <button class="menuButton">All Brands</button>
        </a></li>
        <li><a href="/offers">
            <button class="menuButton">All Offers</button>
        </a></li>
        <li><a href="/login">
            <button class="menuButton">Login</button>
        </a></li>
    </ul>
</header>


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