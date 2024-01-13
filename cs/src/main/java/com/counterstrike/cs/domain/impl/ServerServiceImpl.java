package com.counterstrike.cs.domain.impl;

import com.counterstrike.cs.domain.entity.Server;
import com.counterstrike.cs.domain.repository.ServerRepository;
import com.counterstrike.cs.domain.service.ServerService;
import com.counterstrike.cs.mapper.ServerMapper;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServerServiceImpl implements ServerService {

    @Autowired
    ServerRepository serverRepository;

    @Override
    public Server getById(int id) {
        return serverRepository.getById(id);
    }
}
