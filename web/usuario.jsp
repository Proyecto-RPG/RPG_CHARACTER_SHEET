<%-- 
    Document   : usuario
    Created on : 09-06-2021, 13:11:33
    Author     : Alex A_R
--%>

<%@page import="elements.character.data.ArrayCharacter"%>
<%@page import="elements.users.GameMaster"%>
<%@page import="elements.users.Player"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Crea tu Personaje RPG - Perfil de Usuario</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div class="container">
            <%
                    Player player = (Player) request.getSession().getAttribute("user");
                %>
            <div class="jumbotron center-block">
                <div class="row">
                    <div class="col-md-3 center"><img src="logo-small.png" class="center-block"></div>
                    <div class="col-md-7 center"><p class="text5">¡Bienvenid@ nuevamente, <%=player.getNickname()%>!</p></div>
                    <div class="col-md-2 center"><form action="session_manager.do"><button name="btn_logout" class="btn btn-danger">Cerrar Sesión</button></form></div>
                </div>
                <br>
                <p class="text4">Tus Personajes:</p>
                <br>
                <!-- INICIO ÁREA DE DESPLIEGUE DE TARJETAS DE PERSONAJE - MOSTRAR SÓLO SI USUARIO TIENE PSJES. REGISTRADOS -->
                
                <div id="area_personajes">

                    <!-- INICIO TARJETA DE PERSONAJE - REPETIR EN LISTADO (TODOS LOS ELEMENTOS IMPORTANTES TIENEN ID) -->

                    <%
                        if (ArrayCharacter.listCharacter(player)) {
                            for (elements.character.Character charac : ArrayCharacter.characterList) {
                    %>

                    <div class="jumbotron tarjeta center-block">
                        <!--Nombre de personaje -->

                        <div class="col-md-4">
                            <div class="row">
                                <img class="center-block" src="char_img.png">
                            </div>
                            <div class="row">
                                <p class="text5" id="nombre_personaje">Nombre personaje</p>
                            </div>
                        </div>

                        <!--Raza de personaje -->

                        <div class="col-md-2">
                            <div class="row center">
                                <img id="img_raza_personaje" class="center-block imgwidth4" src="img/raza_humano.png">
                            </div>
                            <div class="row center">
                                <p id="raza_personaje" class="text3">Humano</p>
                            </div>
                        </div>

                        <!--Clase de personaje -->

                        <div class="col-md-2">
                            <div class="row center">
                                <img id="img_clase_personaje" class="center-block imgwidth3" src="img/clase_guerrero.png">
                            </div>
                            <div class="row center">
                                <p class="text3" id="clase_personaje">Guerrero</p>
                            </div>
                        </div>

                        <!--Nivel de personaje -->

                        <div class="col-md-2">
                            <div class="row center">
                                <p class="text6" id="nivel_personaje">1</p>
                            </div>
                            <div class="row center">
                                <p class="text3">LVL</p>
                            </div>
                        </div>

                        <!--Ver de personaje -->

                        <div class="col-md-2">
                            <div class="row center">
                                <form action=""><button name="btn_ver_psje" class="btn btn-primary mar3 center-block">Ver Personaje</button></form>
                            </div>
                        </div>
                    </div>
                    <!-- FIN TARJETA DE PERSONAJE -->

                </div>
                <!-- FIN ÁREA DE DESPLIEGUE DE TARJETAS -->

                <script>


                    var nickname = <%player.getCharacter().getCharacterName();%>;
                    var race = <%player.getCharacter().getRace().getRaceName();%>;
                    var classes = <%player.getCharacter().getCls().getClassName();%>;
                    var level = <%player.getCharacter().getLevel();%>;


                    document.getElementById("nombre_personaje").innerHTML = nickname;
                    
                    
                    <%
                        if (player.getCharacter().getRace().getRaceName().equals("Humano")) {
                    %>
                    document.getElementById("img_raza_personaje").src = "img/raza_humano.jpg";
                    <%
                    } else if (player.getCharacter().getRace().getRaceName().equals("Elfo")) {
                    %>
                    document.getElementById("img_raza_personaje").src = "img/raza_elfo.jpg";
                    <%
                    } else if (player.getCharacter().getRace().getRaceName().equals("Enano")) {
                    %>
                    document.getElementById("img_raza_personaje").src = "img/raza_enano.jpg";
                    <%
                    } else if (player.getCharacter().getRace().getRaceName().equals("Orco")) {
                    %>
                    document.getElementById("img_raza_personaje").src = "img/raza_orco.jpg";
                    <%
                        }
                    %>
                        
                    //Cambio nombre de raza
                    document.getElementById("raza_personaje").innerHTML = race;
                    
                    
                    <%
                        if (charac.getCls().getClassName().equals("Arquero")) {
                    %>
                    document.getElementById("img_clase_personaje").src = "img/clase_arquero.jpg";
                    <%
                    } else if (charac.getCls().getClassName().equals("Clérigo")) {
                    %>
                    document.getElementById("img_clase_personaje").src = "img/raza_elfo.jpg";
                    <%
                    } else if (charac.getCls().getClassName().equals("Druida")) {
                    %>
                    document.getElementById("img_clase_personaje").src = "img/clase_druida.jpg";
                    <%
                    } else if (charac.getCls().getClassName().equals("Guerrero")) {
                    %>
                    document.getElementById("img_clase_personaje").src = "img/clase_guerrero.jpg";
                    <%
                        }else if (charac.getCls().getClassName().equals("Ladron")) {
                    %>
                    document.getElementById("img_clase_personaje").src = "img/clase_ladron.jpg";
                    <%
                        }else if (charac.getCls().getClassName().equals("Mago")) {
                    %>
                    document.getElementById("img_clase_personaje").src = "img/clase_mago.jpg";
                    <%
                        }
                    %>
                        
                    document.getElementById("clase_personaje").innerHTML = classes;
                    
                    document.getElementById("nivel_personaje").innerHTML = level;
                </script>
                <%
                        }
                    }
                %>
                <!-- INICIO ÁREA DE DESPLIEGUE DE MSJE. "NO EXISTEN PERSONAJES" - MOSTRAR SÓLO SI USUARIO NO TIENE PSJES. REGISTRADOS -->
                <div class="jumbotron tarjeta center-block center" id="area_sin_personajes">
                    <p class="text7">No tienes personajes registrados. Para crear uno presiona botón "Crear Nuevo Personaje"</p>
                </div>
                <!-- FIN ÁREA DE DESPLIEGUE DE MSJE. "NO EXISTEN PERSONAJES" -->
                <br>
                <!-- BOTÓN CREAR NUEVO PERSONAJE - MOSTRAR SÓLO SI USUARIO TIENE MENOS DE 4 PERSONAJES REGISTRADOS -->
                <div id="area_boton_nuevo_psje">
                    <form action="nombre.html"><button name="btn_nuevo" class="btn btn-success btn-lg center-block">Crear Nuevo Personaje</button></form>
                </div>
                <!-- FIN BOTÓN CREAR NUEVO PSJE. -->
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-2.2.4.js" integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
