package com.le_bar_des_menteurs.server.models;

import com.le_bar_des_menteurs.server.enums.Pip;
import com.le_bar_des_menteurs.server.enums.Suit;

public class Card {
    private Pip pip;
    private Suit suit;

    public Card(Pip pip, Suit suit) {
        this.pip = pip;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "pip=" + pip +
                ", suit=" + suit +
                '}';
    }
}
