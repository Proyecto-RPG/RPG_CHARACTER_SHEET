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

}
