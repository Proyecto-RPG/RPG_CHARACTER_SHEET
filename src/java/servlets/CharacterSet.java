/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import elements.character.Character;
import elements.character.Classes;
import elements.character.Equipment;
import elements.character.Race;
import elements.character.Skill;
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
                String characterName = request.getParameter("txt_nombre");
                String characterGender = request.getParameter("cb_typeuser");

                character.setCharacterName(characterName);
                character.setCharacterGender(characterGender);

                System.out.println("Nombre de personaje: " + character.getCharacterName());
                System.out.println("Genero de personaje: " + character.getCharacterGender());

                HttpSession session = request.getSession();
                session.setAttribute("user", character);

                response.sendRedirect("raza.html");
            }

//            Captura los parametros de raza, busca la raza en base de datos por medio
//            de metodo searchRace(), donde se instancia un objeto Race y se setea en
//            el objeto Character capturado en la sesion.
            if (request.getParameter("btn_raza") != null) {
                Character character = (Character) request.getSession().getAttribute("user");
                String race = request.getParameter("raza");
                character.setRace(Race.searchRace(race));
                System.out.println("Raza escogida: " + character.getRace().getRaceName());
                character.setRace_idRace(Race.searchRace(race).getIdRace());

                response.sendRedirect("clase.html");
            }

//            Captura los parametros de clase, busca una clase por metodo searchClass(),
//            se instancia un objeto, se captura la sesión y se setea el objeto Classes en
//            el objeto Character.
            if (request.getParameter("btn_clase") != null) {
                Character character = (Character) request.getSession().getAttribute("user");
                String cls = request.getParameter("clase");

                
                character.setCls(Classes.assignClass(cls));
                character.setClass_idClass(Classes.assignClass(cls).getIdClass());
                System.out.println("Clase escogida: " + character.getCls().getClassName());
                
                if (character.getCls().getClassName().equals("Arquero")){
                    response.sendRedirect("hab_arquero.html");
                }else if (character.getCls().getClassName().equals("Guerrero")){
                    response.sendRedirect("hab_guerrero.html");
                }else if (character.getCls().getClassName().equals("Clérigo")){
                    response.sendRedirect("hab_clerigo.html");
                }else if (character.getCls().getClassName().equals("Mago")){
                    response.sendRedirect("hab_mago.html");
                }else if (character.getCls().getClassName().equals("Ladron")){
                    response.sendRedirect("hab_ladron.html");
                }else if (character.getCls().getClassName().equals("Druida")){
                    response.sendRedirect("hab_druida.html");
                }
            }
            
            if (request.getParameter("btn_habilidades")!=null) {
//              Arreglo que guardará las habilidades de Radio Button
                String[] skill = request.getParameterValues("hab1");
                String[] skill2= request.getParameterValues("hab2");
                
                Character character = (Character) request.getSession().getAttribute("user");
                
                character.setSkill(Skill.searchSkill(Integer.valueOf(skill[0])));
                System.out.println("Habilidad Normal: "+character.getSkill().getSkillName());
                character.setSkill2(Skill.searchSkill(Integer.valueOf(skill2[0])));
                System.out.println("Habilidad Especial: "+character.getSkill2().getSkillName());
                
                response.sendRedirect("equipamiento.html");
            }
            
            if (request.getParameter("btn_equipamiento")!=null) {
                Character character = (Character) request.getSession().getAttribute("user");
                int equipment = Integer.valueOf(request.getParameter("equip1"));
                character.setEquip(Equipment.searchEquip(equipment));
                System.out.println("Equipamiento elegido: "+character.getEquip().getEquipmentName());
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
