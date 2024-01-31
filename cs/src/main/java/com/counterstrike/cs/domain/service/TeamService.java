package com.counterstrike.cs.domain.service;

import com.counterstrike.cs.domain.entity.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    public Optional<Team> getById(int id);
    public List<Team> getAll();
    public int insertTeam(Team team);
    public int updateTeam(Team team);
    public int deleteTeam(int id);
}
