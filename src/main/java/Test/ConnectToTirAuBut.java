package Test;

import java.util.HashMap;
import java.util.Map;
import Entities.Team;
import Entities.TirAuBut;
import EntitiesCsv.Shootouts;
import EntitiesData.ShootoutsData;
import Service.HandleData;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class ConnectToTirAuBut {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetJpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		Shootouts result = HandleData.getShootouts();

		/*
		 * Tableau de Map pour pouvoir enregistrer dans le cash les équipe et les tir
		 * aux buts déjà enregisté --> améliore la performance
		 */
		Map<String, Team> teamMap = new HashMap<>();
		Map<String, TirAuBut> tirAuButMap = new HashMap<>();

		for (ShootoutsData data : result.getShootoutsData()) {
			String winnerCountry = data.getWinner();
			String firstShooter = data.getFirstShooter();

			/*
			 * vérifie si une équipe existe dans le cache
			 */
			Team team = teamMap.get(winnerCountry);
			/*
			 * requête qui vérifie si une équipe corresponds à l'équipe de la table TirAuBut
			 */
			if (team == null) {
				TypedQuery<Team> query = em.createQuery("SELECT t FROM Team t WHERE t.country= :country", Team.class);
				query.setParameter("country", winnerCountry);
				team = query.getResultStream().findFirst().orElse(null);
				if (team != null) {
					teamMap.put(winnerCountry, team);
				}
			}
			if (team != null) {
				/*
				 * vérifie si on a une équipe gagnante, s'il n'existe pas on persist les
				 * attributs ci-dessous
				 */
				TirAuBut tirAuBut = tirAuButMap.get(winnerCountry);
				if (tirAuBut == null) {
					tirAuBut = new TirAuBut();
					tirAuBut.setTeam(team);
					tirAuBut.setFirstShooter(firstShooter);
					tirAuBut.setWinnerCountry(winnerCountry);
//					tirAuBut.setMatch(matchId);
					tirAuButMap.put(winnerCountry, tirAuBut);
					em.persist(tirAuBut);
					/*
					 * si un tir au but déjà on lui ajoute son pays lié
					 */
				} else {
					tirAuBut.setTeam(team);
				}

			}

		}
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
