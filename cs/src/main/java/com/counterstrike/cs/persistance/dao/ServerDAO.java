package com.counterstrike.cs.persistance.dao;

import com.counterstrike.cs.domain.entity.Player;
import com.counterstrike.cs.domain.entity.Server;
import com.counterstrike.cs.persistance.entity.PlayerEntity;
import com.counterstrike.cs.persistance.entity.ServerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ServerDAO extends JpaRepository<ServerEntity, Integer> {
    List<ServerEntity> findAll();
    ServerEntity findById(int id);
    ServerEntity save(Server server);
    ServerEntity deleteById(int id);
}
