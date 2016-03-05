<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="com.mycompany.app.UserData" scope="session"/>
<jsp:setProperty name="user" property="*"/>
<jsp:useBean id="protocol" class="com.mycompany.app.OracleProtocol"  scope="application"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        System.out.println(user.getUserName());
        System.out.println(user.getPassword());

        if(protocol.login(user.getUserName(),user.getPassword())==1)
            {
            System.out.println("OK");
            session.setAttribute("wrong",0);
            response.sendRedirect("Home.jsp");
            }
        else {
            System.out.println("ERROR");
            session.setAttribute("wrong",1);
            response.sendRedirect("index.jsp");
            }
        %>
    </body>
</html>