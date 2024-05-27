package Entities;

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
@Table(name = "JOUEUR")
public class Joueur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_JOUEUR")
	private Integer id;
	@Column(name = "NOM")
	private String nom;
	/*
	 * Clé étrangère de la table team
	 */
	@ManyToOne
	@JoinColumn(name = "COUNTRY")
	private Team team;
	@OneToMany(mappedBy = "joueurs")
	private Set<But> buts = new HashSet<>();

	public Joueur() {
		super();
	}

	public Joueur(Integer id, String nom, Team team) {
		super();
		this.id = id;
		this.nom = nom;
		this.team = team;

	}

	public Integer getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public Team getTeam() {
		return team;
	}

	public Set<But> getButs() {
		return buts;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public void setButs(Set<But> buts) {
		this.buts = buts;
	}

	@Override
	public String toString() {
		return "Joueur [id=" + id + ", nom=" + nom + ", team=" + team + ", buts=" + buts + "]";
	}

}
