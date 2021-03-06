<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Анастасія
  Date: 16.06.2017
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="security"
           uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Offers</title>

    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/AllElementsTableStyle.css"/>


</head>
    <%@ include file="menu.jsp" %>

    <p style="text-align: center">ALL OFFERS</p>


    <security:authorize access="hasRole('ROLE_ADMIN')">
    <td>
        <form action="${pageContext.request.contextPath}/addNewOffer" method="get">
            <button class="menuButton"><input type='hidden' value='${_csrf.token}' name='${_csrf.parameterName}'/>
                Додати нову пропозицію
            </button>
        </form>
    </td>
    </security:authorize>
    <security:authorize access="hasRole('ROLE_ADMIN')"/>

    <security:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
        <form:form action="${pageContext.request.contextPath}/filterByBrandAndPrice" modelAttribute="tempData" method="post">
            <input type='hidden' value='${_csrf.token}' name='${_csrf.parameterName}'/>
            <input type="text" name="brandName" placeholder="Введіть бренд">

            <input type="text" name="maxPrice" placeholder="Максимальна ціна">
            <input type="submit" class="menuButton" value="Шукати">
        </form:form>
        </security:authorize>
    <security:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')"/>
    <table class="center">
        <tr style="margin-bottom: 10px; text-align: left">
            <th>Perfume</th>
            <th>Brand</th>
            <th>Volume Available</th>
            <th>Price per Ml</th>
        </tr>
        <c:forEach items="${offers}" var="offer" varStatus="status">
            <tr style="margin-left: auto">
                <td>${offer.perfume.name}</td>
                <td>${offer.perfume.brand.name}</td>
                <td>${offer.volumeForSale}</td>
                <td>${offer.pricePerMl}</td>
                <security:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
                    <td>
                        <form action="${pageContext.request.contextPath}/seeDetails?id=${offer.id}" method="post">
                            <button class="menuButton"><input type='hidden' value='${_csrf.token}'
                                                              name='${_csrf.parameterName}'/>
                                Деталі
                            </button>
                        </form>
                    </td>
                </security:authorize>
                <security:authorize access="hasRole('ROLE_ADMIN')">
                    <td>
                        <form action="${pageContext.request.contextPath}/editOffer?id=${offer.id}" method="post">
                            <button class="menuButton"><input type='hidden' value='${_csrf.token}'
                                                              name='${_csrf.parameterName}'/>
                                Edit
                            </button>
                        </form>
                    </td>
                </security:authorize>

            </tr>
        </c:forEach>
    </table>
    <p>
    <div style="text-align: end;"><a href="/homepage">
        <button class="new"><b>Homepage:)</b></button>
    </a></div>
    </p>

    </body>
</html>