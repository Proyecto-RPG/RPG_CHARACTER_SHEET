/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements.users;

import elements.character.data.ArrayCharacter;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Connect;

/**
 *
 * @author Alex A_R
 */
public class Player extends User {

    private int idUser;
    private Character character;

    public Player() {
    }

    public Player(String nickname, String password, int typeUser, Character character) {
        super(nickname, password, typeUser);
        this.idUser = super.getIdUser();
        this.character = character;
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

/*  Método para mostrar los personajes del usuario si existen y alojarlos en un ArrayList. Si no, entonces
    retorna un falso. */
    public boolean listCharacter(User user) {
        boolean existCharacter = true;
        try {
            Connect con = new Connect();
            con.connectAsPlayer();
            ResultSet rs = Connect.state.executeQuery("SELECT * FROM personaje"
                    + "WHERE Usuario_idUsuario = " + user.getIdUser() + ";");
            if (rs.next()) {
                ArrayCharacter.addCharacter(character);
            }else{
                existCharacter = false;
            }
        } catch (SQLException e) {
            System.err.println("ERROR: " + e);
        }
        return existCharacter;
    }
}
