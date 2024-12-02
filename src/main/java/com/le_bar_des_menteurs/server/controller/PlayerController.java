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
@RequestMapping("/player")
public class PlayerController {

    @PostMapping("/new")
    public ResponseEntity<String> newPlayer(@RequestBody String name) {
        Player player = new Player(name);
        Game.players.add(player);
        return new ResponseEntity<>(player.getToken(), HttpStatus.OK);
    }

    @GetMapping("/cards")
    public ResponseEntity<String> getCards(@RequestHeader String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Player me = Game.getPlayerInRound(token);
        if (me != null)
        {
            return new ResponseEntity<>((new Gson()).toJson(me.getCards()), headers, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
