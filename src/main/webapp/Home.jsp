<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="Error.jsp"%>
<jsp:useBean id="user" class="com.mycompany.app.UserData" scope="session"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <br/><br/><br/><br/><br/>
        <center>
            <h2>
            <%
            out.println("Hello  "+user.getUserName());
            %>
            </h2>
            <br/>
            <br/>
            <br/><br/><br/><br/><br/>
        <a href="index.jsp">Logout</a>
        </center>

    </body>
</html>