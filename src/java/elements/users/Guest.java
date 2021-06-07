/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements.users;

import model.Connect;

/**
 *
 * @author Alex A_R
 */
public class Guest{
    
//    Metodo para registrar una cuenta de usuario
    public boolean signUp(String nickname, String password, int typeUser){
        int validate = 0;
        Connect con = new Connect();
        con.connectAsGuest();
//      typeUser = 2 corresponde al ID de Player
        if (typeUser==2){
            try{
                validate = Connect.state.executeUpdate("INSERT INTO 'usuario' "
                        + "('idUsuario', 'nombre_usuario', 'pass_usuario', 'Tipo_usuario')"
                        + " VALUES('NULL','"+nickname+"','"+password+"','"+typeUser+"');");
            }catch(Exception e){
                e.printStackTrace();
            }
//      typeUser = 3 corresponde al ID de GameMaster
        }else if (typeUser==3){
            try{
                validate = Connect.state.executeUpdate("INSERT INTO 'usuario' "
                        + "('idUsuario','nombre_usuario','pass_usuario','Tipo_usuario') "
                        + "VALUES('NULL','"+nickname+"','"+password+"','"+typeUser+"');");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return validate!=0;
    }
    
    public boolean signIn(String nickname, String password){
        int validate = 0;
        Connect con = new Connect();
        con.connectAsGuest();
        try{
            validate = Connect.state.executeUpdate("SELECT * FROM usuario"
                    + "WHERE nombre_usuario ="+nickname+" AND pass_usuario ="+password+";");
        }catch (Exception e){
            e.printStackTrace();
        }
        return validate!=0;
    }
}
