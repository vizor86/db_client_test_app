<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="protocol" class="com.mycompany.app.OracleProtocol"  scope="application"/>
<jsp:useBean id="user" class="com.mycompany.app.UserData"  scope="session"/>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        System.out.println(user.getLogin());
        if(protocol.login(((String)request.getParameter("userName")).toString(),
                          ((String)request.getParameter("password")).toString()
                         )==1)
            {
            System.out.println("OK");
            session.setAttribute("wrong",0);
            user = protocol.getUser();
            System.out.println(user.getLogin());

            %><jsp:forward page="Home.jsp" /><%
            }
        else {
            System.out.println("ERROR");
            session.setAttribute("wrong",1);
            response.sendRedirect("login.jsp");
            }
        %>
    </body>
</html>