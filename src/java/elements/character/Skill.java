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
public class Skill {

    private int idSkill;
    private String skillName;
    private String skillMod;
    private int Class_idClass;

    public Skill() {
    }

    public Skill(int idSkill, String skillName, String skillMod, int Class_idClass) {
        this.idSkill = idSkill;
        this.skillName = skillName;
        this.skillMod = skillMod;
        this.Class_idClass = Class_idClass;
    }

    public int getClass_idClass() {
        return Class_idClass;
    }

    public void setClass_idClass(int Class_idClass) {
        this.Class_idClass = Class_idClass;
    }

    public int getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(int idSkill) {
        this.idSkill = idSkill;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillMod() {
        return skillMod;
    }

    public void setSkillMod(String skillMod) {
        this.skillMod = skillMod;
    }
    
    public static Skill searchSkill(int skillId){
        Skill skill = new Skill();
        try {
            Connect con = new Connect();
            con.connectAsPlayer();
            ResultSet rs = con.state.executeQuery("SELECT * FORM habilidades WHERE idHabilidad = "+skillId+";");
            while(rs.next()){
                skill.setIdSkill((int)rs.getObject(1));
                skill.setSkillName((String)rs.getObject(2));
                skill.setSkillMod((String)rs.getObject(3));
                skill.setClass_idClass((int)rs.getObject(4));
            }
        }catch (SQLException e){
            System.err.println("ERROR: "+e);
        }
        return skill;
    }
    
}
