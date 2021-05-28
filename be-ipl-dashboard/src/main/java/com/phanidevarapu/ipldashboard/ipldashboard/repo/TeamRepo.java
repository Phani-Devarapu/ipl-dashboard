package com.phanidevarapu.ipldashboard.ipldashboard.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.phanidevarapu.ipldashboard.ipldashboard.entity.Team;


@Repository
public interface TeamRepo extends CrudRepository<Team, Long>{
	
	
	Team findByTeamName(String teamName);
	
	List<Team> findAll();
	
	
}
