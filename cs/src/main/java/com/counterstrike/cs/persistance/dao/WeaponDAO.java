package com.counterstrike.cs.persistance.dao;

import com.counterstrike.cs.domain.entity.Weapon;
import com.counterstrike.cs.persistance.entity.WeaponEntity;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeaponDAO extends JpaRepository<WeaponEntity, Integer> {
    List<WeaponEntity> findAll();
    WeaponEntity findById(int id);
    WeaponEntity save (Weapon weapon);
    WeaponEntity deleteById(int id);
}
