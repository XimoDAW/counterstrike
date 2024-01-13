package com.counterstrike.cs.domain.repository;

import com.counterstrike.cs.domain.entity.Player;

import java.util.List;

public interface PlayerRepository {
    public List<Player> getAll();
    public Player getById(int id);
}
