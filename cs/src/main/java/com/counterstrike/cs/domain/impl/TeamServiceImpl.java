package com.counterstrike.cs.domain.impl;

import com.counterstrike.cs.domain.entity.Team;
import com.counterstrike.cs.domain.repository.TeamRepository;
import com.counterstrike.cs.domain.service.TeamService;
import com.counterstrike.cs.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    TeamRepository teamRepository;


    @Override
    public Optional<Team> getById(int id) {
        if (teamRepository.getById(id).isPresent()) {
            return teamRepository.getById(id);
        }else {
            throw new ResourceNotFoundException("No se encuentra el equipo");
        }
    }

    @Override
    public List<Team> getAll() {
        return teamRepository.getAll();
    }

    @Override
    public int insertTeam(Team team) {
        teamRepository.insertTeam(team);
        return 0;
    }
}
