package model.entity;

import model.Move;

import java.util.ArrayList;

public class Player {

    private String nombre;
    private int hp;
    private ArrayList<Move> moves;

    public Player(String nombre) {
        this.nombre = nombre;
        this.hp = 15;
        this.moves = null;
    }
}
