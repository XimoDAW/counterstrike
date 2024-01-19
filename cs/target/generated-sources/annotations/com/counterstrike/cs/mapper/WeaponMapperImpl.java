package com.counterstrike.cs.mapper;

import com.counterstrike.cs.controller.model.WeaponCreate;
import com.counterstrike.cs.controller.model.WeaponListWeb;
import com.counterstrike.cs.controller.model.WeaponWeb;
import com.counterstrike.cs.domain.entity.Weapon;
import com.counterstrike.cs.persistance.entity.WeaponEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-18T16:38:04+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class WeaponMapperImpl implements WeaponMapper {

    @Override
    public Weapon toWeapon(WeaponEntity weaponEntity) {
        if ( weaponEntity == null ) {
            return null;
        }

        Weapon weapon = new Weapon();

        weapon.setId( weaponEntity.getId() );
        weapon.setName( weaponEntity.getName() );
        weapon.setType( weaponEntity.getType() );
        weapon.setPower( weaponEntity.getPower() );
        weapon.setBullet( weaponEntity.getBullet() );
        weapon.setPrice( weaponEntity.getPrice() );

        return weapon;
    }

    @Override
    public WeaponWeb toWeaponWeb(Weapon weapon) {
        if ( weapon == null ) {
            return null;
        }

        WeaponWeb weaponWeb = new WeaponWeb();

        weaponWeb.setId( weapon.getId() );
        weaponWeb.setName( weapon.getName() );
        weaponWeb.setType( weapon.getType() );
        weaponWeb.setPower( weapon.getPower() );
        weaponWeb.setBullet( weapon.getBullet() );
        weaponWeb.setPrice( weapon.getPrice() );

        return weaponWeb;
    }

    @Override
    public List<Weapon> toWeaponList(List<WeaponEntity> weaponEntityList) {
        if ( weaponEntityList == null ) {
            return null;
        }

        List<Weapon> list = new ArrayList<Weapon>( weaponEntityList.size() );
        for ( WeaponEntity weaponEntity : weaponEntityList ) {
            list.add( toWeapon( weaponEntity ) );
        }

        return list;
    }

    @Override
    public List<WeaponListWeb> toWeaponWebList(List<Weapon> weaponList) {
        if ( weaponList == null ) {
            return null;
        }

        List<WeaponListWeb> list = new ArrayList<WeaponListWeb>( weaponList.size() );
        for ( Weapon weapon : weaponList ) {
            list.add( weaponToWeaponListWeb( weapon ) );
        }

        return list;
    }

    @Override
    public Weapon toWeapon(WeaponCreate weaponCreate) {
        if ( weaponCreate == null ) {
            return null;
        }

        Weapon weapon = new Weapon();

        weapon.setName( weaponCreate.getName() );
        weapon.setType( weaponCreate.getType() );
        weapon.setPower( weaponCreate.getPower() );
        weapon.setBullet( weaponCreate.getBullet() );
        weapon.setPrice( weaponCreate.getPrice() );

        return weapon;
    }

    @Override
    public WeaponEntity toWeaponEntity(Weapon weapon) {
        if ( weapon == null ) {
            return null;
        }

        WeaponEntity weaponEntity = new WeaponEntity();

        weaponEntity.setId( weapon.getId() );
        weaponEntity.setName( weapon.getName() );
        weaponEntity.setType( weapon.getType() );
        weaponEntity.setPower( weapon.getPower() );
        weaponEntity.setBullet( weapon.getBullet() );
        weaponEntity.setPrice( weapon.getPrice() );

        return weaponEntity;
    }

    protected WeaponListWeb weaponToWeaponListWeb(Weapon weapon) {
        if ( weapon == null ) {
            return null;
        }

        WeaponListWeb weaponListWeb = new WeaponListWeb();

        weaponListWeb.setId( weapon.getId() );
        weaponListWeb.setName( weapon.getName() );

        return weaponListWeb;
    }
}
