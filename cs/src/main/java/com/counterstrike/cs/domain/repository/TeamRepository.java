package com.counterstrike.cs.domain.repository;

import com.counterstrike.cs.domain.entity.Server;
import com.counterstrike.cs.domain.entity.Team;

import java.util.List;
import java.util.Optional;

public interface TeamRepository {
    public Optional<Team> getById(int id);
    public List<Team> getAll();
    public int insertTeam(Team team);
    public int deleteTeam(int id);
}
