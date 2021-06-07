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
public class Player extends User{

    public Player() {
    }

    public Player(String nickname, String password, int typeUser) {
        super(nickname, password, typeUser);
    }
}
