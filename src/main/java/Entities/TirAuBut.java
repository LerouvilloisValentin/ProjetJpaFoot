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
	@ManyToOne
	@JoinColumn(name = "ID_MATCH")
	private Match match;
	@ManyToOne
	@JoinColumn(name = "COUNTRY")
	private Team team;
}
