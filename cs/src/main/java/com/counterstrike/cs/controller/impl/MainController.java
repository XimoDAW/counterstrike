package com.counterstrike.cs.controller.impl;

import com.counterstrike.cs.controller.model.PlayerDetailWeb;
import com.counterstrike.cs.controller.model.PlayerListWeb;
import com.counterstrike.cs.domain.entity.Player;
import com.counterstrike.cs.domain.service.PlayerService;
import com.counterstrike.cs.http_response.Response;
import com.counterstrike.cs.mapper.PlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {
    @Autowired
    PlayerService playerService;

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
        PlayerDetailWeb playerDetailWeb = PlayerMapper.mapper.toPlayerDetailWeb(playerService.getById(id));
        Response response = new Response(playerDetailWeb);
        return response;
    }
}

