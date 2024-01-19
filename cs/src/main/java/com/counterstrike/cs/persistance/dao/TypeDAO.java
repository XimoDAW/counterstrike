package com.counterstrike.cs.persistance.dao;

import com.counterstrike.cs.persistance.entity.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeDAO extends JpaRepository<TypeEntity, Integer> {
    TypeEntity findById(int id);
}
