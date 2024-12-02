package com.le_bar_des_menteurs.server.controller;

import com.le_bar_des_menteurs.server.Game;
import com.le_bar_des_menteurs.server.models.Player;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @PostMapping("/new")
    public ResponseEntity<String> newPlayer(@RequestBody String name) {
        Player player = new Player(name);
        Game.players.add(player);
        return new ResponseEntity<>(player.getToken(), HttpStatus.OK);
    }
}
