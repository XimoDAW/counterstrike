package com.counterstrike.cs.mapper;

import com.counterstrike.cs.controller.model.PlayerDetailWeb;
import com.counterstrike.cs.controller.model.PlayerListWeb;
import com.counterstrike.cs.domain.entity.Player;
import com.counterstrike.cs.domain.entity.Server;
import com.counterstrike.cs.domain.entity.Team;
import com.counterstrike.cs.domain.entity.Weapon;
import com.counterstrike.cs.persistance.entity.PlayerEntity;
import com.counterstrike.cs.persistance.entity.ServerEntity;
import com.counterstrike.cs.persistance.entity.TeamEntity;
import com.counterstrike.cs.persistance.entity.WeaponEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-17T13:47:25+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class PlayerMapperImpl implements PlayerMapper {

    @Override
    public List<Player> toPlayer(List<PlayerEntity> playerEntity) {
        if ( playerEntity == null ) {
            return null;
        }

        List<Player> list = new ArrayList<Player>( playerEntity.size() );
        for ( PlayerEntity playerEntity1 : playerEntity ) {
            list.add( toPlayer( playerEntity1 ) );
        }

        return list;
    }

    @Override
    public List<PlayerListWeb> toPlayerListWeb(List<Player> player) {
        if ( player == null ) {
            return null;
        }

        List<PlayerListWeb> list = new ArrayList<PlayerListWeb>( player.size() );
        for ( Player player1 : player ) {
            list.add( playerToPlayerListWeb( player1 ) );
        }

        return list;
    }

    @Override
    public Player toPlayer(PlayerEntity playerEntity) {
        if ( playerEntity == null ) {
            return null;
        }

        Player player = new Player();

        player.setTeam( teamEntityToTeam( playerEntity.getTeam() ) );
        player.setServer( serverEntityToServer( playerEntity.getServer() ) );
        player.setWeapons( weaponEntityListToWeaponList( playerEntity.getWeapons() ) );
        player.setId( playerEntity.getId() );
        player.setName( playerEntity.getName() );
        player.setCountry( playerEntity.getCountry() );
        player.setLevel( playerEntity.getLevel() );
        player.setBirthYear( playerEntity.getBirthYear() );
        player.setDeathYear( playerEntity.getDeathYear() );

        return player;
    }

    @Override
    public PlayerDetailWeb toPlayerDetailWeb(Player player) {
        if ( player == null ) {
            return null;
        }

        PlayerDetailWeb playerDetailWeb = new PlayerDetailWeb();

        playerDetailWeb.setId( player.getId() );
        playerDetailWeb.setName( player.getName() );
        playerDetailWeb.setCountry( player.getCountry() );
        playerDetailWeb.setLevel( player.getLevel() );
        playerDetailWeb.setBirthYear( player.getBirthYear() );
        playerDetailWeb.setDeathYear( player.getDeathYear() );

        return playerDetailWeb;
    }

    protected PlayerListWeb playerToPlayerListWeb(Player player) {
        if ( player == null ) {
            return null;
        }

        PlayerListWeb playerListWeb = new PlayerListWeb();

        playerListWeb.setId( player.getId() );
        playerListWeb.setName( player.getName() );

        return playerListWeb;
    }

    protected Team teamEntityToTeam(TeamEntity teamEntity) {
        if ( teamEntity == null ) {
            return null;
        }

        Team team = new Team();

        team.setId( teamEntity.getId() );
        team.setName( teamEntity.getName() );

        return team;
    }

    protected Server serverEntityToServer(ServerEntity serverEntity) {
        if ( serverEntity == null ) {
            return null;
        }

        Server server = new Server();

        server.setId( serverEntity.getId() );
        server.setName( serverEntity.getName() );
        server.setCountry( serverEntity.getCountry() );

        return server;
    }

    protected Weapon weaponEntityToWeapon(WeaponEntity weaponEntity) {
        if ( weaponEntity == null ) {
            return null;
        }

        Weapon weapon = new Weapon();

        weapon.setId( weaponEntity.getId() );
        weapon.setName( weaponEntity.getName() );
        weapon.setType( weaponEntity.getType() );
        weapon.setPower( weaponEntity.getPower() );
        weapon.setBullet( weaponEntity.getBullet() );
        weapon.setPrice( weaponEntity.getPrice() );

        return weapon;
    }

    protected List<Weapon> weaponEntityListToWeaponList(List<WeaponEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Weapon> list1 = new ArrayList<Weapon>( list.size() );
        for ( WeaponEntity weaponEntity : list ) {
            list1.add( weaponEntityToWeapon( weaponEntity ) );
        }

        return list1;
    }
}
