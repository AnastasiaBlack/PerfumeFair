<%--
  Created by IntelliJ IDEA.
  User: Анастасія
  Date: 09.06.2017
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%--<html>--%>
<%--<body>--%>
<%--<h2>PERFUME FAIR</h2>--%>
<%--<h3><a href="/brands">See all brands...</a></h3>--%>
<%--<h3><a href="/offers">See all offers...</a></h3>--%>
<%--</body>--%>
<%--</html>--%>
<html>
<head>
    <meta charset="utf-8">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/PageStyle.css" charset=UTF-8"/>

</head>
<body>
<header>
    <h1>Perfume Fair</h1>
    <ul class="hr">
        <li><a href="/hello">[Home]</a></li>
        <li id="about"><a href="/brands">[All Brands]</a></li>
        <li><a href="/offers">[All Offers]</a></li>
    </ul>
</header>

<h2>
    <center><strong>Здесь Вы можете купить отливант и продать часть своего парфюма.
</h2>
</center></strong>

<div>
    <center><img src="http://dummyimage.com/600x120/9d96a1/111111.jpg"></center>
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
    <button>Duis pretium dolor quis!</button>
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