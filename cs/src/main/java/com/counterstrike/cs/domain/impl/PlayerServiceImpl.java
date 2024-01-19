package com.counterstrike.cs.domain.impl;

import com.counterstrike.cs.domain.entity.Player;
import com.counterstrike.cs.domain.repository.PlayerRepository;
import com.counterstrike.cs.domain.service.PlayerService;
import com.counterstrike.cs.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public List<Player> getAll() {
        return playerRepository.getAll();
    }

    @Override
    public Optional <Player> getById(int id) {
        Player player = playerRepository.getById(id).orElse(null);

        if(playerRepository.getById(id).isPresent()){
            if (playerRepository.getById(id).get().getDeathYear() == 0)
                player.setDeathYear(null);
            return Optional.of(player);
        }else {
            throw new ResourceNotFoundException("No se encuentra el jugador");
        }
    }

    @Override
    public int insertPlayer(Player player) {
        return playerRepository.insertPlayer(player);
    }

    @Override
    public int deletePlayer(int id) {
        return playerRepository.deletePlayer(id);
    }
}
