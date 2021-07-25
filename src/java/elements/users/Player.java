package elements.users;

import elements.character.Character;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.*;

public class Player extends User {

    private Character character;

    public Player() {
    }

    public Player(Character character, int idUser, String nickname, String password, int typeUser) {
        super(idUser, nickname, password, typeUser);
        this.character = character;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
    
    public boolean searchCharacter(int idUser){
        boolean exist = false;
        try{
            Connect con = new Connect();
            con.connectAsPlayer();
            ResultSet rs = Connect.state.executeQuery("SELECT * FROM personaje WHERE Usuario_id_Usuario = "+idUser+";");
            if (rs.next()) {
                exist = true;
            }
        }catch (SQLException e){
            System.err.println("ERROR: " + e);
        }
        return exist;
    }
    
    

    
    
}
