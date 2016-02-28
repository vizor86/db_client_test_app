<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        String username=request.getParameter("username");
        System.out.println(username);
        String password=request.getParameter("password");
        System.out.println(password);
        if((username.equals("anurag") && password.equals("qwe")))
            {
            System.out.println("OK");
            session.setAttribute("username",username);
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