<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.apache.log4j.Logger" %>
<jsp:useBean id="jdbcTemplate" class="com.mycompany.app.OracleConnector"  scope="application"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <center>
            <h2>Signup Details</h2>
            <form action="j_security_check" method="post">
            <br/>Username:<input type="text" name="j_username">
            <br/>Password:<input type="password" name="j_password">
            <br/>
                <%
                    Logger log = Logger.getLogger("login.jsp");
                    Object a=session.getAttribute("wrong");
                    session.setAttribute("connection",jdbcTemplate.getConn());
                    log.debug("New DB connection is set");
                    if (a!=null && a.toString().equals("1")){
                        %>wrong login or password<%
                    };
                %>
            <br/><input type="submit" value="Submit">
            </form>
        </center>
    </body>
</html>