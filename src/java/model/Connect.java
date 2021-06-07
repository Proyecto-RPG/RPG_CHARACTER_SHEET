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
    public void connectAsPlayer(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://%:3306/proyecto_rpg","PLAYER","$player");
            state = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
//  Conexión a base de datos desde usuario Game Master
    public void connectAsGameMaster(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://%:3306/proyecto_rpg","GAME_MASTER","$gamemaster");
            state = con.createStatement();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
//  Conexión a la base de datos desde un usuario Guest (1° instancia al ejecutar el programa)
    public void connectAsGuest(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://%:3306/proyecto_rpg","GUEST","$guest");
            state = con.createStatement();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
