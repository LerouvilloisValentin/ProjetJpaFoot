package Test;


import java.util.HashMap;
import java.util.Map;
import Entities.Joueur;
import Entities.Team;
import EntitiesCsv.GoalScorers;
import EntitiesData.GoalScorersData;
import Service.HandleData;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class ConnectToJoueur {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetJpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		/*
		 * récupération des donnée de goalScorer dans Result
		 */
		GoalScorers result = HandleData.getGoalScorers();

		/*
		 * Tableau de Map pour pouvoir enregistrer dans le cash des joueur et pays déjà
		 * enregisté --> améliore la performance
		 */
		Map<String, Joueur> joueurMap = new HashMap<>();
		Map<String, Team> teamMap = new HashMap<>();

		for (GoalScorersData data : result.getGoalScorersData()) {
			String scorerName = data.getScorer();
			String scorerCountry = data.getTeamScorer();
			/*
			 * vérifie si un le pays du buteur existe dans le cache
			 */
			Team team = teamMap.get(scorerCountry);
			if (team == null) {
				/*
				 * requête qui vérifie si le pays du buteur corresponds au pays de la table Team
				 */
				TypedQuery<Team> query = em.createQuery("SELECT t FROM Team t WHERE t.country = :country", Team.class);
				query.setParameter("country", scorerCountry);
				team = query.getResultStream().findFirst().orElse(null);
				/*
				 * si team n'est pas nul on ajoute le pays du buteur en clé et on ajoute le pays
				 * en lien avec ce buteur dans le cache
				 */
				if (team != null) {
					teamMap.put(scorerCountry, team);
				}
			}

			if (team != null) {
				/*
				 * vérifie si on a un nom de buteur, s'il n'existe pas on persist et son nom et
				 * son pays
				 */
				Joueur joueur = joueurMap.get(scorerName);
				if (joueur == null) {
					joueur = new Joueur();
					joueur.setNom(scorerName);
					joueur.setTeam(team); // Associer l'équipe au joueur
					joueurMap.put(scorerName, joueur);
					em.persist(joueur);
					/*
					 * si le buteur existe déja on ajoute son pays
					 */
				} else {
					joueur.setTeam(team);
				}
			}
		}

		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
