/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements.users;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.Connect;

/**
 *
 * @author Alex A_R
 */
public class Guest extends Connect {

//    Metodo para registrar una cuenta de usuario
    public User signUp(String nickname, String password, int typeUser) {
        int validate = 0;
        Connect con = new Connect();
        con.connectAsGuest();
        User user = new User();
        try {
            validate = state.executeUpdate("INSERT INTO usuario "
                    + " VALUES(NULL,'" + nickname + "','" + password + "','" + typeUser + "');");
        } catch (SQLException e) {
            System.err.println("ERROR: " + e);
        }
        if (validate != 0) {
            try {
                ResultSet rs = state.executeQuery("SELECT * FROM usuario WHERE nombre_usuario "
                        + "LIKE '" + nickname + "' AND pass_usuario LIKE '" + password + "';");
                while (rs.next()) {
                    user.setIdUser((int) rs.getObject(1));
                    user.setNickname((String) rs.getObject(2));
                    user.setPassword((String) rs.getObject(3));
                    user.setTypeUser((int) rs.getObject(4));
                }
            } catch (SQLException e) {
                System.err.println("ERROR: " + e);
            }
        }
        return user;
    }

//  Método para ingresar una cuenta creada
    public User signIn(String nickname, String password) throws SQLException {
        User user = new User();
        try {
            Connect con = new Connect();
            con.connectAsGuest();

//          Query para buscar un registro con el nickname y password ingresados
            ResultSet rs = state.executeQuery("SELECT * FROM usuario "
                    + "WHERE nombre_usuario LIKE '" + nickname + "'  AND pass_usuario LIKE '" + password + "';");
            System.out.println("Usuario encontrado");
            while (rs.next()) {
                user.setIdUser((int) rs.getObject(1));
                System.out.println("User id: " + user.getIdUser());
                user.setNickname((String) rs.getObject(2));
                System.out.println("User Nickname: " + user.getNickname());
                user.setPassword((String) rs.getObject(3));
                System.out.println("User Password: " + user.getPassword());
                user.setTypeUser((int) rs.getObject(4));
                System.out.println("User Tipo: " + user.getTypeUser());
            }
            Connect.con.close();
        } catch (SQLException e) {
            System.err.println("ERROR: " + e);
        }
        return user;
    }
}
