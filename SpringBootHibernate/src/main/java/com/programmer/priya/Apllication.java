package com.programmer.priya;

import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.programmer.priya.service.SoccerService;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
@ComponentScan("com.programmer.priya")
@PropertySource("classpath:applications.properties")
@ConfigurationProperties("oracle")
@SpringBootApplication
public class Apllication {

	@Autowired
	private Environment env;

	public static void main(String args[]) {
		ConfigurableApplicationContext context = SpringApplication.run(Apllication.class, args);
		SoccerService soccerservice = context.getBean(SoccerService.class);
		soccerservice.addBarcalonaPlayer("Xavi Hernandez", 6, "Midfielder");
		List<String> players = soccerservice.getAllTeamPlayers(1);
		for (String player : players) {
			System.out.println("Introducing Barca player => " + player);
		}
	}

	@Bean
	public DataSource dataSource() throws SQLException {
		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setURL(env.getProperty("spring.datasource.url"));
		dataSource.setUser(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		dataSource.setImplicitCachingEnabled(true);
        dataSource.setFastConnectionFailoverEnabled(true);
		return dataSource;
	}

}
