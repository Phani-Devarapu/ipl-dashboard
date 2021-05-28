package com.phanidevarapu.ipldashboard.ipldashboard.repo;


import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.phanidevarapu.ipldashboard.ipldashboard.entity.MatchOutput;

@Repository
public interface MatchRepo extends CrudRepository<MatchOutput, Long> {
	
	
	List<MatchOutput> getByFirstInningsOrSecondInningsOrderByDateDesc(String firstIniTeam , String secondIniTeam, Pageable pageable);
	
	default List<MatchOutput> findLatestMatchesbyTeamname(String teamName, int count)
	{
		
		//return null;
		return getByFirstInningsOrSecondInningsOrderByDateDesc(teamName,teamName,(Pageable) PageRequest.of(0, count));
	}
	

}
