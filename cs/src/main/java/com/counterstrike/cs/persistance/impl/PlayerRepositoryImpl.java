package com.counterstrike.cs.persistance.impl;

import com.counterstrike.cs.domain.entity.Player;
import com.counterstrike.cs.domain.entity.Server;
import com.counterstrike.cs.domain.repository.PlayerRepository;
import com.counterstrike.cs.exception.ResourceNotFoundException;
import com.counterstrike.cs.mapper.PlayerMapper;
import com.counterstrike.cs.mapper.ServerMapper;
import com.counterstrike.cs.persistance.dao.PlayerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PlayerRepositoryImpl implements PlayerRepository {
    @Autowired
    PlayerDAO playerDAO;

    @Override
    public List<Player> getAll() {
        List<Player> players = PlayerMapper.mapper.toPlayer(playerDAO.findAll());
        return players;
    }

    @Override
    public Optional<Player> getById(int id) {
        try {
            Player player = PlayerMapper.mapper.toPlayer(playerDAO.findById(id));
            return Optional.ofNullable(player);
        }catch (ResourceNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
    
}
