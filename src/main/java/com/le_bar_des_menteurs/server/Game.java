package com.le_bar_des_menteurs.server;

import com.le_bar_des_menteurs.server.models.Player;

import java.util.ArrayList;

public class Game {
    public static ArrayList<Player> players = new ArrayList<>();
    private static Round currentRound;

    public static void startNewRound()
    {
        currentRound = new Round(players);
    }
}
