package com.counterstrike.cs.persistance.dao;

import com.counterstrike.cs.persistance.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PlayerDAO extends JpaRepository<PlayerEntity, Integer> {
    List<PlayerEntity> findAll();
    PlayerEntity findById(int id);
}
