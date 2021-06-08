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
public class Classes {
    private int idClass;
    private String className;
    private String classMod;

    public Classes() {
    }

    public Classes(int idClass, String className, String classMod) {
        this.idClass = idClass;
        this.className = className;
        this.classMod = classMod;
    }

    public String getClassMod() {
        return classMod;
    }

    public void setClassMod(String classMod) {
        this.classMod = classMod;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    
    
}
