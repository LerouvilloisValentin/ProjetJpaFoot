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
}
