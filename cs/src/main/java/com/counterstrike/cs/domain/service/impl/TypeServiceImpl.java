package com.counterstrike.cs.domain.service.impl;

import com.counterstrike.cs.domain.entity.Type;
import com.counterstrike.cs.domain.repository.TypeRepository;
import com.counterstrike.cs.domain.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeRepository typeRepository;

    @Override
    public Type getById(int id) {
        return typeRepository.getById(id);
    }
}
