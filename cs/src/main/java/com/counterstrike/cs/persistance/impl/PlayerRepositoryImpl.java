package com.counterstrike.cs.persistance.impl;

import com.counterstrike.cs.domain.entity.Player;
import com.counterstrike.cs.domain.repository.PlayerRepository;
import com.counterstrike.cs.mapper.PlayerMapper;
import com.counterstrike.cs.persistance.dao.PlayerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public Player getById(int id) {
        Player player = PlayerMapper.mapper.toPlayer(playerDAO.findById(id));
        return player;
    }
}
