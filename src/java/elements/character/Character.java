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
public class Character {

//  Atributos presentes en la base de datos
    private int idCharacter;
    private String characterName;
    private String characterGender;
    private int hp;
    private int level;
    private String state;
    private int dextery;
    private int strong;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int carism;
    private int User_idUser;
    private int Race_idRace;
    private int Class_idClass;

//  Atributos de la mecánica del juego
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

    public String getCharacterGender() {
        return characterGender;
    }

    public void setCharacterGender(String characterGender) {
        this.characterGender = characterGender;
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

    public int getDextery() {
        return dextery;
    }

    public void setDextery(int dextery) {
        this.dextery = dextery;
    }

    public int getStrong() {
        return strong;
    }

    public void setStrong(int strong) {
        this.strong = strong;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCarism() {
        return carism;
    }

    public void setCarism(int carism) {
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

    public void searchCharacter() {

    }

    public void characterSetZeroStat() {
        this.setStrong(0);
        System.out.println("Strong: " + this.getStrong());
        this.setCarism(0);
        System.out.println("Carism: " + this.getCarism());
        this.setDextery(0);
        System.out.println("Dextery: " + this.getDextery());
        this.setConstitution(0);
        System.out.println("Constitution: " + this.getConstitution());
        this.setIntelligence(0);
        System.out.println("Intelligence: " + this.getIntelligence());
        this.setWisdom(0);
        System.out.println("Wisdom: " + this.getWisdom());

    }

    public void setLevelHpState(int extraHp) {
        this.setLevel(1);
        System.out.println("Level: " + this.getLevel());
        this.setState("Vivo");
        System.out.println("State: " + this.getState());
        this.setHp(50 + extraHp);
        System.out.println("Health Points: " + this.getHp());
    }

    public void addCharacter() {
        int idEquip = this.getEquip().getIdEquipment();
        int idUser = this.getUser_idUser();

        int idSkill = this.getSkill().getIdSkill();

        try {
            this.getCharacterGender();
            Connect con = new Connect();
            con.connectAsPlayer();
            int rs;
            rs = Connect.state.executeUpdate("INSERT INTO personaje VALUES(NULL,'"
                    + this.getCharacterName() + "','" + this.getCharacterGender() + "',"
                    + this.getHp() + "," + this.getLevel() + ",'" + this.getState() + "',"
                    + this.getDextery() + "," + this.getStrong() + "," + this.getConstitution() + ","
                    + this.getIntelligence() + "," + this.getWisdom() + "," + this.getCarism() + ","
                    + idUser + "," + this.getRace_idRace() + "," + this.getClass_idClass() + ");");
        } catch (SQLException e) {
            System.err.println("ERROR (Tabla personaje): " + e);
        }
        try {
            int rs;
            Connect con = new Connect();
            con.connectAsPlayer();
            ResultSet res = Connect.state.executeQuery("SELECT idPersonaje FROM personaje WHERE Usuario_id_Usuario = " + idUser);
            while (res.next()) {
                this.setIdCharacter((int) res.getObject(1));
            }
            int idCharacter = this.getIdCharacter();

            rs = Connect.state.executeUpdate("INSERT INTO equipamiento_personaje VALUES(" + idUser + "," + idEquip + "," + idCharacter + ");");
            rs = Connect.state.executeUpdate("INSERT INTO habilidad_personaje VALUES(" + idSkill + "," + idCharacter + "," + idUser + ");");

        } catch (SQLException e) {
            System.err.println("ERROR (Tablas intermedias): " + e);
        }
    }
    
    
}
