package com.gen4.pas.survival.models.mappers;

import com.gen4.pas.survival.models.dtos.PlayerDto;
import com.gen4.pas.survival.models.entities.Player;


public class PlayerMapper {
    public static PlayerDto convertPlayer(Player player) {
        return new PlayerDto(
            player.getId(), 
            player.getName(), 
            player.getHealth(), 
            player.getTotalHealth(), 
            player.getDamage(),
            player.getHunger(), 
            player.getThirst(), 
            player.toString()
        );
    }
}
