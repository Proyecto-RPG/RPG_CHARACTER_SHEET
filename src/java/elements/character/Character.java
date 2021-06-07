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
    private Race race;
    private Skill skill;
    
    public Character() {
    }

    public Character(int idCharacter, String characterName, int hp, int level, String state, String dextery, String strong, String constitution, String intelligence, String wisdom, String carism, int User_idUser, int Race_idRace, int Class_idClass, Classes cls, Equipment equip, Race race, Skill skill) {
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
    
    
            
}
