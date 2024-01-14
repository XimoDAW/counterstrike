package com.counterstrike.cs.controller.impl;

import com.counterstrike.cs.controller.model.PlayerListWeb;
import com.counterstrike.cs.controller.model.ServerWeb;
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
    public Response getAll(@PathVariable("id") int id) {
        ServerWeb serverWeb = ServerMapper.mapper.toServerWeb(serverService.getById(id));
        Response response = new Response(serverWeb);
        return response;
    }
}
