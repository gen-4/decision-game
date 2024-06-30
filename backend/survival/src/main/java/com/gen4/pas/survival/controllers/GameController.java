package com.gen4.pas.survival.controllers;

import com.gen4.pas.survival.models.dtos.CommandDto;
import com.gen4.pas.survival.models.dtos.GetOrCreatePlayerDto;
import com.gen4.pas.survival.models.dtos.PlayerDto;
import com.gen4.pas.survival.models.dtos.ResponseDto;
import com.gen4.pas.survival.services.GameService;
import com.gen4.pas.survival.models.dtos.CommandDto;
import com.gen4.pas.survival.exceptions.BadRequestException;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class GameController {
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("api/v0.0.1/help")
    public ResponseDto getHelp(@RequestBody CommandDto command) throws IOException, BadRequestException {
        return gameService.getHelp(command);
    }

    @PostMapping("api/v0.0.1/status")
    public ResponseDto getStatus(@RequestBody CommandDto command) throws IOException, BadRequestException {
        return gameService.getStatus(command);
    }

    @PostMapping("api/v0.0.1/items")
    public ResponseDto getItems(@RequestBody CommandDto command) throws IOException, BadRequestException {
        return gameService.getItems(command);
    }

    @PostMapping("api/v0.0.1/get-create-player")
    public PlayerDto getOrCreatePlayer(@RequestBody GetOrCreatePlayerDto playerIdentifier) throws IOException {
        return gameService.getOrCreatePlayer(playerIdentifier.getName());
    }

}
