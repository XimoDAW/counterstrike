package com.counterstrike.cs.mapper;

import com.counterstrike.cs.controller.model.*;
import com.counterstrike.cs.domain.entity.Server;
import com.counterstrike.cs.domain.entity.Team;
import com.counterstrike.cs.domain.entity.Weapon;
import com.counterstrike.cs.persistance.entity.ServerEntity;
import com.counterstrike.cs.persistance.entity.TeamEntity;
import com.counterstrike.cs.persistance.entity.WeaponEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WeaponMapper {
    WeaponMapper mapper = Mappers.getMapper(WeaponMapper.class);
    Weapon toWeapon (WeaponEntity weaponEntity);
    WeaponWeb toWeaponWeb (Weapon weapon);
    List<Weapon> toWeaponList (List<WeaponEntity> weaponEntityList);
    List<WeaponListWeb> toWeaponWebList (List<Weapon> weaponList);

    Weapon toWeapon(WeaponCreate weaponCreate);
    WeaponEntity toWeaponEntity(Weapon weapon);
}
