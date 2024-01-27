package com.counterstrike.cs.persistance.impl;

import com.counterstrike.cs.domain.entity.Type;
import com.counterstrike.cs.domain.repository.TypeRepository;
import com.counterstrike.cs.mapper.TypeMapper;
import com.counterstrike.cs.persistance.dao.TypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TypeRepositoryImpl implements TypeRepository {
    @Autowired
    TypeDAO typeDAO;
    @Override
    public Type getById(int id) {
        return TypeMapper.mapper.toType(typeDAO.findById(id));
    }
}
