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
        if((username.equals("anurag") && password.equals("jain")))
            {
            System.out.println("OK");
            session.setAttribute("username",username);
            response.sendRedirect("Home.jsp");
            }
        else {
            System.out.println("ERROR");
            response.sendRedirect("Error.jsp");
            }
        %>
    </body>
</html>