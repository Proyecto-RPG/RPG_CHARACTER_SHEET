/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements.users;

/**
 *
 * @author Alex A_R
 */
public class User {

    private int idUser;
    private String nickname;
    private String password;
    private int typeUser;

    public User() {
    }

    public User(String nickname, String password, int typeUser) {
        this.nickname = nickname;
        this.password = password;
        this.typeUser = typeUser;
    }

    public int getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(int typeUser) {
        this.typeUser = typeUser;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

}
