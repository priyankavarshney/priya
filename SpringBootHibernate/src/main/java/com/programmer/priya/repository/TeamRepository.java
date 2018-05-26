package com.programmer.priya.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.programmer.priya.model.Team;
@Repository
public interface TeamRepository extends CrudRepository<Team, Long> 
{
    Team findByPlayers(long playerId);
    
}