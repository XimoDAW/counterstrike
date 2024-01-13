package com.counterstrike.cs.persistance.dao;

import com.counterstrike.cs.persistance.entity.PlayerEntity;
import com.counterstrike.cs.persistance.entity.ServerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerDAO extends JpaRepository<ServerEntity, Integer> {
    ServerEntity findById(int id);
}
