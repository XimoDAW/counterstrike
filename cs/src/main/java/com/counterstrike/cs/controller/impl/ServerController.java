package com.counterstrike.cs.controller.impl;

import com.counterstrike.cs.controller.model.PlayerListWeb;
import com.counterstrike.cs.controller.model.ServerCreate;
import com.counterstrike.cs.controller.model.ServerWeb;
import com.counterstrike.cs.domain.entity.Server;
import com.counterstrike.cs.domain.service.ServerService;
import com.counterstrike.cs.http_response.Response;
import com.counterstrike.cs.mapper.PlayerMapper;
import com.counterstrike.cs.mapper.ServerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServerController {
    @Autowired
    ServerService serverService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/server/{id}")
    public Response getById(@PathVariable("id") int id) {
        ServerWeb serverWeb = ServerMapper.mapper.toServerWeb(serverService.getById(id).orElse(null));
        Response response = new Response(serverWeb);
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/server")
    public Response getAll(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize) {
        List<ServerWeb> serverListWebs = ServerMapper.mapper.toServerWebList(serverService.getAll());
        Response response = new Response(serverListWebs);
        return response;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/server")
    public Response insertServer(@RequestBody ServerCreate serverCreate) {
        Server server = ServerMapper.mapper.toServer(serverCreate);
        serverService.insertServer(server);
        Response response = new Response(server.getId());
        return response;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping("/server/{id}")
    public Response deleteServer(@PathVariable("id") int id) {
        Response response = new Response(serverService.deleteServer(id));
        return response;
    }
}
