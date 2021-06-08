/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;


import elements.character.Character;
import elements.character.Classes;
import elements.character.Race;
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
            
            if (request.getParameter("btn_nombre")!=null) {
                Character character = new Character();
                String characterName = request.getParameter("txt_nombre");
                String characterGender = request.getParameter("cb_typeuser");
                
                character.setCharacterName(characterName);
                character.setCharacterGender(characterGender);
                
                System.out.println("Nombre de personaje: "+characterName);
                System.out.println("Genero de personaje: "+characterGender);
                
                HttpSession session = request.getSession();
                session.setAttribute("user", character);
                
                response.sendRedirect("raza.html");
            }
            
            if (request.getParameter("btn_raza")!=null) {
                Character character = (Character)request.getSession().getAttribute("user");
                String race = request.getParameter("raza");
                character.setRace(Race.searchRace(race));
                System.out.println("Raza escogida: "+race);
                character.setRace_idRace(Race.searchRace(race).getIdRace());
                
                response.sendRedirect("clase.html");
            }
            
            if (request.getParameter("btn_clase")!=null) {
                Character character = (Character)request.getSession().getAttribute("user");
                String cls = request.getParameter("clase");
                
                System.out.println("Clase escogida: "+cls);
                character.setCls(Classes.searchClass(cls));
                character.setClass_idClass(Classes.searchClass(cls).getIdClass());
                
                response.sendRedirect("clase.html?nombre="+character.getCharacterName()+
                        "&genero="+character.getCharacterGender()+"&raza="+character.getRace_idRace());
                
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
