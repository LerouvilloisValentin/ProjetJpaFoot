package Entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "MATCHS")
public class Match {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MATCH")
	private Integer id;
	@Column(name = "DATE_MATCH")
	private LocalDate dateMatch;
	@Column(name = "CITY")
	private String city;
	@Column(name = "NEUTRAL")
	private Boolean neutral;
	@Column(name = "HOME_SCORE")
	private String homeScore;
	@Column(name = "AWAY_SCORE")
	private String awayScore;
	@OneToMany(mappedBy = "match")
	private Set<TirAuBut> tirAuButs;
	/*
	 * Country clé étrangère de la table Team (home_team)
	 */
	@ManyToOne
	@JoinColumn(name = "COUNTRY")
	private Team home_team;
	/*
	 * Country1 aussi clé étrangère de la table Team (away_team)
	 */
	@ManyToOne
	@JoinColumn(name = "COUNTRY_1")
	private Team away_team;
	/*
	 * clé étrangère de la table tournoi
	 */
	@ManyToOne
	@JoinColumn(name = "NOM_TOURNOI")
	private Tournoi tournoi;
	@OneToMany(mappedBy = "match")
	private Set<But> buts;

	{
		tirAuButs = new HashSet<>();
	}

	{
		buts = new HashSet<>();
	}

	public Match() {
		super();
	}

	public Match(LocalDate dateMatch, String city, Boolean neutral, String homeScore, String awayScore,
			Tournoi tournoi) {
		super();
//		this.id = id;
		this.dateMatch = dateMatch;
		this.city = city;
		this.neutral = neutral;
		this.homeScore = homeScore;
		this.awayScore = awayScore;
//		this.tirAuButs = tirAuButs;
//		this.home_team = home_team;
//		this.away_team = away_team;
		this.tournoi = tournoi;
//		this.buts = buts;
	}

	public Integer getId() {
		return id;
	}

	public LocalDate getDateMatch() {
		return dateMatch;
	}

	public String getCity() {
		return city;
	}

	public Boolean getNeutral() {
		return neutral;
	}

	public String getHomeScore() {
		return homeScore;
	}

	public String getAwayScore() {
		return awayScore;
	}

	public Set<TirAuBut> getTirAuButs() {
		return tirAuButs;
	}

	public Team getHome_team() {
		return home_team;
	}

	public Team getAway_team() {
		return away_team;
	}

	public Tournoi getTournoi() {
		return tournoi;
	}

	public Set<But> getButs() {
		return buts;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDateMatch(LocalDate dateMatch) {
		this.dateMatch = dateMatch;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setNeutral(Boolean neutral) {
		this.neutral = neutral;
	}

	public void setHomeScore(String homeScore) {
		this.homeScore = homeScore;
	}

	public void setAwayScore(String awayScore) {
		this.awayScore = awayScore;
	}

	public void setTirAuButs(Set<TirAuBut> tirAuButs) {
		this.tirAuButs = tirAuButs;
	}

	public void setHome_team(Team home_team) {
		this.home_team = home_team;
	}

	public void setAway_team(Team away_team) {
		this.away_team = away_team;
	}

	public void setTournoi(Tournoi tournoi) {
		this.tournoi = tournoi;
	}

	public void setButs(Set<But> buts) {
		this.buts = buts;
	}

	@Override
	public String toString() {
		return "Match [id=" + id + ", dateMatch=" + dateMatch + ", city=" + city + ", neutral=" + neutral
				+ ", homeScore=" + homeScore + ", AwayScore=" + awayScore + ", tirAuButs=" + tirAuButs + ", home_team="
				+ home_team + ", away_team=" + away_team + ", tournoi=" + tournoi + ", buts=" + buts + "]";
	}

}
