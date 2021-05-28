package com.phanidevarapu.ipldashboard.ipldashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.phanidevarapu.ipldashboard.ipldashboard.entity.Team;
import com.phanidevarapu.ipldashboard.ipldashboard.repo.MatchRepo;
import com.phanidevarapu.ipldashboard.ipldashboard.repo.TeamRepo;

@RestController
@CrossOrigin
public class TeamController {
	
	
	
	private TeamRepo teamRepo;
	
	
	private MatchRepo matchRepo;
	
	
	
	
	
	
	public TeamController(TeamRepo teamRepo, MatchRepo matchRepo) {
		super();
		this.teamRepo = teamRepo;
		this.matchRepo = matchRepo;
	}






	@GetMapping("/team/{teamName}")
	public Team getTeamDetails(@PathVariable String teamName)
	{
		System.out.println("inside the each tEAM method");
		
		 Team findByTeamName = teamRepo.findByTeamName(teamName);
		
		findByTeamName.setRecentMatches(matchRepo.findLatestMatchesbyTeamname(teamName, 4));
		
		return findByTeamName;
		
		
	}
	
	@GetMapping("/teams")
	public List<Team> getAllTeamDetails()
	{
		return teamRepo.findAll();
		

	}

}
