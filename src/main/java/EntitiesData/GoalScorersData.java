package EntitiesData;

import java.time.LocalDate;

public class GoalScorersData {

	private LocalDate date;
	private String homeTeam;
	private String AwayTeam;
	private String teamScorer; 
	private int minScorer;
	private Boolean isOwnGoal;
	private Boolean isPenalty;
	
	public GoalScorersData() {
		super();

	}

	public GoalScorersData(LocalDate date, String homeTeam, String awayTeam, String teamScorer, int minScorer,
			Boolean isOwnGoal, Boolean isPenalty) {
		super();
		this.date = date;
		this.homeTeam = homeTeam;
		AwayTeam = awayTeam;
		this.teamScorer = teamScorer;
		this.minScorer = minScorer;
		this.isOwnGoal = isOwnGoal;
		this.isPenalty = isPenalty;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public String getAwayTeam() {
		return AwayTeam;
	}

	public String getTeamScorer() {
		return teamScorer;
	}

	public int getMinScorer() {
		return minScorer;
	}

	public Boolean getIsOwnGoal() {
		return isOwnGoal;
	}

	public Boolean getIsPenalty() {
		return isPenalty;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public void setAwayTeam(String awayTeam) {
		AwayTeam = awayTeam;
	}

	public void setTeamScorer(String teamScorer) {
		this.teamScorer = teamScorer;
	}

	public void setMinScorer(int minScorer) {
		this.minScorer = minScorer;
	}

	public void setIsOwnGoal(Boolean isOwnGoal) {
		this.isOwnGoal = isOwnGoal;
	}

	public void setIsPenalty(Boolean isPenalty) {
		this.isPenalty = isPenalty;
	}

	@Override
	public String toString() {
		return "GoalScorersData [date=" + date + ", homeTeam=" + homeTeam + ", AwayTeam=" + AwayTeam + ", teamScorer="
				+ teamScorer + ", minScorer=" + minScorer + ", isOwnGoal=" + isOwnGoal + ", isPenalty=" + isPenalty
				+ "]";
	}

	
	

}
