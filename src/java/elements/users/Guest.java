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
public class Guest {

//    Metodo para registrar una cuenta de usuario
    public boolean signUp(String nickname, String password, int typeUser) {
        int validate = 0;
        Connect con = new Connect();
        con.connectAsGuest();
        
        if (typeUser == 2) { //      typeUser = 2 corresponde al ID de Player
            try {
                validate = Connect.state.executeUpdate("INSERT INTO usuario "
                        + " VALUES('NULL','" + nickname + "','" + password + "','" + typeUser + "');");
            } catch (SQLException e) {
            }

        } else if (typeUser == 3) { //      typeUser = 3 corresponde al ID de GameMaster
            try {
                validate = Connect.state.executeUpdate("INSERT INTO usuario "
                        + "VALUES('NULL','" + nickname + "','" + password + "','" + typeUser + "');");
            } catch (SQLException e) {
            }
        }
        return validate != 0;
    }

//  Método para ingresar una cuenta creada
    public User signIn(String nickname, String password) throws SQLException{
        try {
            Connect con = new Connect();
            con.connectAsGuest();
            User user = new User();
            ResultSet rs = Connect.state.executeQuery("SELECT * FROM usuario "
                + "WHERE nombre_usuario LIKE '"+ nickname +"'  AND pass_usuario LIKE '" + password + "';");
            if (rs.next()) {
                System.out.println("Usuario encontrado");
                while (rs.next()) {
                    user.setNickname((String) rs.getObject(1));
                    user.setPassword((String) rs.getObject(2));
                    user.setTypeUser((int) rs.getObject(3));
                }
            return user;
            } else {
                System.out.println("Usuario no encontrado");
            }
            
        } catch (SQLException e) {
            System.err.println("ERROR: "+e);
        }
        return null;
    }
}
