package com.counterstrike.cs.domain.service;

import com.counterstrike.cs.domain.entity.Weapon;

import java.util.List;
import java.util.Optional;

public interface WeaponService {
    public Optional<Weapon> getById(int id);
    public List<Weapon> getAll();
    public int insertWeapon(Weapon weapon);
}
