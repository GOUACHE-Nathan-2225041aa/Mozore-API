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

    public static ArrayList<Player> getAlivePlayers()
    {
        return currentRound.getPlayers();
    }

    public static ArrayList<Player> getDeadPlayers()
    {
        // On crée une nouvelle liste pour pas changer l'autre et on retient seulement les éléments en commun
        ArrayList<Player> players1 = new ArrayList<>(players);
        players1.retainAll(currentRound.getPlayers());
        return players1;
    }

    public static Player getOnePlayer(String name)
    {
        for (Player p : players)
        {
            if(p.getName().equals(name))
            {
                return p;
            }
        }
        return null;
    }

    public static Player getPlayerInRound(String token)
    {
        return currentRound.getOnePlayer(token);
    }
}
