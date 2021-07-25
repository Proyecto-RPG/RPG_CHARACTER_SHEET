/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements.character.data;

import elements.character.Character;
import elements.character.Classes;
import elements.character.Equipment;
import elements.character.Race;
import elements.character.Skill;
import elements.users.Player;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Connect;

/**
 *
 * @author Alex A_R
 */
public class ArrayCharacter {

    public static ArrayList<Character> characterList = new ArrayList();

    public static void addCharacter(Character character) {
        characterList.add(character);
    }

    public static ArrayList<Character> displayCharacter() {
        return characterList;
    }

    public static ArrayList<Character> searchCharacter(Player player) {
        ArrayCharacter.characterList = new ArrayList();
        try {
            Connect con = new Connect();
            con.connectAsPlayer();
            ResultSet rs = Connect.state.executeQuery("SELECT * FROM personaje "
                    + "WHERE Usuario_id_Usuario = " + player.getIdUser() + ";");
            while (rs.next()) {
                Character character = new Character();
                character.setIdCharacter((int) rs.getObject(1));
                character.setCharacterName((String) rs.getObject(2));
                character.setCharacterGender((String) rs.getObject(3));
                character.setHp((int) rs.getObject(4));
                character.setLevel((int) rs.getObject(5));
                character.setState((String) rs.getObject(6));
                character.setDextery((int) rs.getObject(7));
                character.setStrong((int) rs.getObject(8));
                character.setConstitution((int) rs.getObject(9));
                character.setIntelligence((int) rs.getObject(10));
                character.setWisdom((int) rs.getObject(11));
                character.setCarism((int) rs.getObject(12));
                character.setUser_idUser((int) rs.getObject(13));
                character.setRace_idRace((int) rs.getObject(14));
                character.setClass_idClass((int) rs.getObject(15));
                character.setCls(Classes.searchClass(character.getClass_idClass()));

//                Recorre el arreglo de Equipamientos y dependiendo de la cantidad de elementos del arreglo
//                lo asigna a su respectivo atributo en la clase Character.
                
                for (Equipment equip : ArrayEquipment.listEquipment(character.getIdCharacter())) {
                    switch (ArrayEquipment.equipmentList.indexOf(equip)) {
                        case 0:
                            character.setEquip(equip);
                            System.out.println("Equipamiento 1: " + equip.getEquipmentName());
                            break;
                        case 1:
                            character.setEquip2(equip);
                            System.out.println("Equipamiento 2: " + equip.getEquipmentName());
                            break;
                        case 2:
                            character.setEquip3(equip);
                            System.out.println("Equipamiento 3: " + equip.getEquipmentName());
                            break;
                        case 3:
                            character.setEquip4(equip);
                            System.out.println("Equipamiento 4: " + equip.getEquipmentName());
                            break;
                        case 4:
                            character.setEquip5(equip);
                            System.out.println("Equipamiento 5: " + equip.getEquipmentName());
                            break;
                        case 5:
                            character.setEquip6(equip);
                            System.out.println("Equipamiento 6: " + equip.getEquipmentName());
                            break;
                        case 6:
                            character.setEquip7(equip);
                            System.out.println("Equipamiento 7: " + equip.getEquipmentName());
                            break;
                        case 7:
                            character.setEquip8(equip);
                            System.out.println("Equipamiento 8: " + equip.getEquipmentName());
                            break;
                        default:
                            break;
                    }
                }
                character.setRace(Race.searchIdRace(character.getRace_idRace()));

                for (Skill skill : ArraySkill.listSkill(character.getIdCharacter())) {
                    switch (ArraySkill.skillList.indexOf(skill)) {
                        case 0:
                            character.setSkill(skill);
                            System.out.println("Habilidad 1: " + skill.getSkillName());
                            break;
                        case 1:
                            character.setSkill2(skill);
                            System.out.println("Habilidad 2: " + skill.getSkillName());
                            break;
                        case 2:
                            character.setSkill3(skill);
                            System.out.println("Habilidad 3: " + skill.getSkillName());
                            break;
                        case 3:
                            character.setSkill4(skill);
                            System.out.println("Habilidad 4: " + skill.getSkillName());
                            break;
                        default:
                            break;
                    }
                }
                addCharacter(character);
            }
        } catch (SQLException e) {
            System.err.println("ERROR: " + e);
        }
        return characterList;
    }
}