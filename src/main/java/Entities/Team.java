package Entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TEAM")
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_COUNTRY")
	private Integer id;
	@Column(name = "COUNTRY")
	private String country;
	@OneToMany(mappedBy = "team")
	private Set<Joueur> joueurs= new HashSet<>();
	@OneToMany(mappedBy = "team")
	private Set<TirAuBut> tirAuBut = new HashSet<>();
	@OneToMany(mappedBy = "home_team", cascade = CascadeType.PERSIST)
	private Set<Match> home_matchs = new HashSet<>();
	@OneToMany(mappedBy = "away_team", cascade = CascadeType.PERSIST)
	private Set<Match> away_matchs;

	

	public Team() {
		super();
	}

	public Team(String country, Set<Joueur> joueurs, Set<TirAuBut> tirAuBut, Set<Match> home_matchs,
			Set<Match> away_matchs) {
		super();
		this.country = country;
		this.joueurs = joueurs;
		this.tirAuBut = tirAuBut;
		this.home_matchs = home_matchs;
		this.away_matchs = away_matchs;
	}

	public String getCountry() {
		return country;
	}

	public Set<Joueur> getJoueurs() {
		return joueurs;
	}

	public Set<TirAuBut> getTirAuBut() {
		return tirAuBut;
	}

	public Set<Match> getHome_matchs() {
		return home_matchs;
	}

	public Set<Match> getAway_matchs() {
		return away_matchs;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setJoueurs(Set<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public void setTirAuBut(Set<TirAuBut> tirAuBut) {
		this.tirAuBut = tirAuBut;
	}

	public void setHome_matchs(Set<Match> home_matchs) {
		this.home_matchs = home_matchs;
	}

	public void setAway_matchs(Set<Match> away_matchs) {
		this.away_matchs = away_matchs;
	}

	@Override
	public String toString() {
		return "Team [country=" + country + ", joueurs=" + joueurs + ", tirAuBut=" + tirAuBut + ", home_matchs="
				+ home_matchs + ", away_matchs=" + away_matchs + "]";
	}
}
