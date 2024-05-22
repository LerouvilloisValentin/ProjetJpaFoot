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
@Table(name = "BUTS")
public class But {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_BUT")
	private String id;
	@Column(name = "MINUTE_BUT_MARQUE")
	private String minuteButMarque;
	@Column(name = "IS_PENALTY")
	private Boolean isPenalty;
	@Column(name = "IS_OWN_GOAL")
	private Boolean isOwnGoal;
	@ManyToOne
	@JoinColumn(name="ID_MATCH")
	private Match match;
	@ManyToOne
	@JoinColumn(name="ID_JOUEUR")
	private Joueur joueurs;

}
