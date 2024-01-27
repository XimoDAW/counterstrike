package com.counterstrike.cs.controller.impl;

import com.counterstrike.cs.controller.model.*;
import com.counterstrike.cs.domain.entity.Player;
import com.counterstrike.cs.domain.entity.Weapon;
import com.counterstrike.cs.domain.service.PlayerService;
import com.counterstrike.cs.domain.service.ServerService;
import com.counterstrike.cs.domain.service.TeamService;
import com.counterstrike.cs.domain.service.WeaponService;
import com.counterstrike.cs.http_response.Response;
import com.counterstrike.cs.mapper.PlayerMapper;
import com.counterstrike.cs.mapper.ServerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.counterstrike.cs.common.validation.Validation.validate;

@RestController
public class MainController {
    @Autowired
    PlayerService playerService;
    @Autowired
    TeamService teamService;
    @Autowired
    ServerService serverService;
    @Autowired
    WeaponService weaponService;
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/player")
    public Response getAll(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize) {
        List<PlayerListWeb> playerListWebs = PlayerMapper.mapper.toPlayerListWeb(playerService.getAll());
        Response response = new Response(playerListWebs);
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/player/{id}")
    public Response getById(@PathVariable("id") int id) {
        PlayerDetailWeb playerDetailWeb = PlayerMapper.mapper.toPlayerDetailWeb(playerService.getById(id).orElse(null));
        playerDetailWeb.setServer(playerService.getById(id).get().getServer().getName());
        playerDetailWeb.setTeam(playerService.getById(id).get().getTeam().getName());
        List<String> weapons = new ArrayList<>();
        playerService.getById(id).get().getWeapons().forEach(weapon -> weapons.add(weapon.getName()));
        playerDetailWeb.setWeapons(weapons);
        Response response = new Response(playerDetailWeb);
        return response;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/player")
    public Response insertPlayer(@RequestBody PlayerCreate playerCreate) {
        validate(playerCreate);
        Player player = PlayerMapper.mapper.toPlayer(playerCreate);
        player.setServer(serverService.getById(playerCreate.getId_server()).orElse(null));
        player.setTeam(teamService.getById(playerCreate.getId_team()).orElse(null));
        List<Weapon> weapons = new ArrayList<>();
        playerCreate.getId_weapons().forEach(id -> {
            weapons.add(weaponService.getById(id).orElse(null));
        });
        player.setWeapons(weapons);
        playerService.insertPlayer(player);
        Response response = new Response(player.getId());
        return response;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping("/player/{id}")
    public Response deletePlayer(@PathVariable("id") int id) {
        Response response = new Response(playerService.deletePlayer(id));
        return response;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PatchMapping("/player/{id}")
    public Response updatePlayer(@PathVariable("id") int id, @RequestBody PlayerCreate playerCreate) {
        validate(playerCreate);
        Optional<Player> player = playerService.getById(id);
        player.get().setName(playerCreate.getName());
        player.get().setLevel(playerCreate.getLevel());
        player.get().setBirthYear(playerCreate.getBirthYear());
        player.get().setDeathYear(playerCreate.getDeathYear());
        player.get().setServer(serverService.getById(playerCreate.getId_server()).orElse(null));
        player.get().setTeam(teamService.getById(playerCreate.getId_team()).orElse(null));
        List<Weapon> weapons = new ArrayList<>();
        playerCreate.getId_weapons().forEach(idWeapon -> {
            weapons.add(weaponService.getById(idWeapon).orElse(null));
        });
        player.get().setWeapons(weapons);
        Response response = new Response(player);
        return response;
    }
}