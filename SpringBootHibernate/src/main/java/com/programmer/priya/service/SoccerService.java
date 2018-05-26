package com.programmer.priya.service;
import java.util.List;

public interface SoccerService 
{
	public List<String> getAllTeamPlayers(long teamId);
	public void addBarcalonaPlayer(String name,int num,String position);
	

}
