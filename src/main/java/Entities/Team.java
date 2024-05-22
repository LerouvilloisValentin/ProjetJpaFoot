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
@Table(name = "TEAM")
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COUNTRY")
	private String country;
	@OneToMany(mappedBy = "team")
	private Set<Joueur> joueurs;
	@OneToMany(mappedBy = "team")
	private Set<TirAuBut> tirAuBut;
	@OneToMany(mappedBy = "team")
	private Set<Match> matchs;


}
