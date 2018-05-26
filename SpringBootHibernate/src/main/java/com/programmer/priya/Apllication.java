package com.programmer.priya;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import com.programmer.priya.service.*;
import com.programmer.priya.service.SoccerService;
@SpringBootApplication

public class Apllication implements CommandLineRunner
{
	@Autowired
	SoccerService  soccerservice;
public static void main(String args[])
	{
		SpringApplication.run(Apllication.class, args);
	}
@Override
public void run(String... arg0) throws Exception {
	soccerservice.addBarcalonaPlayer("Xavi Hernandez",6, "Midfielder");
    List<String> players = soccerservice.getAllTeamPlayers(1);
    for(String player : players)
    {
        System.out.println("Introducing Barca player => " + player);
    }
}
}
