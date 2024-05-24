package EntitiesData;

import java.time.LocalDate;

/*
 * class correspondants aux élément du fichier csv Results
 */
public class ResultData {

	private LocalDate date;
	private String homeTeam;
	private String awayTeam;
	private String homeScore;
	private String awayScore;
	private String tournament;
	private String city;
	private String country;
	private Boolean neutral;
	
	public ResultData() {
		super();
		
	}
	public ResultData(LocalDate date, String homeTeam, String awayTeam, String homeScore, String awayScore, String tournament,
			String city, String country, Boolean neutral) {
		super();
		this.date = date;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeScore = homeScore;
		this.awayScore = awayScore;
		this.tournament = tournament;
		this.city = city;
		this.country = country;
		this.neutral = neutral;
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
	public String getHomeScore() {
		return homeScore;
	}
	public String getAwayScore() {
		return awayScore;
	}
	public String getTournament() {
		return tournament;
	}
	public String getCity() {
		return city;
	}
	public String getCountry() {
		return country;
	}
	public Boolean getNeutral() {
		return neutral;
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
	public void setHomeScore(String homeScore) {
		this.homeScore = homeScore;
	}
	public void setAwayScore(String awayScore) {
		this.awayScore = awayScore;
	}
	public void setTournament(String tournament) {
		this.tournament = tournament;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setNeutral(Boolean neutral) {
		this.neutral = neutral;
	}
	@Override
	public String toString() {
		return "ResultData [date=" + date + ", homeTeam=" + homeTeam + ", awayTeam=" + awayTeam + ", homeScore="
				+ homeScore + ", awayScore=" + awayScore + ", tournament=" + tournament + ", city=" + city
				+ ", country=" + country + ", neutral=" + neutral + "]\n";
	}
	public String[] split(String string) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
