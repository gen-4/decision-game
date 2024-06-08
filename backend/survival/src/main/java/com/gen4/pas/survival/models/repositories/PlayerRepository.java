package com.gen4.pas.survival.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gen4.pas.survival.models.entities.Player;



@Repository
public interface PlayerRepository 
    extends JpaRepository<Player, Long> {
    
    public Player findByName(String name);
}
