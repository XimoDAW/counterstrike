package com.counterstrike.cs.persistance.dao;

import com.counterstrike.cs.domain.entity.Team;
import com.counterstrike.cs.persistance.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamDAO extends JpaRepository<TeamEntity, Integer> {
    List<TeamEntity> findAll();
    TeamEntity findById(int id);
    TeamEntity save(Team team);
}
