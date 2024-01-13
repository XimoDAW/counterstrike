package com.counterstrike.cs.persistance.impl;

import com.counterstrike.cs.domain.entity.Server;
import com.counterstrike.cs.domain.repository.ServerRepository;
import com.counterstrike.cs.mapper.ServerMapper;
import com.counterstrike.cs.persistance.dao.ServerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ServerRepositoryImpl implements ServerRepository {
    @Autowired
    ServerDAO serverDAO;

    @Override
    public Server getById(int id) {
        Server server = ServerMapper.mapper.toServer(serverDAO.findById(id));
        return server;
    }
}
