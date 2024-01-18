package com.counterstrike.cs.domain.repository;

import com.counterstrike.cs.domain.entity.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository {
    public List<Player> getAll();
    public Optional<Player> getById(int id);
    public int insertPlayer(Player player);
}
