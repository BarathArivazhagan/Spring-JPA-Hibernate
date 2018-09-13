package com.barath.app.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TEAM")
public class Team implements Serializable {
	
	private static final long serialVersionUID = -7762318616016786577L;

	@Id
	@Column(name="TEAM_ID")
	private long teamId;
	
	
	@Column(name="TEAM_NAME")
	private String teamName;
	
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="COUNTRY_ID")
	private Country country;
	
	
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<Player> players;



	public long getTeamId() {
		return teamId;
	}



	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}



	public String getTeamName() {
		return teamName;
	}



	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}



	public Set<Player> getPlayers() {
		return players;
	}



	public void setPlayers(Set<Player> players) {
		this.players = players;
	}



	public Team(long teamId, String teamName, Set<Player> players) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.players = players;
	}



	public Team(long teamId, String teamName) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
	}



	public Team() {
		super();
		
	}



	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + "]";
	}
	
	
	
	
	

}
