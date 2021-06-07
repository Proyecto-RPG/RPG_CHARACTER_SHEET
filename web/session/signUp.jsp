<%-- 
    Document   : signUp
    Created on : 06-06-2021, 21:53:29
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
        <form action="session_manager.do" method="POST">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Nombre de usuario:</td>
                    </tr>
                    <tr>
                        <td><input type="text" name="txt_nickname" value="" required/></td>
                    </tr>
                    <tr>
                        <td>Contraseña:</td>
                    </tr>
                    <tr>
                        <td><input type="text" name="txt_password" value="" required/></td>
                    </tr>
                    <tr>
                        <td>Repetir contraseña:</td>
                    </tr>
                    <tr>
                        <td><input type="text" name="" value="" required/></td>
                    </tr>
                    <tr>
                        <td>Tipo de usuario:</td>
                    </tr>
                    <tr>
                        <td><select name="cb_typeuser">
                                <option value = "2">Jugador</option>
                                <option value = "3">Game Master</option>
                            </select></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="btn_register" />
        </form>
    </body>
</html>
