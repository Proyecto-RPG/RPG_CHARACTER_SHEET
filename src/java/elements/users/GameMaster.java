package elements.users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Connect;
import elements.character.Character;
import elements.character.Classes;
import elements.character.Race;


public class GameMaster extends User {

    public GameMaster() {
    }

    public GameMaster(int idUser, String nickname, String password, int typeUser) {
        super(idUser, nickname, password, typeUser);
    }
    
    public String getUserOwner(int idUser){
        String userOwner = new String();
        try{
            Connect con = new Connect();
            con.connectAsGameMaster();
            ResultSet rs = Connect.state.executeQuery("SELECT nombre_usuario FROM usuario WHERE idUsuario = "+idUser+";");
            if (rs.next()) {
                userOwner = (String)rs.getObject(1);
            }   
        }catch (SQLException e){
            System.err.println("ERROR getUserOwner: "+e);
        }
        return  userOwner;
    }


    public static ArrayList<Character> listCharacter(){
        ArrayList<Character> characterList = null;
        try{
            Connect con = new Connect();
            con.connectAsGameMaster();
            ResultSet rs = Connect.state.executeQuery("SELECT * FROM personaje;");
            characterList = new ArrayList();
            while(rs.next()){
                Character charac = new Character();
                charac.setIdCharacter((int)rs.getObject(1));
                charac.setCharacterName((String)rs.getObject(2));
                charac.setLevel((int)rs.getObject(5));
                charac.setUser_idUser((int) rs.getObject(13));
                charac.setRace_idRace((int)rs.getObject(14));
                charac.setRace(Race.searchIdRace(charac.getRace_idRace()));
                charac.setClass_idClass((int) rs.getObject(15));
                charac.setCls(Classes.searchClass(charac.getClass_idClass()));
                characterList.add(charac);
            }
        }catch (SQLException e){
            System.err.println("GameMaster listCharacter ERROR : " + e);
        }
        
        return characterList;
    }
}
