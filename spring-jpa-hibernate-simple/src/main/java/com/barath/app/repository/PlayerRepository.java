package com.barath.app.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.barath.app.entities.Player;


@Repository
public class PlayerRepository {
	
	private static final Logger logger=LoggerFactory.getLogger(PlayerRepository.class);
	
	@PersistenceContext(unitName="competition")
	private EntityManager entityManager;
	
	@Transactional
	public void persistPlayer(Player player){
		if(logger.isInfoEnabled()){
			logger.info("Persisting the player  entity  "+player.toString());
		}
		entityManager.persist(player);
	}
	
	
	@Transactional(readOnly=true)
	public Player readPlayer(long playerId){
		Player player=null;
		if(logger.isInfoEnabled()){
			logger.info("Finding the player with  ID  "+playerId);
		}
		player=entityManager.find(Player.class,playerId);
		
		return player;
	}
	
	@Transactional(propagation=Propagation.MANDATORY)
	public Player updatePlayer(long playerId){
		Player player=null;
		if(logger.isInfoEnabled()){
			logger.info("Finding the player with  ID  "+playerId);
		}
		player=entityManager.find(Player.class,playerId);
		
		return player;
	}
	
	@Transactional(readOnly=true)
	public void deletePlayer(long playerId){
		Player player=null;
		if(logger.isInfoEnabled()){
			logger.info("Finding the player with  ID  "+playerId);
		}
		player=entityManager.find(Player.class,playerId);
		if(player !=null){
			entityManager.remove(player);
		}
		
	}

}
