package com.barath.app.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PLAYER")
public class Player implements Serializable {
	
	private static final long serialVersionUID = -8987510035067274497L;
	
	@Id
	@Column(name="PLAYER_ID")
	private long playerId;
	
	@Column(name="PLAYER_NAME")
	private String playerName;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name="PLAYER_GENDER")
	private Gender playerGender;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="COUNTRY_ID")
	private Country country;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Sport sport;
	
	
	public enum Gender{
		MALE,
		FEMALE
	}


	public long getPlayerId() {
		return playerId;
	}


	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}


	public String getPlayerName() {
		return playerName;
	}


	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}


	public Gender getPlayerGender() {
		return playerGender;
	}


	public void setPlayerGender(Gender playerGender) {
		this.playerGender = playerGender;
	}


	public Country getCountry() {
		return country;
	}


	public void setCountry(Country country) {
		this.country = country;
	}


	public Sport getSport() {
		return sport;
	}


	public void setSport(Sport sport) {
		this.sport = sport;
	}


	public Player(long playerId, String playerName, Gender playerGender, Country country, Sport sport) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.playerGender = playerGender;
		this.country = country;
		this.sport = sport;
	}


	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((playerGender == null) ? 0 : playerGender.hashCode());
		result = prime * result + (int) (playerId ^ (playerId >>> 32));
		result = prime * result + ((playerName == null) ? 0 : playerName.hashCode());
		result = prime * result + ((sport == null) ? 0 : sport.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (playerGender != other.playerGender)
			return false;
		if (playerId != other.playerId)
			return false;
		if (playerName == null) {
			if (other.playerName != null)
				return false;
		} else if (!playerName.equals(other.playerName))
			return false;
		if (sport == null) {
			if (other.sport != null)
				return false;
		} else if (!sport.equals(other.sport))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", playerName=" + playerName + ", playerGender=" + playerGender + "]";
	}


	public Player(long playerId, String playerName, Gender playerGender) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.playerGender = playerGender;
	}
	
	
	
	
	

}
