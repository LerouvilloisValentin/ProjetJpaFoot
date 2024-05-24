package Service;

//import Entities.Team;
import Entities.Tournoi;
import jakarta.persistence.EntityManager;

public class EntityUtils {
	/*
	 * Créer s'il n'existe pas de teamName(country), un nouveau nom de pays, se
	 * connecte à la bdd et fait persisté la donnée
	 */
//	public static Team findOrCreateTeam(EntityManager em, String teamName) {
//		Team team = em.find(Team.class, teamName);
//		if (team == null) {
//			team = new Team();
//			team.setCountry(teamName);
//			em.persist(team);
//		}
//		return team;
//	}

	/*
	 * Créer s'il n'existe pas de tournoiName, un nouveau tournoi, se connecte à la
	 * bdd et fait persisté la donnée
	 */
	public static Tournoi findOrCreateTournoi(EntityManager em, String tournoiName) {
		Tournoi tournoi = em.find(Tournoi.class, tournoiName);
		if (tournoi == null) {
			tournoi = new Tournoi();
			tournoi.setNomTournoi(tournoiName);
			em.persist(tournoi);
		}
		return tournoi;
	}
}
