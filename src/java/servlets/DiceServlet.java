/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import elements.character.Character;
import elements.character.ExtraHp;
import elements.users.Player;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alex A_R
 */
public class DiceServlet extends HttpServlet {

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
            Character character = (Character) request.getSession().getAttribute("character");

            if (request.getParameter("btn_fue") != null) {
                int str = (int) (Math.random() * 20 + 1);
                character.setStrong(str);
                response.sendRedirect("atributos.jsp");
            }
            if (request.getParameter("btn_des") != null) {
                int dex = (int) (Math.random() * 20 + 1);
                character.setDextery(dex);
                response.sendRedirect("atributos.jsp");
            }
            if (request.getParameter("btn_int") != null) {
                int inte = (int) (Math.random() * 20 + 1);
                character.setIntelligence(inte);
                response.sendRedirect("atributos.jsp");
            }
            if (request.getParameter("btn_con") != null) {
                int con = (int) (Math.random() * 20 + 1);
                character.setConstitution(con);
                response.sendRedirect("atributos.jsp");
            }
            if (request.getParameter("btn_car") != null) {
                int car = (int) (Math.random() * 20 + 1);
                character.setCarism(car);
                response.sendRedirect("atributos.jsp");
            }
            if (request.getParameter("btn_sab") != null) {
                int sab = (int) (Math.random() * 20 + 1);
                character.setWisdom(sab);
                response.sendRedirect("atributos.jsp");
            }
            
            {//Bloque de código donde se establecerán las vidas extras según la clase
                ExtraHp extraHp = (ExtraHp) request.getSession().getAttribute("extrahp");
                if (character.getRace().getRaceName().equals("Humano")) {
                    System.out.println("Vidas extra Humano");
                    if (request.getParameter("btn_h1") != null) {
                        int h1 = (int) (Math.random() * 8 + 1);
                        extraHp.setH1(h1);
                        response.sendRedirect("atributos.jsp");
                    }
                    if (request.getParameter("btn_h2") != null) {
                        int h2 = (int) (Math.random() * 8 + 1);
                        extraHp.setH2(h2);
                        response.sendRedirect("atributos.jsp");
                    }
                    if (request.getParameter("btn_h3") != null) {
                        int h3 = (int) (Math.random() * 8 + 1);
                        extraHp.setH3(h3);
                        response.sendRedirect("atributos.jsp");
                    }
                }
                if (character.getRace().getRaceName().equals("Elfo")) {
                    System.out.println("Vidas extra Elfo");
                    if (request.getParameter("btn_e1") != null) {
                        int h1 = (int) (Math.random() * 12 + 1);
                        extraHp.setH1(h1);
                        response.sendRedirect("atributos.jsp");
                    }
                    if (request.getParameter("btn_e2") != null) {
                        int h2 = (int) (Math.random() * 12 + 1);
                        extraHp.setH2(h2);
                        response.sendRedirect("atributos.jsp");
                    }
                    if (request.getParameter("btn_e3") != null) {
                        int h3 = (int) (Math.random() * 12 + 1);
                        extraHp.setH3(h3);
                        response.sendRedirect("atributos.jsp");
                    }
                }
                if (character.getRace().getRaceName().equals("Enano")) {
                    System.out.println("Vidas extra Enano");
                    if (request.getParameter("btn_en1") != null) {
                        int h1 = (int) (Math.random() * 6 + 1);
                        extraHp.setH1(h1);
                        response.sendRedirect("atributos.jsp");
                    }
                    if (request.getParameter("btn_en2") != null) {
                        int h2 = (int) (Math.random() * 6 + 1);
                        extraHp.setH2(h2);
                        response.sendRedirect("atributos.jsp");
                    }
                    if (request.getParameter("btn_en3") != null) {
                        int h3 = (int) (Math.random() * 6 + 1);
                        extraHp.setH3(h3);
                        response.sendRedirect("atributos.jsp");
                    }
                }
                if (character.getRace().getRaceName().equals("Orco")) {
                    System.out.println("Vidas extra Orco");
                    if (request.getParameter("btn_o1") != null) {
                        int h1 = (int) (Math.random() * 6 + 1);
                        extraHp.setH1(h1);
                        response.sendRedirect("atributos.jsp");
                    }
                    if (request.getParameter("btn_o2") != null) {
                        int h2 = (int) (Math.random() * 6 + 1);
                        extraHp.setH2(h2);
                        response.sendRedirect("atributos.jsp");
                    }
                    if (request.getParameter("btn_o3") != null) {
                        int h3 = (int) (Math.random() * 6 + 1);
                        extraHp.setH3(h3);
                        response.sendRedirect("atributos.jsp");
                    }
                    if (request.getParameter("btn_o4") != null) {
                        int h4 = (int) (Math.random() * 6 + 1);
                        extraHp.setH4(h4);
                        response.sendRedirect("atributos.jsp");
                    }
                    if (request.getParameter("btn_o5") != null) {
                        int h5 = (int) (Math.random() * 6 + 1);
                        extraHp.setH5(h5);
                        response.sendRedirect("atributos.jsp");
                    }
                }
                
                
                if (request.getParameter("btn_guardar_psje") != null) {
                    System.out.println("Guardando personaje...");
                    int totalHp = extraHp.getH1() + extraHp.getH2() + extraHp.getH3() + extraHp.getH4() + extraHp.getH5();
                    
                    character.setLevelHpState(totalHp);
                    System.out.println("Hp Total = " + character.getHp());
                    System.out.println("Procesando personaje");
                    character.addCharacter();
                    System.out.println("Personaje agregado");
                    Player player = (Player) request.getSession().getAttribute("player");
                    player.setCharacter(character);
                    response.sendRedirect("usuario.jsp");
                }
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
