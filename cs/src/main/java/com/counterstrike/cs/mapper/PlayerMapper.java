package com.counterstrike.cs.mapper;

import com.counterstrike.cs.controller.model.PlayerDetailWeb;
import com.counterstrike.cs.controller.model.PlayerListWeb;
import com.counterstrike.cs.domain.entity.Player;
import com.counterstrike.cs.persistance.entity.PlayerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlayerMapper {
    PlayerMapper mapper = Mappers.getMapper(PlayerMapper.class);

    @Mapping(target = "team", ignore = true)
    @Mapping(target = "server", ignore = true)
    List<Player> toPlayer(List<PlayerEntity> playerEntity);
    @Mapping(target = "team", ignore = true)
    @Mapping(target = "server", ignore = true)
    List<PlayerListWeb> toPlayerListWeb(List<Player> player);

    @Mapping(target = "team", ignore = true)
    @Mapping(target = "server", ignore = true)
    Player toPlayer(PlayerEntity playerEntity);
    @Mapping(target = "team", ignore = true)
    @Mapping(target = "server", ignore = true)
    PlayerDetailWeb toPlayerDetailWeb(Player player);
}
