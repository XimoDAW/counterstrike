package com.counterstrike.cs.persistance.impl;

import com.counterstrike.cs.domain.entity.Player;
import com.counterstrike.cs.domain.entity.Server;
import com.counterstrike.cs.domain.repository.PlayerRepository;
import com.counterstrike.cs.exception.ResourceNotFoundException;
import com.counterstrike.cs.mapper.PlayerMapper;
import com.counterstrike.cs.mapper.ServerMapper;
import com.counterstrike.cs.mapper.WeaponMapper;
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
            player.setWeapons(WeaponMapper.mapper.toWeaponList(playerDAO.findById(id).getWeapons()));
            return Optional.ofNullable(player);
        }catch (ResourceNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public int insertPlayer(Player player) {
        playerDAO.save(PlayerMapper.mapper.toPlayerEntity(player));
        return 0;
    }

    @Override
    public int updatePlayer(Player player) {
        playerDAO.save(PlayerMapper.mapper.toPlayerEntity(player));
        return 0;
    }

    @Override
    public int deletePlayer(int id) {
        playerDAO.deleteById(id);
        return 0;
    }

}
