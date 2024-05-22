package Entities;

import java.time.LocalDate;
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
	private boolean neutral;
	@Column(name = "HOME_SCORE")
	private String homeScore;
	@Column(name = "AWAY_SCORE")
	private String AwayScore;
	@OneToMany(mappedBy="match")
	private Set<TirAuBut> tirAuButs;
	@ManyToOne
	@JoinColumn(name="COUNTRY")
	private Team team;
	@ManyToOne
	@JoinColumn(name="NOM_TOURNOI")
	private Tournoi tournoi;
	@OneToMany(mappedBy="match")
	private Set<But> buts;
}
