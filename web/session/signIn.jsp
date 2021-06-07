<%-- 
    Document   : signIn
    Created on : 06-06-2021, 21:47:40
    Author     : Alex A_R
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="../session_manager.do" method="POST">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Usuario: </td><br>
                        <td><input type="text" name="txt_nickname" value="" required /></td>
                    </tr>
                    <tr>
                        <td>Contraseña: </td><br>
                        <td><input type="password" name="txt_password" value="" required/></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Ingresar" name="btn_login" />
        </form>
        <form action="../index.html"> 
                <input type="submit" value="Volver" name="btn_back" />
            </form>
    </body>
</html>
