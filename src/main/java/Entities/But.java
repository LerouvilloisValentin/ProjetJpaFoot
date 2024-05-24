//package Entities;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//
//@Entity
//
//@Table(name = "BUTS")
//public class But {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "ID_BUT")
//	private int id;
//	@Column(name = "MINUTE_BUT_MARQUE")
//	private String minuteButMarque;
//	@Column(name = "IS_PENALTY")
//	private Boolean isPenalty;
//	@Column(name = "IS_OWN_GOAL")
//	private Boolean isOwnGoal;
//	/*
//	 * Clé étrangère de la table matchs
//	 */
//	@ManyToOne
//	@JoinColumn(name = "ID_MATCH")
//	private Match match;
//	/*
//	 * Clé étrangère de la table joueur
//	 */
//	@ManyToOne
//	@JoinColumn(name = "ID_JOUEUR")
//	private Joueur joueurs;
//
//	public But() {
//		super();
//	}
//	
//	public But(int id, String minuteButMarque, Boolean isPenalty, Boolean isOwnGoal, Match match, Joueur joueurs) {
//		super();
//		this.id = id;
//		this.minuteButMarque = minuteButMarque;
//		this.isPenalty = isPenalty;
//		this.isOwnGoal = isOwnGoal;
//		this.match = match;
//		this.joueurs = joueurs;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public String getMinuteButMarque() {
//		return minuteButMarque;
//	}
//
//	public Boolean getIsPenalty() {
//		return isPenalty;
//	}
//
//	public Boolean getIsOwnGoal() {
//		return isOwnGoal;
//	}
//
//	public Match getMatch() {
//		return match;
//	}
//
//	public Joueur getJoueurs() {
//		return joueurs;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public void setMinuteButMarque(String minuteButMarque) {
//		this.minuteButMarque = minuteButMarque;
//	}
//
//	public void setIsPenalty(Boolean isPenalty) {
//		this.isPenalty = isPenalty;
//	}
//
//	public void setIsOwnGoal(Boolean isOwnGoal) {
//		this.isOwnGoal = isOwnGoal;
//	}
//
//	public void setMatch(Match match) {
//		this.match = match;
//	}
//
//	public void setJoueurs(Joueur joueurs) {
//		this.joueurs = joueurs;
//	}
//
//	@Override
//	public String toString() {
//		return "But [id=" + id + ", minuteButMarque=" + minuteButMarque + ", isPenalty=" + isPenalty + ", isOwnGoal="
//				+ isOwnGoal + ", match=" + match + ", joueurs=" + joueurs + "]";
//	}
//
//}
