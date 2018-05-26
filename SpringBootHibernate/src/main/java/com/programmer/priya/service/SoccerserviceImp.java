package com.programmer.priya.service;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.programmer.priya.repository.*;
import com.programmer.priya.service.SoccerService;
import com.programmer.priya.model.*;
@Service
public class SoccerserviceImp implements SoccerService 
{
@Autowired 
private PlayerRepository playerrepository;
@Autowired
private TeamRepository teamrepository;

public List<String> getAllTeamPlayers(long teamId)
{
	List<String> result=new ArrayList<String>();
	List<Player> players = playerrepository.findByTeamId(teamId);
	for (Player player : players) {
        result.add(player.getName());
    }
    return result;
}
public void addBarcalonaPlayer(String name, int number,String position) {
    Team barcelona = teamrepository.findOne(1l);
    Player newPlayer = new Player();
    newPlayer.setName(name);
    newPlayer.setPosition(position);
    newPlayer.setNum(number);
    newPlayer.setTeam(barcelona);
    playerrepository.save(newPlayer);
}

}
