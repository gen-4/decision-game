package com.gen4.pas.survival.services;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gen4.pas.survival.models.dtos.ResponseDto;
import com.gen4.pas.survival.exceptions.BadRequestException;
import com.gen4.pas.survival.models.dtos.CommandDto;
import com.gen4.pas.survival.models.entities.Player;
import com.gen4.pas.survival.models.dtos.PlayerDto;
import com.gen4.pas.survival.models.repositories.BagRepository;
import com.gen4.pas.survival.models.repositories.PlayerRepository;
import com.gen4.pas.survival.models.mappers.PlayerMapper;
import com.gen4.pas.survival.models.entities.Bag;




@Service
public class GameService {
    private final PlayerRepository playerRepository;
    private final BagRepository bagRepository;

    @Autowired
    public GameService(PlayerRepository playerRepository, BagRepository bagRepository) {
        this.playerRepository = playerRepository;
        this.bagRepository = bagRepository;
    }

    private Optional<Player> obtainPlayer(Long playerId) throws BadRequestException {
        if (playerId == null)
            throw new BadRequestException("id", "null"); 

        return playerRepository.findById(playerId);
    }

    public ResponseDto executeCommand(CommandDto command) throws IOException, BadRequestException {
        Optional<Player> player;
        String response = "Available commands:\n" 
            + "help -> display list of available commands\n"
            + "status -> display player info\n" 
            + "items -> display inventory";
        
        switch (command.getCommand()) {
            case "status": // I should probably call a handler in each one of these...
                player = this.obtainPlayer(command.getPlayerId());
                response = "Unable to find the player";
                if (player.isPresent()) {
                    response = player.get().toString();
                }
                break;
            
            case "items":
                player = this.obtainPlayer(command.getPlayerId()); 
                response = "Unable to find the player";
                if (player.isPresent()) {
                    response = player.get().getBag().toString();
                }
                break;

            default:
                break;
        }

        return new ResponseDto(response);
    }

    public PlayerDto getOrCreatePlayer(String name) throws IOException {
        PlayerDto resultPlayer;
        Bag bag;
        Player player = playerRepository.findByName(name);
        String response = "Player loaded";
        
        if (player == null) {
            player = new Player(name);
            bag = new Bag();
            bag = bagRepository.save(bag); 
            player.setBag(bag);
            player = playerRepository.save(player);
            response = "Player created";
        }

        resultPlayer = PlayerMapper.convertPlayer(player);
        resultPlayer.setResponse(response);
        return resultPlayer;
    }

}
