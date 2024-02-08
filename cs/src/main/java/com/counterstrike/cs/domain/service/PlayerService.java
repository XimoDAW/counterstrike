package com.counterstrike.cs.domain.service;

import com.counterstrike.cs.domain.entity.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    public List<Player> getAll();
    public List<Player> getPlayersByTeam(int teamId);
    public Optional<Player> getById(int id);
    public int insertPlayer(Player player, int idTeam, int idServer, List<Integer> idWeapons);
    //public boolean validatePlayer(Player player);
    public int updatePlayer(Player player, String name, int level, Integer birthYear, Integer deathYear, int idTeam, int idServer, List<Integer> idWeapons);
    public int deletePlayer(int id);
}
