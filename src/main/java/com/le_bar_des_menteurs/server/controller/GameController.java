package com.le_bar_des_menteurs.server.controller;

import com.google.gson.Gson;
import com.le_bar_des_menteurs.server.Game;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        Game.startNewRound();
        return new ResponseEntity<>("Partie lancée", HttpStatus.OK);
    }
}
