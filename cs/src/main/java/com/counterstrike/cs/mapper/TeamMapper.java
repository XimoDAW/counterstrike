package com.counterstrike.cs.mapper;

import com.counterstrike.cs.controller.model.ServerCreate;
import com.counterstrike.cs.controller.model.TeamCreate;
import com.counterstrike.cs.controller.model.TeamListWeb;
import com.counterstrike.cs.controller.model.TeamWeb;
import com.counterstrike.cs.domain.entity.Server;
import com.counterstrike.cs.domain.entity.Team;
import com.counterstrike.cs.persistance.entity.ServerEntity;
import com.counterstrike.cs.persistance.entity.TeamEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamMapper {
    TeamMapper mapper = Mappers.getMapper(TeamMapper.class);
    
    Team toTeam (TeamEntity teamEntity);
    TeamWeb toTeamWeb (Team team);
    List<Team> toTeamList (List<TeamEntity> teamEntityList);
    List<TeamListWeb> toTeamWebList (List<Team> teamList);
    Team toTeam(TeamCreate teamCreate);
    TeamEntity toTeamEntity(Team team);
}
