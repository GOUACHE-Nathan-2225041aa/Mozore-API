package com.le_bar_des_menteurs.server.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.UUID;

public class Player {

    private transient String token;

    private String name;

    private boolean alive = false;

    private int bullets = 6;

    private transient ArrayList<Card> cards = new ArrayList<>();

    public Player(String name) {
        this.name = name;
        token = UUID.randomUUID().toString();
    }

    public String getToken() {
        return token;
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card)
    {
        cards.add(card);
    }

    public void removecard(Card card)
    {
        cards.remove(card);
    }
    public void revive()
    {
        this.alive = true;
    }

    public void kill()
    {
        this.alive = false;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.toJson(this);
    }
}
