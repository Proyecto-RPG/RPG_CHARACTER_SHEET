/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements.character.data;

import elements.character.Skill;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Connect;

/**
 *
 * @author Alex A_R
 */
public class ArraySkill {
    
    public static ArrayList<Skill> skillList = new ArrayList();
    
    public static void addSkill (Skill skill){
        skillList.add(skill);
    }
    
    public static ArrayList<Skill> listSkill(int idCharacter){
        ArraySkill.skillList = new ArrayList();
        Skill skill  = new Skill();
        try {
            Connect con = new Connect();
            con.connectAsPlayer();
            ResultSet rs = con.state.executeQuery("SELECT * FROM habilidad_personaje WHERE Personaje_idPersonaje = '" + idCharacter+"';");
            while (rs.next()){
                skill = Skill.searchSkill((int) rs.getObject(1));
                addSkill(skill);
            }
        } catch (SQLException e){
            System.err.println("ERROR: "+e);
        }
        return skillList;
    }
}
