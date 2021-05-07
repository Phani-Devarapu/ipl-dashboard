package com.phanidevarapu.ipldashboard.ipldashboard.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="match")
public class MatchOutput {
	
	@Id
	private long id;	
	
	private String city;	
	private LocalDate date	;
	private String playerOfMatch;	
	private String venue	;
	private String firstInnings;	
	private String secondInnings;	
	private String tossWinner;	
	private String tossDecision;	
	private String winner;	
	private String result;	
	private String resultMargin;	
	private String eliminator;	
	private String method;	
	private String umpire1;	
	private String umpire2;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getPlayerOfMatch() {
		return playerOfMatch;
	}
	public void setPlayerOfMatch(String playerOfMatch) {
		this.playerOfMatch = playerOfMatch;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	
	public String getFirstInnings() {
		return firstInnings;
	}
	public void setFirstInnings(String firstInnings) {
		this.firstInnings = firstInnings;
	}
	public String getSecondInnings() {
		return secondInnings;
	}
	public void setSecondInnings(String secondInnings) {
		this.secondInnings = secondInnings;
	}
	public String getTossWinner() {
		return tossWinner;
	}
	public void setTossWinner(String tossWinner) {
		this.tossWinner = tossWinner;
	}
	public String getTossDecision() {
		return tossDecision;
	}
	public void setTossDecision(String tossDecision) {
		this.tossDecision = tossDecision;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getResultMargin() {
		return resultMargin;
	}
	public void setResultMargin(String resultMargin) {
		this.resultMargin = resultMargin;
	}
	public String getEliminator() {
		return eliminator;
	}
	public void setEliminator(String eliminator) {
		this.eliminator = eliminator;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getUmpire1() {
		return umpire1;
	}
	public void setUmpire1(String umpire1) {
		this.umpire1 = umpire1;
	}
	public String getUmpire2() {
		return umpire2;
	}
	public void setUmpire2(String umpire2) {
		this.umpire2 = umpire2;
	}
	
	
	

}
