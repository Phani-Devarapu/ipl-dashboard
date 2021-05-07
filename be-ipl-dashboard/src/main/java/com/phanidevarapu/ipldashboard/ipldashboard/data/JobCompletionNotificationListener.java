package com.phanidevarapu.ipldashboard.ipldashboard.data;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.phanidevarapu.ipldashboard.ipldashboard.entity.MatchOutput;
import com.phanidevarapu.ipldashboard.ipldashboard.entity.Team;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

  private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

  private final EntityManager entityManager;
  

  @Autowired
  public JobCompletionNotificationListener(EntityManager entityManager) {

	this.entityManager = entityManager;
  }
  
//  private final JdbcTemplate jdbcTemplate;
//  
//
//  @Autowired
//  public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
//
//	this.jdbcTemplate = jdbcTemplate;
//  }

  @Override
  @Transactional
  public void afterJob(JobExecution jobExecution) {
    if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
      log.info("!!! JOB FINISHED! Time to verify the results");
      
      Map<String, Team> teamData = new HashMap<>();
      
      entityManager.createQuery("SELECT firstInnings, count(*) FROM MatchOutput  group by firstInnings ", Object[].class)
      .getResultList()
      .stream()
      .map(e->new Team((String)e[0],(long)e[1]))
      .forEach(team->teamData.put(team.getTeamName(),team));
      
    
      
      entityManager.createQuery("select  m.secondInnings, count(*) from MatchOutput m group by  m.secondInnings", Object[].class)
      .getResultList()
      .stream()
      .forEach(e->{
    	  Team team =teamData.get((String)e[0]);
    	  team.setTotalMatches(team.getTotalMatches()+ (long)e[1]);
      });
      
      entityManager.createQuery("select m.winner, count(*) from MatchOutput m group by m.winner", Object[].class)
      .getResultList()
      .stream()
      .forEach(e->{
    	  Team team =teamData.get((String)e[0]);
    	 if(team!=null) team.setTotalWins((long)e[1]);
      });
     
      teamData.values().forEach(team->{
    	  System.out.println(team.toString());
    	  entityManager.persist(team);	
      });
      
      
      
      
//
//      jdbcTemplate.query("SELECT first_innings,second_innings,toss_winner FROM match",
//        (rs, row) -> 
//      "team1" + rs.getString(1) + "team2" + rs.getString(2) + "toss" + rs.getString(3)
//      ).forEach(str -> System.out.println(str));
    }
  }
}