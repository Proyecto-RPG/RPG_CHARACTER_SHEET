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
public class Character {
    private int idCharacter;
    private String characterName;
    private int hp;
    private int level;
    private String state;
    private String dextery;
    private String strong;
    private String constitution;
    private String intelligence;
    private String wisdom;
    private String carism;
    private int User_idUser;
    private int Race_idRace;
    private int Class_idClass;
    private Classes cls;
    private Equipment equip;
    private Equipment equip2;
    private Equipment equip3;
    private Equipment equip4;
    private Equipment equip5;
    private Equipment equip6;
    private Equipment equip7;
    private Equipment equip8;
    private Race race;
    private Skill skill;
    private Skill skill2;
    private Skill skill3;
    private Skill skill4;

    
    public Character() {
    }

    public Character(int idCharacter, String characterName, int hp, int level,
            String state, String dextery, String strong, String constitution, 
            String intelligence, String wisdom, String carism, int User_idUser,
            int Race_idRace, int Class_idClass, Classes cls, Equipment equip,
            Race race, Skill skill, Skill skill2) {
        this.idCharacter = idCharacter;
        this.characterName = characterName;
        this.hp = hp;
        this.level = level;
        this.state = state;
        this.dextery = dextery;
        this.strong = strong;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.carism = carism;
        this.User_idUser = User_idUser;
        this.Race_idRace = Race_idRace;
        this.Class_idClass = Class_idClass;
        this.cls = cls;
        this.equip = equip;
        this.race = race;
        this.skill = skill;
        this.skill2 = skill2;
    }

    

    public int getClass_idClass() {
        return Class_idClass;
    }

    public void setClass_idClass(int Class_idClass) {
        this.Class_idClass = Class_idClass;
    }

    public int getIdCharacter() {
        return idCharacter;
    }

    public void setIdCharacter(int idCharacter) {
        this.idCharacter = idCharacter;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDextery() {
        return dextery;
    }

    public void setDextery(String dextery) {
        this.dextery = dextery;
    }

    public String getStrong() {
        return strong;
    }

    public void setStrong(String strong) {
        this.strong = strong;
    }

    public String getConstitution() {
        return constitution;
    }

    public void setConstitution(String constitution) {
        this.constitution = constitution;
    }

    public String getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    public String getWisdom() {
        return wisdom;
    }

    public void setWisdom(String wisdom) {
        this.wisdom = wisdom;
    }

    public String getCarism() {
        return carism;
    }

    public void setCarism(String carism) {
        this.carism = carism;
    }

    public int getUser_idUser() {
        return User_idUser;
    }

    public void setUser_idUser(int User_idUser) {
        this.User_idUser = User_idUser;
    }

    public int getRace_idRace() {
        return Race_idRace;
    }

    public void setRace_idRace(int Race_idRace) {
        this.Race_idRace = Race_idRace;
    }

    public Classes getCls() {
        return cls;
    }

    public void setCls(Classes cls) {
        this.cls = cls;
    }

    public Equipment getEquip() {
        return equip;
    }

    public void setEquip(Equipment equip) {
        this.equip = equip;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Equipment getEquip2() {
        return equip2;
    }

    public void setEquip2(Equipment equip2) {
        this.equip2 = equip2;
    }

    public Equipment getEquip3() {
        return equip3;
    }

    public void setEquip3(Equipment equip3) {
        this.equip3 = equip3;
    }

    public Equipment getEquip4() {
        return equip4;
    }

    public void setEquip4(Equipment equip4) {
        this.equip4 = equip4;
    }

    public Equipment getEquip5() {
        return equip5;
    }

    public void setEquip5(Equipment equip5) {
        this.equip5 = equip5;
    }

    public Equipment getEquip6() {
        return equip6;
    }

    public void setEquip6(Equipment equip6) {
        this.equip6 = equip6;
    }

    public Equipment getEquip7() {
        return equip7;
    }

    public void setEquip7(Equipment equip7) {
        this.equip7 = equip7;
    }

    public Equipment getEquip8() {
        return equip8;
    }

    public void setEquip8(Equipment equip8) {
        this.equip8 = equip8;
    }

    public Skill getSkill2() {
        return skill2;
    }

    public void setSkill2(Skill skill2) {
        this.skill2 = skill2;
    }

    public Skill getSkill3() {
        return skill3;
    }

    public void setSkill3(Skill skill3) {
        this.skill3 = skill3;
    }

    public Skill getSkill4() {
        return skill4;
    }

    public void setSkill4(Skill skill4) {
        this.skill4 = skill4;
    }
        
}
