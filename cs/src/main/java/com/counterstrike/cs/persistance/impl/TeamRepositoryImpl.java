package com.counterstrike.cs.persistance.impl;

import com.counterstrike.cs.domain.entity.Team;
import com.counterstrike.cs.domain.repository.TeamRepository;
import com.counterstrike.cs.exception.ResourceNotFoundException;
import com.counterstrike.cs.mapper.ServerMapper;
import com.counterstrike.cs.mapper.TeamMapper;
import com.counterstrike.cs.persistance.dao.TeamDAO;
import com.counterstrike.cs.persistance.entity.TeamEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TeamRepositoryImpl implements TeamRepository {
    @Autowired
    TeamDAO teamDAO;
    @Override
    public Optional<Team> getById(int id) {
        try {
            Team team = TeamMapper.mapper.toTeam(teamDAO.findById(id));
            if (team != null) {
                String position = "TERRORIST";
                if(teamDAO.findById(id).isTerrorist())
                    position = "COUNTER TERRORIST";
                team.setPosition(position);
            }
            return Optional.ofNullable(team);
        }catch (ResourceNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Team> getAll() {
        List<Team> teamList = TeamMapper.mapper.toTeamList(teamDAO.findAll());
        return teamList;
    }


    @Override
    public int insertTeam(Team team) {

        TeamEntity teamEntity = TeamMapper.mapper.toTeamEntity(team);
        teamEntity.setTerrorist(setPosition(team));
        teamDAO.save(teamEntity);
        return 0;
    }

    @Override
    public int updateTeam(Team team) {
        TeamEntity teamEntity = TeamMapper.mapper.toTeamEntity(team);
        teamEntity.setTerrorist(setPosition(team));
        teamDAO.save(teamEntity);
        return 0;
    }

    @Override
    public boolean setPosition(Team team) {
        boolean position = true;
        if (team.getPosition().equals("COUNTER TERRORIST"))
            position = false;
        return position;
    }

    @Override
    public int deleteTeam(int id) {
        teamDAO.deleteById(id);
        return 0;
    }
}
