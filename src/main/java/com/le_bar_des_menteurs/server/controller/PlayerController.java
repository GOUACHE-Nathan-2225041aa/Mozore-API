package com.le_bar_des_menteurs.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerController {
    @PostMapping("/new")
    public ResponseEntity<String> newPlayer() {
        return new ResponseEntity<>("Le joueur a été créé", HttpStatus.OK);
    }
}
