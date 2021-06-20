/*
 *Conexión a la Base de Datos
 */
package model;

import java.sql.*;

/**
 *
 * @author Alex A_R
 */
public class Connect {

    public static Connection con;
    public static Statement state;

//  Conexión a base de datos desde usuario Jugador
    public void connectAsPlayer() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/proyecto_rpg", "PLAYER", "$player");
            state = con.createStatement();
            System.out.println("Conexión establecida por PLAYER");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.err.println("Error: " + e);
        }
    }

//  Conexión a base de datos desde usuario Game Master
    public void connectAsGameMaster() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/proyecto_rpg", "GAME_MASTER", "$gamemaster");
            state = con.createStatement();
            System.out.println("Conexión establecida por GAMEMASTER");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.err.println("Error: " + e);
        }
    }

//  Conexión a la base de datos desde un usuario Guest (1° instancia al ejecutar el programa)
    public void connectAsGuest() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/proyecto_rpg", "GUEST", "$guest");
            state = con.createStatement();
            System.out.println("Conexión establecida por GUEST");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.err.println("Error: " + e);
        }
    }
}
