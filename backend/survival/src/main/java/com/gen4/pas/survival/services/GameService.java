package com.gen4.pas.survival.services;

import com.gen4.pas.survival.models.dtos.CommandDto;
import com.gen4.pas.survival.models.dtos.PlayerDto;
import com.gen4.pas.survival.models.dtos.ResponseDto;
import com.gen4.pas.survival.models.entities.Bag;
import com.gen4.pas.survival.models.entities.Player;
import com.gen4.pas.survival.models.mappers.PlayerMapper;
import com.gen4.pas.survival.models.repositories.BagRepository;
import com.gen4.pas.survival.models.repositories.PlayerRepository;
import com.gen4.pas.survival.models.dtos.CommandDto;
import com.gen4.pas.survival.exceptions.BadRequestException;

import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    public ResponseDto getHelp(CommandDto command) throws BadRequestException {
        String response = "Available commands:\n"
                + "help -> display list of available commands\n"
                + "status -> display player info\n"
                + "items -> display inventory";

        return new ResponseDto(response);
    }

    public ResponseDto getStatus(CommandDto command) throws IOException, BadRequestException {
        Optional<Player> player;
        String response = "Unable to find the player";

        if (!command.getCommand().toLowerCase().equals("status")) {
            throw new BadRequestException("command(status)", command.getCommand());
        }

        player = this.obtainPlayer(command.getPlayerId());
        if (player.isPresent()) {
            response = player.get().toString();
        }

        return new ResponseDto(response);
    }

    public ResponseDto getItems(CommandDto command) throws IOException, BadRequestException {
        Optional<Player> player;
        String response = "Unable to find the player";

        if (!command.getCommand().toLowerCase().equals("items")) {
            throw new BadRequestException("command(items)", command.getCommand());
        }

        player = this.obtainPlayer(command.getPlayerId());
        if (player.isPresent()) {
            response = player.get().getBag().toString();
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
