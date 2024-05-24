//package Entities;
//
//import java.util.Set;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "JOUEUR")
//public class Joueur {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "ID_JOUEUR")
//	private Integer id;
//	@Column(name = "PRENOM")
//	private String prenom;
//	@Column(name = "NOM")
//	private String nom;
//	/*
//	 * Clé étrangère de la table team
//	 */
//	@ManyToOne
//	@JoinColumn(name = "COUNTRY")
//	private Team team;
//	@OneToMany(mappedBy = "joueurs")
//	private Set<But> buts;
//
//	public Joueur() {
//		super();
//	}
//	
//	public Joueur(Integer id, String prenom, String nom, Team team, Set<But> buts) {
//		super();
//		this.id = id;
//		this.prenom = prenom;
//		this.nom = nom;
//		this.team = team;
//		this.buts = buts;
//	}
//
//	public Integer getId() {
//		return id;
//	}
//
//	public String getPrenom() {
//		return prenom;
//	}
//
//	public String getNom() {
//		return nom;
//	}
//
//	public Team getTeam() {
//		return team;
//	}
//
//	public Set<But> getButs() {
//		return buts;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public void setPrenom(String prenom) {
//		this.prenom = prenom;
//	}
//
//	public void setNom(String nom) {
//		this.nom = nom;
//	}
//
//	public void setTeam(Team team) {
//		this.team = team;
//	}
//
//	public void setButs(Set<But> buts) {
//		this.buts = buts;
//	}
//
//	@Override
//	public String toString() {
//		return "Joueur [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", team=" + team + ", buts=" + buts + "]";
//	}
//
//}
