<%-- 
    Document   : gamemaster
    Created on : 21-07-2021, 19:13:19
    Author     : Alex A_R
--%>

<%@page import="elements.character.Race"%>
<%@page import="elements.character.Classes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="elements.users.GameMaster"%>
<%@page import="elements.character.Character"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Crea tu Personaje RPG - Perfil de GameMaster</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <%
            GameMaster gameMaster = (GameMaster) request.getSession().getAttribute("user");
        %>

        <div class="container">
            <div class="jumbotron center-block">
                <div class="row">
                    <div class="col-md-3 center"><img src="logo-small.png" class="center-block"></div>
                    <div class="col-md-7 center"><p class="text5">¡Bienvenid@ nuevamente, <%=gameMaster.getNickname()%>!</p></div>
                    <div class="col-md-2 center"><form action=""><button name="btn_logout" class="btn btn-danger">Cerrar Sesión</button></form></div>
                </div>
                <br>
                <p class="text4">Personajes:</p>
                <br>

                <!-- INICIO ÁREA DE DESPLIEGUE DE TARJETAS DE PERSONAJE - MOSTRAR SÓLO SI USUARIOS TIENEN PSJES. REGISTRADOS -->
                <%
                    ArrayList<Character> characterList = GameMaster.listCharacter();
                    if (characterList != null) {
                        for (Character character : characterList) {


                %>
                <div id="area_personajes">

                    <!-- INICIO TARJETA DE PERSONAJE - REPETIR EN LISTADO (TODOS LOS ELEMENTOS IMPORTANTES TIENEN ID) -->

                    <div class="jumbotron tarjeta center-block">
                        <div class="col-md-4">
                            <div class="row">
                                <img class="center-block" src="char_img.png">
                            </div>
                            <div class="row">
                                <p class="text5" id="nombre_personaje"><%= character.getCharacterName()%></p>
                            </div>
                            <div class="row">
                                <p class="text9b">Propietario: <span id="usuario_propietario"><%= gameMaster.getUserOwner(character.getUser_idUser())%></span></p>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <div class="row center">
                                <img id="img_raza_personaje" class="center-block imgwidth4" src="<%= Race.raceUrlImage(character.getRace_idRace())%>">
                            </div>
                            <div class="row center">
                                <p id="raza_personaje" class="text3"><%= character.getRace().getRaceName()%></p>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <div class="row center">
                                <img id="img_clase_personaje" class="center-block imgwidth3" src="<%=Classes.classUrlImage(character.getClass_idClass())%>">
                            </div>
                            <div class="row center">
                                <p class="text3" id="clase_personaje"><%= character.getCls().getClassName()%></p>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <div class="row center">
                                <p class="text6" id="nivel_personaje"><%= character.getLevel()%></p>
                            </div>
                            <div class="row center">
                                <p class="text3">Nivel</p>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <div class="row center">
                                <button name="btn_subir_nivel" class="btn btn-success mar3 center-block">Subir 1 Nivel</button>
                            </div>
                            <div class="row center">
                                <button name="btn_eliminar_psje" class="btn btn-danger btn-sm mar3 center-block">Eliminar Personaje</button>
                            </div>
                        </div>
                    </div>

                    <!-- FIN TARJETA DE PERSONAJE -->

                </div>
                <%
                        }
                    } else {
                %>

                <!-- FIN ÁREA DE DESPLIEGUE DE TARJETAS -->

                <!-- INICIO ÁREA DE DESPLIEGUE DE MSJE. "NO EXISTEN PERSONAJES" - MOSTRAR SÓLO SI USUARIOS NO TIENEN PSJES. REGISTRADOS -->

                <div class="jumbotron tarjeta center-block center" id="area_sin_personajes">
                    <p class="text7">No existen personajes registrados.</p>
                </div>

                <!-- FIN ÁREA DE DESPLIEGUE DE MSJE. "NO EXISTEN PERSONAJES" -->

                <%
                    }
                %>
                <br>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-2.2.4.js" integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>