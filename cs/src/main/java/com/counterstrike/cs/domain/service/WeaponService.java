package com.counterstrike.cs.domain.service;

import com.counterstrike.cs.domain.entity.Weapon;

import java.util.List;
import java.util.Optional;

public interface WeaponService {
    public Optional<Weapon> getById(int id);
    public List<Weapon> getAll();
    public int insertWeapon(Weapon weapon, int idType);
    public int updateWeapon(Weapon weapon, String name, int idType);
    public int deleteWeapon(int id);
    public boolean validateWeapon(Weapon weapon);

}
