package EntitiesData;

import java.time.LocalDate;

/*
 * class correspondants aux élément du fichier csv goalscorer
 */
public class GoalScorersData {

	private LocalDate date;
	private String homeTeam;
	private String awayTeam;
	private String teamScorer;
	private String scorer;
	private String minScorer;
	private Boolean isOwnGoal;
	private Boolean isPenalty;

	public GoalScorersData() {
		super();

	}

	public GoalScorersData(LocalDate date, String homeTeam, String awayTeam, String teamScorer, String scorer,
			String minScorer, Boolean isOwnGoal, Boolean isPenalty) {
		super();
		this.date = date;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.teamScorer = teamScorer;
		this.scorer = scorer;
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
		return awayTeam;
	}

	public String getTeamScorer() {
		return teamScorer;
	}

	public String getScorer() {
		return scorer;
	}

	public void setScorer(String scorer) {
		this.scorer = scorer;
	}

	public String getMinScorer() {
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
		this.awayTeam = awayTeam;
	}

	public void setTeamScorer(String teamScorer) {
		this.teamScorer = teamScorer;
	}

	public void setMinScorer(String minScorer) {
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
		return "GoalScorersData [date=" + date + ", homeTeam=" + homeTeam + ", awayTeam=" + awayTeam + ", teamScorer="
				+ teamScorer + ", scorer=" + scorer + ", minScorer=" + minScorer + ", isOwnGoal=" + isOwnGoal
				+ ", isPenalty=" + isPenalty + "]\n";
	}

}
