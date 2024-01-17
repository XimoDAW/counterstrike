package com.counterstrike.cs.mapper;

import com.counterstrike.cs.controller.model.ServerWeb;
import com.counterstrike.cs.domain.entity.Server;
import com.counterstrike.cs.persistance.entity.ServerEntity;
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
public class ServerMapperImpl implements ServerMapper {

    @Override
    public Server toServer(ServerEntity serverEntity) {
        if ( serverEntity == null ) {
            return null;
        }

        Server server = new Server();

        server.setId( serverEntity.getId() );
        server.setName( serverEntity.getName() );
        server.setCountry( serverEntity.getCountry() );

        return server;
    }

    @Override
    public ServerWeb toServerWeb(Server server) {
        if ( server == null ) {
            return null;
        }

        ServerWeb serverWeb = new ServerWeb();

        serverWeb.setId( server.getId() );
        serverWeb.setName( server.getName() );
        serverWeb.setCountry( server.getCountry() );

        return serverWeb;
    }

    @Override
    public List<Server> toServerList(List<ServerEntity> serverEntityList) {
        if ( serverEntityList == null ) {
            return null;
        }

        List<Server> list = new ArrayList<Server>( serverEntityList.size() );
        for ( ServerEntity serverEntity : serverEntityList ) {
            list.add( toServer( serverEntity ) );
        }

        return list;
    }

    @Override
    public List<ServerWeb> toServerWebList(List<Server> serverList) {
        if ( serverList == null ) {
            return null;
        }

        List<ServerWeb> list = new ArrayList<ServerWeb>( serverList.size() );
        for ( Server server : serverList ) {
            list.add( toServerWeb( server ) );
        }

        return list;
    }
}
