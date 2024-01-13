package com.counterstrike.cs.domain.service;

import com.counterstrike.cs.domain.entity.Player;

import java.util.List;

public interface PlayerService {
    public List<Player> getAll();
    public Player getById(int id);
}
