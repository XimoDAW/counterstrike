package com.counterstrike.cs.controller.impl;

import com.counterstrike.cs.controller.model.TeamListWeb;
import com.counterstrike.cs.controller.model.TeamWeb;
import com.counterstrike.cs.domain.service.TeamService;
import com.counterstrike.cs.http_response.Response;
import com.counterstrike.cs.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {
    @Autowired
    TeamService teamService;

    @GetMapping("/team")
    public Response getAll(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize) {
        List<TeamListWeb> teamWebList = TeamMapper.mapper.toTeamWebList(teamService.getAll());
        Response response = new Response(teamWebList);
        return response;
    }

    @GetMapping("/team/{id}")
    public Response getById(@PathVariable("id") int id) {
        TeamWeb teamWeb = TeamMapper.mapper.toTeamWeb(teamService.getById(id).orElse(null));
        Response response = new Response(teamWeb);
        return response;
    }
}
