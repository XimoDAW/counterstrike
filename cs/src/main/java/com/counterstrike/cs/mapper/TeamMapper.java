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
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamMapper {
    TeamMapper mapper = Mappers.getMapper(TeamMapper.class);
    @Mapping(target = "position", expression = "java(mapTeamPosition(teamEntity.isTerrorist()))")
    Team toTeam (TeamEntity teamEntity);

    default String mapTeamPosition(boolean terrorist) {
        String position = "TERRORIST";
        if(!terrorist)
            position = "COUNTER TERRORIST";
        return position;
    }
    TeamWeb toTeamWeb (Team team);
    List<Team> toTeamList (List<TeamEntity> teamEntityList);
    List<TeamListWeb> toTeamWebList (List<Team> teamList);
    Team toTeam(TeamCreate teamCreate);
    @Mapping(target = "terrorist", expression = "java(mapTeamTerrorist(team.getPosition()))")
    TeamEntity toTeamEntity(Team team);
    default boolean mapTeamTerrorist(String terrorist) {
        boolean position = true;
        if (terrorist.equals("COUNTER TERRORIST"))
            position = false;
        return position;
    }
}
