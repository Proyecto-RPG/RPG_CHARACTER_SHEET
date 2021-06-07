<%-- 
    Document   : singin_session
    Created on : 07-06-2021, 16:05:18
    Author     : Alex A_R
--%>

<%@page import="elements.users.Player"%>
<%@page import="elements.users.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            User user = (User)request.getSession().getAttribute(request.getParameter("nickname"));
            if (user.getTypeUser()==2) {
                
                Player player = new Player(user.getNickname(),user.getPassword(),user.getTypeUser());
            }
        %>
        
        
    </body>
</html>
