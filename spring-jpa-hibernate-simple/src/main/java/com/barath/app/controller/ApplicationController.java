package com.barath.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barath.app.entities.Player;
import com.barath.app.service.CountryService;
import com.barath.app.service.PlayerService;
import com.barath.app.service.SportService;
import com.barath.app.service.TeamService;

@RestController
public class ApplicationController {
	
	
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private CountryService countryServcie;
	
	@Autowired
	private SportService sportService;
	
	@Autowired
	private TeamService teamService;
	
	
	
	@GetMapping("/")
	public String handleHome(){
		return "Welcome to Competition";
	}
	
	@PostMapping("/addPlayer")
	public Player handleAddPlayer(Player player){
		return playerService.addPlayer(player);
	}

}
