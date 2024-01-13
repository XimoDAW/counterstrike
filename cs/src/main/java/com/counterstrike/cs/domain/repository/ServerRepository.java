package com.counterstrike.cs.domain.repository;

import com.counterstrike.cs.domain.entity.Server;

public interface ServerRepository {
    public Server getById(int id);
}
