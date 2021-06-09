/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements.character;

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
    
    
}
