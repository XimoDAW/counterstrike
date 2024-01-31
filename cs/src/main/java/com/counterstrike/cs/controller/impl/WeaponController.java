package com.counterstrike.cs.controller.impl;

import com.counterstrike.cs.controller.model.WeaponCreate;
import com.counterstrike.cs.controller.model.WeaponListWeb;
import com.counterstrike.cs.controller.model.WeaponWeb;
import com.counterstrike.cs.domain.entity.Weapon;
import com.counterstrike.cs.domain.service.TypeService;
import com.counterstrike.cs.domain.service.WeaponService;
import com.counterstrike.cs.http_response.Response;
import com.counterstrike.cs.mapper.WeaponMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.counterstrike.cs.common.validation.Validation.validate;

@RestController
public class WeaponController {
    @Autowired
    WeaponService weaponService;

    @Autowired
    TypeService typeService;

    @GetMapping("/weapon")
    public Response getAll(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize) {
        List<WeaponListWeb> weaponWebList = WeaponMapper.mapper.toWeaponWebList(weaponService.getAll());
        Response response = new Response(weaponWebList);
        return response;
    }

    @GetMapping("/weapon/{id}")
    public Response getById(@PathVariable("id") int id) {
        WeaponWeb weaponWeb = WeaponMapper.mapper.toWeaponWeb(weaponService.getById(id).orElse(null));
        weaponWeb.setType(typeService.getById(weaponService.getById(id).get().getType().getId()).getName());
        Response response = new Response(weaponWeb);
        return response;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/weapon")
    public Response insertWeapon(@RequestBody WeaponCreate weaponCreate) {
        Weapon weapon = WeaponMapper.mapper.toWeapon(weaponCreate);
        weapon.setType(typeService.getById(weaponCreate.getId_type()));
        Response response = new Response(weaponService.insertWeapon(weapon));
        return response;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping("/weapon/{id}")
    public Response deleteWeapon(@PathVariable("id") int id) {
        Response response = new Response(weaponService.deleteWeapon(id));
        return response;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/weapon/{id}")
    public Response updateWeapon(@PathVariable("id") int id, @RequestBody WeaponCreate weaponCreate) {
        validate(weaponCreate);
        Optional<Weapon> weapon = weaponService.getById(id);
        weapon.get().setName(weaponCreate.getName());
        weapon.get().setType(typeService.getById(weaponCreate.getId_type()));
        weaponService.updateWeapon(weapon.orElse(null));
        Response response = new Response(weapon);
        return response;
    }
}
