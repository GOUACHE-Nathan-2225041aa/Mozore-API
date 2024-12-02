package com.le_bar_des_menteurs.server;

import com.le_bar_des_menteurs.server.enums.Pip;
import com.le_bar_des_menteurs.server.enums.Suit;
import com.le_bar_des_menteurs.server.models.Card;
import com.le_bar_des_menteurs.server.models.Player;

import java.util.ArrayList;
import java.util.Collections;

public class Round {
    private Pip chosenCard;
    private Player playerTurn;

    private ArrayList<Player> players;

    public Round(ArrayList<Player> players) {
        this.players = new ArrayList<>(players);

        // Generating an array of all cards possible
        Pip[] pipValues = Pip.values();
        Suit[] suitValues = Suit.values();

        ArrayList<Card> cardList = new ArrayList<>();

        // Générer toutes les combinaisons
        for (Pip pip : pipValues) {
            for (Suit suit : suitValues) {
                cardList.add(new Card(pip, suit));
            }
        }

        Collections.shuffle(cardList);

        // En fonction du nombre de joueur, on enlève des cartes du jeu
        int cartesParJoueurs =  cardList.size() / players.size();

        // On donne à chaque joueur ses cartes et on les fait vivre
        for (Player player : players) {
            player.revive();
            for (int i = 0; i < cartesParJoueurs && !cardList.isEmpty(); i++) { // Distribue jusqu'à x cartes ou jusqu'à ce qu'il n'y ait plus de cartes
                player.addCard(cardList.remove(0)); // Retire la carte de la liste et l'ajoute au joueur
            }
        }

        playerTurn = players.get(0);
    }

    public ArrayList<Player> getPlayers()
    {
        return players;
    }
}

