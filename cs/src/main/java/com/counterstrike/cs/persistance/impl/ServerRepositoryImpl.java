package com.counterstrike.cs.persistance.impl;

import com.counterstrike.cs.domain.entity.Server;
import com.counterstrike.cs.domain.repository.ServerRepository;
import com.counterstrike.cs.exception.ResourceNotFoundException;
import com.counterstrike.cs.mapper.ServerMapper;
import com.counterstrike.cs.persistance.dao.ServerDAO;
import com.counterstrike.cs.persistance.entity.ServerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ServerRepositoryImpl implements ServerRepository {
    @Autowired
    ServerDAO serverDAO;


    @Override
    public Optional<Server> getById(int id) {
        try {
            Server server = ServerMapper.mapper.toServer(serverDAO.findById(id));
            return Optional.ofNullable(server);
        }catch (ResourceNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Server> getAll() {
        List<Server> serverList = ServerMapper.mapper.toServerList(serverDAO.findAll());
        return serverList;
    }
}
