package com.phanidevarapu.ipldashboard.ipldashboard.data;


import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.phanidevarapu.ipldashboard.ipldashboard.entity.*;

public class MatchItemProcessor implements ItemProcessor<MatchInput, MatchOutput> {

	  private static final Logger log = LoggerFactory.getLogger(MatchItemProcessor.class);

	  public MatchOutput process(final MatchInput matchIn) throws Exception {
		  
		  MatchOutput matchOutput = new MatchOutput();
		  
		  matchOutput.setId(Long.parseLong(matchIn.getId()));
		  
		  matchOutput.setCity(matchIn.getCity());
		  matchOutput.setDate(LocalDate.parse(matchIn.getDate()));
		  matchOutput.setEliminator(matchIn.getEliminator());
		  matchOutput.setPlayerOfMatch(matchIn.getPlayer_of_match());
		  matchOutput.setResult(matchIn.getResult());
		  matchOutput.setResultMargin(matchIn.getResult_margin());
		  
		  String firstIni, SecondIni;
		  
		  if(matchIn.getToss_decision().equals("bat"))
		  {
			  firstIni = matchIn.getToss_winner();
			  SecondIni = (firstIni.equals(matchIn.getTeam1()))?matchIn.getTeam2():matchIn.getTeam1();
			  
		  }
		  else
		  {
			  SecondIni = matchIn.getToss_winner();
			  firstIni = (SecondIni.equals(matchIn.getTeam1()))?matchIn.getTeam2():matchIn.getTeam1();
		  }
		  
		  matchOutput.setFirstInnings(firstIni);
		  matchOutput.setSecondInnings(SecondIni);
		  matchOutput.setVenue(matchIn.getVenue());
		  matchOutput.setWinner(matchIn.getWinner());
		  matchOutput.setTossDecision(matchIn.getToss_decision());
		  matchOutput.setTossWinner(matchIn.getToss_decision());
		  matchOutput.setUmpire1(matchIn.getUmpire1());
		  matchOutput.setUmpire2(matchIn.getUmpire2());
		  matchOutput.setMethod(matchIn.getMethod());
		  
			 

	    return matchOutput;
	  }

	

}
