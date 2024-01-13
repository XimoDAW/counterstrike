package com.counterstrike.cs.domain.impl;

import com.counterstrike.cs.domain.entity.Player;
import com.counterstrike.cs.domain.repository.PlayerRepository;
import com.counterstrike.cs.domain.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public List<Player> getAll() {
        return playerRepository.getAll();
    }

    @Override
    public Player getById(int id) {
        Player player = playerRepository.getById(id);

        if (playerRepository.getById(id).getTeam().getPosition() == "false") {
            player.getTeam().setPosition("COUNTER TERRORIST");
        }else {
            player.getTeam().setPosition("TERRORIST");
        }

        if (playerRepository.getById(id).getDeathYear() == 0)
            player.setDeathYear(null);

        return player;
    }
}
