/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import elements.character.Character;
import elements.character.Classes;
import elements.character.Equipment;
import elements.character.ExtraHp;
import elements.character.Race;
import elements.character.Skill;
import elements.users.Player;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alex A_R
 */
public class CharacterSet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
//            Captura parametros de nombre de personaje y genero, instancia un personaje
//            y lo captura en una sesión como objeto Character
            if (request.getParameter("btn_nombre") != null) {
                Character character = new Character();
                Player player = (Player) request.getSession().getAttribute("player");
                character.setUser_idUser(player.getIdUser());

                String characterName = request.getParameter("txt_nombre");
                String characterGender = request.getParameter("cb_typeuser");

                character.setCharacterName(characterName);
                character.setCharacterGender(characterGender);
//                Se setean los stats a 0 del personaje recièn creado

                System.out.println("Nombre de personaje: " + character.getCharacterName());
                System.out.println("Genero de personaje: " + character.getCharacterGender());

                HttpSession session = request.getSession();
                session.setAttribute("character", character);

                response.sendRedirect("raza.html");
            }

//            Captura los parametros de raza, busca la raza en base de datos por medio
//            de metodo searchRace(), donde se instancia un objeto Race y se setea en
//            el objeto Character capturado en la sesion.
            if (request.getParameter("btn_raza") != null) {
                Character character = (Character) request.getSession().getAttribute("character");
                String race = request.getParameter("raza");
                character.setRace(Race.searchRace(race));
                System.out.println("Raza escogida: " + character.getRace().getRaceName());
                character.setRace_idRace(character.getRace().getIdRace());

                response.sendRedirect("clase.html");
            }

//            Captura los parametros de clase, busca una clase por metodo searchClass(),
//            se instancia un objeto, se captura la sesión y se setea el objeto Classes en
//            el objeto Character.
            if (request.getParameter("btn_clase") != null) {
                Character character = (Character) request.getSession().getAttribute("character");
                String cls = request.getParameter("clase");
                System.out.println("Parametro clase: " + cls);
                character.setCls(Classes.assignClass(cls));
                character.setClass_idClass(character.getCls().getIdClass());
                String className = character.getCls().getClassName();
                System.out.println("Clase escogida: " + className);

                switch (className) {
                    case "Arquero":
                        response.sendRedirect("hab_arquero.html");
                        break;
                    case "Guerrero":
                        response.sendRedirect("hab_guerrero.html");
                        break;
                    case "Clerigo":
                        response.sendRedirect("hab_clerigo.html");
                        break;
                    case "Mago":
                        response.sendRedirect("hab_mago.html");
                        break;
                    case "Ladron":
                        response.sendRedirect("hab_ladron.html");
                        break;
                    case "Druida":
                        response.sendRedirect("hab_druida.html");
                        break;
                    default:
                        break;
                }
            }

            if (request.getParameter("btn_habilidades") != null) {
//              Arreglo que guardará las habilidades de Radio Button
                String[] skill = request.getParameterValues("hab1");
                String[] skill2 = request.getParameterValues("hab2");

                Character character = (Character) request.getSession().getAttribute("character");

                character.setSkill(Skill.searchSkill(Integer.valueOf(skill[0])));
                System.out.println("Habilidad Normal: " + character.getSkill().getSkillName());
                character.setSkill2(Skill.searchSkill(Integer.valueOf(skill2[0])));
                System.out.println("Habilidad Especial: " + character.getSkill2().getSkillName());

                response.sendRedirect("equipamiento.html");
            }

            if (request.getParameter("btn_equipamiento") != null) {
//              Inicializa una sesión que guarde las vidas extras
                ExtraHp extraHp = new ExtraHp(0, 0, 0, 0, 0);
                HttpSession session = request.getSession();
                session.setAttribute("extrahp", extraHp);

                Character character = (Character) request.getSession().getAttribute("character");
                System.out.println("Prueba de Nivel-1: " + character.getLevel());
                character.characterSetZeroStat();

                System.out.println("Prueba de Nivel-2: " + character.getLevel());
                int equipment = Integer.valueOf(request.getParameter("equip1"));
                character.setEquip(Equipment.searchEquip(equipment));
                System.out.println("Equipamiento elegido: " + character.getEquip().getEquipmentName());

                response.sendRedirect("atributos.jsp");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
