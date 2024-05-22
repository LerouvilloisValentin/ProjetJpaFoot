package Entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TOURNOI")
public class Tournoi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NOM_TOURNOI")
	private String nomTournoi;
	@OneToMany(mappedBy = "tournoi")
	private Set<Match> matchs;

	public Tournoi() {
		super();
	}
	
	public Tournoi(String nomTournoi, Set<Match> matchs) {
		super();
		this.nomTournoi = nomTournoi;
		this.matchs = matchs;
	}

	public String getNomTournoi() {
		return nomTournoi;
	}

	public Set<Match> getMatchs() {
		return matchs;
	}

	public void setNomTournoi(String nomTournoi) {
		this.nomTournoi = nomTournoi;
	}

	public void setMatchs(Set<Match> matchs) {
		this.matchs = matchs;
	}

	@Override
	public String toString() {
		return "Tournoi [nomTournoi=" + nomTournoi + ", matchs=" + matchs + "]";
	}

}
