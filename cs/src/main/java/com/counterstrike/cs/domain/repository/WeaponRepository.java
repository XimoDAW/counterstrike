package com.counterstrike.cs.domain.repository;

import com.counterstrike.cs.domain.entity.Weapon;

import java.util.List;
import java.util.Optional;

public interface WeaponRepository {
    public List<Weapon> getAll();
    public Optional<Weapon> getById(int id);
    public int insertWeapon(Weapon weapon);
    public int updateWeapon(Weapon weapon);

    public int deleteWeapon(int id);
}
