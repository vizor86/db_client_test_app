<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1>Добро пожаловать в административный интерфейс, ${name}!</h1>
<br>
<table border>
<caption>Список пользователей системы</caption>
<col width="20" valign="top">
<col width="250" valign="top">
<col width="250" valign="top">
   <tr>
    <th>&nbsp;</th><th>Логин</th><th>Роль</th>
   </tr>
<c:forEach items="${users}" var="Users">
    <tr>
        <td><input type="radio" name="users" id="${Users.id}" value="${Users.id}" /></td>
        <td>${Users.login}</td>
        <td>${Users.role}</td>
    </tr>
</c:forEach>
</table>
<br/><input type="button" value="Редактировать" ONCLICK="button1()">
<SCRIPT LANGUAGE="JavaScript">
        <!--
        function button1()
        {
            window.open("page url",null,
            "height=200,width=400,status=yes,toolbar=no,menubar=no,location=no");
        }
        // -->
</SCRIPT>
</body>
</html>