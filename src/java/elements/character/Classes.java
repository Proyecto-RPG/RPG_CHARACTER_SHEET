/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements.character;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.Connect;

/**
 *
 * @author Alex A_R
 */
public class Classes {

    private int idClass;
    private String className;

    public Classes() {
    }

    public Classes(int idClass, String className) {
        this.idClass = idClass;
        this.className = className;

    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

//  Busca una clase por nombre para asignarla al personaje en creación
    public static Classes assignClass(String cls){
        Classes clss = new Classes();
        try {
            Connect con = new Connect();
            con.connectAsPlayer();
            ResultSet rs = con.state.executeQuery("SELECT * FROM clase WHERE nombre_clase LIKE '" + cls + "';");
            while (rs.next()) {
                clss.setIdClass((int) rs.getObject(1));
                clss.setClassName((String) rs.getObject(2));
            }
            Connect.con.close();
        } catch (SQLException e) {
            System.err.println("ERROR: " + e);
        }
        return clss;
    }
    
//  Busca una clase para visualizar tarjetas de personajes creados en el menu de usuario
    public static Classes searchClass(int idClass){
        Classes cls = new Classes();
        try {
            Connect con = new Connect();
            con.connectAsPlayer();
            ResultSet rs = con.state.executeQuery("SELECT * FROM clase WHERE idClase = "+idClass+";");
            while (rs.next()){
                cls.setIdClass((int)rs.getObject(1));
                cls.setClassName((String)rs.getObject(2));
            }
            Connect.con.close();
        } catch (SQLException e){
            System.err.println("ERROR: " +e);
        }
        return cls;
    }
}
