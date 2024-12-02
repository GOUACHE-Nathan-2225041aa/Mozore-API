package com.le_bar_des_menteurs.server.models;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.UUID;

public class Player {

    private String token;
    private String name;
    private boolean alive = true;
    private int bullets = 6;

    private ArrayList<Card> cards = new ArrayList<>();

    public Player(String name) {
        this.name = name;
        token = UUID.randomUUID().toString();
    }

    public String getToken() {
        return token;
    }

    public void addCard(Card card)
    {
        cards.add(card);
    }

    public void removecard(Card card)
    {
        cards.remove(card);
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
