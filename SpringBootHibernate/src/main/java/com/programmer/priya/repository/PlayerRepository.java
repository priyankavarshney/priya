package com.programmer.priya.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.programmer.priya.model.Player;
@Repository
public interface PlayerRepository extends CrudRepository<Player,Long>
{
List<Player> findByTeamId(long teamId);
}
