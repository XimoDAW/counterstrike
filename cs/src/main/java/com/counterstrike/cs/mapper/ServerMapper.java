package com.counterstrike.cs.mapper;

import com.counterstrike.cs.controller.model.ServerWeb;
import com.counterstrike.cs.domain.entity.Server;
import com.counterstrike.cs.persistance.entity.ServerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ServerMapper {
    ServerMapper mapper = Mappers.getMapper(ServerMapper.class);

    Server toServer (ServerEntity serverEntity);
    ServerWeb toServerWeb (Server server);
}
