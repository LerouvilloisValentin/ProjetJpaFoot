package Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TIR_AU_BUT")
public class TirAuBut {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TIR_AU_BUT")
	private Integer id;
	@Column(name = "WINNER_COUNTY")
	private String winnerCountry;
	@Column(name = "FIRST_SHOOTER")
	private String firstShooter;
	/*
	 * Clé étrangère de la table matchs
	 */
	@ManyToOne
	@JoinColumn(name = "ID_MATCH")
	private Match match;
	/*
	 * Clé étrangère de la table team
	 */
	@ManyToOne
	@JoinColumn(name = "COUNTRY", referencedColumnName = "COUNTRY")
	private Team team;

	public TirAuBut() {
		super();

	}
	
	public TirAuBut(Integer id, String winnerCountry, String firstShooter, Match match, Team team) {
		super();
		this.id = id;
		this.winnerCountry = winnerCountry;
		this.firstShooter = firstShooter;
		this.match = match;
		this.team = team;
	}

	public Integer getId() {
		return id;
	}

	public String getWinnerCountry() {
		return winnerCountry;
	}

	public String getFirstShooter() {
		return firstShooter;
	}

	public Match getMatch() {
		return match;
	}

	public Team getTeam() {
		return team;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setWinnerCountry(String winnerCountry) {
		this.winnerCountry = winnerCountry;
	}

	public void setFirstShooter(String firstShooter) {
		this.firstShooter = firstShooter;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "TirAuBut [id=" + id + ", winnerCountry=" + winnerCountry + ", firstShooter=" + firstShooter + ", match="
				+ match + ", team=" + team + "]";
	}

}
