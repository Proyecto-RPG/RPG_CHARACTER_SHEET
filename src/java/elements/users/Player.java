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
    private Character character2;
    private Character character3;
    private Character character4;

    
    
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
    public Character getCharacter2() {
        return character2;
    }

    public void setCharacter2(Character character2) {
        this.character2 = character2;
    }

    public Character getCharacter3() {
        return character3;
    }

    public void setCharacter3(Character character3) {
        this.character3 = character3;
    }

    public Character getCharacter4() {
        return character4;
    }

    public void setCharacter4(Character character4) {
        this.character4 = character4;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
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
