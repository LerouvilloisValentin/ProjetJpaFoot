package EntitiesData;

import java.time.LocalDate;

public class ResultData {

	private LocalDate date;
	private String homeTeam;
	private String AwayTeam;
	private int homeScore;
	private int AwayScore;
	private String tournament;
	private String city;
	private String country;
	private Boolean neutral;
	
	public ResultData() {
		super();

	}

	public ResultData(LocalDate date, String homeTeam, String awayTeam, int homeScore, int awayScore, String tournament,
			String city, String country, Boolean neutral) {
		super();
		this.date = date;
		this.homeTeam = homeTeam;
		AwayTeam = awayTeam;
		this.homeScore = homeScore;
		AwayScore = awayScore;
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
		return AwayTeam;
	}

	public int getHomeScore() {
		return homeScore;
	}

	public int getAwayScore() {
		return AwayScore;
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
		AwayTeam = awayTeam;
	}

	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}

	public void setAwayScore(int awayScore) {
		AwayScore = awayScore;
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
		return "date=" + date + ", homeTeam=" + homeTeam + ", AwayTeam=" + AwayTeam + ", homeScore="
				+ homeScore + ", AwayScore=" + AwayScore + ", tournament=" + tournament + ", city=" + city
				+ ", country=" + country + ", neutral=" + neutral + "\n";
	}

}
