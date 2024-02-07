package com.counterstrike.cs.domain.service.impl;

import com.counterstrike.cs.domain.entity.Weapon;
import com.counterstrike.cs.domain.repository.WeaponRepository;
import com.counterstrike.cs.domain.service.WeaponService;
import com.counterstrike.cs.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeaponServiceImpl implements WeaponService {
    @Autowired
    WeaponRepository weaponRepository;
    @Override
    public Optional<Weapon> getById(int id) {
        if (weaponRepository.getById(id).isPresent()) {
            return weaponRepository.getById(id);
        }else {
            throw new ResourceNotFoundException("No se encuentra el arma");
        }
    }

    @Override
    public List<Weapon> getAll() {
        return weaponRepository.getAll();
    }

    @Override
    public int insertWeapon(Weapon weapon) {
        weaponRepository.insertWeapon(weapon);
        return 0;
    }

    @Override
    public int updateWeapon(Weapon weapon) {
        weaponRepository.updateWeapon(weapon);
        return 0;
    }

    @Override
    public int deleteWeapon(int id) {
        return weaponRepository.deleteWeapon(id);
    }

    @Override
    public boolean validateWeapon(Weapon weapon) {
        return false;
    }
}
