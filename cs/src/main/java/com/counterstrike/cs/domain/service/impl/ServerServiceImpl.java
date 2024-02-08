package com.counterstrike.cs.domain.service.impl;

import com.counterstrike.cs.domain.entity.Player;
import com.counterstrike.cs.domain.entity.Server;
import com.counterstrike.cs.domain.repository.ServerRepository;
import com.counterstrike.cs.domain.service.ServerService;
import com.counterstrike.cs.exception.ResourceNotFoundException;
import com.counterstrike.cs.mapper.ServerMapper;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.counterstrike.cs.common.validation.Validation.validate;

@Service
public class ServerServiceImpl implements ServerService {

    @Autowired
    ServerRepository serverRepository;

    @Override
    public Optional<Server> getById(int id) {
        if (serverRepository.getById(id).isPresent()) {
            return serverRepository.getById(id);
        }else {
            throw new ResourceNotFoundException("No se encuentra el servidor");
        }
    }

    @Override
    public List<Server> getAll() {
        return serverRepository.getAll();
    }

    @Override
    public int insertServer(Server server) {
        validate(server);
        serverRepository.insertServer(server);
        return 0;
    }

    @Override
    public int updateServer(Server server, String name, String country) {
        server.setName(name);
        server.setCountry(country);
        validate(server);
        return serverRepository.updateServer(server);
    }

    @Override
    public int deleteServer(int id) {
        return serverRepository.deleteServer(id);
    }
}
