package EntitiesData;

import java.time.LocalDate;

/*
 * class correspondants aux élément du fichier csv shootouts
 */
public class ShootoutsData {

	private LocalDate date;
	private String homeTeam;
	private String awayTeam;
	private String winner;
	private String firstShooter;

	public ShootoutsData(LocalDate date, String homeTeam, String awayTeam, String winner, String firstShooter) {
		super();
		this.date = date;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.winner = winner;
		this.firstShooter = firstShooter;
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

	public String getWinner() {
		return winner;
	}

	public String getFirstShooter() {
		return firstShooter;
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

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public void setFirstShooter(String firstShooter) {
		this.firstShooter = firstShooter;
	}

	@Override
	public String toString() {
		return "ShootoutsData [date=" + date + ", homeTeam=" + homeTeam + ", awayTeam=" + awayTeam + ", winner="
				+ winner + ", firstShooter=" + firstShooter + "]\n";
	}

}
