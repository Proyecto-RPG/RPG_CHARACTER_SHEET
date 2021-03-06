/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;


import elements.users.*;
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
public class SessionManager extends HttpServlet {

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
            Guest guest = new Guest();

//            Captura el parametro de login, crea un objeto y lo captura en una sesion
            if (request.getParameter("btn_login") != null) {
                String nickname = request.getParameter("txt_nickname");
                String password = request.getParameter("txt_password");
                System.out.println("Parametros capturados");

                User user = guest.signIn(nickname, password);
                HttpSession session = request.getSession();

                if (user != null) {
                    System.out.println("User no es nulo");
                    if (user.getTypeUser() == 2) {
                        System.out.println("User es de tipo Player");

                        Player player = new Player();
                        player.setNickname(nickname);
                        player.setPassword(password);
                        player.setTypeUser(2);
                        player.setIdUser(user.getIdUser());

                        System.out.println("User -> Player");
                        session.setAttribute("user", player);
                        System.out.println("Session con obj Player de nombre: "+player.getNickname());
                        response.sendRedirect("usuario.jsp");
                    } else if (user.getTypeUser() == 3) {
                        GameMaster gameMaster = (GameMaster) user;
                        session.setAttribute("user", gameMaster);
                        response.sendRedirect("");//Redireccion a panel de gamemaster
                    }
                } else {
                    response.sendRedirect("index.html?login=" + "false");
                }
            }
//            Captura parametros de registro, los ingresa al metodo signUp y 
//              redirecciona si es Player.
            if (request.getParameter("btn_register") != null) {
                User user = new User();
                String nickanme = request.getParameter("txt_nickname");
                String password = request.getParameter("txt_password");
                int typeUser = Integer.valueOf(request.getParameter("cb_typeuser"));
                user = guest.signUp(nickanme, password, typeUser);
                HttpSession session = request.getSession();
                
                if (typeUser == 2) {
                    Player player = new Player();
                    player.setIdUser(user.getIdUser());
                    player.setNickname(user.getNickname());
                    player.setPassword(user.getPassword());
                    player.setTypeUser(typeUser);
                    
                    session.setAttribute("user", player);
                    response.sendRedirect("usuario.jsp");
                } else if (typeUser == 3) {
                    GameMaster gameMaster = (GameMaster)guest.signUp(nickanme, password, typeUser);
                    session.setAttribute("user", gameMaster);
                    System.out.println("Usuario gamemaster registrado");
                }
            }
            
//            Cierra la sesi??n
            if (request.getParameter("btn_logout")!=null) {
                HttpSession session = request.getSession();
                Player player = (Player)session.getAttribute("user");
                session.invalidate();
                System.out.println("Sesion cerrada");
                out.println("<script>alert(Sesion Cerrada)</script>");
                response.sendRedirect("index.html");
            }
        } catch (Exception e) {
            System.err.println("ERROR: "+e);
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
