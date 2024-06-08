package com.gen4.pas.survival.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.gen4.pas.survival.exceptions.BadRequestException;

import com.gen4.pas.survival.services.GameService;
import com.gen4.pas.survival.models.dtos.ResponseDto;
import com.gen4.pas.survival.models.dtos.CommandDto;
import com.gen4.pas.survival.models.dtos.GetOrCreatePlayerDto;
import com.gen4.pas.survival.models.dtos.PlayerDto;

@RestController
@CrossOrigin
public class GameController {
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("api/v0.0.1/command") // This can't be an aggregation endpoint. I don't think it should be like this
	public ResponseDto executeCommand(@RequestBody CommandDto command) throws IOException, BadRequestException {
        return gameService.executeCommand(command);
	}

    @PostMapping("api/v0.0.1/get-create-player")
    public PlayerDto getOrCreatePlayer(@RequestBody GetOrCreatePlayerDto playerIdentifier) throws IOException {
        return gameService.getOrCreatePlayer(playerIdentifier.getName());
    }
    
}
