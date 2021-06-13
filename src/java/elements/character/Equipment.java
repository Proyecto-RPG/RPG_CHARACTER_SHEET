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
public class Equipment {

    private int idEquipment;
    private String equipmentName;

    public Equipment() {
    }

    public Equipment(int idEquipment, String equipmentName) {
        this.idEquipment = idEquipment;
        this.equipmentName = equipmentName;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public int getIdEquipment() {
        return idEquipment;
    }

    public void setIdEquipment(int idEquipment) {
        this.idEquipment = idEquipment;
    }
    
    public static Equipment searchEquip (int idEquip){
        Equipment equip = new Equipment();
        try{
            Connect con = new Connect();
            con.connectAsPlayer();
            ResultSet rs = con.state.executeQuery("SELECT * FROM equipamiento WHERE idEquipamiento = "+idEquip+";");
            while (rs.next()){
                equip.setIdEquipment((int)rs.getObject(1));
                equip.setEquipmentName((String)rs.getObject(2));
            }
        }catch (SQLException e){
            System.err.println("ERROR: "+e);
        }
        return equip;
    }
}
