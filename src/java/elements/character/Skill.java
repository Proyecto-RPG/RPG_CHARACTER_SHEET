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
    
    
}
