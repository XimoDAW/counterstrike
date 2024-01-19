package com.counterstrike.cs.mapper;

import com.counterstrike.cs.controller.model.TeamCreate;
import com.counterstrike.cs.controller.model.TeamListWeb;
import com.counterstrike.cs.controller.model.TeamWeb;
import com.counterstrike.cs.domain.entity.Team;
import com.counterstrike.cs.persistance.entity.TeamEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-18T16:38:04+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class TeamMapperImpl implements TeamMapper {

    @Override
    public Team toTeam(TeamEntity teamEntity) {
        if ( teamEntity == null ) {
            return null;
        }

        Team team = new Team();

        team.setId( teamEntity.getId() );
        team.setName( teamEntity.getName() );

        return team;
    }

    @Override
    public TeamWeb toTeamWeb(Team team) {
        if ( team == null ) {
            return null;
        }

        TeamWeb teamWeb = new TeamWeb();

        teamWeb.setId( team.getId() );
        teamWeb.setName( team.getName() );
        teamWeb.setPosition( team.getPosition() );

        return teamWeb;
    }

    @Override
    public List<Team> toTeamList(List<TeamEntity> teamEntityList) {
        if ( teamEntityList == null ) {
            return null;
        }

        List<Team> list = new ArrayList<Team>( teamEntityList.size() );
        for ( TeamEntity teamEntity : teamEntityList ) {
            list.add( toTeam( teamEntity ) );
        }

        return list;
    }

    @Override
    public List<TeamListWeb> toTeamWebList(List<Team> teamList) {
        if ( teamList == null ) {
            return null;
        }

        List<TeamListWeb> list = new ArrayList<TeamListWeb>( teamList.size() );
        for ( Team team : teamList ) {
            list.add( teamToTeamListWeb( team ) );
        }

        return list;
    }

    @Override
    public Team toTeam(TeamCreate teamCreate) {
        if ( teamCreate == null ) {
            return null;
        }

        Team team = new Team();

        team.setName( teamCreate.getName() );
        team.setPosition( teamCreate.getPosition() );

        return team;
    }

    @Override
    public TeamEntity toTeamEntity(Team team) {
        if ( team == null ) {
            return null;
        }

        TeamEntity teamEntity = new TeamEntity();

        teamEntity.setId( team.getId() );
        teamEntity.setName( team.getName() );

        return teamEntity;
    }

    protected TeamListWeb teamToTeamListWeb(Team team) {
        if ( team == null ) {
            return null;
        }

        TeamListWeb teamListWeb = new TeamListWeb();

        teamListWeb.setId( team.getId() );
        teamListWeb.setName( team.getName() );

        return teamListWeb;
    }
}
