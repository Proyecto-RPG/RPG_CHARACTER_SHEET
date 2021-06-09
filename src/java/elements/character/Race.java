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
public class Race {

    private int idRace;
    private String raceName;
    private String diceHp;

    public Race() {
    }

    public int getIdRace() {
        return idRace;
    }

    public void setIdRace(int idRace) {
        this.idRace = idRace;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public String getDieHp() {
        return diceHp;
    }

    public void setDieHp(String dieHp) {
        this.diceHp = dieHp;
    }

//    Busca una raza por nombre en la base de datos, y devuelve un objeto Race
    public static Race searchRace(String race) {
        Race race1 = new Race();
        try {
            Connect con = new Connect();
            con.connectAsPlayer();
            ResultSet rs = Connect.state.executeQuery("SELECT * FROM raza WHERE nombre_raza LIKE '" + race + "';");
            while (rs.next()) {
                race1.setIdRace((int) rs.getObject(1));
                race1.setRaceName((String) rs.getObject(2));
                race1.setDieHp((String) rs.getObject(3));
            }
            Connect.con.close();
        } catch (SQLException e) {
            System.err.println("ERROR: " + e);
        }
        return race1;
    }
    
    public static Race searchIdRace (int idRace){
        Race race = new Race();
        try {
            Connect con = new Connect();
            con.connectAsPlayer();
            ResultSet rs = Connect.state.executeQuery("SELECT * FROM raza WHERE idRaza="+idRace+";");
            while (rs.next()){
                race.setIdRace((int) rs.getObject(1));
                race.setRaceName((String) rs.getObject(2));
                race.setDieHp((String) rs.getObject(3));
            }
        }catch (SQLException e){
            System.err.println("ERROR: "+e);
        }
        return race;
    }
}
