package com.counterstrike.cs.domain.service.impl;

import com.counterstrike.cs.domain.entity.Player;
import com.counterstrike.cs.domain.entity.Weapon;
import com.counterstrike.cs.domain.repository.PlayerRepository;
import com.counterstrike.cs.domain.repository.ServerRepository;
import com.counterstrike.cs.domain.repository.TeamRepository;
import com.counterstrike.cs.domain.repository.WeaponRepository;
import com.counterstrike.cs.domain.service.PlayerService;
import com.counterstrike.cs.exception.ResourceNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import static com.counterstrike.cs.common.validation.Validation.validate;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    ServerRepository serverRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    WeaponRepository weaponRepository;

    @Override
    public List<Player> getAll() {
        return playerRepository.getAll();
    }

    @Override
    public List<Player> getPlayersByTeam(int teamId) {
        List<Player> playersByTeam = new ArrayList<>();

        for (Player player: getAll()) {
            if (player.getTeam().getId() == teamId)
                playersByTeam.add(player);
        }
        return playersByTeam;
    }

    @Override
    public Optional <Player> getById(int id) {
        Player player = playerRepository.getById(id).orElse(null);
        if(playerRepository.getById(id).isPresent()){
            return Optional.of(player);
        }else {
            throw new ResourceNotFoundException("No se encuentra el jugador");
        }
    }

    @Override
    public int insertPlayer(Player player, int idTeam, int idServer, List<Integer> idWeapons) {
        player.setServer(serverRepository.getById(idServer).orElse(null));
        player.setTeam(teamRepository.getById(idTeam).orElse(null));
        List<Weapon> weapons = new ArrayList<>();
        idWeapons.forEach(id -> {
            weapons.add(weaponRepository.getById(id).orElse(null));
        });
        player.setWeapons(weapons);
        validate(player);
        return playerRepository.insertPlayer(player);
    }

    /*@Override
    public boolean validatePlayer(Player player) {
        if(getPlayersByTeam(player.getTeam().getId()).size() >=5)
            throw new ValidationException("Limite máximo de jugadores. Un equipo solo puede tener 5 jugadores");
        if (player.getCountry().equals(player.getServer().getCountry())) {
            return true;
        }else {
            throw new ValidationException("El pais del jugador debe coincidir con el pais de equipo y de servidor");
        }
    }*/

    @Override
    public int updatePlayer(Player player, String name, int level, Integer birthYear, Integer deathYear, int idTeam, int idServer, List<Integer> idWeapons) {
        player.setName(name);
        player.setLevel(level);
        player.setBirthYear(birthYear);
        player.setDeathYear(deathYear);
        player.setServer(serverRepository.getById(idServer).orElse(null));
        player.setTeam(teamRepository.getById(idTeam).orElse(null));
        List<Weapon> weapons = new ArrayList<>();
        idWeapons.forEach(idWeapon -> {
            weapons.add(weaponRepository.getById(idWeapon).orElse(null));
        });
        player.setWeapons(weapons);
        validate(player);
        return playerRepository.updatePlayer(player);
    }

    @Override
    public int deletePlayer(int id) {
        return playerRepository.deletePlayer(id);
    }
}
