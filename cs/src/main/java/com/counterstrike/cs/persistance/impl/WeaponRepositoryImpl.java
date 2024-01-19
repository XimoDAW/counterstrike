package com.counterstrike.cs.persistance.impl;

import com.counterstrike.cs.domain.entity.Team;
import com.counterstrike.cs.domain.entity.Weapon;
import com.counterstrike.cs.domain.repository.WeaponRepository;
import com.counterstrike.cs.exception.ResourceNotFoundException;
import com.counterstrike.cs.mapper.TeamMapper;
import com.counterstrike.cs.mapper.WeaponMapper;
import com.counterstrike.cs.persistance.dao.WeaponDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class WeaponRepositoryImpl implements WeaponRepository{
    @Autowired
    WeaponDAO weaponDAO;

    @Override
    public Optional<Weapon> getById(int id) {
        try {
            Weapon weapon = WeaponMapper.mapper.toWeapon(weaponDAO.findById(id));
            return Optional.ofNullable(weapon);
        }catch (ResourceNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int insertWeapon(Weapon weapon) {
        weaponDAO.save(WeaponMapper.mapper.toWeaponEntity(weapon));
        return 0;
    }

    @Override
    public int deleteWeapon(int id) {
        weaponDAO.deleteById(id);
        return 0;
    }

    @Override
    public List<Weapon> getAll() {
        List<Weapon> weaponList = WeaponMapper.mapper.toWeaponList(weaponDAO.findAll());
        return weaponList;
    }
}
