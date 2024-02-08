package com.counterstrike.cs.controller;

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
        Response response = new Response(playerDetailWeb);
        return response;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/player")
    public Response insertPlayer(@RequestBody PlayerCreate playerCreate) {
        Player player = PlayerMapper.mapper.toPlayer(playerCreate);
        playerService.insertPlayer(player, playerCreate.getIdTeam(), playerCreate.getIdServer(), playerCreate.getIdWeapons());
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
    @PutMapping("/player/{id}")
    public Response updatePlayer(@PathVariable("id") int id, @RequestBody PlayerCreate playerCreate) {
        Optional<Player> player = playerService.getById(id);
        playerService.updatePlayer(player.orElse(null), playerCreate.getName(), playerCreate.getLevel(), playerCreate.getBirthYear(), playerCreate.getDeathYear(), playerCreate.getIdTeam(), playerCreate.getIdServer(), playerCreate.getIdWeapons());
        Response response = new Response(player);
        return response;
    }
}