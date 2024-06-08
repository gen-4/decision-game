package com.gen4.pas.survival.models.dtos;

public class CommandDto {
    private String command;
    private Long playerId;

    public CommandDto() {}

    public CommandDto(String command, Long playerId) {
        this.command = command;
        this.playerId = playerId;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }
    
}
