/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements.users;

import elements.character.Character;


/**
 *
 * @author Alex A_R
 */
public class Player extends User {

    private Character character;

    public Player() {
    }

    public Player(String nickname, String password, int typeUser, Character character) {
        super(nickname, password, typeUser);

        this.character = character;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}
