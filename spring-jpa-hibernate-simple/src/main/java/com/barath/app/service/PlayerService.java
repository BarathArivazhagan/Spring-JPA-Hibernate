package com.barath.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barath.app.entities.Player;
import com.barath.app.repository.PlayerRepository;

@Service
public class PlayerService {
	
	@Autowired
	private PlayerRepository playerRep;
	
	
	public Player addPlayer(Player player){
		
		if(player != null){
			playerRep.persistPlayer(player);
		}
		return player;
		
	}
	
	public void readPlayer(long playerId){
		
	}


	public void updatePlayer(Player player){
	
	}

	public void deletePlayer(Player player){
	
	}




}
