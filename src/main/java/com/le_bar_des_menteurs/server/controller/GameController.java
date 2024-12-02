package com.le_bar_des_menteurs.server.controller;

import com.google.gson.Gson;
import com.le_bar_des_menteurs.server.Game;
import com.le_bar_des_menteurs.server.models.Player;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {

    @GetMapping("/players")
    public ResponseEntity<String> getPlayers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>((new Gson()).toJson(Game.players), headers, HttpStatus.OK);
    }

    @PostMapping("/round/start")
    public ResponseEntity<String> startRound() {
        try
        {
            Game.startNewRound();
            return new ResponseEntity<>("Partie lancée", HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("Erreur :"+e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/players/alive")
    public ResponseEntity<String> getAlivePlayers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>((new Gson()).toJson(Game.getAlivePlayers()), headers, HttpStatus.OK);
    }

    @GetMapping("/players/dead")
    public ResponseEntity<String> getDeadPlayers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>((new Gson()).toJson(Game.getDeadPlayers()), headers, HttpStatus.OK);
    }

    @GetMapping("/player")
    public ResponseEntity<String> getOnePlayer(@RequestBody String name) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Player player = Game.getOnePlayer(name);
        if (player != null)
        {
            return new ResponseEntity<>((new Gson()).toJson(player), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
