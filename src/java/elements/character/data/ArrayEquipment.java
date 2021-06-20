/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements.character.data;

import elements.character.Equipment;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Connect;

/**
 *
 * @author Alex A_R
 */
public class ArrayEquipment {
    
    public static ArrayList<Equipment> equipmentList = new ArrayList();
    
    public static void addEquipment(Equipment equip){
        equipmentList.add(equip);
    }
    
    public static ArrayList<Equipment> listEquipment(int idCharacter){
        Equipment equip = new Equipment();
        try {
            Connect con = new Connect();
            con.connectAsPlayer();
            ResultSet rs = con.state.executeQuery("SELECT * FROM equipamiento_personaje WHERE Personaje_idPersonaje = " + idCharacter+";");
            while (rs.next()){
                equip.setIdEquipment((int)rs.getObject(1));
                equip.setEquipmentName((String)rs.getObject(2));
                addEquipment(equip);
            }
        } catch (SQLException e){
            System.err.println("ERROR: "+e);
        }
        return equipmentList;
    }
}
