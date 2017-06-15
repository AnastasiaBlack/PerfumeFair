<%--
  Created by IntelliJ IDEA.
  User: adminaccount
  Date: 6/14/2017
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.*" %>
<HTML>
<HEAD>
    <TITLE>Filling a Table</TITLE>
</HEAD>

<BODY>
<H1>Filling a Table</H1>

<%
    Connection connection = null;
    Class.forName("sun.jdbc.Driver");
    connection = DriverManager.getConnection("jdbc:perfumedb", "root", "1111");

    Statement statement = null;
    try {
        statement = connection.createStatement();
    } catch (SQLException e) {
        e.printStackTrace();
    }


    ResultSet resultset = statement.executeQuery("select * from perfumedb.brands");

    while(resultset.next()){
%>
<TABLE BORDER="1">
    <TR>
        <TH>ID</TH>
        <TH>Name</TH>
    </TR>
    <TR>
        <TD> <%= resultset.getString(1) %> </TD>
        <TD> <%= resultset.getString(2) %> </TD>
    </TR>
</TABLE>
<%
    }
%>
</BODY>
</HTML>
