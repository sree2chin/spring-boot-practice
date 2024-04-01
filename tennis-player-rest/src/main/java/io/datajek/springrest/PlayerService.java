package io.datajek.springrest;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository repo;

    //Get all players
    public List<Player> getAllPlayers() {
        return repo.findAll();
    }

    //Get player by ID
    public Player getPlayer(int id) {
        Optional<Player> tempPlayer = repo.findById(id);

        if(tempPlayer.isEmpty())
            throw new PlayerNotFoundException("Player with id {"+ id +"} not found");

        return tempPlayer.get();
    }

    //Add a player
    public Player addPlayer(Player p) {
        return repo.save(p);
    }

    //Update a player
    public Player updatePlayer(int id, Player p) {
        Optional<Player> tempPlayer = repo.findById(id);

        if(tempPlayer.isEmpty())
            throw new PlayerNotFoundException("Player with id {"+ id +"} not found");

        p.setId(id);
        return repo.save(p);
    }

    //Partial update
    public Player patch( int id, Map<String, Object> partialPlayer) {

        Optional<Player> player = repo.findById(id);

        if(player.isPresent()) {
            partialPlayer.forEach( (key, value) -> {
                System.out.println("Key: " + key + " Value: " + value);
                Field field = ReflectionUtils.findField(Player.class, key);
                ReflectionUtils.makeAccessible(field);
                ReflectionUtils.setField(field, player.get(), value);
            });
        }
        else
            throw new PlayerNotFoundException("Player with id {"+ id +"} not found");

        return repo.save(player.get());
    }

    //delete a player
    public void deletePlayer(int id) {
        Optional<Player> tempPlayer = repo.findById(id);

        if(tempPlayer.isEmpty())
            throw new PlayerNotFoundException("Player with id {"+ id +"} not found");

        repo.delete(tempPlayer.get());
    }

    //update a single field
    @Transactional
    public void updateTitles(int id, int titles) {
        Optional<Player> tempPlayer = repo.findById(id);

        if(tempPlayer.isEmpty())
            throw new PlayerNotFoundException("Player with id {"+ id +"} not found");

        repo.updateTitles(id, titles);
    }
}