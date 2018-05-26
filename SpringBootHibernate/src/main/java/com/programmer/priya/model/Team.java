package com.programmer.priya.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Team 
{
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="team_sequence")
@SequenceGenerator(name="team_sequence",sequenceName="TEAM_SEQ")
private Long id;
@Column
private String name;
@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="Team")
private List<Player> players;
public Team()
{
	
}
public Long getId()
{
	return id;
}
public void setId(Long id)
{
	this.id=id;
}
public String name()
{
	return name;
}
public void setName(String name)
{
	this.name=name;
}
 
}
