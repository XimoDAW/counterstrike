package com.counterstrike.cs.domain.service;

import com.counterstrike.cs.domain.entity.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    public List<Player> getAll();
    public Optional<Player> getById(int id);
    public int insertPlayer(Player player);
}
