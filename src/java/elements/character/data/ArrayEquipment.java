package elements.character.data;

import elements.character.Equipment;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Connect;

public class ArrayEquipment {
    
    public static ArrayList<Equipment> equipmentList = new ArrayList();
    
    public static void addEquipment(Equipment equip){
        equipmentList.add(equip);
    }
    
    public static ArrayList<Equipment> listEquipment(int idCharacter){
        ArrayEquipment.equipmentList = new ArrayList();
        Equipment equip = new Equipment();
        try {
            Connect con = new Connect();
            con.connectAsPlayer();
            ResultSet rs = con.state.executeQuery("SELECT * FROM equipamiento_personaje WHERE Personaje_idPersonaje = " + idCharacter+";");
            while(rs.next()){
                addEquipment(Equipment.searchEquip(idCharacter));
            }
        } catch (SQLException e){
            System.err.println("ERROR: "+e);
        }
        return equipmentList;
    }
}
