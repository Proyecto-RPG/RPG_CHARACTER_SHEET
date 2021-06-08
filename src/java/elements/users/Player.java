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
public class Player extends User{
    private int idUser;
    private Character character;
    
    public Player() {
    }
    
    public Player(String nickname, String password, int typeUser){
        super(nickname, password, typeUser);
        this.idUser = super.getIdUser();
    }
    
    

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
//    Método para mostrar los personajes del usuario
    public boolean listCharacter(User user){
        try{
            Connect con = new Connect();
            con.connectAsPlayer();
            ResultSet rs = Connect.state.executeQuery("SELECT  FROM usuario"
                    + "WHERE idUsuario = "+user.getIdUser()+";");
            if (rs.next()) {
                
            }
        }catch(SQLException e){
            System.err.println("ERROR: "+e);
        }
            
        return true;
    }
    
}
