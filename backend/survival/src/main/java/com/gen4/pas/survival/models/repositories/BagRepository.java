package com.gen4.pas.survival.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gen4.pas.survival.models.entities.Bag;



@Repository
public interface BagRepository
    extends JpaRepository<Bag, Long> {
    
}
