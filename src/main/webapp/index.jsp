<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <center>
            <h2>Signup Details</h2>
            <form action="LoginCheck.jsp" method="post">
            <br/>Username:<input type="text" name="userName">
            <br/>Password:<input type="password" name="password">
            <br/>
                <%
                    Object a=session.getAttribute("wrong");
                    if (a!=null && a.toString().equals("1")){
                        %>wrong login or password<%
                    };
                %>
            <br/><input type="submit" value="Submit">
            </form>
        </center>
    </body>
</html>