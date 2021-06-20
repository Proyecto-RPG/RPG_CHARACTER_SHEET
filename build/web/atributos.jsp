<%-- 
    Document   : atributos
    Created on : 14-06-2021, 20:36:16
    Author     : Alex A_R
--%>
<%@page import="elements.character.ExtraHp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="elements.character.Character"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Crea tu Personaje RPG - Atributos y HP</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <%
            Character character = (Character) request.getSession().getAttribute("character");
        %>
        <div class="container">
            <img src="logo-small.png" class="center-block">
            <br>
            <p class="text4">6. Por último, definamos tus Atributos y HP inicial..</p>
            <br>
            <span class="modulo2 center-block">
                <div class="row">
                    <form action="dice.do" method="post">
                        <div class="col-md-6 imp2">
                            <p class="text10">Definición de Atributos</p>
                            <div class="row">
                                <div class="col-md-6">
                                    <p class="text11"><input type="text" name="txt_fue" id=txt_fue" class="entrada3" maxlength="2" value="<%=character.getStrong()%>" disabled>FUERZA</p>
                                </div>
                                <div class="col-md-6">
                                    <button name="btn_fue" id="btn_fue"  class="btn btnchico btn-primary btn-sm center-block">Tirar Dado D20 </button>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <p class="text11"><input type="text" name="txt_des" id=txt_des" class="entrada3" maxlength="2" disabled value="<%=character.getDextery()%>">DESTREZA</p>
                                </div>
                                <div class="col-md-6">
                                    <button id="btn_des" name="btn_des" class="btn btnchico btn-primary btn-sm center-block">Tirar Dado D20</button>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <p class="text11"><input type="text" name="txt_con" id=txt_con" class="entrada3" maxlength="2" disabled value="<%=character.getConstitution()%>">CONSTITUCIÓN</p>
                                </div>
                                <div class="col-md-6">
                                    <button id="btn_con" name="btn_con" class="btn btnchico btn-primary btn-sm center-block">Tirar Dado D20</button>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <p class="text11"><input type="text" name="txt_int" id=txt_int" class="entrada3" maxlength="2" disabled value="<%=character.getIntelligence()%>">INTELIGENCIA</p>
                                </div>
                                <div class="col-md-6">
                                    <button id="btn_int" name="btn_int" class="btn btnchico btn-primary btn-sm center-block">Tirar Dado D20</button>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <p class="text11"><input type="text" name="txt_sab" id=txt_sab" class="entrada3" maxlength="2" disabled value="<%=character.getWisdom()%>">SABIDURÍA</p>
                                </div>
                                <div class="col-md-6">
                                    <button id="btn_sab" name="btn_sab" class="btn btnchico btn-primary btn-sm center-block">Tirar Dado D20</button>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <p class="text11"><input type="text" name="txt_car" id=txt_car" class="entrada3" maxlength="2" disabled value="<%=character.getCarism()%>">CARISMA</p>
                                </div>
                                <div class="col-md-6">
                                    <button id="btn_car" name="btn_car" class="btn btnchico btn-primary btn-sm center-block">Tirar Dado D20</button>
                                </div>
                            </div>
                        </div>
                        <%
                            ExtraHp extraHp = (ExtraHp) request.getSession().getAttribute("extrahp");
                            if (character.getRace().getRaceName().equals("Humano")) {
                        %>

                        <!-- COMIENZO ÁREA DADOS HP HUMANO -->
                        <div id="area_hum">
                            <div class="col-md-6 imp2">
                                <p class="text10b">Definición de HP</p>
                                <p class="text9">Todos los personaje parten con una base de 50 HP, además de tirar dados extras según su Raza. Tu raza es <b class="colornor">Humano</b>, por lo tanto los dados extras que debes tirar son los siguientes:</p>
                                <div class="row">
                                    <div class="col-md-6">
                                        <button id="btn_h1" name="btn_h1" class="btn btnchico btn-success btn-sm center-block">Tirar Dado D8</button>
                                    </div>
                                    <div class="col-md-6">
                                        <p class="text11">+<input type="text" name="txt_dado1" id="txt_dadoH1" class="entrada4" maxlength="1" value="<%=extraHp.getH1()%>" disabled></p>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <button id="btn_h2" name="btn_h2" class="btn btnchico btn-success btn-sm center-block">Tirar Dado D8</button>
                                    </div>
                                    <div class="col-md-6">
                                        <p class="text11">+<input type="text" name="txt_dado2" id="txt_dadoH2" class="entrada4" maxlength="1" value="<%=extraHp.getH2()%>" disabled></p>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <button id="btn_h3" name="btn_h3" class="btn btnchico btn-success btn-sm center-block">Tirar Dado D8</button>
                                    </div>
                                    <div class="col-md-6">
                                        <p class="text11">+<input type="text" name="txt_dado3" id="txt_dadoH3" class="entrada4" maxlength="1" value="<%=extraHp.getH3()%>" disabled></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- FIN ÁREA DADOS HP HUMANO -->
                        <%
                        } else if (character.getRace().getRaceName().equals("Elfo")) {
                        %>
                        <!-- COMIENZO ÁREA DADOS HP ELFO -->
                        <div id="area_hum">
                            <div class="col-md-6 imp2">
                                <p class="text10b">Definición de HP</p>
                                <p class="text9">Todos los personaje parten con una base de 50 HP, además de tirar dados extras según su Raza. Tu raza es <b class="colornor">Elfo</b>, por lo tanto los dados extras que debes tirar son los siguientes:</p>
                                <div class="row">
                                    <div class="col-md-6">
                                        <button id="btn_e1" name="btn_e1" class="btn btnchico btn-success btn-sm center-block">Tirar Dado D12</button>
                                    </div>
                                    <div class="col-md-6">
                                        <p class="text11">+<input type="text" name="txt_dado1" id="txt_dadoE1" class="entrada4" maxlength="2" value="<%=extraHp.getH1()%>" disabled></p>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <button id="btn_e2" name="btn_e2" class="btn btnchico btn-success btn-sm center-block">Tirar Dado D12</button>
                                    </div>
                                    <div class="col-md-6">
                                        <p class="text11">+<input type="text" name="txt_dado2" id="txt_dadoE2" class="entrada4" maxlength="2" value="<%=extraHp.getH2()%>" disabled></p>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <button id="btn_e3" name="btn_e3" class="btn btnchico btn-success btn-sm center-block">Tirar Dado D12</button>
                                    </div>
                                    <div class="col-md-6">
                                        <p class="text11">+<input type="text" name="txt_dado3" id="txt_dadoE3" class="entrada4" maxlength="2" value="<%=extraHp.getH3()%>" disabled></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- FIN ÁREA DADOS HP ELFO -->
                        <%
                        } else if (character.getRace().getRaceName().equals("Enano")) {
                        %>
                        <!-- COMIENZO ÁREA DADOS HP ENANO -->
                        <div id="area_hum">
                            <div class="col-md-6 imp2">
                                <p class="text10b">Definición de HP</p>
                                <p class="text9">Todos los personaje parten con una base de 50 HP, además de tirar dados extras según su Raza. Tu raza es <b class="colornor">Enano</b>, por lo tanto los dados extras que debes tirar son los siguientes:</p>
                                <div class="row">
                                    <div class="col-md-6">
                                        <button id="btn_en1" name="btn_en1" class="btn btnchico btn-success btn-sm center-block">Tirar Dado D6</button>
                                    </div>
                                    <div class="col-md-6">
                                        <p class="text11">+<input type="text" name="txt_dado1" id="txt_dadoEN1" class="entrada4" maxlength="1" value="<%=extraHp.getH1()%>"  disabled></p>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <button id="btn_en2" name="btn_en2" class="btn btnchico btn-success btn-sm center-block">Tirar Dado D6</button>
                                    </div>
                                    <div class="col-md-6">
                                        <p class="text11">+<input type="text" name="txt_dado2" id="txt_dadoEN2" class="entrada4" maxlength="1" value="<%=extraHp.getH2()%>" disabled></p>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <button id="btn_en3" name="btn_en3" class="btn btnchico btn-success btn-sm center-block">Tirar Dado D6</button>
                                    </div>
                                    <div class="col-md-6">
                                        <p class="text11">+<input type="text" name="txt_dado3" id="txt_dadoEN3" class="entrada4" maxlength="1" value="<%=extraHp.getH3()%>" disabled></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- FIN ÁREA DADOS HP ENANO -->
                        <%
                        } else if (character.getRace().getRaceName().equals("Orco")) {
                        %>
                        <!-- COMIENZO ÁREA DADOS HP ORCO -->
                        <div id="area_hum">
                            <div class="col-md-6 imp2">
                                <p class="text10b">Definición de HP</p>
                                <p class="text9">Todos los personaje parten con una base de 50 HP, además de tirar dados extras según su Raza. Tu raza es <b class="colornor">Orco</b>, por lo tanto los dados extras que debes tirar son los siguientes:</p>
                                <div class="row">
                                    <div class="col-md-6">
                                        <button id="btn_o1" name="btn_o1" class="btn btnchico btn-success btn-sm center-block">Tirar Dado D6</button>
                                    </div>
                                    <div class="col-md-6">
                                        <p class="text11">+<input type="text" name="txt_dado1" id="txt_dadoO1" class="entrada4" maxlength="1" value="<%=extraHp.getH1()%>" disabled></p>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <button id="btn_o2" name="btn_o2" class="btn btnchico btn-success btn-sm center-block">Tirar Dado D6</button>
                                    </div>
                                    <div class="col-md-6">
                                        <p class="text11">+<input type="text" name="txt_dado2" id="txt_dadoO2" class="entrada4" maxlength="1" value="<%=extraHp.getH2()%>" disabled></p>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <button id="btn_o3" name="btn_o3" class="btn btnchico btn-success btn-sm center-block">Tirar Dado D6</button>
                                    </div>
                                    <div class="col-md-6">
                                        <p class="text11">+<input type="text" name="txt_dado3" id="txt_dadoO3" class="entrada4" maxlength="1" value="<%=extraHp.getH3()%>" disabled></p>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <button id="btn_o4" name="btn_o4" class="btn btnchico btn-success btn-sm center-block">Tirar Dado D6</button>
                                    </div>
                                    <div class="col-md-6">
                                        <p class="text11">+<input type="text" name="txt_dado4" id="txt_dadoO4" class="entrada4" maxlength="1" value="<%=extraHp.getH4()%>" disabled></p>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <button id="btn_o5" name="btn_o5" class="btn btnchico btn-success btn-sm center-block">Tirar Dado D6</button>
                                    </div>
                                    <div class="col-md-6">
                                        <p class="text11">+<input type="text" name="txt_dado5" id="txt_dadoO5" class="entrada4" maxlength="1" value="<%=extraHp.getH5()%>" disabled></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- FIN ÁREA DADOS HP ORCO -->
                        <%
                            }
                        %>
                        <button class="btn btn-primary center-block mar2" name="btn_guardar_psje">Guardar Personaje</button>
                    </form>
                </div>
            </span>
            <br>
            <br>
            <form action="clase.html"><button class="btn btn-danger center-block">Atrás</button></form>
        </div>
        <script src="https://code.jquery.com/jquery-2.2.4.js" integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>