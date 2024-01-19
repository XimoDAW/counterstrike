package com.counterstrike.cs.domain.service;

import com.counterstrike.cs.domain.entity.Server;

import java.util.List;
import java.util.Optional;

public interface ServerService {
    public Optional<Server> getById(int id);
    public List<Server> getAll();
    public int insertServer(Server server);
    public int deleteServer(int id);
}
