package com.counterstrike.cs.controller.impl;

import com.counterstrike.cs.controller.model.TeamCreate;
import com.counterstrike.cs.controller.model.TeamListWeb;
import com.counterstrike.cs.controller.model.TeamWeb;
import com.counterstrike.cs.domain.entity.Team;
import com.counterstrike.cs.domain.service.TeamService;
import com.counterstrike.cs.http_response.Response;
import com.counterstrike.cs.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {
    @Autowired
    TeamService teamService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/team")
    public Response getAll(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize) {
        List<TeamListWeb> teamWebList = TeamMapper.mapper.toTeamWebList(teamService.getAll());
        Response response = new Response(teamWebList);
        return response;
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/team/{id}")

    public Response getById(@PathVariable("id") int id) {
        TeamWeb teamWeb = TeamMapper.mapper.toTeamWeb(teamService.getById(id).orElse(null));
        Response response = new Response(teamWeb);
        return response;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/team")
    public Response insertTeam(@RequestBody TeamCreate teamCreate) {
        Team team = TeamMapper.mapper.toTeam(teamCreate);
        Response response = new Response(teamService.insertTeam(team));
        return response;
    }
}
